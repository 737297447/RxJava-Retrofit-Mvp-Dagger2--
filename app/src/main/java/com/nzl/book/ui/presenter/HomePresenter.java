package com.nzl.book.ui.presenter;

import android.content.Context;

import com.nzl.book.api.BookApi;
import com.nzl.book.base.RxPresenter;
import com.nzl.book.bean.BookToc;
import com.nzl.book.bean.Recommend;
import com.nzl.book.manager.SettingManager;
import com.nzl.book.ui.contract.HomeContract;
import com.nzl.book.utils.ACache;
import com.nzl.book.utils.LogUtils;
import com.nzl.book.utils.RxUtil;
import com.nzl.book.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/11/9.
 */

public class HomePresenter extends RxPresenter<HomeContract.View> implements HomeContract.Presenter<HomeContract.View> {


    private Context mContext;
    private BookApi bookApi;

    @Inject
    public HomePresenter(Context mContext, BookApi bookApi) {
        this.mContext = mContext;
        this.bookApi = bookApi;
    }


    @Override
    public void getRecommendList() {
        String key = StringUtils.creatAcacheKey("recommend-list", SettingManager.getInstance().getUserChooseSex());

        Observable<Recommend> fromNetWork = bookApi.getRecommend(SettingManager.getInstance().getUserChooseSex())
                .compose(RxUtil.<Recommend>rxCacheListHelper(key));
        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, Recommend.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Recommend>() {
                    @Override
                    public void onNext(Recommend recommend) {
                        if (recommend != null) {
                            List<Recommend.RecommendBooks> list = recommend.books;
                            if (list != null && !list.isEmpty() && mView != null) {
                                mView.showHomeList(list);
                            }
                        }
                    }

                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getRecommendList", e.toString());
                        mView.showError();
                    }
                });
        addSubscribe(rxSubscription);
    }

    public void getTopList(final String bookId){

        bookApi.getBookToc(bookId,"chapters").subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookToc>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookToc bookToc) {
                        ACache.get(mContext).put(bookId+"bookToc",bookToc);
                        List<BookToc.mixToc.Chapters> list = bookToc.mixToc.chapters;
                        if(list != null && !list.isEmpty() && mView != null){
                            mView.showBookToc(bookId,list);
                        }


                    }
                });


    }



}

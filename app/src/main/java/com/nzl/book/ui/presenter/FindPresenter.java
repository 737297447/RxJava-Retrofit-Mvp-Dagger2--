package com.nzl.book.ui.presenter;

import android.content.Context;

import com.nzl.book.api.BookApi;
import com.nzl.book.base.RxPresenter;
import com.nzl.book.bean.ComTarget;
import com.nzl.book.bean.Tiezi;
import com.nzl.book.ui.contract.FindContract;
import com.nzl.book.utils.RxUtil;
import com.nzl.book.utils.StringUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Administrator on 2016/11/11.
 */

public class FindPresenter extends RxPresenter<FindContract.View> implements FindContract.Presenter<FindContract.View> {

    private Context context;
    private BookApi bookApi;

    @Inject
    public FindPresenter(Context context,BookApi bookApi){
        this.context = context;
        this.bookApi = bookApi;
    }


    @Override
    public void getTieizList(String page,String pagesize) {

        String key = StringUtils.creatAcacheKey("Misscandy", "Hot");
        Observable<Tiezi> fromNetWork = bookApi.getTiezi(page,pagesize).compose(RxUtil.<Tiezi>rxCacheListHelper(key));
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key,Tiezi.class),fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Tiezi>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError();
                    }

                    @Override
                    public void onNext(Tiezi o) {
                        if (o != null) {
                            List<ComTarget> list = o.getData();
                            if (list != null && !list.isEmpty() && mView != null) {
                                mView.showTieziList(list);
                            }
                        }
                    }
                });

        addSubscribe(rxSubscription);
    }
}

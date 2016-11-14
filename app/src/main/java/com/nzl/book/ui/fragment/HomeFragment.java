package com.nzl.book.ui.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nzl.book.R;
import com.nzl.book.api.support.DownloadQueue;
import com.nzl.book.base.BaseRVFragment;
import com.nzl.book.bean.BookToc;
import com.nzl.book.bean.Recommend;
import com.nzl.book.component.AppComponent;
import com.nzl.book.component.DaggerMainComponent;
import com.nzl.book.manager.CollectionsManager;
import com.nzl.book.service.DownloadBookService;
import com.nzl.book.ui.activity.MainActivity;
import com.nzl.book.ui.contract.HomeContract;
import com.nzl.book.ui.easyadapter.RecommendAdapter;
import com.nzl.book.ui.presenter.HomePresenter;
import com.nzl.book.view.recycleview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */

public class HomeFragment extends BaseRVFragment<HomePresenter, Recommend.RecommendBooks> implements HomeContract.View, RecyclerArrayAdapter.OnItemLongClickListener {



    private List<BookToc.mixToc.Chapters> chaptersList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent)
                .build().inject(this);

    }

    @Override
    public void initDatas() {
//        mPresenter.getRecommendList();
    }

    @Override
    public void configViews() {
        initAdapter(RecommendAdapter.class,true,false);
        mAdapter.setOnItemLongClickListener(this);
        mAdapter.addFooter(new RecyclerArrayAdapter.ItemView(){
            @Override
            public View onCreateView(ViewGroup parent) {
                View header = LayoutInflater.from(activity).inflate(R.layout.foot_view_shelf,parent,false);
                return header;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((MainActivity) activity).setCurrentItem(2);
                    }
                });
            }
        });

        mRecyclerView.getEmptyView().findViewById(R.id.tvEmptyView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) activity).setCurrentItem(2);
            }
        });
        onRefresh();

    }

    @Override
    public void showHomeList(List<Recommend.RecommendBooks> list) {
        mAdapter.clear();
        mAdapter.addAll(list);
        //推荐列表默认加入收藏
        for (Recommend.RecommendBooks bean : list) {
            //TODO 此处可优化：批量加入收藏->加入前需先判断是否收藏过
            CollectionsManager.getInstance().add(bean);
        }
    }

    @Override
    public void showBookToc(String bookId, List<BookToc.mixToc.Chapters> list) {
        chaptersList.clear();
        chaptersList.addAll(list);
        DownloadBookService.post(new DownloadQueue(bookId, list, 1, list.size()));
        dismissDialog();
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }


    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void onRefresh(){
        super.onRefresh();
        List<Recommend.RecommendBooks> data = CollectionsManager.getInstance().getCollectionListBySort();
        mAdapter.clear();
        mAdapter.addAll(data);
        //不加下面这句代码会导致，添加本地书籍的时候，部分书籍添加后直接崩溃
        //报错：Scrapped or attached views may not be recycled. isScrap:false isAttached:true
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setRefreshing(false);
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}

package com.nzl.book.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nzl.book.R;
import com.nzl.book.base.BaseFragment;
import com.nzl.book.bean.FindBean;
import com.nzl.book.component.AppComponent;
import com.nzl.book.ui.adapter.FindAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2016/11/8.
 */

public class PeopleFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private FindAdapter mAdapter;
    private List<FindBean> mList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initDatas() {
        mList.clear();
        mList.add(new FindBean("排行榜"));
        mList.add(new FindBean("主题书单"));
        mList.add(new FindBean("分类"));
        mList.add(new FindBean("有声小说"));
    }

    @Override
    public void configViews() {
//        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mAdapter = new FindAdapter(mList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void attachView() {

    }
}

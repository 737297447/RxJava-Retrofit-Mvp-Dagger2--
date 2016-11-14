package com.nzl.book.ui.fragment;

import android.widget.TextView;

import com.nzl.book.R;
import com.nzl.book.base.BaseRVFragment;
import com.nzl.book.bean.ComTarget;
import com.nzl.book.component.AppComponent;
import com.nzl.book.component.DaggerMainComponent;
import com.nzl.book.ui.adapter.FindAdapter;
import com.nzl.book.ui.contract.FindContract;
import com.nzl.book.ui.presenter.FindPresenter;

import java.util.List;

import butterknife.BindView;

/**
 * 发现
 *
 * @author yuyh.
 * @date 16/9/1.
 */
public class FindFragment extends BaseRVFragment<FindPresenter, ComTarget> implements FindContract.View {


    @BindView(R.id.text)
    TextView text;
    private FindAdapter mAdapter;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initDatas() {
        mPresenter.getTieizList("1", "2");
    }

    @Override
    public void configViews() {


    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder().appComponent(appComponent).build().inject(this);
    }


    @Override
    public void showTieziList(List<ComTarget> list) {
        text.setText(list.get(0).getUserInfo().getObjname());
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {

    }
}

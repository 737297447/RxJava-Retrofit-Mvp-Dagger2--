package com.nzl.book.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;

import com.nzl.book.R;
import com.nzl.book.base.BaseActivity;
import com.nzl.book.component.AppComponent;
import com.nzl.book.component.DaggerMainComponent;
import com.nzl.book.ui.adapter.FragmentViewPagerAdapter;
import com.nzl.book.ui.fragment.FindFragment;
import com.nzl.book.ui.fragment.HomeFragment;
import com.nzl.book.ui.fragment.PeopleFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.ly_1)
    LinearLayout ly_1;
    @BindView(R.id.ly_2)
    LinearLayout ly_2;
    @BindView(R.id.ly_3)
    LinearLayout ly_3;

    private List<Fragment> listFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDatas();
        configViews();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initDatas() {
        listFragments = new ArrayList<>();
        listFragments.add(new HomeFragment());
        listFragments.add(new FindFragment());
        listFragments.add(new PeopleFragment());

    }

    @Override
    public void configViews() {
        FragmentViewPagerAdapter adapter = new FragmentViewPagerAdapter(this.getSupportFragmentManager(), mViewPager, listFragments);
        adapter.setOnExtraPageChangeListener(new FragmentViewPagerAdapter.OnExtraPageChangeListener() {
            @Override
            public void onExtraPageSelected(int i) {
                System.out.println("Extra...i: " + i);
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                ly_1.setSelected(false);
                ly_2.setSelected(false);
                ly_3.setSelected(false);
                switch (position) {
                    case 0:
                        ly_1.setSelected(true);
                        break;
                    case 1:
                        ly_2.setSelected(true);
                        break;
                    case 2:
                        ly_3.setSelected(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    public void setCurrentItem(int position) {
        mViewPager.setCurrentItem(position);
    }


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);

    }

}

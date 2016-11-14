package com.nzl.book.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import com.nzl.book.R;
import com.nzl.book.ReaderApplication;
import com.nzl.book.component.AppComponent;
import com.nzl.book.utils.SharedPreferencesUtil;
import com.nzl.book.utils.StatusBarCompat;
import com.nzl.book.view.loadding.CustomDialog;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/11/7.
 */

public abstract class BaseActivity extends AppCompatActivity{


    protected Context mContext;
    protected int statusBarColor = 0;
    protected View statusBarView = null;
    private boolean mNowMode;
    private CustomDialog customDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        if(statusBarColor == 0){
            statusBarView = StatusBarCompat.compat(this, ContextCompat.getColor(this, R.color.colorPrimaryDark));
        }else if(statusBarColor != -1){
            statusBarView = StatusBarCompat.compat(this,statusBarColor);
        }
        mContext = this;
        ButterKnife.bind(this);
        setupActivityComponent(ReaderApplication.getInstance().getAppComponent());
        initDatas();
        configViews();
        mNowMode =SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT);
    }


    public abstract int getLayoutId();
    public abstract void initDatas();
    /**
     * 对各种控件进行设置、适配、填充数据
     */
    public abstract void configViews();

    protected abstract void setupActivityComponent(AppComponent appComponent);




    @Override
    protected void onResume() {
        super.onResume();
        if(SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT,false) != mNowMode){
            if(SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT,false)){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            recreate();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    public CustomDialog getDialog(){
        if(customDialog == null){
            customDialog = CustomDialog.instance(this);
            customDialog.setCancelable(true);
        }
        return customDialog;
    }

    public void hideDialog(){
        if(customDialog != null)
            customDialog.dismiss();
    }

    public void showDialog() {
        getDialog().show();
    }

    public void dismissDialog() {
        if (customDialog != null) {
            customDialog.dismiss();
            customDialog = null;
        }
    }


}

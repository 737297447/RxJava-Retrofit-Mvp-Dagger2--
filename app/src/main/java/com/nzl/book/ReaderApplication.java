package com.nzl.book;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.nzl.book.base.Constant;
import com.nzl.book.component.AppComponent;
import com.nzl.book.component.DaggerAppComponent;
import com.nzl.book.module.AppModule;
import com.nzl.book.module.BookApiModule;
import com.nzl.book.utils.AppUtils;
import com.nzl.book.utils.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/11/4.
 */

public class ReaderApplication extends Application {

    private static ReaderApplication sInstance;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.sInstance = this;
        initComponent();
        AppUtils.init(this);
        initPrefs();
        initNightModel();
    }

    /**
     * 初始化AppComponent组件，
     *
     */
    private void initComponent() {
        appComponent = DaggerAppComponent.builder().
                bookApiModule(new BookApiModule()).
                appModule(new AppModule(this)).
                build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    /**
     * 初始化SharePreference
     */
    protected void initPrefs(){
        SharedPreferencesUtil.init(this,getPackageName()+"_preference", Context.MODE_MULTI_PROCESS);
    }

    public static ReaderApplication getInstance() {
        return sInstance;
    }

    protected void initNightModel(){
        boolean isNight = SharedPreferencesUtil.getInstance().getBoolean(Constant.ISNIGHT);
        if(isNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }
}

package com.nzl.book.module;


import com.nzl.book.api.BookApi;
import com.nzl.book.api.support.HeaderInterceptor;
import com.nzl.book.api.support.LoggingInterceptor;
import com.nzl.book.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Administrator on 2016/11/4.
 */

@Module
public class BookApiModule {

    @Provides
    public OkHttpClient provideOKHttpClient(){
        LoggingInterceptor logging = new LoggingInterceptor(new MyLog());
        logging.setLevel(LoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000,TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }


    @Provides
    protected BookApi provideBookService(OkHttpClient okHttpClient){
        return BookApi.getInstance(okHttpClient);
    }

    public static class MyLog implements LoggingInterceptor.Logger{
        @Override
        public void log(String message) {
            LogUtils.i("oklog: " + message);
        }
    }
}

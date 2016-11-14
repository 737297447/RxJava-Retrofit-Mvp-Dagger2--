package com.nzl.book.api;

import com.nzl.book.base.Constant;
import com.nzl.book.bean.BookToc;
import com.nzl.book.bean.ChapterRead;
import com.nzl.book.bean.Recommend;
import com.nzl.book.bean.Tiezi;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/7.
 */

public class BookApi {

    public static BookApi instance;
    private BookApiService service;

    public BookApi(OkHttpClient okHttpClient){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.MISSCANDY_BASE_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        service = retrofit.create(BookApiService.class);
    }

    public static BookApi getInstance(OkHttpClient okHttpClient){
        if(instance == null)
            instance = new BookApi(okHttpClient);
        return instance;
    }

    /** 获取首页书本信息接口*/
    public Observable<Recommend> getRecommend(String gender){
        return service.getRecommend(gender);
    }

    public Observable<BookToc> getBookToc(String bookId,String view){
        return service.getBookToc(bookId,view);
    }

    //下载书本
    public synchronized Observable<ChapterRead> getChapterRead(String url) {
        return service.getChapterRead(url);
    }

    public Observable<Tiezi> getTiezi(String page, String pagesize){


        return service.getTiezi(page,pagesize,"top","","","","android","large","");
    }

}

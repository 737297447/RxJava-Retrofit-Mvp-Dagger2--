package com.nzl.book.api;

import com.nzl.book.bean.BookToc;
import com.nzl.book.bean.ChapterRead;
import com.nzl.book.bean.Recommend;
import com.nzl.book.bean.Tiezi;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2016/11/7.
 */

public interface BookApiService {

    @GET("/book/recommend")
    Observable<Recommend> getRecommend(@Query("gender")String gender);

    @GET("/mix-atoc/{bookId}")
    Observable<BookToc> getBookToc(@Path("bookId") String bookId,@Query("view") String view);

    //下载书本
    @GET("http://chapter2.zhuishushenqi.com/chapter/{url}")
    Observable<ChapterRead> getChapterRead(@Path("url") String url);


    @GET("/v1.0/selected/rec_works")
    Observable<Tiezi> getTiezi(@Query("paginate[page]") String page, @Query("paginate[perPage]") String pageSize, @Query("type") String type
    , @Query("nonce") String nonce, @Query("timestamp")String timestamp, @Query("client_version")String client_version, @Query("device_type")String device_type
    , @Query("screen_size")String screen_size, @Query("signature")String signature);

}

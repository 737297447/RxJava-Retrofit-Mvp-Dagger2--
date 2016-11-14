package com.nzl.book.component;

import android.content.Context;

import com.nzl.book.api.BookApi;
import com.nzl.book.module.AppModule;
import com.nzl.book.module.BookApiModule;

import dagger.Component;

/** Component(组件)
 * Created by Administrator on 2016/11/7.
 */
@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}

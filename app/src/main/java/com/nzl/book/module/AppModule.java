package com.nzl.book.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * module(模块)
 *
 * Created by Administrator on 2016/11/4.
 * @Module: Modules类里面的方法专门提供依赖，所以我们定义一个类，用@Module注解，
 * 这样Dagger在构造类的实例的时候，就知道从哪里去找到需要的 依赖。modules的一个
 * 重要特征是它们设计为分区并组合在一起（比如说，在我们的app中可以有多个组成在一起的modules）。
 *
 *
 *
 *
 */
//标记这个calss是一个Module，对外提供实例用
@Module
public class AppModule {
    private Context context;

    public AppModule(Context context){
        this.context  = context;
    }

    /**
     * @Provides: 在modules中，我们定义的方法是用这个注解，以此来告诉Dagger我们想要构造对象并提供这些依赖。
     *            标记方法返回值需要注入到dagger中
     * @return
     */
    @Provides
    public Context provideContext(){
        return context;
    }
}

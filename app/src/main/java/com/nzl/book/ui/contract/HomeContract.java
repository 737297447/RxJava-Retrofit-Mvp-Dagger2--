package com.nzl.book.ui.contract;

import com.nzl.book.base.BaseContract;
import com.nzl.book.bean.BookToc;
import com.nzl.book.bean.Recommend;

import java.util.List;

/**
 * Created by Administrator on 2016/11/9.
 */

public interface HomeContract {
    interface View extends BaseContract.BaseView{
        void showHomeList(List<Recommend.RecommendBooks> list);

        void showBookToc(String bookId, List<BookToc.mixToc.Chapters> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void getRecommendList();
    }
}

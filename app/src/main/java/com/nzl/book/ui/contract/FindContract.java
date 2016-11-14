package com.nzl.book.ui.contract;

import com.nzl.book.base.BaseContract;
import com.nzl.book.bean.ComTarget;

import java.util.List;

/**
 * Created by Administrator on 2016/11/11.
 */

public interface FindContract {
    interface View extends BaseContract.BaseView{
        void showTieziList(List<ComTarget> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T>{
        void getTieizList(String page,String pagesize);
    }

}

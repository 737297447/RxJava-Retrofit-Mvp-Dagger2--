package com.nzl.book.bean;

import com.nzl.book.bean.base.BaseBean;

/**
 * Created by Administrator on 2016/11/8.
 */

public class FindBean extends BaseBean {

    private String title;

    public FindBean(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

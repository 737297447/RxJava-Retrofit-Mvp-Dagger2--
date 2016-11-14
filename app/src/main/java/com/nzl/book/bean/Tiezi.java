package com.nzl.book.bean;

import com.nzl.book.bean.base.BaseBean;

import java.util.List;

/**
 * Created by longhy on 2016/8/11.
 */
public class Tiezi extends BaseBean {
    private List<ComTarget> data;

    public List<ComTarget> getData() {
        return data;
    }

    public void setData(List<ComTarget> data) {
        this.data = data;
    }
}

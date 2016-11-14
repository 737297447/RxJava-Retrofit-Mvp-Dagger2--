package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComRes implements Serializable {

    private String url;
    private ComScale scale;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ComScale getScale() {
        return scale;
    }

    public void setScale(ComScale scale) {
        this.scale = scale;
    }
}

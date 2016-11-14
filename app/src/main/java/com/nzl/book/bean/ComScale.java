package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComScale implements Serializable {
    private String thumb;
    private String monet;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getMonet() {
        return monet;
    }

    public void setMonet(String monet) {
        this.monet = monet;
    }
}

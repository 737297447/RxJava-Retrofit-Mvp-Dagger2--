package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/7/8.
 */
public class Favorite_info implements Serializable {
    // 文章类型。0-article（图文），1-article（视频），2-collocation（潮流）
    private int type;
    private Doc_info doc_info;
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Doc_info getDoc_info() {
        return doc_info;
    }

    public void setDoc_info(Doc_info doc_info) {
        this.doc_info = doc_info;
    }
}

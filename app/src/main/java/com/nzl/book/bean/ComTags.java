package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComTags implements Serializable {


    private String type;
    private String tag_id;
    private String name;
    private String lefttop;
    private String rightbottom;
    private String toward;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTag_id() {
        return tag_id;
    }

    public void setTag_id(String tag_id) {
        this.tag_id = tag_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLefttop() {
        return lefttop;
    }

    public void setLefttop(String lefttop) {
        this.lefttop = lefttop;
    }

    public String getRightbottom() {
        return rightbottom;
    }

    public void setRightbottom(String rightbottom) {
        this.rightbottom = rightbottom;
    }

    public String getToward() {
        return toward;
    }

    public void setToward(String toward) {
        this.toward = toward;
    }
}

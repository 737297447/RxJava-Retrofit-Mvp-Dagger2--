package com.nzl.book.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComElements implements Serializable {

    private String type;
    private String summary;
    private List<ComTags> tags;
    private ComRes res;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<ComTags> getTags() {
        return tags;
    }

    public void setTags(List<ComTags> tags) {
        this.tags = tags;
    }

    public ComRes getRes() {
        return res;
    }

    public void setRes(ComRes res) {
        this.res = res;
    }

}

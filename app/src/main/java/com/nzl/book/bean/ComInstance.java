package com.nzl.book.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComInstance implements Serializable {
    private String title;
    private String content;
    private List<ComElements> elements;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<ComElements> getElements() {
        return elements;
    }

    public void setElements(List<ComElements> elements) {
        this.elements = elements;
    }
}

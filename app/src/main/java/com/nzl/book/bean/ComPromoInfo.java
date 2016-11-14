package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComPromoInfo implements Serializable {

    private int type;
    private String promo_id;
    private String name;
    private String thumb;
    private String begin_time;
    private String end_time;
    private String participate_cnt;
    private String begin;
    private String end;

    private ComInstance instance;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(String promo_id) {
        this.promo_id = promo_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ComInstance getInstance() {
        return instance;
    }

    public void setInstance(ComInstance instance) {
        this.instance = instance;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getParticipate_cnt() {
        return participate_cnt;
    }

    public void setParticipate_cnt(String participate_cnt) {
        this.participate_cnt = participate_cnt;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

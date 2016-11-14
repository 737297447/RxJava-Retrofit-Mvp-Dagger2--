package com.nzl.book.bean;

import java.io.Serializable;

/**
 * Created by longhy on 2016/5/16.
 */
public class Actor implements Serializable {
    /** actor对象类型。0-用户，1-商家，2-广告主，3-第三方应用*/
    private int type;
    private String obj_id;
    private String avatar;
    private String objname;
    private String leven;
    /** 徽章（可选）*/
    private String badge;
    /** 关注标记bitmap（可选）。00(0)-互相没关注，01(1)-他关注了我，10(2)-我关注了他，11(3)双向关注*/
    private int followship;
    /** 0普通用户，1代言人，2官方账号*/
    private int degree;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getObj_id() {
        return obj_id;
    }

    public void setObj_id(String obj_id) {
        this.obj_id = obj_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getObjname() {
        return objname;
    }

    public void setObjname(String objname) {
        this.objname = objname;
    }

    public String getLeven() {
        return leven;
    }

    public void setLeven(String leven) {
        this.leven = leven;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getFollowship() {
        return followship;
    }

    public void setFollowship(int followship) {
        this.followship = followship;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }
}

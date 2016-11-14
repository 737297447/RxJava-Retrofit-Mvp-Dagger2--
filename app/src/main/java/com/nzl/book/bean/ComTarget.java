package com.nzl.book.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by longhy on 2016/5/16.
 */
public class ComTarget implements Serializable {

    private int type;
    private String title;
    private String content;
    private int like_cnt;
    private int comment_cnt;
    private List<ComElements> elements;
    private ComPromoInfo promo_info;
    private String is_liked;
    private String post_id;
    private int view_cnt;
    private int favorite_cnt;
    private int share_cnt;
    private String user_id;
    private String ctime;
    private String promo_id;
    private Actor userInfo;
    private Favorite_info favorite_info;
    private String favorite_id;
    /** status == 1 正常显示*/
    private int status;
    private String shelve_time;


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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

    public int getLike_cnt() {
        return like_cnt;
    }

    public void setLike_cnt(int like_cnt) {
        this.like_cnt = like_cnt;
    }

    public int getComment_cnt() {
        return comment_cnt;
    }

    public void setComment_cnt(int comment_cnt) {
        this.comment_cnt = comment_cnt;
    }

    public List<ComElements> getElements() {
        return elements;
    }

    public void setElements(List<ComElements> elements) {
        this.elements = elements;
    }

    public ComPromoInfo getPromo_info() {
        return promo_info;
    }

    public void setPromo_info(ComPromoInfo promo_info) {
        this.promo_info = promo_info;
    }

    public String getIs_liked() {
        return is_liked;
    }

    public void setIs_liked(String is_liked) {
        this.is_liked = is_liked;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }


    public int getView_cnt() {
        return view_cnt;
    }

    public void setView_cnt(int view_cnt) {
        this.view_cnt = view_cnt;
    }

    public int getFavorite_cnt() {
        return favorite_cnt;
    }

    public void setFavorite_cnt(int favorite_cnt) {
        this.favorite_cnt = favorite_cnt;
    }

    public int getShare_cnt() {
        return share_cnt;
    }

    public void setShare_cnt(int share_cnt) {
        this.share_cnt = share_cnt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getPromo_id() {
        return promo_id;
    }

    public void setPromo_id(String promo_id) {
        this.promo_id = promo_id;
    }

    public Actor getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Actor userInfo) {
        this.userInfo = userInfo;
    }

    public Favorite_info getFavorite_info() {
        return favorite_info;
    }

    public void setFavorite_info(Favorite_info favorite_info) {
        this.favorite_info = favorite_info;
    }

    public String getFavorite_id() {
        return favorite_id;
    }

    public void setFavorite_id(String favorite_id) {
        this.favorite_id = favorite_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShelve_time() {
        return shelve_time;
    }

    public void setShelve_time(String shelve_time) {
        this.shelve_time = shelve_time;
    }
}

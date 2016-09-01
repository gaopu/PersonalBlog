package com.blog.po;

import java.util.Date;

/**
 * Created by panlu on 15-10-21.
 */
public class Comment {
    private int id;
    private String user_name;
    private String user_email;
    private Date time;
    private String content;
    private String type;  //type存'a'表示对博文的回复，存'c'表示对评论的回复,,type in ('a','c')
    private int article_id;
    private int comment_id;   //编程时规定:对评论的回复不能被回复

    public Comment() {
    }

    /**
     * @param id
     * @param user_name
     * @param user_email
     * @param time
     * @param content
     * @param type
     * @param article_id
     * @param comment_id
     */
    public Comment(int id, String user_name, String user_email, Date time, String content, String type, int article_id, int comment_id) {
        this.id = id;
        this.user_name = user_name;
        this.user_email = user_email;
        this.time = time;
        this.content = content;
        this.type = type;
        this.article_id = article_id;
        this.comment_id = comment_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    @Override
    public String toString() {
        return "user_name: "+this.user_name+" user_email: "+this.user_email+" time: "+this.time+" content: "+this.content+" comment_id: "+this.comment_id+" article_id: "+this.article_id;
    }
}

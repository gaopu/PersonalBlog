package com.blog.po;

import java.util.Date;

/**
 * Created by geekgao on 15-10-12.
 */
public class Article {
    private int id;
    private int authorId;
    private String title;
    private Date time;
    private int readNum;
    private int commentNum;
    private String deleted;

    public Article() {
    }

    public Article(int authorId, String title, Date time, int readNum, int commentNum, String deleted) {

        this.authorId = authorId;
        this.title = title;
        this.time = time;
        this.readNum = readNum;
        this.commentNum = commentNum;
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getReadNum() {
        return readNum;
    }

    public void setReadNum(int readNum) {
        this.readNum = readNum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}

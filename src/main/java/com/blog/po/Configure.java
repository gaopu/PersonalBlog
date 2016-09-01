package com.blog.po;

/**
 * Created by hexing on 15-10-14.
 */
public class Configure {
    private int id;//主键
    private String head;//标题
    private String describ;//描述
    private int edit_type;//编辑类型
    private int display_num;//每页展示数目
    private int email_inform;//评论是否通知

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDescrib() {
        return describ;
    }

    public void setDescrib(String describ) {
        this.describ = describ;
    }

    public int getEdit_type() {
        return edit_type;
    }

    public void setEdit_type(int edit_type) {
        this.edit_type = edit_type;
    }

    public int getDisplay_num() {
        return display_num;
    }

    public void setDisplay_num(int display_num) {
        this.display_num = display_num;
    }

    public int getEmail_inform() {
        return email_inform;
    }

    public void setEmail_inform(int email_inform) {
        this.email_inform = email_inform;
    }
}

package com.blog.po;

/**
 * Created by geekgao on 15-10-18.
 */
public class ArticleCategory {
    int article_Id;
    int category_Id;

    public ArticleCategory() {
    }

    public ArticleCategory(int article_Id, int category_Id) {
        this.article_Id = article_Id;
        this.category_Id = category_Id;
    }

    public int getArticle_Id() {
        return article_Id;
    }

    public void setArticle_Id(int article_Id) {
        this.article_Id = article_Id;
    }

    public int getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(int category_Id) {
        this.category_Id = category_Id;
    }
}

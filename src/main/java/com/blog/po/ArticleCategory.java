package com.blog.po;

/**
 * Created by geekgao on 15-10-18.
 */
public class ArticleCategory {
    int articleId;
    int categoryId;

    public ArticleCategory() {
    }

    public ArticleCategory(int articleId, int categoryId) {
        this.articleId = articleId;
        this.categoryId = categoryId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}

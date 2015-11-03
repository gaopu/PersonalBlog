package com.blog.controller;

import com.blog.po.Article;
import com.blog.service.AdminService;
import com.blog.service.ArticleCategoryService;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geekgao on 15-10-28.
 */
@Controller
public class HomePageController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleCategoryService articleCategoryService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getIndex(Model model) throws IOException {
        List<Article> articles = articleService.getCommonArticle();
        //传入页面存放article的list
        model.addAttribute("articles",articles);

        //存放作者id和作者昵称的对应关系
        Map<Integer,String> authorId_nickName = new HashMap<Integer, String>();
        //存放文章id和文章分类名称的信息
        Map<Integer,String> articleId_categoryName = new HashMap<Integer, String>();
        //存放文章id和阅读数量的信息
        Map<Integer,Integer> articleId_readNum = new HashMap<Integer, Integer>();
        //存放文章id和评论数量的信息
        Map<Integer,Integer> articleId_commentNum = new HashMap<Integer, Integer>();

        int authorId;
        int articleId;
        for (Article article:articles) {
            authorId = article.getAuthor_Id();
            articleId = article.getId();

            authorId_nickName.put(authorId,adminService.getNickName(authorId));
            articleId_categoryName.put(articleId,categoryService.getName(articleCategoryService.getCategoryId(articleId)));
            articleId_readNum.put(articleId,articleService.getReadNum(articleId));
            articleId_commentNum.put(articleId,articleService.getCommentNum(articleId));
        }
        model.addAttribute("authorId_nickName",authorId_nickName);
        model.addAttribute("articleId_categoryName",articleId_categoryName);
        model.addAttribute("articleId_readNum",articleId_readNum);
        model.addAttribute("articleId_commentNum",articleId_commentNum);
        return "index";
    }
}

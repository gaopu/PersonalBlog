package com.blog.controller;

import com.blog.po.Admin;
import com.blog.po.Article;
import com.blog.service.AdminService;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.*;

/**
 * Created by geekgao on 15-10-28.
 */
@Controller
public class HomePageController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public String getIndex(Model model) throws IOException {
        List<Article> articles = articleService.getCommonArticle();
        //传入页面存放article的list
        model.addAttribute("articles",articles);

        //存放作者id和作者昵称的对应关系
        Map<Integer,String> id_Nickname = new HashMap<Integer, String>();

        int id;
        for (Article article:articles) {
            id = article.getAuthor_Id();
            id_Nickname.put(id,adminService.getNickName(id));
        }
        model.addAttribute("id_nickname",id_Nickname);
        return "index";
    }
}

package com.blog.controller;

import com.blog.po.Comment;
import com.blog.service.ArticleService;
import com.blog.service.CommentService;
import com.blog.utils.BlogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by panlu on 15-10-22.
 */
@Controller
public class ComPostController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "editcomment" ,method = RequestMethod.POST)
    public void editComment(HttpServletResponse respone, @RequestParam("id") String id, @RequestParam("content") String content, @RequestParam("user_name") String user_name, @RequestParam("user_email") String user_email) throws IOException{
        if (content.equals("") || user_email.equals("") || user_name.equals("")) {
            respone.sendRedirect("article?id=" + id);
            return;
        }
        Integer idact = Integer.parseInt(id);
        Date curtime = new Date(System.currentTimeMillis());
        synchronized (ComPostController.class){
            //首先是对一篇文章的评论
            Comment commentpojo = new Comment(0,user_name,user_email,curtime,content,"a",idact,0);
            commentService.insertArt(commentpojo);
        }
        respone.sendRedirect("article?id=" + id);
    }

    //拦截对评论的回复(刚开始默认的是对10号评论的回复)
    @RequestMapping(value = "editreply", method = RequestMethod.POST)
    public void editReply(HttpServletResponse respone, @RequestParam("id") String id,@RequestParam("content") String content, @RequestParam("user_name") String user_name, @RequestParam("user_email") String user_email,@RequestParam("comment_id") String comment_id) throws IOException {
        if (content.equals("") || user_email.equals("") || user_name.equals("")) {
            respone.sendRedirect("article?id=" + id);
            return;
        }
        int idarc = Integer.parseInt(id);
        Date curtime = new Date(System.currentTimeMillis());
        synchronized (ComPostController.class) {
            Integer rcomment_id = Integer.parseInt(comment_id);
            Comment commentpojo = new Comment(0,user_name,user_email,curtime,content,"c",idarc,rcomment_id);
            commentService.insertCom(commentpojo);
        }
        respone.sendRedirect("article?id=" + id);
    }


    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String showCom(Model model,@RequestParam("id") String id,ModelMap modelMap) throws IOException{
        int idarc = Integer.parseInt(id);
        List<Comment> commentsList;
        List<Comment> replyList;

        synchronized (ComPostController.class) {
            commentsList = commentService.selectCom(idarc);  //将所有的评论查找出来

            replyList = commentService.selectRep(idarc);
        }
        model.addAttribute("commentsList", commentsList);     //传过去两个List<Comment>  一个是所有评论的，另一个是所有对评论的回复
        model.addAttribute("replyList", replyList);

        //把文章传入前台页面
        BufferedReader readArticle = new BufferedReader(new FileReader(BlogUtils.getArticleFile(idarc)));
        StringBuilder content = new StringBuilder();
        while (readArticle.ready()) {
            content.append(readArticle.readLine());
        }
        //传入文章内容和标题
        model.addAttribute("content", content);
        model.addAttribute("title",articleService.getTitle(idarc));

        return "article";
    }

}

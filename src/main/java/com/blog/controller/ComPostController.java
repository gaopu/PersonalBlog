package com.blog.controller;

import com.blog.po.Comment;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "editcomment" ,method = RequestMethod.POST)
    public void editComment(HttpSession session,HttpServletResponse respone,@RequestParam("id") String id,@RequestParam("content") String content,@RequestParam("user_name") String user_name,@RequestParam("user_email") String user_email) throws IOException{
        if (content.equals("") || user_email.equals("") || user_name.equals("")) {
            respone.sendRedirect("article?id=" + id);
            return;
        }
        Integer idact = Integer.parseInt(id);
        Date curtime = new Date(System.currentTimeMillis());
        System.out.println(curtime);
        synchronized (ComPostController.class){
            System.out.println("user_email: "+user_email+"user_name: "+user_name+"content: "+content+"curent: "+curtime);
            //首先是对一篇文章的评论
            Comment commentpojo = new Comment(0,user_name,user_email,curtime,content,"a",idact,0);
            commentService.insertArt(commentpojo);
            System.out.println(commentpojo);
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
        System.out.println("回复的时间：" + curtime);
        synchronized (ComPostController.class) {
            System.out.println("回复者的信息:");
            Integer rcomment_id = Integer.parseInt(comment_id);
            System.out.println("user_email: " + user_email + "user_name: " + user_name + "content: " + content + "curent: " + curtime+"comment_id"+comment_id);
            Comment commentpojo = new Comment(0,user_name,user_email,curtime,content,"c",idarc,rcomment_id);
            System.out.println(commentpojo);
            commentService.insertCom(commentpojo);
        }
        respone.sendRedirect("article?id=" + id);
    }


    @RequestMapping(value = "/article",method = RequestMethod.GET)
    public String showCom(ModelMap map,@RequestParam("id") String id) throws IOException{
        int idarc = Integer.parseInt(id);
        List<Comment> commentsList;
        List<Comment> replyList;

        synchronized (ComPostController.class) {
            commentsList = commentService.selectCom(idarc);  //将所有的评论查找出来

            replyList = commentService.selectRep(idarc);
        }
        map.put("commentsList", commentsList);     //传过去两个List<Comment>  一个是所有评论的，另一个是所有对评论的回复
        map.put("replyList",replyList);
        return "article";
    }

}

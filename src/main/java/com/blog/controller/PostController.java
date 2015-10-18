package com.blog.controller;

import com.blog.po.Article;
import com.blog.po.ArticleCategory;
import com.blog.service.ArticleCategoryService;
import com.blog.service.ArticleService;
import com.blog.utils.BlogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Created by geekgao on 15-10-12.
 */
@Controller
public class PostController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    /**
     * 博文表单验证
     * @param session
     * @param response
     * @param title
     * @param content
     * @throws IOException
     */
    @RequestMapping(value = "postedit" ,method = RequestMethod.POST)
    public void postEdit(HttpSession session,HttpServletResponse response,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("category") int categoryId) throws IOException {
        //根据session中的level判断是不是管理员
        String level = (String) session.getAttribute("level");
        //是管理员,调用服务将文章写入数据库
        if (level != null && level.equals("0")) {
            Date nowTime = new Date(System.currentTimeMillis());

            synchronized (PostController.class) {
                articleService.insert(new Article((Integer) session.getAttribute("id"),title,nowTime,0,0,"n"));
                //获得刚存储的文章的id
                int latestId = articleService.getLatestId();
                //存储文章和类别的关联信息
                articleCategoryService.insert(new ArticleCategory(latestId,categoryId));
                //文章存储到本地
                saveArticleToDisk(latestId, content);
            }

        }
        //转到首页
        response.sendRedirect("");
    }

    /**
     * 按照文章id把文章存储到本地
     * @param latestId 最新的文章id
     * @param content 文章内容
     */
    private void saveArticleToDisk(int latestId, String content) throws IOException {

        //获取存储文章文件的路径
        String articleFolderPath = BlogUtils.getArticleFolderPath();

        //尝试创建文件夹
        File folder = new File(articleFolderPath);
        folder.mkdirs();

        BufferedWriter writer = new BufferedWriter(new FileWriter(articleFolderPath + latestId + ".md"));
        writer.write(content);
        writer.close();
    }
}
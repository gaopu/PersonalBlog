package com.blog.controller;

import com.blog.po.Article;
import com.blog.po.Category;
import com.blog.service.ArticleCategoryService;
import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by geekgao on 15-10-7.
 * 后台管理页面控制器
 */
@Controller
@RequestMapping("manage")
public class ManageController {

    @Autowired
    ArticleCategoryService articleCategoryService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public void manage(HttpServletResponse response) throws IOException {
        response.sendRedirect("manage/home");
    }

    /**
     * 后台首页
     * @return
     */
    @RequestMapping(value = "home" , method = RequestMethod.GET)
    public String manageHomePage() {
        return "manage/home";
    }

    /**
     * 写博文页面
     * @return
     */
    @RequestMapping(value = "post" , method = RequestMethod.GET)
    public String postManage(Model model) throws IOException {
        //将文章类别信息传送到前台
        model.addAttribute("categories", categoryService.getAll());
        return "manage/post";
    }

    /**
     * 文章的类别管理页面
     * @return
     */
    @RequestMapping(value = "category",method = RequestMethod.GET)
    public String categoryManage(Model model) throws IOException {
        List<Category> categories = categoryService.getAll();
        if (categories != null) {
            model.addAttribute("categories",categories);
        }

        //类别名称对应所包含的文章个数
        Map<Integer,Integer> categoryId_count = new HashMap<Integer, Integer>();
        for (Category category:categories) {
            categoryId_count.put(category.getId(),categoryService.getArticleCountByCategoryId(category.getId()));
        }
        model.addAttribute("categoryId_count",categoryId_count);

        return "manage/category";
    }

    /**
     * 处理添加类别请求
     * @return
     */
    @RequestMapping(value = "addcategory",method = RequestMethod.GET)
    public @ResponseBody String addCategoryManage(@RequestParam("name") String name) throws IOException {
        if (!categoryService.exist(name)) {
            categoryService.insert(new Category(name));
            return "success";
        } else {
            return "duplicate";
        }
    }

    @RequestMapping(value = "deletecategory",method = RequestMethod.GET)
    public @ResponseBody String deleteCategory(@RequestParam("id") String id) throws IOException {
        //不处理非数字参数
        try {
            Integer.valueOf(id);
        } catch (NumberFormatException e) {
            return "";
        }

        //把当前分类下的文章转移到“未分类”
        articleCategoryService.updateAfterDelCatrgory(id,"1");
        categoryService.delete(id);
        return "success";
    }

    @RequestMapping(value = "getcategorylatestid",method = RequestMethod.GET)
    public @ResponseBody String getCategoryLatestId() throws IOException {
        return String.valueOf(categoryService.getLatestId());
    }

    @RequestMapping(value = "updatecategory",method = RequestMethod.GET)
    public @ResponseBody String update(@RequestParam("id") String id,@RequestParam("name") String newName) throws IOException {
        if (id.equals("") || newName.equals("")) {
            return "";
        }
        //不处理非数字参数
        try {
            Integer.valueOf(id);
        } catch (NumberFormatException e) {
            return "";
        }

        if (categoryService.exist(newName)) {
            return "duplicate";
        }
        categoryService.update(id,newName);
        return "success";
    }

    @RequestMapping(value = "deleted",method = RequestMethod.GET)
    public String deletedArticle(Model model) throws IOException {
        //获取所有被删的文章
        List<Article> articles = articleService.getDeletedArticle();
        model.addAttribute("articles",articles);
        return "manage/deleted";
    }

    @RequestMapping(value = "deletearticle",method = RequestMethod.GET)
    public @ResponseBody String deleteArticle(@RequestParam("id") String articleId) throws IOException {
        int id;
        try {
            id = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            return "fail";
        }

        if (articleService.isDeleted(id)) {
            articleService.delete(id);
        } else {
            articleService.moveToDusbin(id);
        }
        return "success";
    }

    @RequestMapping(value = "recoverarticle",method = RequestMethod.GET)
    public @ResponseBody String recoverArticle(@RequestParam("id") String articleId) throws IOException {
        int id;
        try {
            id = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            return "fail";
        }

        if (articleService.isDeleted(id)) {
            articleService.recover(id);
        } else {
            return "fail";
        }
        return "success";
    }
}

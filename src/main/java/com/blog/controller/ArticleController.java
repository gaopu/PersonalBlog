package com.blog.controller;

import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.utils.PageParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("manage")
public class ArticleController {

	@Resource
	ArticleService articleService;
	@Resource
	CategoryService categoryService;

	//文章列表
	@RequestMapping(value = "/getarticle",method = RequestMethod.GET)
	public String getArticle(Model map,HttpServletRequest request) throws IOException {
		String currPageStr = request.getParameter("page");
		if(currPageStr==null){
			currPageStr="1";
		}
		int currPage = Integer.parseInt(currPageStr);
		// 获取总记录数
		int rowCount = articleService.getRowCount();
		if(rowCount==0){
			return "manage/nullpostlist";
		}else{
			PageParam pageParam = new PageParam();
			pageParam.setRowCount(rowCount);
			if (pageParam.getTotalPage() < currPage) {
				currPage = pageParam.getTotalPage();
			}
			pageParam.setCurrPage(currPage);
			pageParam = articleService.getPagedArticle(pageParam);
			List<String> allcategory = categoryService.getAllCategory();
			map.addAttribute("pageParamData", pageParam.getData());
			map.addAttribute("allcategory",allcategory);
			request.setAttribute("pageParam", pageParam);
			return "manage/postlist";
		}

	}

	//删除文章
	@RequestMapping(value = "/deleArticle",method = RequestMethod.POST)
	public @ResponseBody String setArticle(@RequestParam int id,@RequestParam int page,HttpServletRequest request,HttpServletResponse response) throws IOException {
		articleService.moveToDusbin(id);
		return "success";
	}

	//文章分类
	@RequestMapping(value = "getCategory")
	public @ResponseBody String getCategory(@RequestParam int id,HttpServletResponse response) throws IOException {
		List<Integer> category = categoryService.getCategoryByArticleId(id);
		return category.toString();
	}

	//设置文章分类
	@RequestMapping(value = "setCategory",method = RequestMethod.POST)
	public @ResponseBody String setCategory(@RequestParam int id,@RequestParam String b) throws IOException {
		String[] arr = b.split(",");
		int[] selectId = new int[arr.length];
		for(int i = 0; i < arr.length;i++){
			selectId[i]=Integer.parseInt(arr[i]);
		}
		articleService.setCategory(id, selectId);
		return "success";
	}
}

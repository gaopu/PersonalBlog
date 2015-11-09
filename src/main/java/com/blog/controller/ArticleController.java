package com.blog.controller;

import com.blog.service.ArticleService;
import com.blog.service.CategoryService;
import com.blog.utils.PageParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
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
		int currPage = 1;
		currPage = Integer.parseInt(currPageStr);
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
	@RequestMapping(value = "/setArticle",method = RequestMethod.POST)
	public void setArticle(ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException {
		int id,pages;
		pages = Integer.parseInt(request.getParameter("page"));
		if((id = Integer.parseInt(request.getParameter("delete")))!=0){
			articleService.moveToDusbin(id);
			try {
				response.sendRedirect("http://localhost:8080/getarticle?page="+pages);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//文章分类
	@RequestMapping(value = "getCategory")
	public void getCategory(@RequestParam int id,HttpServletResponse response) throws IOException {
		List<Integer> category = categoryService.getCategoryByArticleId(id);
		try {
			PrintWriter out=response.getWriter();
			out.print(category);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//设置文章分类
	@RequestMapping(value = "setCategory",method = RequestMethod.POST)
	public void setCategory(@RequestParam int id,@RequestParam String b) throws IOException {
		String[] arr = b.split(",");
		int[] selectId = new int[arr.length];
		for(int i = 0; i < arr.length;i++){
			selectId[i]=Integer.parseInt(arr[i]);
		}
		categoryService.setCategory(id,selectId);
	}


}

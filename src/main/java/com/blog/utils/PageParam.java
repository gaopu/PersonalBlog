package com.blog.utils;

import com.blog.po.Article;
import com.blog.po.Comment;

import java.util.List;

public class PageParam {

	private int currPage ; // 当前页
	
	private int totalPage ; // 总页
	
	private int rowCount ; // 总记录数
	
	public static int pageSize = 2; // 页大小

	private List<Article> data ; // 数据

	private List<Comment> datacom;   //评论的数据

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		int totalPage = rowCount / pageSize;
		if (rowCount % pageSize > 0) {
			totalPage += 1;
		}
		setTotalPage(totalPage);
		this.rowCount = rowCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<Article> getData() {
		return data;
	}

	public void setData(List<Article> data) {
		this.data = data;
	}

	public List<Comment> getDatacom() {
		return datacom;
	}

	public void setDatacom(List<Comment> datacom) {
		this.datacom = datacom;
	}
}

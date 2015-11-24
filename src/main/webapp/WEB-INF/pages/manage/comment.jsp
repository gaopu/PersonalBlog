<%@ page import="com.blog.utils.PageParam" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-8
  Time: 下午8:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>评论管理</title>
  <link href="webapp/css/managercom.css" type="text/css" rel="stylesheet">
  <script src="http://cdn.bootcss.com/jquery/3.0.0-alpha1/jquery.js"></script>
</head>
<body>
<form action="deletecomment" id="delcomment" method="post">
<table cellpadding="0">
  <tr>
    <th style="width: 426px;">标题</th>
    <th style="width: 140px;">作者</th>
    <th style="width: 140px;">时间</th>
    <th style="width: 100px;">操作</th>
    <th style="width: 100px;">文章</th>
  </tr>
  <tbody>
  <tr class="altitem">
    <td class="tdleft">

  <c:forEach items="${requestScope.onepagedate}" var="comT">
  <tr>
    <th>${comT.content}</th>
      <c:forEach items="${requestScope.artlist}" var="artT">
        <c:if test ="${comT.article_id==artT.id}">
        <th>${comT.user_name}</th>
        <th>${comT.time}</th>
        <th><a onclick="deletefun(${comT.id})">删除</a></th>
        <th>${artT.title}</th>
  </tr>
      </c:if>
    </c:forEach>
  </c:forEach>
    </td>
  </tr>
  </tbody>
</table>
  <input type="hidden" id="delete" name="delete">
</form>

<span>第</span>
<%
  PageParam pageParam = (PageParam)request.getAttribute("pageParam");
  int currPage = pageParam.getCurrPage();
  int totalPage = pageParam.getTotalPage();
  for(int i = 1; i <= totalPage; i ++){
    if(i == currPage){
%><span style="background: #0000ff; padding: 0 5px; color: #ffffff";><%=currPage %></span><%
}else{
%><a href="getcomment?page=<%=i%>" style="padding: 0 5px"><%=i %></a><%
    }
  }
%>
<span>页</span>

<script>

  var commentId;
  //删除评论
  var deletefun = function (id){
    if(confirm("确认删除")){
      document.getElementById("delete").value=id;
      document.getElementById("delcomment").submit();
    }
  }
</script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-7
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的博客首页</title>
</head>
<body>
这里是首页.<br>
<br>
文章预览:<br>
<c:forEach items="${articles}" var="article">
    题目:<a href="${pageContext.request.contextPath}/article?id=${article.id}">${article.title}</a><br>
    作者:${authorId_nickName[article.author_Id]}<br>
    分类:${articleId_categoryName[article.id]}<br>
    阅读量:${articleId_readNum[article.id]}<br>
    评论量:${articleId_commentNum[article.id]}<br>
    发表时间:${article.time}<br>
    <br>
</c:forEach>
<a href="${pageContext.request.contextPath}/login">管理员登录</a>
<a href="${pageContext.request.contextPath}/manage/post">已经等录?发表博文</a>
<a href="${pageContext.request.contextPath}/manage">后台管理</a>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-8
  Time: 下午8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回收站</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<table>
    <tr>
        <th style="width:120px;">题目</th>
        <th style="width:120px;">时间</th>
        <th style="width:120px;">阅读</th>
        <th style="width:120px;">评论</th>
        <th style="width:120px;">操作</th>
    </tr>
    <c:forEach items="${articles}" var="article">
        <tr id="${article.id}">
            <th>${article.title}</th>
            <th>${article.time}</th>
            <th>${article.read_Num}</th>
            <th>${article.comment_Num}</th>
            <th>
                <input id="recoveryBtn" type="button" onclick="recover(${article.id})" value="还原">
                <input id="completeDeleteBtn" type="button" onclick="completeDelete(${article.id})" value="彻底删除">
            </th>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}">首页</a>

<script>

    function recover(articleId) {
        var isDo = false;

        isDo = confirm("还原文章，确认吗？");
        if (isDo) {
            $.get("recoverarticle?id=" + articleId, function(result) {
                if (result == "success") {
                    $("#" + articleId).remove();
                }
            });
        }
    }

    function completeDelete(articleId) {
        var isDo = false;

        isDo = confirm("这将完全删除文章，确认吗？");
        if (isDo) {
            $.get("deletearticle?id=" + articleId, function(result) {
                if (result == "success") {
                    $("#" + articleId).remove();
                }
            });
        }
    }
</script>
</body>
</html>

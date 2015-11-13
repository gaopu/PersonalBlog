<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
        <%--定义时间变量，以供下面使用--%>
        <c:set var="time" value="${article.time}" />
        <tr id="${article.id}">
            <th>${article.title}</th>
            <th><fmt:formatDate value="${time}" pattern="yyyy年MM月dd日 HH:mm:ss"/></th>
            <th>${article.read_Num}</th>
            <th>${article.comment_Num}</th>
            <th>
                <input id="recoveryBtn" type="button" onclick="recover(${article.id})" value="还原">
                <input id="completeDeleteBtn" type="button" onclick="completeDelete(${article.id})" value="彻底删除">
            </th>
        </tr>
    </c:forEach>
</table>

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

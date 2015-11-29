<%@ page import="com.blog.utils.PageParam" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>评论管理</title>
  <script src="http://cdn.bootcss.com/jquery/3.0.0-alpha1/jquery.js"></script>
</head>

<%--<form action="/manage/getcomment" id="edit" method="post">--%>
<table cellpadding="0">
  <tr>
    <th style="width: 350px;">标题</th>
    <th style="width: 130px;">作者</th>
    <th style="width: 180px;">时间</th>
    <th style="width: 100px;">操作</th>
    <th style="width: 100px;">文章</th>
  </tr>
  <%--<%Configure configure = (Configure) request.getAttribute("comment");%>--%>
  <tbody>
  <c:forEach items="${requestScope.onepagedate}" var="comT">
  <tr id="${comT.id}">
    <th>${comT.content}</th>
      <c:forEach items="${requestScope.artlist}" var="artT">
        <c:if test="${comT.article_id==artT.id}">
        <th>${comT.user_name}</th>
        <th><fmt:formatDate value="${comT.time}" pattern="yyyy年MM月dd日 HH:mm:ss"/></th>
        <th><input type="button" onclick="deletefun(${comT.id})" value="删除"></th>
          <c:choose>
            <c:when test="${artT.deleted=='y'}"><th>该文章已被删除</th></c:when>
            <c:otherwise><th>${artT.title}</th></c:otherwise>
        </c:choose>
        </c:if>
    </c:forEach>
  </c:forEach>
  </tbody>
</table>
  <%--<input type="hidden" id="delete" name="delete" />--%>
<%--</form>--%>

<span>第</span>
<%
  PageParam pageParam = (PageParam)request.getAttribute("pageParam");
  int currPage = pageParam.getCurrPage();
  int totalPage = pageParam.getTotalPage();
  for(int i = 1; i <= totalPage; i ++){
    if(i == currPage){
%><span style="background: #0000ff; padding: 0 5px; color: #ffffff";><%=currPage %></span><%
}else{
%>
<%--<a href="getcomment?page=<%=i%>" style="padding: 0 5px"><%=i %></a><%--%>
<a href="#" onclick="pageJump('getcomment?page=<%=i%>')" style="padding: 0 5px"><%=i%></a><%
    }
  }
%>
<span>页</span>

<script>

  var commentId;
  //删除评论
  var deletefun = function (id) {
    if (confirm("确认删除")) {
//      document.getElementById("delete").value=id;
//      document.getElementById("delcomment").submit();
      $.post("deletecomment", {id: id, page:<%=currPage%>}, function (result) {
        if (result == "success") {
//          window.location.reload();  //重新刷新页面到页面首位置(文章第一页)
          $("#" + id).remove();
        }
      })
    }
  };

  //实现页面跳转
  function pageJump(requestUrl) {
    $.get(requestUrl,function(result){
      $("#content").html(result);
    });
  }

</script>
</body>
</html>

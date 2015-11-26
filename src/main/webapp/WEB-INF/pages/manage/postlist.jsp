<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.blog.utils.PageParam" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <title>文章管理</title>
</head>
<body>
  <table>
    <thead>
    <th width="20%">标题</th>
    <th width="30%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;时间</th>
    <th width="10%">阅读</th>
    <th width="10%">评论</th>
    <th width="10%">&nbsp;&nbsp;编辑</th>
    <th width="10%">&nbsp;&nbsp;删除</th>
    <th width="10%">&nbsp;&nbsp;分类</th>
    </thead>
    <tbody>
    <c:forEach items="${pageParamData}" var="article">
      <tr>
        <th width="20%">${article.title}</th>
        <th width="30%"><fmt:formatDate value="${article.time}" pattern="yyyy年MM月dd日 HH:mm:ss"/></th>
        <th width="10%">&nbsp;${article.read_Num}</th>
        <th width="10%">&nbsp;${article.comment_Num}</th>
        <th width="10%"><input type="button" value="编辑"></th>
        <th width="10%"><input type="button" onclick="dele(${article.id})" value="删除"></th>
        <th width="10%"><input type="button" onclick="showMsg(${article.id})" value="分类"></th>
      </tr>
    </c:forEach>
    </tbody>
  </table>
<span>第</span>
<%
  PageParam pageParam = (PageParam)request.getAttribute("pageParam");
  int currPage = pageParam.getCurrPage();
  int totalPage = pageParam.getTotalPage();
  for(int i = 1; i <= totalPage; i ++){
    if(i == currPage){
%><span style="background: #0000ff; padding: 0 5px; color: #ffffff";><%=currPage %></span><%
}else{
%><a href="#" onclick="pageJump('getarticle?page=<%=i%>')" style="padding: 0 5px"><%=i %></a><%
    }
  }
%>
<span>页</span>
<div style="width: 100px;display: none; height: 100px;border: 1px solid #000"  id="classify">
  <c:forEach var="category" items="${allcategory}">
    <input type="checkbox" name="categorys" value="${category}"/>${category}<br/>
  </c:forEach>
  <input type="submit" value="提交" onclick="submits()"/>
  <input type="submit" value="取消" onclick="cancle()"/>
</div>

<script>
  var selectdId;//选择文章的id

  //删除函数
  var dele = function (id){
    if(confirm("是否删除")){
      $.post("deleArticle",{id:id,page:<%=currPage%>},function(success){
          if(success=="success"){
            location.reload();
          }
      })
    }
  };

  //分类提交函数
  var submits = function(){
    var t = document.getElementById("classify");
    var inputs = t.getElementsByTagName("input");
    var i,j=0;
    var a = [],b = [];
    for(i=0;i < inputs.length;i++){
      if(inputs[i].checked==true){
        a[j++]=i+1;
      }
    }
    b = a.join(",");

    $.post("setCategory",{id:selectdId,b:b},function(success){
      if(success == "success"){
       cancle();
      }
    })
  };

  //分类取消函数
  var cancle = function(){
    var t = document.getElementById("classify");
    var inputs = t.getElementsByTagName("input");
    var i;
    t.style.display="none";
    for(i=0;i < inputs.length;i++){
      inputs[i].checked=false;
    }
  };

  //分类函数
  function showMsg(id){
    cancle();
    selectdId = id;
    $.post("getCategory",{id:id},function(category){
      var t = document.getElementById("classify");
      var inputs = t.getElementsByTagName("input");
      var i;
      for (i = 0; i < inputs.length;i++){
        inputs[i] = false;
      }
      var list = category.split(",");
      for(i = 0; i < list.length;i++){
        inputs[list[i][1]-2].checked = true;
      }
      t.style.display = "block";
    })
  };

</script>
</body>
</html>
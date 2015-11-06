<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.blog.utils.PageParam" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
  <title>文章管理</title>
</head>
<body>
<form action="setArticle" method="post" id="setarticle">
  <table>
    <thead>
    <th>标题</th>
    <th>阅读</th>
    <th>评论</th>
    <th>编辑</th>
    <th>删除</th>
    <th>分类</th>
    </thead>
    <tbody>
    <c:forEach items="${pageParamData}" var="article">
      <tr>
        <th>${article.title}(${article.time})</th>
        <th>${article.read_Num}</th>
        <th>${article.comment_Num}</th>
        <th>编辑</th>
        <th><a onclick="fun(${article.id})" href="#">删除</a></th>
        <th><a onclick="showMsg(${article.id})" href="#">分类</a></th>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <input type="hidden" name="delete" id="delete"/>
  <input type="hidden" name="page" id="page"/>
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
%><a href="getarticle?page=<%=i%>" style="padding: 0 5px"><%=i %></a><%
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
  var fun = function (id){
    if(confirm("是否删除")){
      document.getElementById("delete").value = id;
      document.getElementById("page").value = <%=currPage%>;
      document.getElementById("setarticle").submit();
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
    createXMLHttp();
    xmlHttp.onreadystatechange=function(){
      t.style.display="none";
      location.reload();
    };
    xmlHttp.open("post","setCategory",true);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.send("id="+selectdId+"&b="+b);
  };

  //分类取消函数
  var cancle = function(){
    var t = document.getElementById("classify");
    t.style.display="none";
   // location.reload();
  };
  var xmlHttp;
  function createXMLHttp(){
    if(window.XMLHttpRequest){
      xmlHttp=new XMLHttpRequest();
    }else{
      xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
  }
  //分类函数
  function showMsg(id){
    selectdId = id;
    createXMLHttp();
    xmlHttp.onreadystatechange=showMsgCallback;
    xmlHttp.open("post","getCategory",true);
    xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
    xmlHttp.send("id="+id);
  }
  function showMsgCallback(){
    if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
      var t = document.getElementById("classify");
      var inputs = t.getElementsByTagName("input");
      var list = xmlHttp.responseText;
      list = list.split(",");
      var i;
      for(i = 0; i < list.length;i++){
        inputs[list[i][1]-1].checked = true;
      }
      t.style.display = "block";
    }
  }
</script>
</body>
</html>
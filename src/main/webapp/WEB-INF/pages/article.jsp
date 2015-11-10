<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: panlu
  Date: 15-10-21
  Time: 下午10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>评论页面</title>
  <link href="../resources/css/form.css" type="text/css" rel="stylesheet">
  <script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
<h1>${title}</h1><br>
<div>${content}</div><br/>

<hr/>
<div class="section_title">
  <span>各种回音</span>
</div>
<c:forEach items="${commentsList}" var="t">
  ${t.user_name} 说:<br/>
  ${t.content}<br/>
  ${t.time}<br/>

  <button class="btn-respond">回复</button>
  <div id="respond" class="container">
    <form action="${pageContext.request.contextPath}/editreply" method="post" id="commentform">
      <ul class="comment-l">
        <li style="height:28px;line-height: 28px;overflow: hidden">
          <label for="content">评论内容：（必填）</label>
        </li>
        <li>
          <textarea name="content" id="content" tabindex="1" aria-required="true"></textarea>
        </li>
        <li class="comment-btn">
          <p>
            ( Ctrl+Enter快速提交 )&nbsp;&nbsp;&nbsp;
            <input name="submit" type="submit" id="submit" tabindex="5" value="写好了，发出去！" />
          </p>
        </li>
      </ul>

      <ul class="comment-r">
        <li>
          <label for="user_name">你的大名：（必填）</label>
        </li>
        <li>
          <input type="text" name="user_name" id="user_name" size="25" tabindex="2" aria-required='true' />
        </li>
        <li>
          <label for="user_email">邮箱地址：(必填)</label>
        </li>
        <li>
          <input type="text" name="user_email" id="user_email" size="25" tabindex="3" aria-required='true' />
        </li>
        <li>
          <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
        </li>
        <li>
          <input type="hidden" name="comment_id" value="${t.id}" />
        </li>
      </ul>
    </form>
    <button class="btn-revoke">取消</button>
  </div>
  <br/>
  <c:forEach items="${replyList}" var="tr">
    <c:if test ="${tr.comment_id==t.id}">
      ${tr.user_name} 说:<br/>
      ${tr.content}
      ${tr.time}<br/>
    </c:if>
  </c:forEach>
  <br/>
  <br/>
</c:forEach>

<script>
  $('.btn-respond').each(function(){
    $(this).click(function(){
      $(this).next().css('display', 'block');
    });
  });
  //取消回复
  $('.btn-revoke').each(function(){
    $(this).click(function(){
      $(this).parent().css('display','none');
    });
  });
</script>

<div id="respond">
  <form action="${pageContext.request.contextPath}/editcomment" method="post" id="commentform">
    <ul class="comment-l">
      <li style="height:28px;line-height: 28px;overflow: hidden">
        <label for="content">评论内容：（必填）</label>
      </li>
      <li>
        <textarea name="content" id="content" tabindex="1"></textarea>
      </li>
      <li class="comment-btn">
        <p>
          ( Ctrl+Enter快速提交 )&nbsp;&nbsp;&nbsp;&nbsp;
          <input name="submit" type="submit" id="submit" tabindex="5" value="写好了，发出去！">
        </p>
      </li>
    </ul>

    <ul class="comment-r">


    <li>
      <label for="user_name">你的大名：（必填）</label>
    </li>
    <li>
      <input type="text" name="user_name" id="user_name" size="25" tabindex="2" aria-required='true'>
    </li>
    <li>
      <label for="user_email">邮箱地址：(必填)</label>
    </li>
      <li>
        <input type="hidden" name="id" value="<%= request.getParameter("id") %>" />
      </li>
    <li>
      <input type="text" name="user_email" id="user_email" size="25" tabindex="3" aria-required='true'>
    </li>
    </ul>
  </form>
</div>
</body>
</html>

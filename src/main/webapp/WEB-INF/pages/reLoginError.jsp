<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-18
  Time: 下午17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
亲爱的<%=session.getAttribute("nickname")%>,您已经登录过了,请不要重复登录<br>
<a href="${pageContext.request.contextPath}/">返回首页</a>
</body>
</html>
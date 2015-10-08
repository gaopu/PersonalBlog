<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 2015/10/6
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring MVC Form Handling</title>
</head>
<body>
<h1>请登录:</h1>
<form method="post" action="loginVerify">
    邮箱:<input name="email"/><br/>
    密码:<input name="passwd"/><br/>
    <input type="submit"/>
</form>
</body>
</html>

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
    <script src="js/jquery-2.1.4.min.js"></script>
</head>
<body>
<h1>请登录:</h1>
<form id="loginform" action="loginVerify">
    邮箱:<input id="email" type="email" name="email"/><br/>
    密码:<input id="passwd" type="password" name="passwd"/><br/>
    <input id="submit" type="button" value="提交">
</form>
<div id = "result"></div>

<script type="text/javascript">
    $(document).ready(function() {
        function post() {
            $.post($("#loginform").attr("action"), $("#loginform").serialize(), function (result) {
                if (result == "success") {
                    window.location.href = "${pageContext.request.contextPath}/";
                } else {
                    $("#result").html(result);
                }
            });
        }

        function keydown() {
            if(event.keyCode == 13) {
                post();
            }
        }

        $("#email").keydown(keydown);
        $("#passwd").keydown(keydown);
        $("#submit").click(post);
    });
</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">博客</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="bloghome" class="active"><a href="${pageContext.request.contextPath}/">首页</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <%
                    if (session.getAttribute("flag") == "on") {
                %>
                <li id="postArticle"><a href="${pageContext.request.contextPath}/manage/post">发表博文</a></li>
                <li id="manageHome"><a href="${pageContext.request.contextPath}/manage">后台管理</a></li>
                <li><a id="logout" href="#">退出</a></li>
                <%
                    } else {
                %>
                <li><a href="${pageContext.request.contextPath}/login">管理员登录</a></li>
                <%
                    }
                %>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script>
    $(document).ready(function(){
        $("#logout").click(function() {
            $.get("${pageContext.request.contextPath}/logout",function(result){
                if (result == "success") {
                    window.location.href = "${pageContext.request.contextPath}/";
                }
            });
        });
    });
</script>
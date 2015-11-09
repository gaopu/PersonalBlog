<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-7
  Time: 下午6:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">

    <title>首页</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/starter-template.css" rel="stylesheet">

    <link href="css/screen.css" rel="stylesheet">

    <link href="http://cdn.bootcss.com/magnific-popup.js/1.0.0/magnific-popup.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<%@include file="nav.jsp"%>

<div class="container">
    <div class="starter-template">
        <div class="row">
            <div class="col-md-8">
                <c:forEach items="${articles}" var="article">
                    <%--定义时间变量，以供下面使用--%>
                    <c:set var="time" value="${article.time}" />
                    <article id=92 class="post tag-about-ghost tag-release tag-ghost-0-7-ban-ben">

                        <div class="post-head">
                            <h1 class="post-title"><a href="${pageContext.request.contextPath}/article?id=${article.id}">${article.title}</a></h1>
                            <div class="post-meta">
                                <span class="author">作者：${authorId_nickName[article.author_Id]}</span> &bull;
                                <time class="post-date"><fmt:formatDate value="${time}" pattern="yyyy年MM月dd日 HH:mm:ss"/></time>
                            </div>
                        </div>
                        <div class="post-content">
                            <p>Ghost 0.7.0 已经正式发布了！此版本主要对后台 UI 的重构，既包含重新设计，也包含底层功能的重大改进。0.7.0 还为即将到来的 API 做了很多铺垫工作。 Ghost 0.7.0 的主要改进 [新增] 设计新后台界面 [新增] 后台能够搜索博文和用户 [新增] 安</p>
                        </div>
                        <div class="post-permalink text-right">
                            <a href="${pageContext.request.contextPath}/article?id=${article.id}" class="btn btn-default">阅读全文</a>
                        </div>
                        <footer class="post-footer clearfix">
                            <div class="pull-right tag-list">
                                <i class="glyphicon glyphicon-eye-open"></i>
                                <span>阅读量:${articleId_readNum[article.id]}</span>&nbsp;
                                <i class="glyphicon glyphicon-comment"></i>
                                <span>评论量:${articleId_commentNum[article.id]}</span>
                            </div>
                        </footer>
                    </article>
                </c:forEach>
            </div>
            <div class="col-md-4">
                <h1>其他公告</h1>
            </div>
        </div>
    </div>

</div><!-- /.container -->


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>

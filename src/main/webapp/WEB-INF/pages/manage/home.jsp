<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-7
  Time: 下午8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../images/favicon.ico">

    <title>博客后台管理</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

    <link href="../css/screen.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<jsp:include page="../nav.jsp"/>

<div style="padding: 10px">
    <div class="row">
        <div class="col-md-2">
            <ul class="nav nav-sidebar">
                <li id="articleLi" class="active"><a href="#">文章管理</a></li>
                <li id="commentLi"><a href="#">评论管理</a></li>
                <li id="configLi"><a href="#">博客配置</a></li>
                <li id="categoryLi"><a href="#">类别管理</a></li>
                <li id="deletedLi" ><a href="#">回收站</a></li>
            </ul>
        </div>
        <div id="content" class="col-md-10"></div>
    </div>
</div>

<script>
    //网页一进来就进入文章管理模块
    $.get("getarticle?page=1",function(result){
        $("#content").html(result);
    });

    //清空最上面的导航栏目的ul中所有li的class属性
    $("ul.navbar-nav li").attr("class","");
    $("#manageHome").attr("class","active");

    function pageJump(requestUrl) {
        $.get(requestUrl,function(result){
            $("#content").html(result);
        });
    }

    //传进来被点击的li的id
    function clickList (id) {
        //清空class=nav-sidebar的ul中所有li的class属性
        $("ul.nav-sidebar li").attr("class","");

        if (id == "categoryLi") {
            $.get("category",function(result){
                $("#content").html(result);
            });
            $("#" + id).attr("class","active");
        } else if (id == "deletedLi") {
            $.get("deleted",function(result){
                $("#content").html(result);
            });
            $("#" + id).attr("class","active");
        } else if (id == "configLi") {
            $.get("configured",function(result){
                $("#content").html(result);
            });
            $("#" + id).attr("class","active");
        } else if (id == "commentLi") {
            $.get("getcomment?page=1",function(result){
                $("#content").html(result);
            });
            $("#" + id).attr("class","active");
        } else if (id == "articleLi") {
            $.get("getarticle?page=1",function(result){
                $("#content").html(result);
            });
            $("#" + id).attr("class","active");
        }
    }

    $("#categoryLi").click(function() {
        clickList("categoryLi");
    });
    $("#deletedLi").click(function() {
        clickList("deletedLi");
    });
    $("#configLi").click(function() {
        clickList("configLi");
    });
    $("#commentLi").click(function() {
        clickList("commentLi");
    });
    $("#articleLi").click(function() {
        clickList("articleLi");
    });
</script>
</body>
</html>


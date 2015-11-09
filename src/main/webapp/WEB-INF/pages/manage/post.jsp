<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: geekgao--%>
  <%--Date: 15-10-8--%>
  <%--Time: 下午8:29--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title></title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form method="post" action="${pageContext.request.contextPath}/postedit">--%>
    <%--题目:<input name="title"/><br/>--%>
    <%--内容:<input name="content"/><br/>--%>

    <%--类别:--%>
    <%--<label>--%>
        <%--<select name="category">--%>
            <%--<c:forEach items="${categories}" var="category">--%>
                <%--<option value="${category.id}">${category.name}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</label>--%>
    <%--<br>--%>

    <%--<input type="submit"/>--%>
<%--</form>--%>
<%--</body>--%>
<%--</html>--%>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-11-7
  Time: 下午22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>发博文</title>
    <script>
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/ueditor/";
    </script>

    <!-- Custom styles for this template -->
    <link href="../css/starter-template.css" rel="stylesheet">

    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <link href="../css/screen.css" rel="stylesheet">

    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
<%@include file="../nav.jsp"%>
<!-- 加载编辑器的容器 -->
<div class="container">

    <div class="starter-template">
        <div class="input-group input-group" style="margin-bottom: 10px">
            <span class="input-group-addon" id="sizing-addon1">文章标题</span>
            <input id="articleTitle" type="text" class="form-control" placeholder="输入文章标题" aria-describedby="sizing-addon1">
        </div>
        <script id="editor" name="content" type="text/plain"></script>
        选择类别:<br>
        <div id="selectcategory" class="pull-left">
            <c:forEach items="${categories}" var="category">
                <c:if test="${category.id != 1}">
                    <label class="checkbox-inline" style="margin-left: 10px">
                        <input type="checkbox" value="${category.id}" name="category">${category.name}
                    </label>
                </c:if>
            </c:forEach>
        </div>
        <br>
        <a id="postBtn" href="#" class="btn btn-default pull-right">发布</a>
    </div>
</div>
<!-- 配置文件 -->
<script type="text/javascript" src="../js/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="../js/ueditor.all.min.js"></script>
<!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>

<script>
    $("#postBtn").click(function () {
        //检查所需要的内容是否都填写了
        if ($("#articleTitle").val() == "") {
            alert("请填写文章标题");
            return;
        }
        if (UE.getEditor('editor').getContent() == "") {
            alert("请填写文章内容");
            return;
        }


        var id_array = [];
        $('input[name = "category"]:checked').each(function(){
            id_array.push($(this).val());//向数组中添加元素
        });
        var categoryIds = id_array.join(',');//将数组元素连接起来以构建一个字符串
        var title = $("#articleTitle").val();
        var content = UE.getEditor('editor').getContent();

        $.ajax({
            type:"post",
            url:"${pageContext.request.contextPath}/postedit",
            data:{
                title:title,
                categoryIds:categoryIds,
                content:content
            },
            success:function(result){
                if (result == "success") {
                    window.location.href = "${pageContext.request.contextPath}/";
                } else if (result == "paramWrong") {
                    alert("提交参数错误，请保存文章后调试.");
                } else {
                    alert("发生未知错误,文章提交失败.");
                }
            }
        });
    });
</script>

</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: geekgao
  Date: 15-10-8
  Time: 下午8:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>类别管理</title>
    <script src="http://libs.baidu.com/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>
<h1>类别信息</h1>
<table id="categorytab">
    <tr>
        <th style="width:120px;">类别</th>
        <th style="width:120px;">文章</th>
        <th style="width:120px;">操作</th>
    </tr>
    <c:forEach items="${categories}" var="category">
        <c:if test="${category.id != 1}">
            <tr id="${category.id}">
                <th id="${category.name}">${category.name}</th>
                <th>${categoryId_count[category.id]}</th>
                <th>
                    <input id="btnDel" type="button" onclick="delCategory(${category.id},${categoryId_count[category.id]})" value="删除">
                    <input id="btnMod" type="button" onclick="modCategory(${category.id},'${category.name}')" value="修改">
                </th>
            </tr>
        </c:if>
    </c:forEach>
</table>
<input id="txt"><input id="btnAdd" type="button" value="添加分类">
<div id="mod"></div>
<div id="msg"></div>
<a href="${pageContext.request.contextPath}/">首页</a>

<script type="text/javascript">

    function delCategory(id, num) {
        var isDo = false;

        if (parseInt(num) > 0) {
            isDo = confirm("该类别下有" + num + "篇文章，删除将会把文章移出此类，是否继续？");
        } else {
            isDo = confirm("确定要删除该类别吗？");
        }

        if (isDo) {
            $.get("deletecategory?id=" + id, function() {
                $("#" + id).remove();
            });
        }
    }

    //点击修改按钮之后
    function modCategory(categoryid,name) {
        $("#mod").html("名称:<input id='modtxt' type='text'><input id='btnsavemod' type='button' value='保存' onclick=saveMod(" + categoryid + ",'" + name + "')><input id='btncancelmod' type='button' value='取消' onclick='cancelmod()'>");
        $("#modtxt").val(name);
    }

    //点击保存之后
    function saveMod(categoryid,name) {
        $.get("updatecategory?id=" + categoryid + "&name=" + $("#modtxt").val(),function(result) {
            if (result == "duplicate") {
                $("#msg").html("此类别已经存在");
            } else {
                $("#" + name).html($("#modtxt").val());
                cancelmod();
                $("#msg").html("");
            }
        });
    }

    function cancelmod() {
        $("#mod").html("");
        $("#msg").html("");
    }

    $(document).ready(function() {
        function addCategory() {
            //没输入内容就退出
            if ($("#txt").val() == "") {
                return;
            }

            $.get("addcategory?name=" + $("#txt").val(),function(result) {
                if (result == "success") {
                    $.get("getcategorylatestid",function(latestid) {
                        $("#categorytab").append("<tr id=\"" + latestid + "\"><th>"+ $("#txt").val() +"</th><th>0</th><th><input id=\"btnDel\" type=\"button\" onclick=delCategory("+ latestid +",0) value=\"删除\"><input id=\"btnMod\" type=\"button\" onclick=\"modCategory(" + latestid + ",'" + $("#txt").val() + "')\" value=\"修改\"></th></tr>");
                        $("#txt").val("");
                        $("#msg").html("");
                    });
                } else if (result == "duplicate") {
                    $("#msg").html("此类别已经存在");
                }
            });
        }

        function keydown() {
            if(event.keyCode == 13) {
                addCategory();
            }
        }

        $("#txt").keydown(keydown);
        $("#btnAdd").click(addCategory);
    });
</script>
</body>
</html>
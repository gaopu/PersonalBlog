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
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
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
                    <input id="btnDel" class="btn btn-danger" type="button" onclick="delCategory(${category.id},${categoryId_count[category.id]})" value="删除">
                    <input id="btnMod" class="btn btn-info" type="button" onclick="modCategory(${category.id},'${category.name}',${categoryId_count[category.id]})" value="修改">
                </th>
            </tr>
        </c:if>
    </c:forEach>
</table>
<input id="txt" type="text">
<input id="btnAdd" class="btn btn-success" type="button" value="添加">
<div id="mod"></div>
<div id="msg"></div>

<script type="text/javascript">

    //点击删除后
    function delCategory(id, num) {
        var isDo = false;

        if (parseInt(num) > 0) {
            isDo = confirm("该类别下有" + num + "篇文章，删除将会把文章移出此类，是否继续？");
        } else {
            isDo = confirm("确定要删除该类别吗？");
        }

        if (isDo) {
            $.get("deletecategory?id=" + id, function(result) {
                if (result == "success") {
                    $("#" + id).remove();
                } else {
                    $("#msg").html("删除失败!");
                }
            });
        }
    }

    //点击修改按钮之后
    function modCategory(categoryid,name,articleCount) {
        $("#mod").html("新名称:<br><input id='modtxt' type='text'> <input id='btnsavemod' class=\"btn btn-success\" type='button' value='保存' onclick=saveMod(" + categoryid + ",'" + name + "'," + articleCount + ")> <input id='btncancelmod' class=\"btn\" type='button' value='取消' onclick='cancelmod()'>");
        $("#modtxt").val(name);
    }

    //点击保存之后
    function saveMod(categoryid,name,articleCount) {
        $.get("updatecategory?id=" + categoryid + "&name=" + $("#modtxt").val(),function(result) {
            var newName = $("#modtxt").val();
            if (result == "duplicate") {
                $("#msg").html("此类别已经存在");
            } else {
                //将id为categoryid的元素内容清空
                $("#" + categoryid).html("");
                //重新添加内容
                $("#" + categoryid).html("<th id=\"" + newName + "\">" + newName + "</th> <th>" + articleCount + "</th> <th> <input id=\"btnDel\" class=\"btn btn-danger\" type=\"button\" onclick=\"delCategory(" + categoryid + "," + articleCount + ")\" value=\"删除\"> <input id=\"btnMod\" class=\"btn btn-info\" type=\"button\" onclick=\"modCategory(" + categoryid + ",'" + newName + "'," + articleCount + ")\" value=\"修改\"> </th>");
//                $("#" + categoryid).html('<th id="' + newName + '">' + newName + '</th><th>' + articleCount + '</th><th><input id="btnDel" class="btn btn-danger" type="button" onclick="delCategory(' + categoryid + ',' + articleCount + ')" value="删除"> <input id="btnMod" class="btn btn-info" type="button" onclick="modCategory(' + categoryid + ',\"' + newName + '\"' + articleCount + ')\" value=\"修改\"></th>');
                cancelmod();
                $("#msg").html("");
            }
        });
    }

    function cancelmod() {
        $("#mod").html("");
        $("#msg").html("");
    }

    //点击添加分类按钮之后
    function addCategory() {
        //没输入内容就退出
        if ($("#txt").val() == "") {
            return;
        }

        $.get("addcategory?name=" + $("#txt").val(),function(result) {
            if (result == "success") {
                $.get("getcategorylatestid",function(latestid) {
                    $("#categorytab").append("<tr id=\"" + latestid + "\"><th>"+ $("#txt").val() +"</th><th>0</th><th><input id=\"btnDel\" class=\"btn btn-danger\" type=\"button\" onclick=delCategory("+ latestid +",0) value=\"删除\"> <input id=\"btnMod\" class=\"btn btn-info\" type=\"button\" onclick=\"modCategory(" + latestid + ",'" + $("#txt").val() + "')\" value=\"修改\"></th></tr>");
                    $("#txt").val("");
                    $("#msg").html("");
                });
            } else if (result == "duplicate") {
                $("#msg").html("此类别已经存在");
            } else {
                $("#msg").html("修改出错");
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

</script>
</body>
</html>
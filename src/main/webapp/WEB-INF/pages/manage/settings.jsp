<%@ page import="com.blog.po.Configure" %>
<%@ page isELIgnored="false"%>
<%--
  Created by IntelliJ IDEA.
  User: hexing
  Date: 15-10-15
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>配置博客</title>
</head>
<body>
<form action="setconfigure" method="post" id="set">
  <%Configure configure = (Configure) request.getAttribute("configured");%>
      博客标题<br>
      <input type="text" name="head" value="<%=configure.getHead()%>"/><br><br>
      博客描述<br>
      <input type="text" name="describ" value="<%=configure.getDescrib()%>"/><br><br>
      编辑器类型<br>
      <select name="editor" id="editor">
        <option value="0">MarkDown编辑器</option>
        <option value="1">Editor编辑器</option>
      </select><br><br>
      每页显示文章数<br>
      <select name="display" id="display">
        <option value="0">5</option>
        <option value="1">10</option>
        <option value="2">15</option>
        <option value="3">20</option>
        </select><br><br>
        有评论是否邮件通知<br>
      <input type="radio" name="isemail" value="0"/>否
      <input type="radio" name="isemail" value="1"/>是<br><br>
      <input type="button" onclick="sub()" value="保存设置">
    <div id="msg"></div>
</form>

<script>
   var sub = function(){
       $.post("setconfigure",$("#set").serialize())
   };
  //分别获取数据库中的值
    var edit_type = '<%=configure.getEdit_type()%>';
    var display_num = '<%=configure.getDisplay_num()%>';
    var email_inform = '<%=configure.getEmail_inform()%>';

    //根据数据库中的值动态确定编辑器类型的默认选项
    var e_sel = document.getElementById("editor");
    var e_opts = e_sel.getElementsByTagName("option");
    e_opts[edit_type].selected = true;

    //根据数据库中的值动态确定每页显示数目的默认选项
    var n_sel = document.getElementById("display");
    var n_opts = n_sel.getElementsByTagName("option");
    n_opts[display_num].selected = true;

    //根据数据库中的值动态确定评论是否发送邮件的默认选项
    var m_opts = document.getElementsByName("isemail");
    m_opts[email_inform].checked = true;
</script>
</body>
</html>

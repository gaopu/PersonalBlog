[示例](http://www.geekgao.top/PersonalBlog)

使用方式:
>(1)最后war包内的WEB-INF/lib目录内需要额外添加的jar包: 根目录lib目录下的所有jar包

>(2)需要修改参数的地方:
>>[1]对于文件ueditor/jsp/config.json,里面有很多的UrlPrefix需要配置为你的项目的上下文

>>[2]blog.properties配置博客文件存储的路径

>>[3]spring-mvc.xml内更改数据库访问的用户名密码

<%--
  Created by IntelliJ IDEA.
  user: huawei
  Date: 2021/4/20
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增用户</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增用户</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/user/adduser" method="post">
        用户编号：<input type="text" name="id"><br><br><br>
        用户姓名：<input type="text" name="name"><br><br><br>
        用户密码：<input type="text" name="pwd"><br><br><br>
        <input type="submit" value="添加">
    </form>
</div>
</body>
</html>

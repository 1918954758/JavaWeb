<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
<center>
    <h2>用户登录错误页面</h2>
</center>
<div>
    <center>
        <%=
            request.getAttribute("errMessage")
        %>
    </center>
</div>
</html>

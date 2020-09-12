<%@ page import="net.zixue.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/12
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setAttribute("name", "lemon");

    User user = new User();
    user.setName("lemon");
    user.setSex("女");
    session.setAttribute("user", user);

    List<User> list = new ArrayList<>();
    User user1 = new User();
    user1.setName("小强");
    user1.setSex("男");
    User user2 = new User();
    user2.setName("小丽");
    user2.setSex("女");

    list.add(user1);
    list.add(user2);
    application.setAttribute("list", list);
%>
<%--使用脚本获取域中的对象--%>
<%--方式一--%>
<%=request.getAttribute("name")%>
<%--方式二--%>
<%
    String name1 = (String) request.getAttribute("name");
    out.write(name1);
%>
<%
    User user3 = (User) session.getAttribute("user");
    String name = user3.getName();
    out.write(name);
%>

<%
    List<User> list1 = (List<User>)application.getAttribute("list");
    User user4 = list1.get(0);
    out.write(user4.getName());
%>
<br>
<%-- 使用EL表达式获取域中的对象 --%>
${requestScope.name}
${sessionScope.user.name}
${applicationScope.list[0].name}

<br>

${name}
${user.name}
${list[0].name}
</body>
</html>

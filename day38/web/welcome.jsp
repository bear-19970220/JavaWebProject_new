<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/18
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<h1>${sessionScope.user.username}，欢迎您！</h1>
<a href="${pageContext.request.contextPath}/ShowAllServlet">查看所有用户</a>




</body>
</html>
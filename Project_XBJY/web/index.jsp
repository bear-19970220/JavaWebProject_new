<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/2
  Time: 10:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<a href="#">登录</a>

<form action="${pageContext.request.contextPath}/TestServlet" method="POST">
    用户名：<input type="text" name="username" />
    生日：<input type="date" name="birth" />
    <input type="submit" value="提交" />
</form>

</body>
</html>

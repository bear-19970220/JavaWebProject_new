<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/18
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
<div class="main-body clearfix">

    <h1>登录</h1>

    <img class="bg" src="images/登录页背景图.jpg"/>

    <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <%--<label><input type="text" name="username" value="${requestScope.userInput.username}"/></label><br/>--%>
        <%--<label><input type="text" name="password" value="${requestScope.userInput.password}"/></label><br/>--%>
            <label><input type="text" name="username" value="root"/></label><br/>
            <label><input type="text" name="password" value="123"/></label><br/>
        <input type="button" value="Login" onclick="check_regist()"/><br/>
        <span class="s-show-error">${requestScope.loginMsg}</span>
    </form>
</div>
</body>
<script>
    function check_login() {
        var form_login = document.querySelector('form');
        form_login.submit();
    }

    function check_regist() {
        document.querySelector('form').submit();
    }

    window.onload = function () {
        var s_showError = document.querySelector('.s-show-error');
        if (s_showError.innerHTML === 'success') {
            window.location.href = '${pageContext.request.contextPath}/login.jsp';
        }
    }
</script>
</html>

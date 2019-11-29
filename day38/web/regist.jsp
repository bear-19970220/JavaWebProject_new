<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/18
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <link rel="stylesheet" href="css/regist.css"/>
</head>
<body>
<div class="main-body  clearfix">
    <img class="bg" src="images/注册页背景图.jpg"/>

    <h1>注册</h1>

    <form method="post" action="${pageContext.request.contextPath}/RegistServlet">
        <label><input type="text" name="username" value="${requestScope.userInput.username}"/></label><br/>
        <label><input type="text" name="password" value="${requestScope.userInput.password}"/></label><br/>
        <input type="button" value="Regist" onclick="check_regist()"/><br/>
        <span class="s-show-error">${requestScope.registMsg}</span>
    </form>
</div>
</body>
<script>
    function check_regist() {
        document.querySelector('form').submit();
    }

    window.onload = function () {
        var s_showError = document.querySelector('.s-show-error');
        if (s_showError.innerHTML === 'success') {
            var remainingTime = 3;
            var timer_jump = window.setInterval(function () {
                if (remainingTime <= 0) {
                    window.location.href = '${pageContext.request.contextPath}/login.jsp';
                } else {
                    s_showError.innerHTML = '注册成功，' + remainingTime + ' 秒后前往登录';
                    remainingTime--;
                }
            }, 1000);
        }
    }
</script>
</html>

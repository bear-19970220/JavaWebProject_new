<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/25
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/login.css"/>
</head>
<body>
<div class="main-body clearfix">

    <h1>登录</h1>

    <img class="bg" src="image/登录页背景图.jpg"/>

    <form class="clearfix" method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <label><input type="text" name="username" value="${requestScope.userInput.username}"/></label><br/>
        <label><input type="text" name="password" value="${requestScope.userInput.password}"/></label><br/>
        <%--<label><input type="text" name="username" value="root"/></label><br/>--%>
        <%--<label><input type="text" name="password" value="123"/></label><br/>--%>
        <input type="button" value="Login" onclick="check_login()"/><br/>
        <span class="s-show-error">${requestScope.loginMsg}</span>
        <div class="remb">
            <label><input type="checkbox" name="rembPassword" value="true"><span>记住密码</span></label>
        </div>

    </form>

</div>
</body>
<script>
    function check_login() {
        var form_login = document.querySelector('form');
        form_login.submit();
    }

    window.onload = function () {

        document.onkeydown = function (ev) {
            console.log(ev.key);
            if(ev.key === "Enter") {
                check_login();
            }
        };


        var s_showError = document.querySelector('.s-show-error');
        if (s_showError.innerHTML === 'success') {
            window.location.href = '${pageContext.request.contextPath}/login.jsp';
        }

        var remb = document.querySelector('.remb input[type="checkbox"]');
        remb.addEventListener('click', function() {
            // form input[type="text"], form input[type="password"]
            //
            if(this.checked === true) {
                var ins = document.querySelectorAll('form input[type="text"], form input[type="password"]');
                for(var key in ins) {
                    ins[key].style.borderColor = 'red';
                }
            } else {
                var ins = document.querySelectorAll('form input[type="text"], form input[type="password"]');
                for(var key in ins) {
                    ins[key].style.borderColor = 'white';
                }
            }
        });
    }
</script>

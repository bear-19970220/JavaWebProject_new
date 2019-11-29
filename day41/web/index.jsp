<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/21
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <style>
        a {
            text-decoration: none;
            display: block;
            width: 200px;
            height: 200px;
            font-size: 18px;
            margin: 20px auto;
            border-radius: 20px;
            background-color: firebrick;
            color: white;
            line-height: 200px;
            text-align: center;
            transition: all 180ms;
        }

        a:hover {
            font-size: 26px;
        }
    </style>
</head>
<body>

<%--用户名：<input type="text"/>--%>
<%--<span></span>--%>
<a href="${pageContext.request.contextPath}/LoginViewServlet">
    <h1>登录</h1>
</a>

<script src="js/jquery-3.1.4.js" type="text/javascript"></script>
<script>

    var input = document.querySelector('input');



    var span = document.querySelector('span');
    input.addEventListener('blur', function () {
        var inputValue = input.value;
        $.get(
            '${pageContext.request.contextPath}/TestServlet',
            {'username': inputValue},
            function (data) {
                span.innerHTML = data.msg;
            }
        );
    });


</script>
</body>

</html>

<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/18
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="css/index.css" />
</head>


<div class="main">
    <img src="images/云层-灰.jpg">
    <a class="a-login" href="${pageContext.request.contextPath}/login.jsp">登录</a>
    <a class="a-regist" href="${pageContext.request.contextPath}/regist.jsp">注册</a>
    <div class="main-backboard"></div>
</div>

</body>
<script>
    var as = document.querySelectorAll('a');
    var mainBackboard = document.querySelector('.main-backboard');
    var bgImg = document.querySelector('.main img');
    for (var k in as) {
        as[k].addEventListener('mouseover', function () {
            // mainBackboard.style.display = 'block';
            mainBackboard.style.backgroundColor = 'rgba(0, 0, 0, 0.3)';
            bgImg.style.filter = 'blur(7px)';
        });
        as[k].addEventListener('mouseout', function () {
            // mainBackboard.style.display = 'none';
            mainBackboard.style.backgroundColor = 'rgba(0, 0, 0, 0)';
            bgImg.style.filter = 'blur(3px)';
        })
    }



</script>
</html>

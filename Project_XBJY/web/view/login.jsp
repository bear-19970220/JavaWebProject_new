<%@ page import="java.util.Collection" %>
<%@ page import="java.util.Collections" %>
<%@ page import="com.xbjy.domain.User" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/4
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <link href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet"/>
    <script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</head>
<body>

<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
        for (Cookie c : cookies) {
            if (c.getName().equals("userInfo")) {
//                System.out.println("正在唤醒 Cookie：" + URLDecoder.decode(c.getValue(), "utf-8"));
                ObjectMapper om = new ObjectMapper();
                User userInfo = om.readValue(URLDecoder.decode(c.getValue(), "utf-8"), User.class);
//                System.out.println("页面已读取 Cookie 信息：" + userInfo);
                pageContext.setAttribute("userInfo", userInfo);
            }
        }
    }
%>

<div class="form">
    <div>
        <img class="bg-img" src="../static/images/登录页背景.jpg">
    </div>
    <form id="loginForm" action="${pageContext.request.contextPath}/LoginServlet">


        <p class="loginMsg">${loginMsg}</p>

        <input type="text" name="account" value="${userInfo.account}" placeholder="用户名"/>
        <input type="text" name="password" value="${userInfo.password}" placeholder="密码"/>
        <input type="hidden" name="remberLogin" value=""/>

        <c:if test="${not empty loginMsg}">
            <div class="vcode">
                <input type="text" name="vcode" placeholder="请输入验证码">
                <img class="vcodeImg" src="${pageContext.request.contextPath}/VCodeServlet" title="看不清，换一张"/>
            </div>
        </c:if>

        <div class="d-login">
            <em id="select_remb"
                    <c:if test="${empty pageScope.userInfo}">
                        data-status="0">
                    </c:if>
                    <c:if test="${not empty pageScope.userInfo}">
                        data-status="1">√
                    </c:if>
            </em>
            <span id="txt_remb">记住密码</span>
            <a class="a-login" href="javascript:login();">登&nbsp;录</a>
        </div>

    </form>
</div>

</body>
<script>
    var contextPath = '${pageContext.request.contextPath}';
</script>
<script>

</script>

</html>

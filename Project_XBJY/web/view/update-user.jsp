<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/4
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/add-user.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/add-user.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/update-user.js"></script>
    <style>

    </style>
</head>
<body>

<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content clearfix">


        <c:if test="${not empty requestScope.addUserMsg}">
            <p class="addUserMsg">Error：${requestScope.addUserMsg}</p>
        </c:if>


        <c:set var="userInfo" value="${sessionScope.userInfo}" scope="page"/>
        <c:remove var="userInfo" scope="session"/>
        <form class="clearfix" action="${pageContext.request.contextPath}/UpdateUserServlet"
              method="post">
            <div class="fd d-l">
                <input type="hidden" name="uid" value="${userInfo.uid}"/>
                <label><i>·</i>客户姓名：<input type="text" name="uname" value="${userInfo.name}"/></label>
                <label>
                    性别：
                    <div class="d-sex">
                        <c:choose>
                            <c:when test="${userInfo.sex == 1}">
                                <label><input type="radio" name="sex" value="1" checked>男</label>
                                <label><input type="radio" name="sex" value="0">女</label>
                            </c:when>
                            <c:when test="${userInfo.sex == 0}">
                                <label><input type="radio" name="sex" value="1">男</label>
                                <label><input type="radio" name="sex" value="0" checked>女</label>
                            </c:when>
                            <c:otherwise>
                                <label><input type="radio" name="sex" value="1">男</label>
                                <label><input type="radio" name="sex" value="0">女</label>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </label>
                <label>邮箱：<input type="text" name="email" value="${userInfo.email}"/></label>
                <label>生日：<input type="date" name="birthStr" value="${userInfo.birthStr}" placeholder=""/></label>

                <label>
                    <i>·</i>所属部门：
                    <select id="select_dept" name="deptId">
                        <option value="">- 请选择 -</option>
                    </select>
                </label>
            </div>

            <div class="fd d-r">
                <label><i>·</i>账号：<input type="text" name="account" value="${userInfo.account}" placeholder=""/></label><br/>
                <label><i>·</i>密码：<input type="text" name="password" value="${userInfo.password}"
                                         placeholder=""/></label><br/>
                <label><i>·</i>确认新密码：<input type="text" name="passwordConfirm" value=""/></label><br/>
                <div class="btns">
                    <a class="a-reset" href="javascript:resetInput();">撤销修改</a>
                    <a class="a-submit" href="javascript:submitForm();">确认修改</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script>
    var contextPath = '${pageContext.request.contextPath}';
    var deptId = '${userInfo.deptId}';
    var sex = '${userInfo.sex}';
</script>
<script>

    var password = document.querySelector('input[name="password"]');
    var passwordConfirm = document.querySelector('input[name="passwordConfirm"]');
    password.addEventListener('click', function () {

    });


</script>

</html>

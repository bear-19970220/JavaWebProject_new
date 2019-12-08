<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/3
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/add-user.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/add-user.js"></script>
    <style>

    </style>
</head>
<body>
<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content clearfix">

        <!-- 添加结果 -->
        <c:if test="${requestScope.resultFlag == 1}">
            <script>
                alert('添加成功');
            </script>
        </c:if>
        <c:if test="${requestScope.resultFlag == 0}">
            <script>
                alert('添加失败');
            </script>
        </c:if>

        <c:if test="${not empty requestScope.addUserMsg}">
            <p class="addUserMsg">Error：${requestScope.addUserMsg}</p>
        </c:if>

        <c:set var="userInfo" value="${requestScope.userInfo}" scope="page"/>
        <form class="clearfix" action="${pageContext.request.contextPath}/AddUserServlet" method="post">
            <div class="fd d-l">
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
                <label><i>·</i>确认密码：<input type="text" name="passwordConfirm" value=""/></label><br/>
                <div class="btns">
                    <a class="a-reset" href="javascript:resetInput();">重置</a>
                    <a class="a-submit" href="javascript:submitForm();">保存</a>
                </div>
            </div>

        </form>
    </div>
</div>

</body>

<script>
    var contextPath = '${pageContext.request.contextPath}';
</script>
<script>


</script>

</html>

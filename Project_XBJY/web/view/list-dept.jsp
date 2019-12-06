<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/2
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>部门管理</title>
    <link rel="stylesheet" href="../static/css/common.css"/>
    <style>

    </style>
</head>
<body>

<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content">

        <c:if test="${not empty requestScope.depts}">
            <table>
                <tr>
                    <th>编号</th>
                    <th>部门名称</th>
                    <th>创建时间</th>
                    <th>创建者</th>
                    <th>可用</th>
                </tr>
                <c:forEach var="dept" items="${requestScope.depts}" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${dept.name}</td>
                        <td>${dept.createTime}</td>
                        <td>${dept.createBy}</td>
                        <td>${dept.delFlag}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>


    </div>
</div>


</body>
</html>

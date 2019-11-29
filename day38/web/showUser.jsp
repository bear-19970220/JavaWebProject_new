<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/20
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>显示用户</title>
</head>
<style>
    body {
        background-color: #2B2B2B;
    }

    table {
        border: 1px solid steelblue;
        border-width: 0 1px 1px 0;
        position: absolute;
        right: 50%;
    }

    td, th {
        width: 120px;
        height: 40px;
        border: 1px solid steelblue;
        border-width: 1px 0 0 1px;
        text-align: center;
        line-height: 40px;
        color: steelblue;
    }

    a {
        text-decoration: none;
        color: steelblue;
    }

    a:hover {
        color: gold;
    }
</style>
<body>

<table border="0" cellpadding="0" cellspacing="0">
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>操作</th>
    </tr>
    <c:forEach var="user" items="${sessionScope.users}">
        <tr>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td><a class="a-delete" href="javascript:;">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>

<script>

    window.addEventListener('load', function () {
        var a_dels = document.querySelectorAll('.a-delete');
        for (var k in a_dels) {
            a_dels[k].addEventListener('click', deleteUser);
        }
    });

    function deleteUser() {
        var username = this.parentElement.parentElement.querySelector('td').innerHTML;
        if (window.confirm('确认删除' + username + '？') === true) {
            window.location.href = '${pageContext.request.contextPath}/DeleteServlet?username=' + username;
        }
    }

</script>

</html>

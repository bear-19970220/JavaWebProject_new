<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/20
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>客户管理系统</title>
    <link href="css/customermng.css" rel="stylesheet">
</head>
<body>

<div class="show-table">
    <table class="t-user" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <th><input id="chk-all" type="checkbox"></th>
            <th>ID</th>
            <th>客户姓名</th>
            <th>联系方式</th>
            <th>居住地址</th>
            <th>性别</th>
            <th>出生日期</th>
            <th>注册时间</th>
            <th>操作</th>
        </tr>
        <c:forEach var="cust" items="${sessionScope.customers}">
            <tr>
                <td><input name="chk" type="checkbox"></td>
                <td><input type="text" name="cid" value="${cust.cid}"/></td>
                <td><input type="text" name="cname" value="${cust.cname}"/></td>
                <td><input type="text" name="cphone" value="${cust.cphone}"/></td>
                <td><input type="text" name="caddress" value="${cust.caddress}"/></td>
                <td><input type="text" name="csex" value="${cust.csex}"/></td>
                <td><input type="text" name="cbirth" value="${cust.cbirth}"/></td>
                <td><input type="text" name="cjointime" value="${cust.cjointime}"/></td>
                <td class="t-option">
                    <a class="a-delete" href="javascript:;"
                       onclick="deleteCustomer(${cust.cid}, '${cust.cname}')">删除</a>
                    <a href="#">修改</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div class="t-bar">
        <span class="s-pagemsg">共有40条，每页显示：10条</span>
    </div>
</div>

<br/>
<button id="btn-deleteList" disabled="disabled">批量删除</button>

</body>
<script type="text/javascript" src="js/customermng.js"></script>
<script>var contextPath = '${pageContext.request.contextPath}';</script>

</html>

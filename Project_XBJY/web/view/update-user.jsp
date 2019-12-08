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
    <link rel="stylesheet" href="../static/css/common.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>

<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content">
        <form action="${pageContext.request.contextPath}/UpdateUserServlet" method="post">

            <c:set var="userInfo" value="${sessionScope.userInfo}" scope="page"/>
            <div>
                <input type="text" name="uid" value="${userInfo.uid}"/>
                <label>账号：<input type="text" name="account" value="${userInfo.account}"/></label><br/>
                <label>密码：<input type="text" name="password" value="${userInfo.password}"/></label><br/>
                <label>确认新密码：<input type="text" name="passwordConfirm" value=""/></label><br/>
                <label>姓名：<input type="text" name="name" value="${userInfo.name}"/></label>
                <br/>
                所属部门：
                <select id="select_dept" name="deptId">
                    <option value="">-- 请选择 --</option>
                </select>
            </div>
            <div>
                性别：
                <label><input type="radio" name="sex" value="1"/>男</label>
                <label><input type="radio" name="sex" value="0"/>女</label>
                <br/>
                <label>邮件：<input type="text" name="email" value="${userInfo.email}"/></label>
            </div>
            <label>生日：<input type="date" name="birthStr" value="${userInfo.birthStr}"/></label>
            <br/>
            <input type="submit" value="确认修改"/>
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

    window.addEventListener('load', function () {
        // 回显：部门下拉列表
        init_deptSelect();
        // 回显：性别单选框
        init_sexRadio();
    });

    /**
     * 回显：部门下拉列表
     */
    function init_deptSelect() {
        // 初始化下拉列表数据
        var select_dept = document.querySelector('#select_dept');
        $.get(contextPath + '/ListDeptAjaxServlet', function (depts) {
            var innerHtml = [];
            for (var k in depts) {
                if (depts[k].id == deptId) {
                    innerHtml.push('<option value="' + depts[k].id + '" selected="selected">' + depts[k].name + '</option>');
                    continue;
                }
                innerHtml.push('<option value="' + depts[k].id + '">' + depts[k].name + '</option>');
            }
            select_dept.innerHTML += innerHtml.join('');
        }, 'json');
    }

    /**
     * 回显：性别单选框
     */
    function init_sexRadio() {
        if (sex === '1') {
            document.querySelector('input[name="sex"][value="1"]').checked = true;
        } else if (sex === '0') {
            document.querySelector('input[name="sex"][value="0"]').checked = true;
        }
    }
</script>

</html>

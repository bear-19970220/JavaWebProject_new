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

            <c:set var="user" value="${requestScope.user}" scope="page"/>
            <div>
                <input type="text" name="uid" value="${user.uid}"/>
                <label>账号：<input type="text" name="account" value="${user.account}"/></label><br/>
                <label>旧密码：<input type="text" name="password" value="${user.password}"/></label><br/>
                <label>新密码：<input type="text" name="password" value=""/></label><br/>
                <label>确认新密码：<input type="text" name="password" value=""/></label><br/>
                <label>姓名：<input type="text" name="name" value="${user.name}"/></label>
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
                <label>邮件：<input type="text" name="email" value="${user.email}"/></label>
            </div>
            <label>生日：<input type="date" name="birthStr" value="${user.birthStr}"/></label>
            <br/>
            <input type="submit" value="确认修改"/>
        </form>
    </div>
</div>
</body>
<script>
    var contextPath = '${pageContext.request.contextPath}';
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
                if (depts[k].id == ${user.deptId}) {
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
        if (${user.sex == 1}) {
            document.querySelector('input[name="sex"][value="1"]').checked = true;
        } else if (${user.sex == 0}) {
            document.querySelector('input[name="sex"][value="0"]').checked = true;
        }
    }
</script>

</html>

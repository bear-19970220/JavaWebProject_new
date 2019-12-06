<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/3
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加用户</title>
    <link rel="stylesheet" href="../static/css/common.css"/>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content">
        <form action="${pageContext.request.contextPath}/AddUserServlet" method="post">

            <div>
                <label>账号：<input type="text" name="account" value=""/></label><br/>
                <label>密码：<input type="text" name="password" value=""/></label><br/>
                <label>姓名：<input type="text" name="name" value=""/></label>
                <br/>
                <label>所属部门：
                    <select id="select_dept" name="deptId">
                        <option value="">-- 请选择 --</option>
                    </select>
                </label>
            </div>

            <div>
                <label>性别：
                    <input type="radio" name="sex" value="1">男
                    <input type="radio" name="sex" value="0">女
                </label>
                <br/>
                <label>邮件：<input type="text" name="email" value=""/></label>
            </div>
            <label>生日：<input type="date" name="birthStr" value=""/></label>
            <br/>
            <input type="submit" value="保存">


        </form>
    </div>
</div>

</body>

<script>

    window.addEventListener('load', function () {
        init_select_dept();
    });


    function init_select_dept() {
        $.get('${pageContext.request.contextPath}/ListDeptAjaxServlet', function (depts) {
            var select_dept = document.querySelector('#select_dept');
            var innerHtml = [];
            for (var k in depts) {
                var d = depts[k];
                innerHtml.push('<option value="' + d.id + '">' + d.name + '</option>');
            }
            select_dept.innerHTML += innerHtml.join('');
        }, 'json');
    }


</script>

</html>

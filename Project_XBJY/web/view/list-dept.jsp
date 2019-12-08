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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/search-bar.css"/>
    <script src="${pageContext.request.contextPath}/static/js/check-all.js"></script>
</head>
<body>

<%@include file="common/head.jsp" %>
<div class="main">
    <%@ include file="common/menu.jsp" %>
    <div class="content">

        <%-- 初始化分页参数 --%>
        <c:set var="cp" value="${requestScope.page.currentPage}"/>
        <c:set var="tp" value="${requestScope.page.totalPage}"/>

        <!-- 条件查询 -->
        <div class="search-bar">
            <input type="hidden" name="cp" value="${cp}"/>
            <input type="text" name="dname" value="" placeholder="部门名称"/>
            <select id="select_sex" name="sex">
                <option value="">- 创建年份 -</option>
            </select>
            <select id="select_dept" name="deptId">
                <option value="">- 所属部门 -</option>
            </select>
            <a href="javascript:searchUser();">搜索部门</a>
            <a href="javascript:clearCondition();">重置查询</a>
        </div>

        <!-- 功能按键 -->
        <div class="btns">
            <a class="a-add" href="${pageContext.request.contextPath}/view/add-dept.jsp">添加部门</a>
            <a class="a-del disabled" href="javascript:;">删除选中</a>
        </div>

        <!-- 客户表格 -->
        <c:if test="${not empty requestScope.depts}">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th class="td-check"><input id="check_all" type="checkbox"/></th>
                    <th>编号</th>
                    <th>部门名称</th>
                    <th>创建时间</th>
                    <th>创建者</th>
                    <th>可用</th>
                </tr>
                <c:forEach var="dept" items="${requestScope.depts}" varStatus="s">
                    <tr>
                        <td class="td-check">
                            <input type="checkbox" name="check" value="${user.uid}"/>
                        </td>
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
<script>
    /**
     * 删除选中
     */
    function deleteSelectedUser() {
        if (confirm("确认删除选中客户？")) {
            // var form_delSelected = document.querySelector('#form_delSelected');
            // form_delSelected.submit();
            var uids = [];
            var checks = document.querySelectorAll('td input[type="checkbox"]');
            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked === true) {
                    uids.push('&uid=' + checks[i].value);
                    // uids.push(checks[i].value);  // 都可以实现
                }
            }
            window.location.href = contextPath + '/DeleteSelectedUser?1=1' + uids.join('') + getCondition();
            // window.location.href = contextPath + '/DeleteSelectedUser?1=1&uid=' + uids.join(',') + getCondition();
        }
    }
</script>
</html>

<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/2
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/list-user.css"/>
    <style>

    </style>
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
            <input type="text" name="uname" value="${cdUser.name}" placeholder="客户姓名"/>
            <select id="select_sex" name="sex">
                <option value="">-- 性别 --</option>
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
            <select id="select_dept" name="deptId">
                <option value="">-- 所属部门 --</option>
            </select>
            <a href="javascript:searchUser();">搜索客户</a>
            <a href="javascript:clearCondition();">重置查询</a>
        </div>
        <!-- 功能按键 -->
        <div class="btns">
            <a class="a-add" href="${pageContext.request.contextPath}/view/add-user.jsp">添加客户</a>
            <a class="a-del disabled" href="javascript:;">删除选中</a>
        </div>
        <!-- 客户表格 -->
        <form id="form_delSelected" action="${pageContext.request.contextPath}/DeleteSelectedUser" method="post">
            <table border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <th class="td-check"><input id="check_all" type="checkbox"/></th>
                    <th>编号</th>
                    <th>部门</th>
                    <th>账号</th>
                    <th>密码</th>
                    <th>姓名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>邮件</th>
                    <th>生日</th>
                    <th>创建日期</th>
                    <th>创建者</th>
                    <th>可用</th>
                    <th>操作</th>
                </tr>
                <c:if test="${not empty requestScope.page.beanList}">
                    <c:forEach var="user" items="${requestScope.page.beanList}" varStatus="s">
                        <tr>
                            <td class="td-check">
                                <input type="checkbox" name="check" value="${user.uid}"/>
                            </td>
                            <td>${s.count}</td>
                            <td>${user.dname}</td>
                            <td>${user.account}</td>
                            <td>${user.password}</td>
                            <td>${user.name}</td>
                            <td>${user.age}</td>
                            <td>${user.sexStr}</td>
                            <td>${user.email}</td>
                            <td>${user.birthStr}</td>
                            <td>${user.createTime}</td>
                            <td>${user.createBy}</td>
                            <td>${user.delFlagStr}</td>
                            <td>
                                <a class="a-option" href="javascript:deleteUser(${user.uid});">删除</a>
                                <a class="a-option" href="javascript:updateUser(${user.uid});">修改</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <%-- 分页条 --%>
                    <tr class="tr-page">
                        <td colspan="14">
                            <div class="page-bar">

                                <span class="msg">每页显示<i>${requestScope.page.pageSize}</i>条，共有<i>${requestScope.page.totalRecord}</i>条</span>

                                    <%-- 上一页 --%>
                                <c:if test="${cp > 1}">
                                    <%-- 首页 --%>
                                    <a href="javascript:searchUser(1);"><span title="首页">&laquo;</span></a>
                                    <a href="javascript:searchUser(${cp - 1});"><span
                                            title="上一页">&lt;</span></a>
                                </c:if>

                                    <%-- 总页数大于最大显示页码数 --%>
                                <c:if test="${tp > requestScope.page.pageSize}">

                                    <%--<h1 style="position: absolute;top: 0;left: 0;color: firebrick;z-index: 999;">--%>
                                    <%--总页数 > 最大显示页码数--%>
                                    <%--</h1>--%>

                                    <c:set var="begin" value="${cp - 2}"/>
                                    <c:set var="end" value="${cp + 2}"/>
                                    <c:choose>
                                        <%-- 首溢出 --%>
                                        <c:when test="${begin < 1}">
                                            <c:set var="begin" value="1"/>
                                            <c:set var="end" value="${requestScope.page.pageSize}"/>
                                        </c:when>
                                        <%-- 尾溢出 --%>
                                        <c:when test="${end > tp}">
                                            <c:set var="begin" value="${tp - 4}"/>
                                            <c:set var="end" value="${tp}"/>
                                        </c:when>
                                    </c:choose>

                                    <c:forEach begin="${begin}" end="${end}" var="i">
                                        <c:if test="${cp == i}">
                                            <span class="cp">${cp}</span>
                                        </c:if>
                                        <c:if test="${cp != i}">
                                            <a href="javascript:searchUser(${i});"><span>${i}</span></a>
                                        </c:if>
                                    </c:forEach>
                                </c:if>


                                    <%-- 总页数小于最大显示页码数 --%>
                                <c:if test="${tp <= requestScope.page.pageSize}">

                                    <%--<h1 style="position: absolute;top: 0;left: 0;color: firebrick;z-index: 999;">--%>
                                    <%--总页数 <= 最大显示页码数--%>
                                    <%--</h1>--%>


                                    <c:forEach begin="1" end="${tp}" var="i">
                                        <c:if test="${cp == i}">
                                            <span class="cp">${cp}</span>
                                        </c:if>
                                        <c:if test="${cp != i}">
                                            <a href="javascript:searchUser(${i});"><span>${i}</span></a>
                                        </c:if>
                                    </c:forEach>
                                </c:if>

                                    <%-- 下一页 --%>
                                <c:if test="${cp <tp}">
                                    <a href="javascript:searchUser(${cp + 1});"><span
                                            title="下一页">&gt;</span></a><%-- 末页 --%>
                                    <a href="javascript:searchUser(${tp});"><span
                                            title="末页">&raquo;</span></a>
                                </c:if>
                            </div>
                        </td>
                    </tr>

                </c:if>
                <c:if test="${empty requestScope.page.beanList}">
                    <tr>
                        <td colspan="13">暂无结果</td>
                    </tr>
                </c:if>
            </table>
            <%--</form>--%>
    </div>
</div>
</body>

<script>
    var contextPath = '${pageContext.request.contextPath}';
    var cdUser_deptId = '${cdUser.deptId}';
    var cdUser_sex = '${cdUser.sex}';
</script>
<script src="${pageContext.request.contextPath}/static/js/list-user.js"></script>
<script>


</script>

</html>

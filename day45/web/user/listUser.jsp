<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/27
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>显示所有用户</title>
    <link href="${pageContext.request.contextPath}/css/listUser.css" rel="stylesheet">
    <script src="../js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
<!-- 设置临时变量：cp，当前页 -->
<c:set var="cp" value="${sessionScope.pageBean.currentPage}" scope="page"/>
<div class="nav">
    <ul>
        <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
        <li><a href="${pageContext.request.contextPath}/PageListUserServlet">查看用户</a></li>
    </ul>
</div>
<div class="show-table">
    <table class="clearfix" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <%--<th>ID</th>--%>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>出生日期</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%--<c:forEach var="user" items="${sessionScope.users}">--%>
        <c:forEach var="user" items="${sessionScope.pageBean.users}">
            <tr>
                <form action="${pageContext.request.contextPath}/UpdateUserServlet" method="POST">
                    <input type="hidden" name="uid" value="${user.uid}" disabled="disabled"/>
                    <td><input type="text" name="uname" value="${user.uname}" disabled="disabled"/></td>
                    <td><input type="text" name="sex" value="${user.sex}" disabled="disabled"/></td>
                    <td><input type="text" name="age" value="${user.age}" disabled="disabled"/></td>
                    <td><input type="date" name="birthStr" value="${user.birthStr}" disabled="disabled"/></td>
                    <td><input type="text" name="email" value="${user.email}" disabled="disabled"/></td>
                    <input type="hidden" name="cp" value="${cp}">
                </form>
                <td class="td-option">
                    <a class="a-delete" href="#">删除</a>
                    <a class="a-update" href="javascipt:void(0);">修改</a>
                    <a class="a-save" href="#">保存</a>
                    <a class="a-cancel" href="javascipt:void(0);">取消</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <button class="btn-add">+</button>
</div>


<!-- 分页 -->
<div class="page-bar">
    <!-- 上一页 -->
    <c:if test="${cp > 1}">
        <a class="a-back" href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp - 1}">&lt;</a>
    </c:if>

    <c:choose>
        <%-- 数据不够 5 页 --%>
        <c:when test="${sessionScope.pageBean.totalPage < 5}">
            <c:forEach begin="1" end="${sessionScope.pageBean.totalPage}" var="i" step="1">
                <c:choose>
                    <c:when test="${cp == i}">
                        <a class="a-currentPage">${cp}</a>
                    </c:when>
                    <c:otherwise>
                        <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${i}">${i}</a>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:when>
        <%-- 数据超出 5 页 --%>
        <c:otherwise>
            <!-- 两端限定 -->
            <c:set var="begin" value="${cp - 2}"/>
            <c:set var="end" value="${cp + 2}"/>

            <!-- 中间部分 -->
            <c:if test="${cp > 2 and cp <= sessionScope.pageBean.totalPage - 2}">
                <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp - 2}">${cp - 2}</a>
                <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp - 1}">${cp - 1}</a>
                <a class="a-currentPage">${cp}</a>
                <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp + 1}">${cp + 1}</a>
                <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp + 2}">${cp + 2}</a>
            </c:if>
            <!-- 首溢出 -->
            <c:if test="${begin < 1}">
                <c:forEach begin="1" end="5" step="1" var="i">
                    <c:choose>
                        <c:when test="${cp == i}">
                            <a class="a-currentPage">${cp}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:if>
            <!-- 尾溢出 -->
            <c:if test="${end > sessionScope.pageBean.totalPage}">
                <c:forEach begin="${sessionScope.pageBean.totalPage - 4}" end="${sessionScope.pageBean.totalPage}"
                           step="1"
                           var="i">
                    <c:choose>
                        <c:when test="${cp == i}">
                            <a class="a-currentPage">${cp}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/PageListUserServlet?cp=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </c:if>
        </c:otherwise>
    </c:choose>

    <!-- 下一页 -->
    <c:if test="${cp < sessionScope.pageBean.totalPage}">
        <a class="a-front" href="${pageContext.request.contextPath}/PageListUserServlet?cp=${cp + 1}">&gt;</a>
    </c:if>
</div>

</body>


<script>
    var contextPath = '${pageContext.request.contextPath}';
    var cp = ${cp};
    var tp = ${sessionScope.pageBean.totalPage}

    console.log('当前页：' + cp + '，末页：' + tp);
</script>
<script type="text/javascript" src="../js/listUser.js"></script>
</html>

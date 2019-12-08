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
    <style>
        .addUserMsg {
            width: 618px;
            position: absolute;
            top: 50px;
            left: 87px;
            font-size: 13px;
            color: #FF7900;
            /*background-color: #1fb5ad;*/
            letter-spacing: 1px;
        }


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
        <form class="form-addUser clearfix" action="${pageContext.request.contextPath}/AddUserServlet" method="post">
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
                    <a class="a-save" href="javascript:addUser();">保存</a>
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

    window.addEventListener('load', function () {
        init_select_dept();
    });


    /**
     * 添加用户
     */
    function addUser() {
        var account = document.querySelector('input[name="account"]');
        var password = document.querySelector('input[name="password"]');
        var passwordConfirm = document.querySelector('input[name="passwordConfirm"]');
        var uname = document.querySelector('input[name="uname"]');
        var deptId = document.querySelector('select[name="deptId"]');

        /**
         * 错误提示 + 输入回显
         */
        function inputError(input, message) {
            var valueTemp = input.value;
            input.value = '';
            input.placeholder = message;
            input.className += ' checkFailure';
            flag = false;
            input.addEventListener('click', showBack);

            function showBack() {
                this.value = valueTemp;
                this.removeEventListener('click', showBack);
            }
        }

        var flag = true;
        // 账号
        if (!account.value) {
            account.placeholder = '请填写账号';
            account.className += ' checkFailure';
            flag = false;
        } else {
            var reg = /^[a-zA-Z0-9]{3,16}$/;
            if (reg.test(account.value)) {
                account.classList.remove('checkFailure');
            } else {
                inputError(account, '仅限3-16位英文/数字/下划线');
            }
        }
        // 密码
        if (!password.value) {
            password.placeholder = '请填写密码';
            password.className += ' checkFailure';
            flag = false;
        } else {
            var reg = /\w{6,20}/;
            if (reg.test(password.value)) {
                password.classList.remove('checkFailure');
            } else {
                inputError(password, '密码长度需要6-20位');
            }

        }
        // 确认密码
        if (!passwordConfirm.value) {
            passwordConfirm.placeholder = '请再次确认密码';
            passwordConfirm.className += ' checkFailure';
            flag = false;
        } else {
            if (password.value === passwordConfirm.value) {
                passwordConfirm.classList.remove('checkFailure');
            } else {
                inputError(passwordConfirm, '两次密码输入不一致');
            }
        }
        // 姓名
        if (!uname.value) {
            uname.placeholder = '请填写客户姓名';
            uname.className += ' checkFailure';
            flag = false;
        } else {
            if (uname.value.length <= 50) {
                uname.classList.remove('checkFailure');
            } else {
                inputError(uname, '姓名长度不能超过50');
            }
        }
        // 部门
        if (!deptId.value) {
            deptId.className += ' checkFailure';
            flag = false;
        } else {
            deptId.classList.remove('checkFailure');
        }

        // 提交表单
        if (flag) {
            var form_addUser = document.querySelector('.form-addUser');
            form_addUser.submit();
        }
    }

    /**
     * 清空输入
     */
    function resetInput() {
        if (confirm("清空所有内容？")) {
            var form_addUser = document.querySelector('.form-addUser');
            form_addUser.reset();
        }

    }


    /**
     * 初始化部门列表
     */
    function init_select_dept() {
        $.get(contextPath + '/ListDeptAjaxServlet', function (depts) {
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

window.addEventListener('load', function () {
    init_select_dept();
});


/**
 * 添加用户
 */
function submitForm() {
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
        var form = document.querySelector('form');
        form.submit();
    }
}

/**
 * 清空输入
 */
function resetInput() {
    if (confirm("撤销所有输入？")) {
        var form = document.querySelector('form');
        form.reset();
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

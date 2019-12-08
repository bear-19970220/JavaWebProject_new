window.addEventListener('load', function () {
    init_select_dept();
});

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


/**
 * 删除用户
 */
function deleteUser(uid) {
    if (window.confirm("确认删除？")) {
        window.location.href = contextPath + '/DeleteUserServlet?uid=' + uid;
    }
}

/**
 * 修改用户
 */
function updateUser(uid) {
    window.location.href = contextPath + '/UpdateUserViewServlet?uid=' + uid + getCondition();
}

/**
 * 条件查询
 */
function searchUser(cp) {
    window.location.href = contextPath + '/PageListUserServlet?1=1' + getCondition(cp);
}

function getCondition(cp) {
// 预备数组（参数容器）
    var condition = [];
    // 获取条件
    if (!cp) {
        cp = document.querySelector('.search-bar input[name="cp"]').value;
    }
    var uname = document.querySelector('.search-bar input[name="uname"]').value;
    var sex = document.querySelector('#select_sex').value;
    var deptId = document.querySelector('#select_dept').value;
    // 条件参数拼接
    if (cp) {
        condition.push('&cp=' + cp);
    }
    if (uname) {
        condition.push('&uname=' + uname);
    }
    if (sex) {
        condition.push('&sex=' + sex);
    }
    if (deptId) {
        condition.push('&deptId=' + deptId);
    }
    console.log('查询条件拼接结果：' + condition.join(''));
    return condition.join('');
}

/**
 * 重置查询条件
 */
function clearCondition() {
    document.querySelector('.search-bar input[name="uname"]').value = '';
    document.querySelector('#select_sex').value = '';
    document.querySelector('#select_dept').value = '';
}


/**
 * 初始化：下拉列表
 */
function init_select_dept() {
    // 初始化下拉列表数据 + 查询条件回显
    var select_dept = document.querySelector('#select_dept');
    $.get(contextPath + '/ListDeptAjaxServlet', function (depts) {
        var innerHtml = [];
        for (var k in depts) {
            var d = depts[k];
            if (parseInt(cdUser_deptId) === d.id) {
                innerHtml.push('<option value="' + d.id + '" selected="selected">' + d.name + '</option>');
            } else {
                innerHtml.push('<option value="' + d.id + '">' + d.name + '</option>');
            }
        }
        select_dept.innerHTML += innerHtml.join('');
    }, 'json');

    var select_sex = document.querySelector('#select_sex');
    if (cdUser_sex) {
        if (cdUser_sex === '1') {
            select_sex.querySelector('option[value="1"]').selected = true;
        } else if (cdUser_sex === '0') {
            select_sex.querySelector('option[value="0"]').selected = true;
        }
    }
}
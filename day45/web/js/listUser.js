/**
 * 主函数
 */
window.addEventListener('load', function () {
    // 初始化按钮
    initButtons();
    // 据说可以禁用输入历史？
    $('input').attr('autocomplete', 'off');

});

/**
 * 添加用户
 */
function addUser() {
    // 禁用此按钮
    this.disabled = true;
    // 创建表格
    var table = document.querySelector('table');
    var tr = document.createElement('tr');

    var fieldNames = ['uname', 'sex', 'age', 'birthStr', 'email'];
    for (var k in fieldNames) {
        var fieldName = fieldNames[k];
        var td = document.createElement('td');
        var input = document.createElement('input');
        if ('birthStr' === fieldName) {
            input.setAttribute('type', 'date');
        } else {
            input.setAttribute('type', 'text');
        }
        input.setAttribute('name', fieldName);
        td.appendChild(input);
        tr.appendChild(td);

    }
    // 【保存】操作按钮
    var td = document.createElement('td');
    var a_saveAdd = document.createElement('a');
    a_saveAdd.innerHTML = "保存";
    a_saveAdd.setAttribute('href', 'javascipt:void(0);');
    a_saveAdd.addEventListener('click', saveAdd);
    a_saveAdd.className = 'a-save-add';
    // 【取消】操作按钮
    var a_cancelAdd = document.createElement('a');
    a_cancelAdd.innerHTML = "取消";
    a_cancelAdd.setAttribute('href', 'javascipt:void(0);');
    a_cancelAdd.addEventListener('click', cancelAdd);
    td.appendChild(a_saveAdd);
    td.appendChild(a_cancelAdd);
    tr.appendChild(td);
    table.appendChild(tr);
    a_cancelAdd.className = 'a-cancel-add';
}

/**
 * 保存添加
 */
function saveAdd() {
    // 提交数据
    var tr = this.parentElement.parentElement;
    var uname = tr.querySelector('input[name="uname"]').value;
    var sex = tr.querySelector('input[name="sex"]').value;
    var age = tr.querySelector('input[name="age"]').value;
    var birthStr = tr.querySelector('input[name="birthStr"]').value;
    var email = tr.querySelector('input[name="email"]').value;
    var params = {
        uname: uname,
        sex: sex,
        age: age,
        birthStr: birthStr,
        email: email,
        tp: tp
    };
    console.log(params);
    console.log(contextPath);


    // 回收输入框
    cancelAdd();

    if (isNaN(age)) {
        alert('请输入正确的年龄');
    } else {
        $.post(
            contextPath + '/AddUserServlet',
            params,
            function (totalPage) {
                console.log(totalPage);
                window.location.href = contextPath + '/PageListUserServlet?cp=' + totalPage;
            }
        );
    }
}

/**
 * 取消添加
 */
function cancelAdd() {
    // 移除输入框
    var table = document.querySelector('table');
    table.removeChild(table.lastChild);
    // 恢复【添加】按钮
    var btn_add = document.querySelector('.btn-add');
    btn_add.disabled = false;
}

/**
 * 删除用户
 */
function deleteUser() {
    var uid = this.parentElement.parentElement.querySelector('input[name="uid"]').value;
    var uname = this.parentElement.parentElement.querySelector('input[name="uname"]').value;
    if (true === confirm('确认删除 ' + uname + '？')) {
        window.location.href = contextPath + '/DeleteUserServlet?uid=' + uid + '&cp=' + cp;
    }
}

/**
 * 修改用户
 */
function updateUser() {
    // 排他（一次只能修改一个）
    var as_cancel = document.querySelectorAll('table .a-cancel');
    for (var i = 0; i < as_cancel.length; i++) {
        var a_cancel = as_cancel[i];
        // 1.输入框：不可用
        cancelInput(a_cancel);
        // 2.显示：删除、修改
        btn_status_default(a_cancel);
    }
    // 2.准备输入
    readyInput(this);
    // 3.按钮转换
    btn_status_update(this);
}

/**
 * 取消修改
 */
function cancelUpdate() {
    // 1.输入框：不可用
    cancelInput(this);
    // 2.显示：删除、修改
    btn_status_default(this);
}

/**
 * 保存修改
 */
function saveUser() {
    // GET
    // var inputs = this.parentElement.parentElement.querySelectorAll('input');
    // var params = ['uid=', inputs[0].value, '&uname=', inputs[1].value, '&sex=', inputs[2].value,
    //     '&age=', inputs[3].value, '&birthStr=', inputs[4].value, '&email=', inputs[5].value];
    // console.log(contextPath + '/UpdateUserServlet?' + params.join(''));
    // window.location.href = contextPath + '/UpdateUserServlet?' + params.join('');
    // 尝试POST
    var form = this.parentElement.parentElement.querySelector('form');
    form.submit();
}

/**
 * 准备输入
 * @param btn
 */
function readyInput(btn) {
    // 唤醒所有输入框
    var inputs = btn.parentElement.parentElement.querySelectorAll('input');
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].disabled = false;
    }
    // 该行底线变色（聚焦）
    var tds = btn.parentElement.parentElement.querySelectorAll('td');
    for (var i = 0; i < tds.length; i++) {
        var td = tds[i];
        // td.style.borderBottomColor = 'gold';
        // td.style.borderBottomColor = '#cccccc';
        // td.className = 'td-ready-input'; // 底边框设置不了，权重？
    }
}

/**
 * 取消输入
 * @param btn
 */
function cancelInput(btn) {
    if (btn) {
        var inputs = btn.parentElement.parentElement.querySelectorAll('input');
        for (var i = 0; i < inputs.length; i++) {
            inputs[i].disabled = 'true';
        }

        var tds = btn.parentElement.parentElement.querySelectorAll('td');
        for (var i = 0; i < tds.length; i++) {
            var td = tds[i];
            td.style.borderBottom = '1px solid steelblue';
        }
    }
}

/**
 * 初始化按钮
 */
function initButtons() {
    // 【删除】
    var as_delete = document.querySelectorAll('table .a-delete');
    for (var i = 0; i < as_delete.length; i++) {
        as_delete[i].addEventListener('click', deleteUser);
    }
    // 【修改】
    var as_update = document.querySelectorAll('table .a-update');
    for (var i = 0; i < as_update.length; i++) {
        as_update[i].addEventListener('click', updateUser);
    }
    // 【添加】
    var btn_add = document.querySelector('.btn-add');
    btn_add.addEventListener('click', addUser);

}

/**
 * 刷新按钮 - 默认状态
 */
function btn_status_default(btn) {
    // 【取消】
    if (btn) {
        btn.style.display = 'none';
        var td = btn.parentElement;
        // 【保存】
        td.querySelector('.a-save').style.display = 'none';
        // 【删除】
        td.querySelector('.a-delete').style.display = 'inline-block';
        // 【修改】
        td.querySelector('.a-update').style.display = 'inline-block';
    }
}

/**
 * 刷新按钮 - 修改状态
 * @param btn
 */
function btn_status_update(btn) {
    if (btn) {
        // 【修改】
        btn.style.display = 'none';
        var td = btn.parentElement;
        // 【删除】
        var a_delete = td.querySelector('.a-delete');
        a_delete.style.display = 'none';
        // 【保存】
        var a_save = td.querySelector('.a-save');
        a_save.style.display = 'inline-block';
        a_save.addEventListener('click', saveUser);
        // 【取消】
        var a_cancel = td.querySelector('.a-cancel');
        a_cancel.style.display = 'inline-block';
        a_cancel.addEventListener('click', cancelUpdate);
    }
}



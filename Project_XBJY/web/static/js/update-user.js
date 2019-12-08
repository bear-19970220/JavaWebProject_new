
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
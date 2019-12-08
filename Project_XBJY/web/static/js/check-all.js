window.addEventListener('load', function () {
    init_check();
});

/**
 * 全选全不选
 */
function init_check() {
    var check_all = document.querySelector('#check_all');
    var checkboxs = document.querySelectorAll('td input[type="checkbox"]');
    // 全选 / 全不选
    check_all.addEventListener('click', function () {
        var delFlag = true;
        for (var i = 0; i < checkboxs.length; i++) {
            checkboxs[i].checked = this.checked;
            delFlag = this.checked;
            init_btnDel(delFlag);
        }
    });
    // 其他
    for (var i = 0; i < checkboxs.length; i++) {
        checkboxs[i].addEventListener('click', function () {
            var flag = true;    // 开关
            for (var i = 0; i < checkboxs.length; i++) {
                if (checkboxs[i].checked === false) {
                    flag = false;
                    break;
                }
            }
            check_all.checked = flag;
            var delFlag = false;
            for (var i = 0; i < checkboxs.length; i++) {
                if (checkboxs[i].checked === true) {
                    delFlag = true;
                    break;
                }
            }
            init_btnDel(delFlag);
        });
    }

    /**
     * 【删除选中】按钮状态变化
     * @param flag
     */
    function init_btnDel(flag) {
        var btnDel = document.querySelector('.btns .a-del');
        // 可用
        if (flag) {
            btnDel.className = 'a-del';
            btnDel.setAttribute('href', 'javascript:deleteSelectedUser();');
        }
        // 不可用（默认）
        else {
            btnDel.className = 'a-del disabled';
            btnDel.setAttribute('href', 'javascript:;');
        }
    }
}


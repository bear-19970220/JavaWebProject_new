/**
 * 来了老弟
 */
window.addEventListener('load', function () {
    init_vcode();
    enterLogin();
    bgImageSuit();
    init_selectRemb();
});

/**
 * 记住密码勾选框
 */
function init_selectRemb() {
    var selectRemb = document.querySelector('#select_remb');
    var txtRemb = document.querySelector('#txt_remb');
    var remberLogin = document.querySelector('input[name="remberLogin"]');
    selectRemb.addEventListener('click', changeRemb);
    txtRemb.addEventListener('click', changeRemb);

    function changeRemb() {
        var status = selectRemb.getAttribute("data-status");
        if (status == '0') {
            selectRemb.innerHTML = '√';
            selectRemb.setAttribute('data-status', '1');
            remberLogin.value = 'on';
        } else if (status == '1') {
            selectRemb.innerHTML = '';
            selectRemb.setAttribute('data-status', '0');
            remberLogin.value = '';
        }
    }
}

/**
 * 自适应背景
 */
function bgImageSuit() {
    var bgImg = document.querySelector('.bg-img');
    bgImg.style.width = window.innerWidth;
    bgImg.style.height = window.innerHeight;
    window.addEventListener('resize', function () {
        bgImg.style.width = window.innerWidth;
        bgImg.style.height = window.innerHeight;
    });
}

/**
 * 回车登录
 */
function enterLogin() {
    document.addEventListener('keydown', function (ev) {
        if (ev.key === 'Enter' || ev.keyCode === 13) {
            login();
        }
    });
}

/**
 * 登录
 */
function login() {
    var loginForm = document.querySelector('#loginForm');
    loginForm.submit();
}

/**
 * 验证码换一换
 */
function init_vcode() {
    var vcodeImg = document.querySelector('.vcodeImg');
    if (vcodeImg) {
        vcodeImg.addEventListener('click', function () {
            this.src = contextPath + '/VCodeServlet?time' + new Date().getTime();
        });
    }
}

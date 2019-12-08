/**
 * 来了老弟
 */
window.addEventListener('load', function () {
    init_inputs();
    init_timer();
    init_vcode();
    enterLogin();
    bgImageSuit();
    init_selectRemb();
});

/**
 * 控制输入框提示信息
 */
function init_inputs() {
    var in_account = document.querySelector('input[name="account"]');
    var in_password = document.querySelector('input[name="password"]');
    in_account.addEventListener('focus', function(){
        this.placeholder = '';
    });
    in_account.addEventListener('blur', function () {
        this.placeholder = '用户名';
    });

    in_password.addEventListener('focus', function(){
        this.placeholder = '';
    });
    in_password.addEventListener('blur', function () {
        this.placeholder = '密码';
    });
}

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
    var bgImg = document.querySelector('.bg-img img');
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

/**
 * 电子表
 */
function init_timer() {
    var timer = document.querySelector('.timer');
    timer.innerHTML = getCurrentTime();
    window.setInterval(function () {
        timer.innerHTML = getCurrentTime();
    }, 1000);

    /**
     * 获取当前时间（自动补零）
     * @returns {string}
     */
    function getCurrentTime() {
        var d = new Date();
        var year = d.getFullYear();
        year = year > 9 ? year : '0' + year;
        var month = d.getMonth() + 1;
        month = month > 9 ? month : '0' + month;
        var day = d.getDate();
        day = day > 9 ? day : '0' + day;
        var hour = d.getHours();
        hour = hour > 9 ? hour : '0' + hour;
        var minute = d.getMinutes();
        minute = minute > 9 ? minute : '0' + minute;
        var second = d.getSeconds();
        second = second > 9 ? second : '0' + second;
        return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
    }
}

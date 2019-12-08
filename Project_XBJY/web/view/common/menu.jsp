<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/12/2
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/menu.css">
<html>

<div class="menu">
    <div class="user">
        <a href="#"><img src="${pageContext.request.contextPath}/static/images/头像.png"/></a>
        <div class="msg">
            <p>${sessionScope.user.name}</p>
            <span>${sessionScope.user.dname}</span>
        </div>
    </div>
</div>

<script>

    window.addEventListener('load', function () {
        // 初始化菜单
        init_menu();
        // var menu = document.querySelector('.menu');
        // 自适应菜单
    });

    function init_menu() {
        $.get('${pageContext.request.contextPath}/MenuServlet', function (data) {
            var menu = document.querySelector('.menu');
            var dadMenus = data['dad'];
            var sonMenus = data['son'];
            // 遍历一级目录（H5）
            for (var i = 0; i < dadMenus.length; i++) {
                var dadMenu = dadMenus[i];
                var h5 = document.createElement('h5');

                h5.innerHTML = dadMenu.name;
                h5.setAttribute('data-index', (i + 1).toString());
                h5.addEventListener('click', function () {
                    // 修改自身样式（排他）
                    var h5s = document.querySelectorAll('.menu h5');
                    for (var i = 0; i < h5s.length; i++) {
                        h5s[i].className = '';
                    }
                    this.className = 'focus';

                    // 显示对应的列表（排他）
                    var index = this.getAttribute('data-index');
                    var uls = document.querySelectorAll('.menu ul');
                    for (var i = 0; i < uls.length; i++) {
                        uls[i].className = '';
                    }
                    var son = document.querySelector('.menu ul[data-index="' + index + '"]');
                    son.className = 'focus';
                });
                var ul = document.createElement('ul');

                ul.setAttribute('data-index', (i + 1).toString());
                // 遍历二级目录（ul）
                var innerHtml = [];
                for (var k in sonMenus) {
                    var sonMenu = sonMenus[k];
                    if (sonMenu.pId == dadMenu.id) {
                        innerHtml.push('<li><a href="${pageContext.request.contextPath}' + sonMenu.menuUrl + '">' + sonMenu.name + '</a></li>');
                    }
                }
                ul.innerHTML = innerHtml.join('');

                // 添加初始化样式
                if (i === 0) {
                    h5.className = 'focus';
                    ul.className = 'focus';
                }

                menu.appendChild(h5);
                menu.appendChild(ul);
            }
        }, 'json');
    }


</script>

</html>

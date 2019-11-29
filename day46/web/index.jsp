<%--
  Created by IntelliJ IDEA.
  User: FTDN
  Date: 2019/11/29
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>省市级联</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        body {
            background-color: #3c3f41;
        }

        .main {
            margin: 20px 0;
            text-align: center;
        }

        select {
            width: 160px;
            height: 40px;
            font: normal 22px 微软雅黑;
            border-radius: 5px;
            outline: none;
            text-align: center;
            padding-left: 10px;
            margin: 30px;
            color: #333333;
        }

        select:hover {
            box-shadow: 0 0 10px 5px rgba(255, 215, 0, 0.3);
        }

        select:focus {
            box-shadow: 0 0 10px 5px rgba(255, 215, 0, 0.3);
        }

        select option{
            background-color: #eeeeee;
            font-size: 18px;
        }

        i {
            font-style: normal;
            font: bolder 26px 微软雅黑;
            color: #eeeeee;
            margin-right: -30px;
        }
    </style>
</head>
<body>


<div class="main">
    <label><i>省：</i>
        <select class="select-prvn" name="province" >
            <option value="">-- 请选择 --</option>
        </select>
    </label>
    <label><i>市：</i>
        <select class="select-city" name="city"></select>
    </label>
</div>


</body>
<script>
    window.addEventListener('load', function () {
        var select_province = document.querySelector('select[name="province"]');
        var select_city = document.querySelector('select[name="city"]');

        /**
         * 省
         */
        $.get(
            '${pageContext.request.contextPath}/PrvnCityCascadeServlet',
            {'type': '1'},
            function (provinces) {
                console.log('[市] 获取成功：' + provinces);
                for (var k in provinces) {
                    var option = document.createElement('option');
                    option.setAttribute("value", provinces[k]);
                    option.innerHTML = provinces[k];
                    select_province.appendChild(option);
                }
            },
            'json'
        );

        /**
         * 市
         */
        select_province.addEventListener('change', function () {
            console.log('已选择：' + this.value);
            $.get(
                '${pageContext.request.contextPath}/PrvnCityCascadeServlet',
                {'type': 2, 'province': this.value},
                function (cities) {
                    console.log(cities);
                    while (true) {
                        if (!select_city.firstChild) {
                            break;
                        }
                        select_city.removeChild(select_city.firstChild);
                    }
                    for (var k in cities) {
                        var option = document.createElement('option');
                        option.setAttribute('value', cities[k]);
                        option.innerHTML = cities[k];
                        select_city.appendChild(option);
                    }
                },
                'json'
            );
        });
    });
</script>


</html>

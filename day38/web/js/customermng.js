function deleteCustomer(cid, cname) {
    if (window.confirm('确认删除' + cname + '？') === true) {
        window.location.href = contextPath + '/DeleteServlet?cid=' + cid;
    }
}

window.addEventListener('load', function () {
        /**
         * 获取所有事件源
         * @type {Element}
         */
        var chk_all = document.querySelector('#chk-all');
        // var chks = document.querySelectorAll('.t-user input[type="checkbox"]');
        var chks = document.querySelectorAll('.t-user td input[type="checkbox"][name="chk"]');
        var btn_deleteList = document.querySelector('#btn-deleteList');

        /**
         * 批量删除
         */
        btn_deleteList.addEventListener('click', deleteSelected);

        /**
         * 批量删除
         */
        function deleteSelected() {
            console.log(233);
            if (window.confirm('确认删除所选客户？') === true) {
                var cids = [];
                for (var k in chks) {
                    if (chks[k].checked === true) {
                        var in_cid = chks[k].parentElement.parentElement.querySelector('td input[name="cid"]');
                        cids.push(in_cid.value);
                    }
                }
                window.location.href = contextPath + '/DeleteSelectedServlet?cid=' + cids.join('&cid=');
            }
        }


        /**
         * 全选、全不选
         * @type {Element}
         */
        chk_all.addEventListener('click', selectAll);
        for (var k in chks) {
            chks[k].addEventListener('click', selectSome);
            chks[k].addEventListener('click', callButton);
        }

        /**
         * 全选/全不选
         */
        function selectAll() {
            for (var k in chks) {
                chks[k].checked = this.checked;
            }
            btn_deleteList.disabled = !this.checked;
        }

        /**
         * 另选
         */
        function selectSome() {
            var flag_all = true;
            for (var i = 0; i < chks.length; i++) {
                if (chks[i].checked === false) {
                    flag_all = false;
                }
            }
            chk_all.checked = flag_all;
        }

        function callButton() {
            var flag_display = false;
            /*不能使用 for in，会多出来几个元素
           for (var k in chks) {
                if (chks[k].checked === true) {
                   flag_display = true;
               }
           }*/
            for (var i = 0; i < chks.length; i++) {
                if (chks[i].checked === true) {
                    flag_display = true;
                }
            }
            if (flag_display === true) {
                btn_deleteList.disabled = false;
            } else {
                btn_deleteList.disabled = true;
            }
        }

    }
);



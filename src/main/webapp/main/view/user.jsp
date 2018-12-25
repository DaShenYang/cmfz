<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    function userStatusFormatter(value, row, idx) {
        if (value == 0)
            return "冻结";
        else
            return "正常";
    }


    function userHeadPic(value, row, idx) {

        return "<img style='height:60px;' src='${pageContext.request.contextPath}/" + value + "'/>"

    }


    $(function () {

        var toolbar3 = [{
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row6 = $("#dg2").edatagrid("getSelected");

                if (row6 != null) {
                    //编辑指定行
                    var index6 = $("#dg2").edatagrid("getRowIndex", row6);


                    $("#dg2").edatagrid("editRow", index6);

                } else {
                    $.messager.alert('提示', '请先选中行！', 'info');
                }


            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg2").edatagrid("saveRow");
                $("#dg2").edatagrid("reload");
            }
        }];

        $('#dg2').edatagrid({
            method: "GET",
            updateUrl: "${pageContext.request.contextPath}/user/update",
            url: '${pageContext.request.contextPath}/user/queryAllUserByPage',
            columns: [[
                {field: 'name', title: '姓名', width: 100},
                {field: 'headPic', title: '头像', width: 100, formatter: userHeadPic},
                {field: 'phone', title: '电话', width: 100},
                {
                    field: 'status', formatter: userStatusFormatter, title: '状态', width: 100, editor: {
                        type: "combobox",
                        options: {
                            required: true,
                            editable: false,
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '0',
                                value: '冻结'


                            }, {
                                label: '1',
                                value: '正常'

                            }]
                        }
                    }
                }
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [3, 5, 10, 20],
            pageSize: 5,
            toolbar: toolbar3

        });
    });
</script>
<table id="dg2"></table>
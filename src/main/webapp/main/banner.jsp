<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    function myStatusFormatter(value, row, idx) {
        if (value == 0)
            return "下架";
        else
            return "在架";
    }

    $(function () {


        $("#addBannerDialog").dialog({
            title: "添加轮播图页面",
            width: 450,
            height: 450,
            closed: true,
            href: "${pageContext.request.contextPath}/main/view/addBanner.jsp",
            modal: true,
            cache: false
        });

        var toolbar = [{
            iconCls: 'icon-add',
            text: "添加",
            handler: function () {
                $("#addBannerDialog").dialog("open");

            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-edit',
            handler: function () {
                //获取选中行
                var row = $("#dg").edatagrid("getSelected");

                if (row != null) {
                    //编辑指定行
                    var index = $("#dg").edatagrid("getRowIndex", row);


                    $("#dg").edatagrid("editRow", index);

                } else {
                    $.messager.alert('提示', '请先选中行！', 'info');
                }


            }
        }, '-', {
            text: "删除",
            iconCls: 'icon-remove',
            handler: function () {
                //获取选中行
                var row2 = $("#dg").edatagrid("getSelected");

                if (row2 != null) {
                    //删除指定行      默认先刷新后删除 ----->  保存后才能刷新页面
                    var index2 = $("#dg").edatagrid("getRowIndex", row2);
                    $("#dg").edatagrid("destroyRow", index2);

                } else {

                    $.messager.alert('提示', '请先选中行！', 'info');

                }
            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-save',
            handler: function () {
                $("#dg").edatagrid("saveRow");
                $("#dg").edatagrid("reload");
            }
        }];


        $('#dg').edatagrid({
            method: "GET",
            destroyUrl: "${pageContext.request.contextPath}/banner/delete",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryAllBannerByPage',
            columns: [[
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', formatter: myStatusFormatter, title: '状态', width: 100, editor: {
                        type: "combobox",
                        options: {
                            required: true,
                            editable: false,
                            valueField: 'label',
                            textField: 'value',
                            data: [{
                                label: '0',
                                value: '下架'


                            }, {
                                label: '1',
                                value: '上架'

                            }]
                        }
                    }
                }
            ]],
            fitColumns: true,
            fit: true,
            pagination: true,
            pageList: [1, 3, 5],
            pageSize: 3,
            toolbar: toolbar,
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/' + rowData.imgPath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>描述: ' + rowData.description + '</p>' +
                    '<p>日期: ' + rowData.pubDate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }

        });

    });
</script>
<table id="dg"></table>
<div id="addBannerDialog"></div>
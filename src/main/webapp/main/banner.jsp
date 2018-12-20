<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    function myStatusFormatter(value, row, idx) {
        if (value == 0)
            return "下架";
        else
            return "在架";
    }

    $(function () {

        var toolbar = [{}, {}, {}, {}];


        $('#dg').edatagrid({
            method: "GET",
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/queryAllBannerByPage',
            columns: [[
                {field: 'title', title: '名称', width: 100},
                {
                    field: 'status', formatter: myStatusFormatter, title: '状态', width: 100, editor: {
                        type: "text",
                        options: {required: true}
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
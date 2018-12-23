<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    function myUrlFormatter(value, row, idx) {
        if (row.children == null) {
            return "<audio controls='controls' src='${pageContext.request.contextPath}/" + value + "'></audio>";
        }

    }

    $(function () {

        var toolbar2 = [{
            iconCls: 'icon-application',
            text: "专辑详情",
            handler: function () {
                //获取选中行
                var row3 = $("#album").treegrid("getSelected");

                if (row3 != null) {
                    if (row3.children != null) {
                        $("#queryAlbumDialog").dialog({
                            title: "专辑详情页面",
                            width: 450,
                            height: 450,
                            closed: true,
                            href: "${pageContext.request.contextPath}/main/view/queryAlbum.jsp?id=" + row3.id,
                            modal: true,
                            cache: false
                        });
                        $("#queryAlbumDialog").dialog("open");
                    } else {
                        $.messager.alert('提示', '请先选中专辑所在行！', 'info');
                    }


                } else {
                    $.messager.alert('提示', '请先选中专辑所在行！', 'info');
                }
            }
        }, '-', {
            text: "添加专辑",
            iconCls: 'icon-add',
            handler: function () {
                $("#addAlbumDialog").dialog({
                    title: "添加专辑页面",
                    width: 450,
                    height: 450,
                    closed: true,
                    href: "${pageContext.request.contextPath}/main/view/addAlbum.jsp",
                    modal: true,
                    cache: false
                });
                $("#addAlbumDialog").dialog("open");


            }
        }, '-', {
            text: "添加音频",
            iconCls: 'icon-arrow_up',
            handler: function () {
                //获取选中行
                var row4 = $("#album").treegrid("getSelected");

                if (row4 != null && row4.children != null) {
                    $("#addChapterDialog").dialog({
                        title: "添加音频页面",
                        width: 450,
                        height: 450,
                        closed: true,
                        href: "${pageContext.request.contextPath}/main/view/addChapter.jsp?id=" + row4.id,
                        modal: true,
                        cache: false
                    });
                    $("#addChapterDialog").dialog("open");

                } else {
                    $.messager.alert('提示', '请先选中专辑所在行！', 'info');
                }
            }
        }, '-', {
            text: "音频下载",
            iconCls: 'icon-arrow_down',
            handler: function () {
                //获取选中行
                var row5 = $("#album").treegrid("getSelected");
                if (row5 != null && row5.children == null) {

                    location.href = "${pageContext.request.contextPath}/chapter/downloadChapter?url=" + row5.url;


                } else {
                    $.messager.alert('提示', '请先选中音频所在行！', 'info');
                }
            }
        }];


        $('#album').treegrid({

            url: '${pageContext.request.contextPath}/album/queryAllAlbumByPage',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '章节名称', width: 60},
                {field: 'url', title: '音频播放', width: 80, formatter: myUrlFormatter},
                /*{field:'duration',title:'章节时长',width:80,align:'center'},*/
                {field: 'size', title: '章节大小', width: 80, align: 'center'},
                {field: 'uploadDate', title: '发布时间', width: 80, align: 'center'}
            ]],
            fit: true,
            fitColumns: true,
            pagination: true,
            pageList: [1, 3, 5, 10],
            pageSize: 3,
            animate: true,
            toolbar: toolbar2
        });
    });
</script>
<table id="album"></table>
<div id="queryAlbumDialog"></div>
<div id="addAlbumDialog"></div>
<div id="addChapterDialog"></div>

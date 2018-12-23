<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/demo/css/application.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.raty.min.js"></script>
<script type="text/javascript">
    $(function () {
        $("#addAlbumFormName").textbox({
            required: true
        });
        $("#addAlbumFormFile").filebox({
            required: true
        });

        $('#star2').raty({
            score: function () {
                return $(this).attr('score-score');
            }

        });

        $("#addAlbumFormAuthor").textbox({
            required: true
        });


        $("#addAlbumFormBroadcast").textbox({
            required: true
        });

        $("#addAlbumFormBrief").textbox({
            required: true,
            multiline: true
        });


        $("#addAlbumFormSubmitBtn").linkbutton({
            iconCls: "icon-ok",
            onClick: function () {
                $("#addAlbumForm").form("submit", {
                    url: "${pageContext.request.contextPath}/album/addAlbum",
                    onSubmit: function () {
                        return $("#addAlbumForm").form("validate");
                    },
                    success: function () {
                        $("#addAlbumDialog").dialog("close");
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功",
                            timeout: 2000,
                            showType: 'fade'

                        });
                        $("#album").treegrid("load");

                    }
                });
            }
        });


        $("#addAlbumFormResetBtn").linkbutton({
            iconCls: "icon-no",
            onClick: function () {
                $("#addAlbumForm").form("reset");
            }
        });


    });
</script>
<form id="addAlbumForm" method="post" align="center" enctype="multipart/form-data" style="margin-top:50px">
    <table align="center">
        <tr>
            <td align="right">名称:</td>
            <td align="left"><input name="title" id="addAlbumFormName"></td>
        </tr>
        <tr>
            <td align="right">图片:</td>
            <td align="left">
                <input name="file2" id="addAlbumFormFile"></td>
        </tr>
        <tr>
            <td align="right">评分:</td>
            <td align="left">
                <span id="star2" score-score="1"></span>
            </td>
        </tr>

        <tr>
            <td align="right"> 作者:</td>
            <td align="left"><input name="author" id="addAlbumFormAuthor"></td>
        </tr>
        <tr>
            <td align="right"> 播音:</td>
            <td align="left"><input name="broadcast" id="addAlbumFormBroadcast"></td>
        </tr>

        <tr>
            <td align="right"> 简介:</td>
            <td align="left">
                <textarea name="brief" id="addAlbumFormBrief" style="width: 172px;height: 30px"></textarea></td>
        </tr>


        <tr>
            <td align="right"></td>
            <td align="left">
                <a id="addAlbumFormSubmitBtn">提交</a>
                <a id="addAlbumFormResetBtn" style="margin-left:60px">重置</a></td>
        </tr>
    </table>
</form>
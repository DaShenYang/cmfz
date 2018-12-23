<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function () {

        $("#addChapterFormName").textbox({
            required: true
        });
        $("#addChapterFormFile").filebox({
            required: true
        });

        $("#addChapterFormSubmitBtn").linkbutton({
            iconCls: "icon-ok",
            onClick: function () {
                $("#addChapterForm").form("submit", {
                    url: "${pageContext.request.contextPath}/chapter/addChapter?albumId=" +${param.id},
                    onSubmit: function () {
                        return $("#addChapterForm").form("validate");
                    },
                    success: function () {
                        $("#addChapterDialog").dialog("close");
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功",
                            timeout: 2000,
                            showType: 'fade'

                        });
                        $("#album").treegrid("reload");

                    }
                });
            }
        });


        $("#addChapterFormResetBtn").linkbutton({
            iconCls: "icon-no",
            onClick: function () {
                $("#addChapterForm").form("reset");
            }
        });
    });
</script>
<form id="addChapterForm" method="post" align="center" enctype="multipart/form-data" style="margin-top:50px">
    <table align="center">
        <tr>
            <td align="right">名称:</td>
            <td align="left"><input name="title" id="addChapterFormName"></td>
        </tr>
        <tr>
            <td align="right">音频:</td>
            <td align="left">
                <input name="file3" id="addChapterFormFile"></td>
        </tr>

        <tr>
            <td align="right"></td>
            <td align="left">
                <a id="addChapterFormSubmitBtn">提交</a>
                <a id="addChapterFormResetBtn" style="margin-left:60px">重置</a></td>
        </tr>
    </table>
    <%--<input type="text" value='"+${param.id}+"' name="albumId" hidden>--%>
</form>
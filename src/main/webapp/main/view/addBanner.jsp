<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">

    $(function () {
        $("#addBannerFormName").textbox({
            required: true
        });


        $("#addBannerFormStatus").combobox({
            required: true,
            editable: false

        });


        $("#addBannerFormDesc").textbox({
            required: true
        });


        $("#addBannerFormSubmitBtn").linkbutton({
            iconCls: "icon-ok",
            onClick: function () {
                $("#addBannerForm").form("submit", {
                    url: "${pageContext.request.contextPath}/banner/addBanner",
                    onSubmit: function () {
                        return $("#addBannerForm").form("validate");
                    },
                    success: function () {
                        $("#addBannerDialog").dialog("close");
                        $.messager.show({
                            title: "提示",
                            msg: "添加成功",
                            timeout: 2000,
                            showType: 'fade'

                        });
                        $("#dg").edatagrid("load");

                    }
                });
            }
        });


        $("#addBannerFormResetBtn").linkbutton({
            iconCls: "icon-no",
            onClick: function () {
                $("#addBannerForm").form("reset");
            }
        });


    });
</script>
<form id="addBannerForm" method="post" align="center" enctype="multipart/form-data" style="margin-top:50px">
    <table align="center">
        <tr>
            <td align="right">名称:</td>
            <td align="left"><input name="title" id="addBannerFormName"></td>
        </tr>
        <tr>
            <td align="right">图片:</td>
            <td align="left">
                <input name="file1" class="easyui-filebox" id="addBannerFormFile"></td>
        </tr>
        <tr>
            <td align="right">状态:</td>
            <td align="left">
                <select name="status" id="addBannerFormStatus" class="easyui-combobox" style="width:170px;">
                    <option value="0">下架</option>
                    <option value="1">上架</option>
                </select>
            </td>
        </tr>

        <tr>
            <td align="right"> 描述:</td>
            <td align="left"><input name="description" id="addBannerFormDesc"></td>
        </tr>
        <tr>
            <td align="right"></td>
            <td align="left">
                <a id="addBannerFormSubmitBtn">提交</a>
                <a id="addBannerFormResetBtn" style="margin-left:60px">重置</a></td>
        </tr>
    </table>
</form>
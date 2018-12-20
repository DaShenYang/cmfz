<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    $("#updateAdminForm").form("load", "${pageContext.request.contextPath}/admin/queryOneAdmin?id=" +${param.id});
    $(function () {

    });
</script>
<form id="updateAdminForm" method="post" align="center" style="margin-top:50px">
    <input name="id" type="hidden">
    原密码:<input name="password" id="updateAdminFormPassword"><br><br>
    新密码:<input name="password1" id="updateAdminFormPassword1"><br><br>
    新密码:<input name="password2" id="updateAdminFormPassword2"><br><br>
    <a id="updateAdminFormSubmitBtn" style="margin-left:30px">提交</a>
    <a id="updateAdminFormResetBtn" style="margin-left:40px">重置</a>
</form>
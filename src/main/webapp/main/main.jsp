<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

    <script type="text/javascript">
        $(function () {

        });

        function editPassword(id) {
            $("#updateAdminDialog").dialog({
                title: "修改密码页面",
                width: 450,
                height: 450,
                closed: true,
                href: "${pageContext.request.contextPath}/main/updateAdmin.jsp?id=" + id,
                modal: true,
                cache: false
            });
            $("#updateAdminDialog").dialog("open");
        }

    </script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
        <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
            欢迎您:${sessionScope.admin.name} &nbsp;<%--<a href="#" id="editPass"
                                                    onclick="editPassword('+${sessionScope.admin.id}+')"
                                                    class="easyui-linkbutton"
                                                    data-options="iconCls:'icon-edit'">修改密码</a>--%>&nbsp;&nbsp;<a
                href="${pageContext.request.contextPath}/admin/exit" class="easyui-linkbutton"
                data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 2252618624@qq.com</div>
    </div>

    <div data-options="region:'west',title:'导航菜单',split:true,href:'${pageContext.request.contextPath}/main/left.jsp'"
         style="width:220px;">

    </div>
    <div data-options="region:'center',href:'${pageContext.request.contextPath}/main/center.jsp'">

    </div>
    <div id="updateAdminDialog"></div>
</body> 
</html>
<%--可以加个acticle的基于Lucene的全文检索--%>
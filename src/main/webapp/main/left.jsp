<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript">
    // 菜单处理
    $(function () {


        $.get("${pageContext.request.contextPath}/menu/queryAllMenu",
            function (data) {
                $.each(data, function (idx, prov) {
                    var a = "";
                    $.each(prov.list, function (index, res) {
                        a += "<p style='text-align: center;background:#E0ECFF'><a  href=\"#\" class=\"easyui-linkbutton\" onclick=\"addTabs('" + res.title + "','" + res.iconcls + "','" + res.url + "')\" data-options=\"plain:true,iconCls:'" + res.iconcls + "'\">" + res.title + "</a></p>";
                    });
                    $('#aa').accordion("add", {
                        title: prov.title,
                        iconCls: prov.iconcls,
                        content: a,
                        selected: false,
                        animate: true
                    });

                });
            },
            "JSON"
        );


    });


    function addTabs(title, iconCls, url) {
        var a = $("#tt").tabs("exists", title);
        if (a) {
            $("#tt").tabs("select", title);
        } else {
            $('#tt').tabs('add', {
                title: title,
                iconCls: iconCls,
                href: "${pageContext.request.contextPath}/main/" + url,
                selected: true,
                closable: true
            });
        }

    }
</script>
<div id="aa" class="easyui-accordion" data-options="fit:true">

</div>
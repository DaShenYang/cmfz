<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/demo/css/application.css">

<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.raty.min.js"></script>

<script type="text/javascript">
    $("#queryAlbumForm").form("load", "${pageContext.request.contextPath}/album/queryOneAlbum?id=" +${param.id});

    $(function () {
        $("#queryAlbumForm").form({

            onLoadSuccess: function () {
                var u = $("#coverImg").val();
                $("#img1").prop("src", "${pageContext.request.contextPath}/" + u);
                $('#star').raty({
                    score: $("#score").val(),
                    readOnly: true

                });
            }
        });

    });


</script>
<form id="queryAlbumForm" method="post" align="center" style="margin-top:15px">

    专辑名称: <input name="title" readonly> <br>
    章节数量: <input name="count" readonly> <br>
    <input name="coverImg" id="coverImg" hidden> <br>
    封面图片: <img src="" id="img1" style="width:150px"/>
    <input name="score" id="score" hidden> <br>
    星级评分: <span id="star" style="margin-right:58px "></span><br>
    传奇作者: <input name="author" readonly> <br>
    优秀播音: <input name="broadcast" readonly> <br>
    精彩简介: <textarea name="brief" readonly style="margin-right:4px;width: 145px"></textarea><br><br>
    发布时间: <input name="pubDate" readonly>


</form>




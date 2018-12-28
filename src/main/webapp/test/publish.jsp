<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<html>
<head>
    <script type="text/javascript" src="http://cdn-hangzhou.goeasy.io/goeasy.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
<script type="text/javascript">
    $(function () {
        var goEasy = new GoEasy({
            appkey: "BC-a36c38bc99ab4be39f74d7840201943e"
        });
        goEasy.publish({
            channel: "140",
            message: "Hello, GoEasy!"
        });
    })
</script>
</body>
</html>

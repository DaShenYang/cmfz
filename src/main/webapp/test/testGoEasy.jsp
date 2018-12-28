<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>


<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="http://cdn-hangzhou.goeasy.io/goeasy.js" type="text/javascript"></script>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BS-4e74309cb8ef4b57b493a71ba3edeefc"
    });

    goEasy.subscribe({
        channel: "1228",
        onMessage: function (message) {
            alert("Channel:" + message.channel + " content:" + message.content);

        }
    });
</script>

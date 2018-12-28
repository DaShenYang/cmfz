<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script src="http://cdn-hangzhou.goeasy.io/goeasy.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/china.js"></script>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_china'));


    option = {
        title: {
            text: '持名法州APP用户分布图',
            subtext: '2018年12月25日 最新数据',
            left: 'center'
        },
        tooltip: {
            trigger: 'item'
        },
        // 说明
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['男', '女']
        },
        visualMap: {
            min: 0,
            max: 2500,
            left: 'left',
            top: 'bottom',
            text: ['高', '低'],           // 文本，默认为数值文本
            calculable: true
        },
        // 工具箱
        toolbox: {
            show: true,
            orient: 'vertical',
            left: 'right',
            top: 'center',
            feature: {
                dataView: {readOnly: false},
                restore: {},
                saveAsImage: {}
            }
        },
        series: [
            {
                name: '男',
                type: 'map',
                mapType: 'china',
                roam: false,
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            },
            {
                name: '女',
                type: 'map',
                mapType: 'china',
                label: {
                    normal: {
                        show: true
                    },
                    emphasis: {
                        show: true
                    }
                },
                data: []
            }
        ]
    };
    myChart.setOption(option);


    $(function () {
        var goEasy = new GoEasy({
            appkey: "BS-4e74309cb8ef4b57b493a71ba3edeefc"
        });


        /* $.post("/user/distribution2?sex=1", function () {
             goEasy.subscribe({
                 channel: "1228",
                 onMessage: function (message) {
                     myChart.setOption({
                         series: [{
                             name: '男',
                             data:message.content
                         }]
                     });
                 }
             });

         }, "json");*/


        $.ajax({
            async: false,
            type: 'POST',
            url: "${pageContext.request.contextPath }/user/distribution2?sex=1",
            success: function () {
                goEasy.subscribe({
                    channel: "1228",
                    onMessage: function (message) {
                        //alert("Channel:" + message.channel + " content:" + message.content);
                        myChart.setOption({
                            series: [{
                                // 根据名字对应到相应的系列
                                name: '男',
                                data: message.content
                            }]
                        });
                    }
                });

            },
            dataType: "json"
        });


        $.ajax({
            async: false,
            type: 'POST',
            url: "${pageContext.request.contextPath }/user/distribution2?sex=0",
            success: function () {
                goEasy.subscribe({
                    channel: "1228",
                    onMessage: function (message) {
                        //alert("Channel:" + message.channel + " content:" + message.content);
                        myChart.setOption({
                            series: [{
                                // 根据名字对应到相应的系列
                                name: '女',
                                data: message.content
                            }]
                        });
                    }
                });

            },
            dataType: "json"
        });


        /*$.post("/user/distribution2?sex=0", function () {
            goEasy.subscribe({
                channel: "1228",
                onMessage: function (message) {
                    myChart.setOption({
                        series: [{
                            name: '女',
                            data:message.content
                        }]
                    });
                }
            });

        }, "json");*/
    });
</script>


<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 0px;margin-left: 0px">

</div>



















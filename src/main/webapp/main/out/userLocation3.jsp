<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/china.js"></script>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('statistics_china'));
    var goEasy = new GoEasy({
        appkey: "BS-4e74309cb8ef4b57b493a71ba3edeefc"
    });


    goEasy.subscribe({
        channel: "1228",
        onMessage: function (message) {
            //alert("Channel:" + message.channel + " content:" + message.content);
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '女',
                    data: eval("(" + message.content + ")")
                }]
            });
        }
    });


    goEasy.subscribe({
        channel: "1828",
        onMessage: function (message) {
            //alert("Channel:" + message.channel + " content:" + message.content);
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '男',
                    data: eval("(" + message.content + ")")
                }]
            });
        }
    });


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


        $.post("${pageContext.request.contextPath }/user/distribution?sex=1", function (data) {

            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '男',
                    data: data
                }]
            });


        }, "json");


        /*[
            {
                "name":"北京",
                "value":1000
            },
            {
                "name":"四川",
                "value":1000
            },
            {
                "name":"河南",
                "value":2000
            }
        ]*/

        $.post("${pageContext.request.contextPath }/user/distribution?sex=0", function (data) {
            //console.log(data);
            myChart.setOption({
                series: [{
                    // 根据名字对应到相应的系列
                    name: '女',
                    data: data
                }]
            });


        }, "json");
    });
</script>


<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="statistics_china" style="width: 100%;height: 100%;margin-top: 0px;margin-left: 0px">

</div>



















<template>
    <div class="main">
        <div class="main-img">
            <div class="img-l">
                <span>生产商地区分布</span>
                <div id="manu">

                </div>
            </div>
            <div class="img-m">
                <span>供应商地区分布</span>
                <div id="sup"></div>
            </div>
            <div class="img-r">
                <span>经销商地区分布</span>
                <div id="deal"></div>
            </div>
        </div>
        <div class="msg" id="guizhang">
            <div class="title">
                <span>
                    规章制度
                </span>
            </div>
            <div class="m">
                <ul>
                    <li><a href="#" class="cs">平台管理制度(2023修订版)</a></li>
                    <li><a href="#" class="cs">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>
                    <li><a href="#">平台管理制度(2023修订版)</a></li>

                </ul>
            </div>
        </div>
        <div class="msg" id="xinxi">
            <div class="title">
                <span>
                    信息公告
                </span>
            </div>
            <div class="m">
                <ul>
                    <li><a href="#" class="cs">药明康德上传***信息</a></li>
                    <li><a href="#" class="cs">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>
                    <li><a href="#">药明康德上传***信息</a></li>

                </ul>
            </div>
        </div>
        <div class="msg" id="zhengce">
            <div class="title">
                <span>
                    相关政策
                </span>
            </div>
            <div class="m">
                <ul>
                    <li><a href="#" class="cs">《十四五农业发展规划》解读</a></li>
                    <li><a href="#" class="cs">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                    <li><a href="#">《十四五农业发展规划》解读</a></li>
                </ul>
            </div>
        </div>
    </div>
</template>

<script>
import * as echarts from 'echarts';
export default {
    data() {
        return {

        }
    },
    components: {

    },
    mounted() {
        this.drawChart();
        this.drawChart2();
        this.drawChart3();
    },
    methods: {
        drawChart() {
            let myChart = echarts.init(document.getElementById('manu'));
            let option;

            option = {
                backgroundColor: '#edeeff',
                title: {
                    text: '',
                    left: 'center',
                    top: 40,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                visualMap: {
                    show: false,
                    min: 80,
                    max: 600,
                    inRange: {
                        colorLightness: [0.5, 1]
                    }
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '60%',
                        center: ['50%', '50%'],
                        data: [
                            { value: 305, name: '哈尔滨' },
                            { value: 350, name: '北京' },
                            { value: 274, name: '上海' },
                            { value: 235, name: '广州' },
                            { value: 400, name: '深圳' }
                        ].sort(function (a, b) {
                            return a.value - b.value;
                        }),
                        roseType: 'radius',
                        label: {
                            color: 'rgba(51,51,51, 1.3)'
                        },
                        labelLine: {
                            lineStyle: {
                                color: 'rgba(98,102,235, 1.3)'
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20
                        },
                        itemStyle: {
                            color: '#a9abf4',
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        },
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function () {
                            return Math.random() * 200;
                        }
                    }
                ]
            };

            option && myChart.setOption(option);
        },
        drawChart2() {
            let myChart = echarts.init(document.getElementById('sup'));
            let option;

            option = {
                backgroundColor: '#ffeff7',
                title: {
                    text: '',
                    left: 'center',
                    top: 20,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                visualMap: {
                    show: false,
                    min: 80,
                    max: 600,
                    inRange: {
                        colorLightness: [0.5, 1]
                    }
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '60%',
                        center: ['50%', '50%'],
                        data: [
                        { value: 155, name: '哈尔滨' },
                            { value: 350, name: '北京' },
                            { value: 274, name: '上海' },
                            { value: 205, name: '广州' },
                            { value: 400, name: '深圳' }
                        ].sort(function (a, b) {
                            return a.value - b.value;
                        }),
                        roseType: 'radius',
                        label: {
                            color: 'rgba(51,51,51, 1.3)'
                        },
                        labelLine: {
                            lineStyle: {
                                color: 'rgba(255,116,187,1.3)'
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20
                        },
                        itemStyle: {
                            color: '#ff74bb',
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        },
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function () {
                            return Math.random() * 200;
                        }
                    }
                ]
            };

            option && myChart.setOption(option);
        },
        drawChart3() {
            let myChart = echarts.init(document.getElementById('deal'));
            let option;

            option = {
                backgroundColor: '#fff4ee',
                title: {
                    text: '',
                    left: 'center',
                    top: 20,
                    textStyle: {
                        color: '#ccc'
                    }
                },
                tooltip: {
                    trigger: 'item'
                },
                visualMap: {
                    show: false,
                    min: 80,
                    max: 600,
                    inRange: {
                        colorLightness: [0.5, 1]
                    }
                },
                series: [
                    {
                        name: 'Access From',
                        type: 'pie',
                        radius: '60%',
                        center: ['50%', '50%'],
                        data: [
                        { value: 355, name: '哈尔滨' },
                            { value: 280, name: '北京' },
                            { value: 324, name: '上海' },
                            { value: 205, name: '广州' },
                            { value: 400, name: '深圳' }
                        ].sort(function (a, b) {
                            return a.value - b.value;
                        }),
                        roseType: 'radius',
                        label: {
                            color: 'rgba(51,51,51, 1.3)'
                        },
                        labelLine: {
                            lineStyle: {
                                color: 'rgba(246,126,63,1.3)'
                            },
                            smooth: 0.2,
                            length: 10,
                            length2: 20
                        },
                        itemStyle: {
                            color: '#f67e3f',
                            shadowBlur: 200,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        },
                        animationType: 'scale',
                        animationEasing: 'elasticOut',
                        animationDelay: function () {
                            return Math.random() * 200;
                        }
                    }
                ]
            };

            option && myChart.setOption(option);
        },
    }

}

</script>

<style scoped>
.main {
    background-color: #f0f1f6;
    height: 880px;
    width: 1680px;
}

.main-img {
    height: 409px;
    width: 1640px;
    position: absolute;
    left: 20px;
    top: 11px;
    background-color: #fff;
}

.main-img span {
    width: 113px;
    height: 17px;
    border-radius: 0px;
    font-size: 16px;
    font-family: Microsoft YaHei, Microsoft YaHei-Bold;
    font-weight: normal;
    text-align: LEFT;
    color: #333333;
    line-height: 17px;
    font-weight: bolder;
}

.img-l {
    position: absolute;
    top: 21px;
    left: 20px;
}

.img-m {
    position: absolute;
    top: 21px;
    left: 560px;
}

.img-r {
    position: absolute;
    top: 21px;
    left: 1100px;
}

#manu {
    margin-top: 22px;
    height: 329px;
    width: 520px;
    background-color: aqua;
    border-radius: 6px;
}

#sup {
    margin-top: 22px;
    height: 329px;
    width: 520px;
    background-color: aqua;
    border-radius: 6px;
}

#deal {
    margin-top: 22px;
    height: 329px;
    width: 520px;
    background-color: aqua;
    border-radius: 6px;
}

.msg {
    height: 440px;
    width: 533px;
    background: #ffffff;
    border-radius: 6px;
}

.title {
    width: 513px;
    height: 60px;
    background: #ffffff;
    border-radius: 6px 6px 0px 0px;
    font-size: 14px;
    font-family: Microsoft YaHei, Microsoft YaHei-Normal;
    font-weight: normal;
    color: #333333;
    line-height: 60px;
    border-bottom: #f0f1f6 1px solid;

}

.title span {
    width: 64px;
    height: 17px;
    border-radius: 0px;
    font-size: 16px;
    font-family: Microsoft YaHei, Microsoft YaHei-Bold;
    font-weight: normal;
    text-align: LEFT;
    color: #333333;
    line-height: 17px;
    font-weight: bolder;
}

#guizhang {
    position: absolute;
    left: 21px;
    top: 430px;
}

#xinxi {
    position: absolute;
    left: 575px;
    top: 430px;
}

#zhengce {
    position: absolute;
    left: 1129px;
    top: 430px;
}

ul {
    list-style: none;
}

li {
    height: 35px;
    margin-top: 5px;
    margin-left: 20px;
}

li a {
    text-decoration: none
}

a {
    color: black;
}

.cs{
    color: #FF6B01;
}
</style>
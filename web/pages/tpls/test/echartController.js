/**
 * Created by Administrator on 2017-12-21.
 */
routerApp.controller('echartController',function ($scope,$state,$stateRegistry,FileUploader,TestService){
    //做第一个画布
  /*  var canvas1=document.getElementById('echarts1')
    var cxt=canvas1.getContext('2d');
    canvas1.width=600;
    canvas1.height=300;
    cxt.fillStyle='#cc92f9';
    cxt.fillRect(0,0,canvas1.width,canvas1.height);
    $scope.echarts1=echarts.init(canvas1);*/
    $scope.testJson=[{"is_total":"","quyu":"湖南","task_name":"测试任务1","value":"1"},
        {"is_total":"","quyu":"湖南2","task_name":"测试任务2","value":"2"},
        {"is_total":"yes","total_value":"total_value","quyu":"湖南3","task_name":"测试任务3","value":"3"}];
   /* var option={
        title:{
            text:'Echarts入门',

        },
        tooltip:{
            trigger: "item",
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend:{
            data:['销量']
        },
        xAxis:{
            data:['衬衫','羊毛衫','毛衣','大衣','棉衣']
        },
        yAxis:{

        },
        series:[{
            name:'销量',
            type:'bar',
            data:[5,12,18,20,26]
        }]
    };
    $scope.echarts1.setOption(option);
    //做第二个画布
    var canvas2=document.getElementById('echarts2')
    /!* var cxt2=canvas2.getContext('2d');
    canvas2.width=600;
    canvas2.height=300;
    cxt2.fillStyle='#cc92f9';
    cxt2.fillRect(0,0,canvas2.width,canvas2.height);*!/
    var echarts2 = echarts.init(canvas2);

    var option2={
        tooltip:{
            trigger:'item'
        },
        title:{
            text:'这是饼图',
            link:'http://echarts.baidu.com/option.html#title.show',
            target:'blank',
            subtext:'我是副标题',
            borderRadius:'5'

        },
        legend:{
            type:'scroll',
            top:'5',
            orient:'vertical',
            right:'0',
            formatter: function (name) {
                return echarts.format.truncateText(name, 40, '14px Microsoft Yahei', '…');
            },
            tooltip: {
                show: true
            },
            data:['视频广告','联盟广告','邮件营销','直接访问','搜索引擎','口头传输']
        },

        series:[
            {
                name:'访问来源',
                type:'pie',
                radius:'70%',
                data:[
                    {value:'236',name:'视频广告',
                          itemStyle:{
                                emphasis:{
                                shadowBlur:200,
                                shadowOffsetX:0,
                                shadowOffsetY:0,
                                shadowColor:'rgba(0,0,0,0.5)'
                            }

                        }

                    },
                    {value:'275',name:'联盟广告'},
                    {value:'220',name:'邮件营销'},
                    {value:'288',name:'直接访问'},
                    {value:'232',name:'搜索引擎'},
                    {value:'300',name:'口头传输'}
                ],
                roseType: 'angle',
                color:['#5FC235','#C2441E','#BEC214','#C2BABC','#1DC21D','#BCC20B'],
                backgroudColor:'#C29694'
            }
        ]
    };
    echarts2.setOption(option2);

    //第三个图
    var  canvas = document.getElementById("echarts3");
    var echarts3=echarts.init(canvas);
    var uploader=$scope.uploader = new FileUploader({
        url:'/SpringMvcAno/upload/uploadTest.do',
        formData:{
            fileName2:'66'
        }
    });
   uploader.filters.push({
        name:'fileNumber',
        fn:function (item,options) {
            return this.queue.length < 10;
        }
    });


*/
   $scope.testMapper=function () {
       var max=1000;
       for(var i =1;i<max;i++){
           var obj={
               redPacketId:1,
               userId:i
           }
           TestService.grapRedPacket(obj).$promise.then(function (obj) {

           });
       }

    }

})
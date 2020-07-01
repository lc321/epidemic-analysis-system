$(function(){
	$.ajax({
		url:"testinfo/selectForeignYiqingInWeeks.do",
		type:"get",//提交方式
		dataType:"json",//返回的数据类型
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			var echarts_3 = echarts.init(document.getElementById('echarts_3'));
		    option = {
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['现存确诊','现存治愈','现存死亡'],
			        textStyle:{
			        	color: 'white',
						fontStyle: 'normal',
						fontWeight: 'normal',
						fontFamily: '微软雅黑',
			        }
			    },
			    grid: {
			        left: '2%',
			        right: '7%',
			        bottom: '3%',
			        top: '10%',
			        containLabel: true
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: data[0].time,
			        axisLine: {
		                lineStyle: {
		                    type: 'solid',
		                    color: 'white',//左边线的颜色
		                }
		            },
			        axisLabel:{
			        	textStyle:{
				        	color: 'white',
							fontStyle: 'normal',
							fontWeight: 'normal',
							fontFamily: '微软雅黑',
				        }
			        }
			    },
			    yAxis: {
			        type: 'value',
			        axisLine: {
		                lineStyle: {
		                    type: 'solid',
		                    color: 'white',//左边线的颜色
		                    width:'1'//坐标线的宽度
		                }
		            },
			        axisLabel:{
			        	textStyle:{
				        	color: 'white',
							fontStyle: 'normal',
							fontWeight: 'normal',
							fontFamily: '微软雅黑',
				        }
			        }
			    },
			    series: [
			        {
			            name:'现存确诊',
			            type:'line',
			            smooth:true,
			            data:data[0].confimvalue,
			            itemStyle : {
			            	normal : {
			            		lineStyle:{
			            			color: '#FF0000'
			            		}
			            	}
			            }
			        },
			        {
			            name:'现存治愈',
			            type:'line',
			            smooth:true,
			            data:data[1].curedvalue,
			            itemStyle : {
			            	normal : {
			            		lineStyle:{
			            			color:'#00FF00'
			            		}
			            	}
			            }
			        },
			        {
			            name:'现存死亡',
			            type:'line',
			            smooth:true,
			            data:data[2].deadvalue,
			            itemStyle : {
			            	normal : {
			            		lineStyle:{
			            			color: '#1C1C1C'
			            		}
			            	}
			            }
			        }
			    ]
			};
		    echarts_3.setOption(option,true);
		}
	})
})

function loadTimeInWeeks(){
	var curTime = dateFormat();
	
}
//定义文档加载事件
$(function(){
	//运行加载国外所有国家名称的方法
	loadForeignPName("nameSelect");
	//默认加载
	loadData("美国");
})
//加载所有国家的名称
function loadForeignPName(id){
	$.ajax({
		url:"testinfo/selectForeignPName.do",
		type:"get",//提交方式
		dataType:"json",//返回的数据类型
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			//拼接省市名称
			var html = "";
			//遍历数组
			for(var i=0;i<data.length;i++){
				console.log(data[i].provinceName);
				html += "<option value='"+data[i].provinceName+"'>"+data[i].provinceName+"</option>"
			}
			//加载到select下拉框中
			$("#"+id+"").html(html);
			
		}
	})
}

//
function loadData(name){
	$.ajax({
		url:"testinfo/selectForeignYiqingByPName.do",
		type:"get",//提交方式
		data:{"pName":name},
		dataType:"json",//返回的数据类型
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			
			var echarts_2 =echarts.init(document.getElementById("echarts_2"),'infographic'); 
			option = {
			    title : {
			        x:'center'
			       
			    },
			    tooltip : {
			        trigger: 'item',
			        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    },
			    legend: {
			        orient: 'vertical',
			        left: 'left',
			        data: ['现有确诊','现有治愈','现有死亡'],
			        textStyle: {color: 'balck'}
			    },
			    
				label: {
				     normal: {
				          textStyle: {
				                color: 'red'  // 改变标示文字的颜色
				          }
				     }
				},
			    series : [
			        {
			            name: '今日国内疫情分析',
			            type: 'pie',
			            radius : '55%',
			            center: ['50%', '60%'],
			            data:data,
			          
			            itemStyle: {
			                emphasis: {
			                    shadowBlur: 10,
			                    shadowOffsetX: 0,
			                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			                }
			            }
			            
			        }
			    ]
			    
			};
			
			//
			echarts_2.setOption(option);
		}
	})
}

//下拉框选中触发
function selectByName(){
	var name = $("#nameSelect").val();
	loadData(name);
}
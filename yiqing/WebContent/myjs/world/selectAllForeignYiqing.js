//文档加载事件
$(function(){
	$.ajax({
		url:"testinfo/selectAllForeignYiqing.do",
		type:"get",//提交方式
		dataType:"json",//返回的数据类型
		success:function(data){
			//在浏览器控制台打印数据
			console.log(data);
			//显示查询数据到id="allcount"的标签的文本
			$("#newConfirm").text(data.newConfirm);
			$("#allConfirm").text(data.allConfirm);
			$("#cured").text(data.cured);
			$("#dead").text(data.dead);
			$("#maxPname").text(data.maxPname);
			$("#minPname").text(data.minPname);
			//
			var str = String(data.dead);
			console.log(str);
			var html = ""
			for(var i=0;i<str.length;i++){
				html += "<span>"+str[i]+"</span>";
			}
			$("#deadCount").html(html);
		}
	})
})
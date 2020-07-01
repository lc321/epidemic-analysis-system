<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>新冠型肺炎分析系统</title>
	<script src="js/jquery.min.js"></script>
	<script>
	 $(window).load(function(){  
             $(".loading").fadeOut()
            })  
	</script>
	
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/map.css">
</head>
<body>
	<div class="loading">
      <div class="loadbox"> 页面加载中... </div>
    </div>
<div class="data">
    <div class="data-title">
        <div class="title-center ">新冠型肺炎国外疫情分析</div>
    </div>
    <div class="data-content">
        <div class="con-left fl">
            <div class="left-top">
                <div class="info boxstyle">
                    <div class="title">国外疫情实时统计</div>
                    <div class="info-main">
						<ul>
							<li><span>现有确诊(认)</span><p id="newConfirm"></p></li>
							<li><span>累计确诊(人)</span><p id="allConfirm"></p></li>
							<li><span>治愈(人)</span><p id="cured"></p></li>
							<li><span>死亡(人)</span><p id="dead"></p></li>
							<li><span>疫情最严重国家</span><p id="maxPname"></p></li>
							<li><span>疫情最轻国家</span><p id="minPname"></p></li>
						</ul>
                    </div>
                </div>
                <div class="top-bottom boxstyle">
                    <div class="title">今日国外疫情分析</div>
                    <div id="echarts_1" class="charts"></div>
                </div>
            </div>
            <div class="left-bottom boxstyle">
                <div class="title">
                	<span>各国疫情分析</span>
                	<select id="nameSelect" onchange="selectByName()" style="height:20px;width:50px;margin-left:10px;font-size: 12px">
                		
                	</select>
                </div>
                <div id="echarts_2" class="charts"></div>
            </div>
        </div>
        <div class="con-center fl">
            <div class="map-num">
                <p>全球新冠肺炎死亡人数(人)</p>
                <div class="num" id="deadCount">
                    
                </div>
                <p><a href="./shouye.jsp">国内疫情分析</a></p>
            </div>
            <!-- <div class="select" tabindex="0" hidefocus="true">
                <a href="./shouye.jsp" >国外疫情分析</a>
            </div> -->
            <div class="cen-top map" id="world_map">
            </div>
            <div class="cen-bottom boxstyle">
                <div class="title">最近7天疫情趋势图</div>
                <div id="echarts_3" class="charts"></div>
            </div>
        </div>
        <div class="con-right fr">
            <div class="right-top boxstyle">
                <div class="title">国外新冠肺炎确诊TOP5</div>
                <div id="echarts_4" class="charts"></div>
            </div>
            <div class="right-center boxstyle">
                <div class="title">国外新冠肺炎治愈TOP5</div>
                <div id="echarts_5" class="charts"></div>
            </div>
            <div class="right-bottom boxstyle">
                <div class="title">国外新冠肺炎死亡TOP5</div>
                <div id="echarts_6" class="charts"></div>
            </div>
        </div>
    </div>
</div>
</body>

<script src="js/echarts.min.js"></script>
<script src="http://gallery.echartsjs.com/dep/echarts/map/js/world.js"></script>
<script src="myjs/world/myWorld.js"></script>
<script src="myjs/world/selectAllForeignYiqing.js"></script>
<script src="myjs/world/selectCurForeignYiqing.js"></script>
<script src="myjs/world/selectForeignYiqingByPName.js"></script>
<script src="myjs/world/selectForeignFiveConfrim.js"></script>
<script src="myjs/world/selectForeignFiveCured.js"></script>
<script src="myjs/world/selectForeignFiveDead.js"></script>
<script src="myjs/world/selectForeignYiqingInWeeks.js"></script>
</html>
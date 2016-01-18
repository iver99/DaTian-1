<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-零担</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
#allmap {
	width: 100%;
	height: 100%;
	overflow: hidden;
	margin: 1;
	font-family: "微软雅黑";
}
</style>
<!-- <script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=osuO3WDtmGYEK9nMYGZimjkb"></script> -->

<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
	<link type="text/css" rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
		<script type="text/javascript" src="js/top_search.js"></script>
		<script type="text/javascript" src="js/main_nav.js"></script>
		<script type="text/javascript" src="js/resource_select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="js/citylist.js"></script>
		<script type="text/javascript" src="js/cityquery.js"></script>
		<script type="text/javascript" src="js/jquery.tablesorter.pack.js"></script>
		<script type="text/javascript" src="js/table_sort.js"></script>
		<script type="text/javascript" src="js/popup.js"></script>
		<script type="text/javascript" src="js/backtop.js"></script>
		<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
		<!-- <script type="text/javascript" src="js/splitPage.js"></script> <!-- 新增 -->
		<script type="text/javascript" src="js/focus_load.js"></script>
		<!-- <script type="text/javascript" src="js/search_resource.js"></script>搜索资源 -->
		<!-- 引入工具js -->
<%@ include file="jsTool.jsp" %>
		<script type="text/javascript">
			$(function() {
				$('input, textarea').placeholder();
			});
		</script>
</head>

<body onload="OnLoad()">
	<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>
	<div id="main_frame">
		<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;零担<input type="hidden" id="page_info" value="零担"/>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
						<a href="fulltruckload?flag=0" class="a_leftnav" hidefocus="true">整车</a>
						<span class="text_leftnav1">零担</span> 
						<a href="cityline?flag=0" class="a_leftnav" hidefocus="true">落地配</a>
						<a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						<!-- <a href="company" class="a_leftnav" hidefocus="true">公司</a> --> 
						<a href="airline?flag=0" class="a_leftnav" hidefocus="true">国内空运</a>
					</div>
				</td>
				<td>
					<div id="div_resource_select">
						<div id="cityselector" class="div_cityselector1">
							起止城市： <input id="city1" type="text" value="" text="startCity" class="input_city1" /> &nbsp;&nbsp;至 &nbsp;&nbsp;
							 <input	id="city2" type="text" value="" text="endCity"	class="input_city1" />
						</div>
						<ul class="resource">
							<li class="resource_list">
								<dl id="select1" value="onwayTime">
									<dt>运输时限：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select1_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_1">24小时以内</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_2">48小时以内</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select1_3">72小时以内</a>
									</dd>
								</dl>
							</li>
							<li class="resource_list">
								<dl id="select2" value="offerReturn">
									<dt>提供回程：</dt>
									<dd class="resource_all selected">
										<a href="javascript:;" hidefocus="true" id="select2_0">全部</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_1">提供回程</a>
									</dd>
									<dd>
										<a href="javascript:;" hidefocus="true" id="select2_2">不提供回程</a>
									</dd>
								</dl>
							</li>
					 	<!-- <li class="resource_list">
								<dl>
									<dt>车辆位置：</dt>
									<dd>
										<input id="location1" type="text" text="location"
											class="input_resource_search1"
											style="width: 300px; cursor: pointer;" value="点击此处定位..."
											readonly="readonly" onclick="showid('popup2');map()" />
									</dd>
								</dl>
							</li>  -->
							<li class="resource_result">
								<dl>
									<dt>已选条件：</dt>
									<dd class="resource_no">暂无内容</dd>
								</dl>
							</li>
							<li><input type="button" id="btn2" value="重置"
								class="btn_resource_search2" hidefocus="true" onclick="Reset()"/> <input
								type="button" id="btn1" value="筛选" class="btn_resource_search1"
								hidefocus="true" /></li>
						</ul>
					</div>
					<div id="div_resource_list_head">
						<div id="div_resource_list_head1"><!-- 共  条记录 --></div>
						<input id="count" value="" type="hidden"/>
						<input id="display" value="10" type="hidden"/>
						<input id="currentPage" value="1" type="hidden"/>
						<input id="flag" value=0 type="hidden"/><!-- 点击页码和点击筛选标识位 -->
						
						<!-- <div id="middlesort">
							<ul class="quickmenu">
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">用途</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger1a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger1b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">状态</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger2a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger2b">降序</a>
											</div>
										</div>
									</div>
								</li>

								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">车长</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger3a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger3b">降序</a>
											</div>
										</div>
									</div>
								</li>
								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">载重</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger4a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger4b">降序</a>
											</div>
										</div>
									</div>
								</li>

								<li class="menuitem">
									<div class="menu">
										<a href="javascript:;" class="menuhd" hidefocus="true">关注</a>
										<div class="menubd">
											<div class="menubdpanel">
												<a href="javascript:;" class="a_top2a" hidefocus="true"
													id="trigger5a">升序</a> <a href="javascript:;"
													class="a_top2b" hidefocus="true" id="trigger5b">降序</a>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div> -->
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						class="table_main_list" id="list1">
						<thead id="thead">
                        <tr>
                            <td width="15" class="td_main_list_head"></td>
                            <td width="70" class="td_main_list_head">始发城市</td>
                            <td width="70" class="td_main_list_head">到达城市</td>
                            <td class="td_main_list_head">所有者</td>
                            <td class="td_main_list_head" width="55">&nbsp;时限<br />
                            <td class="td_main_list_head" width="55">提供<br />
                                回程</td>
                            <td class="td_main_list_head" width="75">标准报价<br />(元/吨)</td>
                            <td class="td_main_list_head" width="75">标准报价<br />(元/方)</td>
                            <td class="td_main_list_head" width="80">发布日期</td>
                            <td class="td_main_list_head" width="45">关注</td>
                        </tr>


						</thead>
						<tbody id="testbody">
							
						</tbody>
	<%-- 					<select id="carloc" style="display:none" >
							<c:forEach var="location" items="${locList }">
								<option value="${location.carNum }">${location.carNum }</option>
								<option value="${location.locLongitude }">${location.locLongitude }</option>
								<option value="${location.locLatitude }">${location.locLatitude }</option>
								<option value="${location.carLocation }">${location.carLocation }</option>
							</c:forEach>
						</select> 
 --%>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页 <select id="Display" onchange="changeDisplay()">
									<option value="10" selected="selected">10</option>
									<option value="20" >20</option>
									<option value="50">50</option>
							</select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_pagenumber" id="page_layout" value="1">
						<!-- 页码位置 -->
					</table>
				</td>
			</tr>
		</table>
	</div>

	<%-- <%@ include  file="popup1.jsp"%> --%>
	<div id="popup1" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">留言</div></td>
            <td>
                <div id="close" style="cursor:pointer;"><img src="images/btn_cancel1.png" title="关闭本窗口" /></div>
            </td>
        </tr>
    </table>
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="540">
            	<textarea class="textarea_popup1" placeholder="请输入内容..." id="message"></textarea>
            </td>
        </tr>
        <tr>
            <td class="td_popup1">
                <input type="button" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" onclick="insertMessage()"/>
                <input type="button" id="btn2" value="重填" class="btn_mgmt2" hidefocus="true" />
            </td>
        </tr>
    </table>
</div>

	<!-- <div id="popup2" style="display: inline;">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="610"><div class="div_popup_title1">地图</div></td>
				<td>
					<div id="close2" style="cursor: pointer;">
						<img src="images/btn_cancel1.png" title="关闭本窗口" />
					</div>
				</td>
			</tr>
		</table>
		<div class="div_popup_content1">
    	<img src="images/illust_4.jpg" width="100%" height="100%" />
    </div>
		<div class="div_popup_content1">
			<div id="allmap"></div>
		</div>
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="570" height="40"><input type="text"
					class="input_resource_search1"
					style="width: 200px; margin-left: 10px;" placeholder="请输入要查找的地点..."
					id="searchloc" value=""/> 
					<select class="select_popup1" id="searcharea">
						<option value="1" selected="selected">请选择范围</option>
						<option value="5">周围5公里以内</option>
						<option value="10">周围10公里以内</option>
						<option value="20">周围20公里以内</option>
						<option value="50">周围50公里以内</option>
				</select> <input type="button" value="搜索" class="btn_mgmt1" hidefocus="true"
					onclick="search()" /></td>
				<td>
					<div>
						<input type="button" id="close2a" value="提交" class="btn_mgmt1"
							hidefocus="true" />
					</div>
				</td>
			</tr>
		</table>
	</div> -->

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="footer.jsp"></iframe>
	</div>
</body>
<script type="text/javascript" charset="utf-8">
function OnLoad() {
	//Rescreen();
	
	
/*  	//修改隐藏字段，每页数量
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
	//加载数据
	if(checkSearch()){
		var display = $("#display").val();
		var currentPage = $("#currentPage").val();
	getSelectedLessLoadTruckAjax("中文或拼音","中文或拼音","All","All",display,currentPage);
	getSelectedLessTruckLoadTotalRows("中文或拼音","中文或拼音","All","All",display,currentPage); */
 
	 loadFocus(); 
		if(checkSearch()){
			if(checkRecommend()){
				var display = $("#display").val();
				var currentPage = $("#currentPage").val();
			getSelectedLessLoadTruckAjax("中文或拼音","中文或拼音","All","All",display,currentPage);
			getSelectedLessTruckLoadTotalRowsAjax("中文或拼音","中文或拼音","All","All",display,currentPage);
				
			}
			
		}
/*  	检查是否需要执行搜索功能   上面if语句和js已经判断是否执行，故无用

	checkSearch();  */
}
//用于上方下拉页的链接
function checkRecommend(){
	var paraStr=window.location.search;
	paraStr=UrlDecode(paraStr);//汉字解析
	if(paraStr.indexOf("city1")>0 || paraStr.indexOf("city2")>0){//参数串中存在搜索信息
		var para=new Array();
		var city1;//存储搜索种类
		var city2;//存储搜索内容
		//debugger;
		para=paraStr.split("&");
		for(var i=0;i<para.length;i++){
			//alert(para[i]);
			if(para[i].indexOf("city1")>=0){//解析搜索类型
				var para_kind=new Array();
				para_kind=para[i].split("=");
				city1=para_kind[1];//第二个值为参数值
			}
			if(para[i].indexOf("city2")>=0){//解析搜索内容
				var para_content=new Array();
				para_content=para[i].split("=");
				city2=para_content[1];//第二个值为参数值
			}
		}
		//set value
		$("#city1").val(city1);
		$("#city2").val(city2);
		//这里没有设置运输类型的显示效果
		if(type == '整车'){
			$("#select1_1").click(); 
		}
		if(type == '零担'){
			$("#select1_2").click(); 
		}
		$("#btn1").click();
		return false;
	}
	
	return true;
}
</script>






<!-- <script type="text/javascript">
	// 百度地图API功能
	var map = new BMap.Map("allmap"); // 创建Map实例
	map.centerAndZoom(new BMap.Point(116.403851, 39.915295), 12); // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl()); //添加地图类型控件
	map.setCurrentCity("北京"); // 设置地图显示的城市 此项是必须设置的
	map.enableScrollWheelZoom(true); //开启鼠标滚轮缩放
	var longitude = 116.403851;
	var latitude = 39.915295;
	var localSearch = new BMap.LocalSearch(map);
	var loclist = new Array();
	var k = -4;
	<c:forEach var="location" items="${locList }">
	k += 4;
	var point = new BMap.Point(
			document.getElementById("carloc").options[k + 1].text, document
					.getElementById("carloc").options[k + 2].text);
	var marker = new BMap.Marker(point);
	marker.disableMassClear();
	map.addOverlay(marker); // 将标注添加到地图中
	//marker.addEventListener("click",getAttr);
	var label = new BMap.Label(
			document.getElementById("carloc").options[k].text, {
				offset : new BMap.Size(20, -10)
			});
	marker.setLabel(label);
	</c:forEach>
	var point = new BMap.Point(longitude, latitude);
	map.centerAndZoom(point, 13);
	//alert(k);
	map
			.addEventListener(
					"click",
					function(e) {
						if (e.overlay) {

							for (i = 0; i <= k; i += 4) {
								//alert(document.getElementById("carloc").options[i].text + " " +e.overlay.getLabel().content);
								if (document.getElementById("carloc").options[i].text == e.overlay
										.getLabel().content) {
									document.getElementById("searchloc").value = document
											.getElementById("carloc").options[i + 3].text;
									//e.overlay.setAnimation(BMAP_ANIMATION_BOUNCE);
									longitude = document
											.getElementById("carloc").options[i + 1].text;
									latitude = document
											.getElementById("carloc").options[i + 2].text;
								}
								//alert(document.getElementById("carloc").options[i+3].text);
							}
							//alert(e.overlay.getLabel().content);
							//alert('你点击的是覆盖物：'+e.overlay.toString());   
						}
					});
//车辆位置-范围-圈
function search() {
	
	var myGeo = new BMap.Geocoder();
	if(document.getElementById("searchloc").value != "")
	{
		// 将地址解析结果显示在地图上,并调整地图视野
		myGeo.getPoint($("#searchloc").val(), function(point){
			if (point) {
				localSearch.setSearchCompleteCallback(function (searchResult) {
			        var poi = searchResult.getPoi(0);
			        longitude = poi.point.lng;
			        latitude = poi.point.lat;
			        map.clearOverlays();
					var point = new BMap.Point(longitude, latitude);
					var range = document.getElementById("searcharea").options[document
							.getElementById("searcharea").selectedIndex].value * 1000;
					var circle = new BMap.Circle(point, range, {
						strokeColor : "blue",
						strokeWeight : 2,
						strokeOpacity : 0.5
					});
					map.addOverlay(circle);
			    });
				localSearch.search($("#searchloc").val());
				map.panTo(point);
			}else{
				alert("您选择地址没有解析到结果!");
			}
		}, "北京市");
		
	}
	else
	{
		longitude=116.403851;
		latitude=39.915295;
		map.clearOverlays();
		var point = new BMap.Point(longitude, latitude);
		var range = document.getElementById("searcharea").options[document
				.getElementById("searcharea").selectedIndex].value * 1000;
		var circle = new BMap.Circle(point, range, {
			strokeColor : "blue",
			strokeWeight : 2,
			strokeOpacity : 0.5
		});
		map.addOverlay(circle);
		map.panTo(point);
	}
}
document.getElementById('popup2').style.display = "none";
</script> -->

<script type="text/javascript">
function Reset()
{
	document.getElementById("select1_0").click();
	document.getElementById("select2_0").click();
	document.getElementById("city1").value = "中文或拼音";
	document.getElementById("city2").value = "中文或拼音";
}
function loadXMLDoc(id)
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=car&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}

//零担筛选
function getSelectedLessLoadTruckAjax(startCity,endCity,onwayTime,offerReturn,display,currentPage){
      var url="getSelectedLesstruckloadAjax";
	  $.post(url,{
		  startCity:startCity,
		  endCity:endCity,
		  onwayTime:onwayTime,
		  offerReturn:offerReturn,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //alert(data);
			  $("#testbody").empty();
		for(var i=0; i<data.length; i++) {
			var str="<tr>";
			/* str+="<td class=\"td_main_list_content\"></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startCity+"</a></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].endCity+"</a></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"companyDetail?id="+data[i].carrierId+"\" style=\"color:#717071;\"  hidefocus=\"true\"> "+data[i].companyName+" <img src=\"images/btn_level1a.png\" /></a>"+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].onwayTime+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].offerReturn+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].stanPrice1+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].stanPrice2+"</td>";
			str+="<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>"
			if(data[i].status == "有效"){
				str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
			}else{
				str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
			}
			str+="</tr>";
			 $("#testbody").append(str);
		}
	  },"json"); */
	  	$("#testbody").append("<tr>");
		$("#testbody").append("<td class=\"td_main_list_content\"></td>");
		$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startCity+"</a></td>");
		$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].endCity+"</a></td>");
		$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"companyDetail?id="+data[i].carrierId+"\" style=\"color:#717071;\"  hidefocus=\"true\"> "+data[i].companyName+" <img src=\"images/btn_level1a.png\" /></a></td>");
		$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].onwayTime+"</td>");
		$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].offerReturn+"</td>");
		$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].stanPrice1+"</td>");
		$("#testbody").append("<td class=\"td_main_list_content\">"+data[i].stanPrice2+"</td>");
		$("#testbody").append("<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>");
		if(data[i].status == "有效")
			$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
		else
			$("#testbody").append("<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>");
		$("#testbody").append("</tr>");
		
		
	}
  },"json");
}

function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 

//获取所有零担筛选的总条数
function getSelectedLessTruckLoadTotalRowsAjax(startCity,endCity,onwayTime,offerReturn,display,currentPage){
	 
	var url="getSelectedLesstruckloadTotalRowsAjax";
	  $.post(url,{
		  startCity:startCity,
		  endCity:endCity,
		  onwayTime:onwayTime,
		  offerReturn:offerReturn,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //返回总记录数
			  $('#div_resource_list_head1').text("共"+data+"条记录");
			  $('#count').val(data);
			  $("#page_layout").empty();
			  pageLayout(data);//页面布局
	  },"text");
	
}

//控制页码显示
function pageLayout(totalRows){
	var display=parseInt($('#display').val());
	var currentPage=parseInt($('#currentPage').val());
	var pageNum=Math.ceil(totalRows/display);
	var page_layout=$('#page_layout');
	var str="<tr>";
	str+="<td width='45' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+1+");' class='a_pagenumber' hidefocus='true'>首页</a></td>";
	var pre=currentPage==1?1:currentPage-1;
	str+="";
	if(pageNum< 8){
		for(var i=1;i<=pageNum;i++){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
		}
	}
	if(pageNum>=8){
		if(currentPage<=3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage==4){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage==5){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			str+="...";
		}
		if(currentPage>5 && currentPage<=pageNum-3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var j=currentPage-2;j<currentPage+2;j++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+j+");' class='a_pagenumber' hidefocus='true' id="+j+">"+j+"</a></td>";
			}
			str+="...";
		}
		if(currentPage==pageNum-3){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var i=currentPage-5;i<=currentPage;i++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			}
		}
		if(currentPage==pageNum-2){
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('1');' class='a_pagenumber' hidefocus='true' id='1'>1</a></td>";
			str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo('2');' class='a_pagenumber' hidefocus='true' id='2'>2</a></td>";
			str+="...";
			for(var i=currentPage-4;i<=currentPage;i++){
				str+="<td width='30' class='td_pagenumber' onclick=''><a href='javascript:ChangeTo("+i+");' class='a_pagenumber' hidefocus='true' id="+i+">"+i+"</a></td>";
			}
		}
	}
	var lat=currentPage==pageNum?pageNum:currentPage+1;
	str+="<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+lat+");' class='a_pagenumber' hidefocus='true'>下页</a></td>";
	str+="<td width='45' class='td_pagenumber' ><a href='javascript:ChangeTo("+pageNum+");' class='a_pagenumber' hidefocus='true'>末页</a></td>";
	str+="</tr>";
   
	page_layout.append(str);
	
	$("#"+currentPage).css("background","#7EBFEF");
}
//页面 跳转
function ChangeTo(page){
	//alert("change to "+page);
	var page_layout=$('#page_layout');
	page_layout.empty();
	$('#currentPage').val(page);
	//点击页码，标志位置为1
	$('#flag').val(1);
	$('#btn1').click();
	
}        

//变更每页展示数量
function changeDisplay(){
	//修改隐藏字段，每页数量——
	
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
	//加载数据
	if(checkSearch()){
		var display = $("#display").val();
		var currentPage = $("#currentPage").val();
	getSelectedLessLoadTruckAjax("中文或拼音","中文或拼音","All","All",display,currentPage);
	getSelectedLessTruckLoadTotalRowsAjax("中文或拼音","中文或拼音","All","All",display,currentPage);
		
	}
}
</script>
</html>
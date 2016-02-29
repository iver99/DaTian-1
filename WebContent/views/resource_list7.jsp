<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>资源-国内空运</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
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
		<!-- <!-- script type="text/javascript" src="js/search_resource.js"></script> -->
		<!-- 引入工具js -->
		
		<script type="text/javascript" src="js/resource_select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="js/search_resource.js" charset="UTF-8"></script>
		<script type="text/javascript" src="js/change_item.js" charset="UTF-8"></script>
		<script type="text/javascript" src="js/tool.js" charset="UTF-8"></script>
		<!-- 兼容html5 -->

 		<script src="http://haiqiancun.com/file/demo/custom.modernizr.js"></script>

 		<!-- 用于表单验证 -->
		<script type="text/javascript" src="js/jquery.metadata.js"></script>
		<script type="text/javascript" src="js/jquery.validate.js"></script>
		<script type="text/javascript" src="js/messages_zh.js"></script>
		<!-- 仓库详情，查看联系人 -->
		<script type="text/javascript" src="js/viewContact.js"></script>
		<script type="text/javascript" src="js/renderTime.js"></script>
		<!-- 选择日期控件 -->
		<script type="text/javascript" src="js/calendar.js"></script>
		
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
		<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;国内空运<input type="hidden" id="page_info" value="国内空运"/>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
						 <a href="fulltruckload?flag=0" class="a_leftnav" hidefocus="true">整车</a>
						 <a href="lesstruckload?flag=0" class="a_leftnav" hidefocus="true">零担</a>
						 <a href="cityline?flag=0"	class="a_leftnav" hidefocus="true">落地配</a> 
						 <a href="warehouse?flag=0" class="a_leftnav" hidefocus="true">仓库</a>
						 <span class="text_leftnav1">国内空运</span> 
						 <!-- <a href="goodsform?flag=0" class="a_leftnav" hidefocus="true" style="border-bottom: none;">货物</a> -->
					</div>
				</td>
				<td>
				 <!-- 这一层对应筛选部分,某些控件的text和value值有所更改，后面通过这两个值控制筛选状态  -->
            	<div id="div_resource_select">
                    <div id="cityselector" class="div_cityselector1">
                        起止港：
                        <input id="city1" type="text" text="startCity" value="" class="input_city1" />
                        &nbsp;&nbsp;至&nbsp;&nbsp;
                        <input id="city2" type="text" text="endCity" value="" class="input_city1" />
                    </div>
                    <ul class="resource">
                        <li class="resource_list">
                            <dl id="select1" value="onwayTime">
                                <dt>抵运时间：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="select1_0">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_1">12小时抵运</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_2">24小时抵运</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select1_3">48小时抵运</a></dd>
                            </dl>
                        </li>
<!--                         <li class="resource_list">
                            <dl id="select2" value="">
                                <dt>航班周期：</dt>
                                <dd class="resource_all selected"><a href="javascript:;" hidefocus="true" id="">全部</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_1">每天</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_2">周一二</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_3">周一二三</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_3">周一二三四</a></dd>
                                <dd><a href="javascript:;" hidefocus="true" id="select2_3">周一二三四五</a></dd>
                            </dl>
                        </li> -->
                        <li class="resource_result">
                            <dl>
                                <dt>已选条件：</dt>
                                <dd class="resource_no">暂无内容</dd>
                            </dl>
                        </li>
                        <li>
                            <input type="button" id="btn2" value="重置" class="btn_resource_search2" hidefocus="true" onclick="Reset()"/>
                        	<input type="button" id="btn1" value="筛选" class="btn_resource_search1" hidefocus="true"/>
                        </li>
                    </ul>
				</div>
					<div id="div_resource_list_head">
						<div id="div_resource_list_head1"><!-- 共  条记录 --></div>
						<input id="count" value="" type="hidden"/>
						<input id="display" value="10" type="hidden"/>
						<input id="currentPage" value="1" type="hidden"/>
						<input id="flag" value=0 type="hidden"/><!-- 点击页码和点击筛选标识位 -->
					</div>
					<table border="0" cellspacing="0" cellpadding="0"
						class="table_main_list" id="list">
						<thead id="thead">
							<tr>
								<td width="15" class="td_main_list_head"></td>
								<td width="70" class="td_main_list_head">始发港</td>
								<td width="70" class="td_main_list_head">目的港</td>
								<td class="td_main_list_head">所有者</td>
								<td class="td_main_list_head" width="60">M</td>
                                <td class="td_main_list_head" width="60">N</td>
                                <td class="td_main_list_head" width="60">+45</td>
                                <td class="td_main_list_head" width="60">+100</td>
                                <td class="td_main_list_head" width="60">+300</td>
                                <td class="td_main_list_head" width="70">航班周期</td>
                                <td class="td_main_list_head" width="70">抵运时间</td>
                                <td class="td_main_list_head" width="80">发布日期</td>
                                <td class="td_main_list_head" width="45">关注</td>
							</tr>
						</thead>
						<tbody id="testbody"></tbody>
						<tbody>
							<!-- 资源位置 -->
						</tbody>
					</table>
					<table border="0" cellpadding="0" cellspacing="0"
						class="table_recordnumber">
						<tr>
							<td>每页  <select id="Display" onchange="changeDisplay()">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select> 条记录
							</td>
						</tr>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout" value="1">
          <!--        页码位置 -->
				</table>
				</td>
			</tr>
		</table>
	</div>

	<%@ include  file="popup1.jsp"%>
	

	<div id="footer_frame">
		<iframe allowtransparency="true" width="100%" frameborder="0"
			hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0"
			src="footer.jsp"></iframe>
	</div>
	<!-- <div id="myDiv"></div> -->
</body>
<script type="text/javascript" charset="utf-8">
	function OnLoad() {
		loadFocus();
		if(checkSearch()){//返回true执行if,返回false执行上方搜索  checkSearch()
			if(checkRecommend()){//返回trye执行if，返回false执行首页查询  checkFind()
				var display=$("#display").val();
				var currentPage=$("#currentPage").val();
			getSelectedAirLineAjax("中文或拼音","中文或拼音","All",display,currentPage);
			getSelectedAirLineTotalRowsAjax("中文或拼音","中文或拼音","All",display,currentPage); 
			}
		}
		//首页的查询功能
		//checkFind();
		//检查是否需要执行搜索功能
		//checkSearch();
	}
	//用于topframe中菜单中推荐功能
	/* function checkRecommendation(){
		
	} */
	
	
	function checkSearch(){
		//debugger;
		var paraStr=window.location.search;
		paraStr=UrlDecode(paraStr);//汉字解析
//		alert("搜索功能...");
		//debugger;
		if(paraStr.indexOf("resource_kind")>0 || paraStr.indexOf("search_content")>0){//参数串中存在搜索信息
			var para=new Array();
			var resource_kind;//存储搜索种类
			var search_content;//存储搜索内容
			para=paraStr.split("&");
			for(var i=0;i<para.length;i++){
				//alert(para[i]);
				if(para[i].indexOf("resource_kind")>=0){//解析搜索类型
					var para_kind=new Array();
					para_kind=para[i].split("=");
					resource_kind=para_kind[1];//第二个值为参数值
				}
				if(para[i].indexOf("search_content")>=0){//解析搜索内容
					var para_content=new Array();
					para_content=para[i].split("=");
					search_content=para_content[1];//第二个值为参数值
				}
			}
			//往上方的搜索框填值用来保存搜索信息
			$("#search_content").val(search_content);
			$("#resource_choose").val(resource_kind);
			if(resource_kind == '线路'){
				$("#choose1").click();
			}else if(resource_kind == '配送'){
				$("#choose2").click();
			}else if(resource_kind == '车辆'){
				$("#choose3").click();
			}else if(resource_kind == '仓库'){
				$("#choose4").click();
			}else if(resource_kind == '公司'){
				$("#choose5").click();
			}else if(resource_kind == '货物'){
				$("#choose6").click();
			}
			//执行搜索
			searchKind();
			return false;//返回false，执行搜索功能,不执行list页面的默认的异步加载资源
		}
		return true;//返回true说明不需要执行搜索，则执行list页面上默认的资源加载
	}
	
	//用于国内空运资源
	function checkRecommend(){
		//alert("recommend");
		var paraStr=window.location.search;
		paraStr=UrlDecode(paraStr);//汉字解析
		if(paraStr.indexOf("city1")>0 || paraStr.indexOf("city2")>0 ){//参数串中存在搜索信息
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
			$("#btn1").click();
			return false;
		}
		
		return true;
	}
</script>
<script type="text/javascript">
//重置功能
function Reset()
{
	document.getElementById("select1_0").click();
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
		   data: "type=airline&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
}

//国内空运筛选
function getSelectedAirLineAjax(startCity,endCity,onwayTime,display,currentPage){
	//alert("ajax_post");
      var url="airlineAjax";
	  $.post(url,{
		  startCity:startCity,
		  endCity:endCity,
		  onwayTime:onwayTime,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //alert(data);
			  $("#testbody").empty();
		for(var i=0; i<data.length; i++) {
			var str="<tr>";
			str+="<td class=\"td_main_list_content\"></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"airlinedetail?airlineId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startCity+"</a></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"airlinedetail?airlineId="+data[i].id+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].endCity+"</a></td>";
			str+="<td class=\"td_main_list_content\">"+"<a href=\"companyDetail?id="+data[i].carrierId+"\" style=\"color:#717071;\"  hidefocus=\"true\"> "+data[i].companyName+" <img src=\"images/btn_level1a.png\" /></a>"+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].price1+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].price2+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].price3+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].price4+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].price5+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].airCycle+"</td>";
			str+="<td class=\"td_main_list_content\">"+data[i].onwayTime+"</td>";
			str+="<td class=\"td_main_list_content\">"+renderTime(data[i].relDate)+"</td>"
			if(data[i].status == "有效"){
				str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
			}else{
				str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
			}
			str+="</tr>";
			 $("#testbody").append(str);
		}
	  },"json");
}

//时间转换
function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 

//获取国内空运的总条数
function getSelectedAirLineTotalRowsAjax(startPlace,
		endPlace,
		onwayTime,
		display,
		currentPage){
	var url="airlineTotalRowsAjax";
	  $.post(url,{
		  startPlace:startPlace,
		  endPlace:endPlace,
		  onwayTime:onwayTime,
		  display:display,
		  currentPage:currentPage},
	  function(data,status){
			  //返回总记录数
			  $('#div_resource_list_head1').text("共"+data+"条记录");
			  $('#count').val(data);
			  $("#page_layout").empty();
				pageLayout(data);
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
	//修改隐藏字段，每页数量
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
	if(checkSearch()){
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getSelectedAirLineAjax("中文或拼音","中文或拼音","All",display,currentPage);
		getSelectedAirLineTotalRowsAjax("中文或拼音","中文或拼音","All",display,currentPage);
	}
}

</script>


</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>零担资源信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/splitPage.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<!-- 新增 -->
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的资源
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
                    <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>

	<td class="td_leftnav_top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			class="table_mgmt_right2">
			<tr>
				<td><span class="span_mgmt_right2_text1">零担资源信息</span> <span
					class="span_mgmt_right2_text2"><a href="insert?flag=12"
						hidefocus="true"><img src="images/btn_add1.png"
							class="span_mgmt_right2_pic1" title="添加" /></a></span></td>
			</tr>

		</table>

		<div id="div_resource_list_head1"><%-- 共 ${count } 条记录 --%></div> <!-- 新增 --> 
		<!-- 页码相关 -->
		<input id="count" value="" type="hidden" /><!--  总记录条数 -->
		<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
		<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
		<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
		<input id="kind" value="lesstruckload" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
		

		<table width="100%" border="0" cellspacing="0" cellpadding="0" 
			class="table_mgmt_right3">
			<thead id="thead">
			   <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td width="70" class="td_mgmt_right3_head">始发城市</td>
                        <td width="70" class="td_mgmt_right3_head">到达城市</td>
                        <td width="55" class="td_mgmt_right3_head">时限<br />
                            (小时)</td>
                        <td class="td_mgmt_right3_head">提供<br />回程</td>
                        <td width="75" class="td_mgmt_right3_head">标准报价<br />
                            (元/吨)</td>
                        <td width="75" class="td_mgmt_right3_head">标准报价<br />
                            (元/方)</td>
                        <td width="55" class="td_mgmt_right3_head">提货费<br />
                            (元)</td>
                        <td width="55" class="td_mgmt_right3_head">送货费<br />
                            (元)</td>
                        <td width="80" class="td_mgmt_right3_head">发布日期</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
              </tr>

			</thead>
			<tbody id="result_body">
				
			</tbody>
		</table>
		<table border="0" cellpadding="0" cellspacing="0"
			class="table_recordnumber">
			<tr>
				<td>每页 <select id="Display" onchange="changeDisplay()">
						<option value="10" selected="selected">10</option>
						<!-- 修改value -->
						<option value="20">20</option>
						<option value="50">50</option>
				</select> 条记录
				</td>
			</tr>
		</table> 
		<table border="0" cellpadding="0" cellspacing="0" id="page_layout" class="table_pagenumber">
			<!--  page -->
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

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		//加载零担资源
		getLesstruckloadResource(display,currentPage);
		getLessTruckLoadResourceTotalRows(display,currentPage); 
	}
	
//加载零担资源
function getLesstruckloadResource(display,currentPage){
	var url="getLessTruckLoadResourceAjax";
	$.ajax({
		url:url,
		data:{
			display:display,
			currentPage:currentPage
			},
		cache:false,
		dataType:"json",
		success:function(data,status){
			var body=$("#result_body");
			//循环输出结果集
			body.empty();
			   for(var i=0;i<data.length;i++){
				   		var str="<tr>";
				   		str+="<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\"><a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId=0&flag=1\" hidefocus=\"true\">"+data[i].startCity+"</a></td>";
				   		str+="<td class=\"td_mgmt_right3_td1\"><a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId=0&flag=1\" hidefocus=\"true\">"+data[i].endCity+"</a></td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].onwayTime+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].offerReturn+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].stanPrice1+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].stanPrice2+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].pickFee+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+data[i].deliveryFee+"</td>";
				   		str+="<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>";
				   		str+="<td class='td_mgmt_right3_td3'>";
				   		str+="<div id=\"handlebox\" style=\"z-index: 201;\">";
						str+="<ul class=\"quickmenu\">";
						str+="<li class=\"menuitem\">";
						str+="<div class=\"menu\">";
						str+="<a href=\"lesstruckloaddetail?truckId="+data[i].id+"&carrierId=0&flag=2\" class=\"menuhd\" hidefocus=\"true\">更新</a>";
						str+="<div class=\"menubd\">";
						str+="<div class=\"menubdpanel\">";
						str+="<a href=\"lesstruckloaddelete?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">删除</a>";
						str+="</div></div></div></li></ul></div></td></tr>";
						
						body.append(str);
			}   
			
		}
	})
}
//干线资源总条数
function getLessTruckLoadResourceTotalRows(display,currentPage){
	var url="getLessTruckLoadResourceTotalRowsAjax";
	$.ajax({
		url:url,
		data:{
			display:display,
			currentPage:currentPage
		},
		cache:false,
		dataType:"json",
		success:function(data,status){
			 $('#count').val(data);
			 $("#page_layout").empty();
			 pageLayout(data);//页面布局
		}
	});
}

//变更每页展示数量
function changeDisplay(){
	//修改隐藏字段，每页数量
	$("#display").val($("#Display").val());
	//当前页归1
	$("#currentPage").val(1);
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		//加载零担资源
		getLesstruckloadResource(display,currentPage);
		getLessTruckLoadResourceTotalRows(display,currentPage);
}

</script>

</html>
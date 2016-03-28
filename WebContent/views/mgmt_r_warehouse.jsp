<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>仓库信息</title>
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
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
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
                <div id="main_frame_left" >
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch1a();">我的交易</span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch1b();">我的交易</span>
                    <div id="mgmt_nav1" class="div_mgmt_show1">
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                         <% if((Integer)session.getAttribute("userKind") ==2) {%>
                         	<a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的意向</a>
                         <% } %>    <!-- 个人用户 -->
                         <% if((Integer)session.getAttribute("userKind") ==3) {%>
                            <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的意向</a>
                         <% } %>    <!-- 企业用户 -->
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();">我的资源</span>
                    <span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();">我的资源</span>
                    <div id="mgmt_nav2" >
                     <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="fulltruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">整车资源信息</a>
                        <a href="lesstruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">零担资源信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">落地配资源信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆资源信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav1" hidefocus="true">仓库资源信息</a>
                        <a href="airline?flag=1" class="a_mgmt_leftnav" hidefocus="true">国内空运资源信息</a>
                        <a href="driver" class="a_mgmt_leftnav" hidefocus="true">司机资源信息</a>
                     <% } %>    <!-- 企业用户 -->
                     <% if((Integer)session.getAttribute("userKind") ==2) {%>
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                     <% } %>    <!-- 个人用户 -->
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch4a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch4a();">统计分析</span>
                    <span id="mgmt_nav_switch4b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch4b();">统计分析</span>
                    <div id="mgmt_nav4" class="div_mgmt_show1">
                    <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getTransportAccuracyPage" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                    <% } %>
                        <a href="getFinancialInfoPage" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" class="div_mgmt_show1">
                        <a href="accountinfo" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属账户</a>
                      <% } %>    <!-- 企业用户 -->
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">仓库信息</span>
                            <span class="span_mgmt_right2_text2"><a href="insert?flag=4" hidefocus="true"><img src="images/btn_add1.png" class="span_mgmt_right2_pic1" title="添加" /></a></span>
                        </td>
                	</tr>
            	</table>
            	
            	<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="warehouse" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
		            	
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3" >
                   <thead>
                    <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td class="td_mgmt_right3_head">仓库名称</td>
                        <td width="60" class="td_mgmt_right3_head">所在城市</td>
                        <td width="60" class="td_mgmt_right3_head">类型</td>
                        <td width="80" class="td_mgmt_right3_head">仓库面积<br />
                        (平方米)</td>
                        <td width="80" class="td_mgmt_right3_head">发布日期</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
                    </tr>
                   </thead>
                   <tbody id="result_body">
                   
                   </tbody>       
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                            <select id="Display" onchange="changeDisplay()">
                                <option value="10" selected="selected">10</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
            	<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber" id="page_layout">
				</table>
			</td>
		</tr>
    </table>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getUserWarehouseResource(display,currentPage);
		getUserWarehouseResourceTotalRows(display,currentPage);
	}
	//加载仓库资源
	function getUserWarehouseResource(display,currentPage){
		var url="getUserWarehouseResourceAjax";
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
				body.empty();
				//循环输出结果集
				for(var i =0;i<data.length;i++){
					
					var str="<tr>";
					str+="<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>";
					str+="<td class=\"td_mgmt_right3_td1\"><a href=\"warehousedetail?warehouseId="+data[i].id+"&carrierId=0&flag=1\" hidefocus=\"true\">"+data[i].name+"</a></td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].city+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].type+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].houseArea+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>";
					str+="<td class=\"td_mgmt_right3_td3\"><div id=\"handlebox\" style=\"z-index: 203;\">";
					str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
					str+="<div class=\"menu\">";
					str+="<a href=\"warehousedetail?warehouseId="+data[i].id+"&carrierId=0&flag=2\" class=\"menuhd\" hidefocus=\"true\">更新</a>";
					str+="<div class=\"menubd\">";
					str+="<div class=\"menubdpanel\">";
					str+="<a href=\"warehousedelete?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">删除</a>";
					str+="</div></div></div></li></ul></div></td>";
					str+="</tr>";
					body.append(str);
							
				} 
				
			}
		})
	}
	//仓库资源总条数
	function getUserWarehouseResourceTotalRows(display,currentPage){
		var url="getUserWarehouseResourceTotalRowsAjax";
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
			getUserWarehouseResource(display,currentPage);
			getUserWarehouseResourceTotalRows(display,currentPage);
	}
</script>
</html>
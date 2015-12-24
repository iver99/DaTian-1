<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String date=(String)request.getParameter("date");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的关注</title>
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
<!-- <script type="text/javascript" src="js/jquery.placeholder.min.js"></script> -->
<script type="text/javascript" src="js/focus_load.js"></script>
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
/* 	$(function() {
		$('input, textarea').placeholder(); 
	}); */
</script>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>

<div id="main_frame">
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的交易
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();"></span><span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();"></span>我的交易</span>
                    <div id="mgmt_nav1">
                        <a href="getallfocus" class="a_mgmt_leftnav1" hidefocus="true">我的关注</a>
                       	<% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="getallresponse" class="a_mgmt_leftnav" hidefocus="true">我的反馈</a>
                         <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==2) {%> <!-- 普通用户 -->
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的订单</a>
                      <%} %>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%><!-- 企业用户 -->
                        <a href="recieveorderinfo" class="a_mgmt_leftnav" hidefocus="true">我收到的订单</a>
                       <%} %>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <% if((Integer)session.getAttribute("userKind") ==2) {%>  <!-- 普通用户 -->
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                       <%} %>
						</div>
                   <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                   <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">财务指标</span>
                            <div class="div_mgmt_s1">
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="意向开始时间" readonly="readonly" title="点击选择" />
                                &nbsp;&nbsp;至&nbsp;&nbsp;
                                <input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" value="意向结束时间" readonly="readonly" title="点击选择" />
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" />
                            </div>

                        </td>
                	</tr>
            	</table>
            	
            	<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="focus" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
                <table id="list" width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <!-- <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head">&nbsp;</td>
                        <td width="100" class="td_mgmt_right3_head">意向编号</td>
                        <td width="70" class="td_mgmt_right3_head">类别</td>
                        <td width="120" class="td_mgmt_right3_head">名称</td>
                        <td class="td_mgmt_right3_head">承运方</td>
                        <td width="88" class="td_mgmt_right3_head">意向提交时间</td>
                        <td class="td_mgmt_right3_head">运费收入(元)</td>
                        <td class="td_mgmt_right3_head">保险费收入(元)</td>
                        <td class="td_mgmt_right3_head">合计收入(元)</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
					</tr>
                    <tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1">Y001001001</td>
                        <td class="td_mgmt_right3_td1">整车</td>
                        <td class="td_mgmt_right3_td1">北京→上海</td>
                        <td class="td_mgmt_right3_td1">北京畅通达物流</td>
                        <td class="td_mgmt_right3_td1">2014-02-21<br />
                            10:44:28</td>
                        <td class="td_mgmt_right3_td1">12000</td>
                        <td class="td_mgmt_right3_td1">1000</td>
                        <td class="td_mgmt_right3_td1">13000</td>
                        <td class="td_mgmt_right3_td3"><a href="javascript:;" class="a_top3" hidefocus="true">查看</a></td>
                    </tr> -->
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                            <select  id="Display" onchange="changeDisplay()">
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
		//var search_content=$("#search_focus").val();
		var date="<%=date %>";
		var startDate=$("#startDate").val();
		var endDate=$("#endDate").val();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		viewFinancialDetails(date,startDate,endDate,display,currentPage);
		//总数
		//getFinancialInfoTotalRowsAjax(startDate,endDate,display,currentPage);
	}
	
	//获取财务指标猎豹
	function viewFinancialDetails(date,startDate,endDate,display,currentPage){
		var url="viewFinancialDetailsAjax";
		$.ajax({
			url:url,
			data:{
				date:date,
				startDate:startDate,
				endDate:endDate,
				display:display,
				currentPage:currentPage
			},
			dataType:"json",
			cache:false,
			success:function(data,status){
				var body=$("#list");
				body.empty();
				var str="";
				str+="<tr>";
				str+="<td width=\"20\" height=\"40\" class=\"td_mgmt_right3_head\">&nbsp;</td>";
				str+="<td width=\"100\" class=\"td_mgmt_right3_head\">意向编号</td>";
				str+="<td width=\"70\" class=\"td_mgmt_right3_head\">类别</td>";
				str+="<td width=\"120\" class=\"td_mgmt_right3_head\">名称</td>";
				str+="<td class=\"td_mgmt_right3_head\">承运方</td>";
				str+="<td width=\"88\" class=\"td_mgmt_right3_head\">意向提交时间</td>";
				str+="<td class=\"td_mgmt_right3_head\">运费收入(元)</td>";
				str+="<td class=\"td_mgmt_right3_head\">保险费收入(元)</td>";
				str+="<td class=\"td_mgmt_right3_head\">合计收入(元)</td>";
				str+="<td width=\"80\" class=\"td_mgmt_right3_head\">操作</td>";
				str+="</tr>";
				
				body.append(str);
				str="";
				for(var i=0;i<data.length;i++){
					str+="<tr>";
					str+="<td height=\"60\" class=\"td_mgmt_right3_td1d\">&nbsp;</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].orderNum+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\"></td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].resourceName+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].clientName+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].submitTime)+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].actualPrice+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+data[i].insurance+"</td>";
					str+="<td class=\"td_mgmt_right3_td1\">"+(data[i].actualPrice+data[i].insurance)+"</td>";
					str+="<td class=\"td_mgmt_right3_td3\"><a href=\"javascript:;\" class=\"a_top3\" hidefocus=\"true\">查看</a></td>";
					str+="</tr>";
				}
				body.append(str);
				}
			
				
		});
	}
	//总记录数
	function getUserFocusTotalRowsAjax(search_content,display,currentPage){
		var url="getUserFocusTotalRowsAjax";
		$.ajax({
			url:url,
			data:{
				startDate:startDate,
				endDate:endDate,
				display:display,
				currentPage:currentPage
			},
			dataType:"json",
			cache:false,
			success:function(data,status){
				 $('#count').val(data);
				 $("#page_layout").empty();
				  pageLayout(data);//页面布局
			}
				
		});
	}
	
	//搜素关注
	function searchFocus(){
		$("#result_body").empty();
		var search_content=$("#search_focus").val();
		//reset page
		$("#display").val(1);
		$("#currentPage").val(1);
		
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getUserFocusAjax(search_content,display,currentPage);
		//总数
		getUserFocusTotalRowsAjax(search_content,display,currentPage);
		
	}
	
	//变更每页展示数量
	function changeDisplay(){
		//修改隐藏字段，每页数量
		$("#display").val($("#Display").val());
		//当前页归1
		$("#currentPage").val(1);
			var display=$("#display").val();
			var currentPage=$("#currentPage").val();
			var search_content=$("#search_focus").val();
			getUserFocusAjax(search_content,display,currentPage);
			//总数
			getUserFocusTotalRowsAjax(search_content,display,currentPage);
	}
</script>
</html>
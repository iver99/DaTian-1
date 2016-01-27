<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
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
                        	<span class="span_mgmt_right2_text1">我的关注</span>
                            <!-- <span class="span_mgmt_right2_text2"><a href="javascript:;" hidefocus="true" class="a_btn_mgmt3">取消关注</a></span> -->
                            <div class="div_mgmt_s1">
                            <!-- <form action="getallfocus" method="post"> -->
                            	<input type="text" class="input_mgmt1" style="width:200px;" placeholder="关注内容" name="search_focus" id="search_focus"/>
                                <input type="button" id="btn1" value="查询" class="btn_mgmt3" hidefocus="true" onclick="searchFocus()"/>
                              <!--   </form> -->
                            </div>
                        </td>
                	</tr>
            	</table>
            	
            	<input id="count" value="" type="hidden" /><!--  总记录条数 -->
				<input id="display" value="10" type="hidden" /> <!-- 每页展示的数量 -->
				<input id="currentPage" value="1" type="hidden" /><!-- 当前页 -->
				<input id="is_resource_page" value="0" type="hidden"/><!-- 是否为资源页，资源页需要模拟click按钮 -->
				<input id="kind" value="focus" type="hidden"/><!-- 用于判断是哪一栏的分页,用于splitPage.js -->
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                <thead>
                    <tr>
                        <td width="30" height="40" class="td_mgmt_right3_head1"><input type="checkbox" id="f1_all" onClick="selectall();" /></td>
						<td width="60" class="td_mgmt_right3_head">类别</td>
                        <td class="td_mgmt_right3_head">名称</td>
                        <td width="80" class="td_mgmt_right3_head">发布日期</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
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
		var search_content=$("#search_focus").val();
		var display=$("#display").val();
		var currentPage=$("#currentPage").val();
		getUserFocusAjax(search_content,display,currentPage);
		//总数
		getUserFocusTotalRowsAjax(search_content,display,currentPage);
	}
	
	//获取用户的关注列表
	function getUserFocusAjax(search_content,display,currentPage){
		var url="getUserFocusAjax";
		$.ajax({
			url:url,
			data:{
				search_content:search_content,
				display:display,
				currentPage:currentPage
			},
			dataType:"json",
			cache:false,
			success:function(data,status){
				var body=$("#result_body");
				body.empty();
				for(var i=0;i<data.length;i++){
					if(data[i].focusType == 'fulltruckload'){
						body.append("<tr>");
						body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\"><input type=\"checkbox\" name=\"f1\" id=\"f1a\" /></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">整车</td>");
						var str="<td class=\"td_mgmt_right3_td1\">";
						str+="<a href=\"fulltruckloaddetail?truckId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startPlace+"→"+data[i].endPlace+"</a>"+"<br>"+"<a href=\"fulltruckloaddetail?truckId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"&nbsp;<img src=\"images/btn_level1a.png\" /></a>";
						str+="</td>";
						body.append(str);	
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>");
						
						if(data[i].status == '有效'){
							var str="<td class=\"td_mgmt_right3_td1\">有效</td>";
							str+="<td class=\"td_mgmt_right3_td3\">";
							str+="<div id=\"handlebox\" style=\"z-index:205;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getneworderform?carrierid="+data[i].carrierId+"&flag=1&resourceId="+data[i].resourceId+"\" class=\"menuhd\" hidefocus=\"true\">提交订单</a> ";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"deletefocus?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">取消关注</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
							}
						else if(data[i].status == '失效'){
							body.append("<td class=\"td_mgmt_right3_td1\"><span class=\"span_mgmt_right3_text3\">失效</span></td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						body.append("</tr>");
					}
					if(data[i].focusType == 'lesstruckload'){
						body.append("<tr>");
						body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\"><input type=\"checkbox\" name=\"f1\" id=\"f1a\" /></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">零担</td>");
						var str="<td class=\"td_mgmt_right3_td1\">";
						str+="<a href=\"lesstruckloaddetail?truckId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startPlace+"→"+data[i].endPlace+"</a>"+"<br>"+"<a href=\"lesstruckloaddetail?truckId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"&nbsp;<img src=\"images/btn_level1a.png\" /></a>";
						str+="</td>";
						body.append(str);	
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>");
						
						if(data[i].status == '有效'){
							var str="<td class=\"td_mgmt_right3_td1\">有效</td>";
							str+="<td class=\"td_mgmt_right3_td3\">";
							str+="<div id=\"handlebox\" style=\"z-index:205;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getneworderform?carrierid="+data[i].carrierId+"&flag=5&resourceId="+data[i].resourceId+"\" class=\"menuhd\" hidefocus=\"true\">提交订单</a> ";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"deletefocus?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">取消关注</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
							}
						else if(data[i].status == '失效'){
							body.append("<td class=\"td_mgmt_right3_td1\"><span class=\"span_mgmt_right3_text3\">失效</span></td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						body.append("</tr>");
					}
					if(data[i].focusType == 'cityline'){
						body.append("<tr>");
						body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\"><input type=\"checkbox\" name=\"f1\" id=\"f1a\" /></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">落地配</td>");
						var str="<td class=\"td_mgmt_right3_td1\">";
						str+="<a href=\"citylinedetail?citylineId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].name+"</a>"+"<br>"+"<a href=\"citylinedetail?citylineId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"&nbsp;<img src=\"images/btn_level1a.png\" /></a>";
						str+="</td>";
						body.append(str);	
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>");
						
						if(data[i].status == '有效'){
							var str="<td class=\"td_mgmt_right3_td1\">有效</td>";
							str+="<td class=\"td_mgmt_right3_td3\">";
							str+="<div id=\"handlebox\" style=\"z-index:205;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getneworderform?carrierid="+data[i].carrierId+"&flag=2&resourceId="+data[i].resourceId+"\" class=\"menuhd\" hidefocus=\"true\">提交订单</a> ";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"deletefocus?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">取消关注</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
							}
						else if(data[i].status == '失效'){
							body.append("<td class=\"td_mgmt_right3_td1\"><span class=\"span_mgmt_right3_text3\">失效</span></td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						body.append("</tr>");
							
					}
					if(data[i].focusType == 'warehouse'){
						body.append("<tr>");
						body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\"><input type=\"checkbox\" name=\"f1\" id=\"f1a\" /></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">仓库</td>");
						var str="<td class=\"td_mgmt_right3_td1\">";
						str+="<a href=\"warehousedetail?warehouseId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].name+"</a>"+"<br>"+"<a href=\"warehousedetail?warehouseId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"&nbsp;<img src=\"images/btn_level1a.png\" /></a>";
						str+="</td>";
						body.append(str);	
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>");
						
						if(data[i].status == '有效'){
							body.append("<td class=\"td_mgmt_right3_td1\">有效</td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						else if(data[i].status == '失效'){
							body.append("<td class=\"td_mgmt_right3_td1\"><span class=\"span_mgmt_right3_text3\">失效</span></td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						body.append("</tr>");			
					}
					if(data[i].focusType == 'airline'){
						body.append("<tr>");
						body.append("<td height=\"60\" class=\"td_mgmt_right3_td1d\"><input type=\"checkbox\" name=\"f1\" id=\"f1a\" /></td>");
						body.append("<td class=\"td_mgmt_right3_td1\">国内空运</td>");
						var str="<td class=\"td_mgmt_right3_td1\">";
						str+="<a href=\"airlinedetail?airlineId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" hidefocus=\"true\">"+data[i].startPlace+"→"+data[i].endPlace+"</a>"+"<br>"+"<a href=\"airlinedetail?truckId="+data[i].resourceId+"&carrierId="+data[i].carrierId+"&flag=0\" class=\"link1\" hidefocus=\"true\">"+data[i].companyName+"&nbsp;<img src=\"images/btn_level1a.png\" /></a>";
						str+="</td>";
						body.append(str);	
						body.append("<td class=\"td_mgmt_right3_td1\">"+renderTime(data[i].relDate)+"</td>");
						
						if(data[i].status == '有效'){
							var str="<td class=\"td_mgmt_right3_td1\">有效</td>";
							str+="<td class=\"td_mgmt_right3_td3\">";
							str+="<div id=\"handlebox\" style=\"z-index:205;\">";
							str+="<ul class=\"quickmenu\"><li class=\"menuitem\">";
							str+="<div class=\"menu\">";
							str+="<a href=\"getneworderform?carrierid="+data[i].carrierId+"&flag=6&resourceId="+data[i].resourceId+"\" class=\"menuhd\" hidefocus=\"true\">提交订单</a> ";
							str+="<div class=\"menubd\">";
							str+="<div class=\"menubdpanel\">";
							str+="<a href=\"deletefocus?id="+data[i].id+"\" class=\"a_top3\" hidefocus=\"true\">取消关注</a>";
							str+="</div></div></div></li></ul></div></td>";
							body.append(str);
							}
						else if(data[i].status == '失效'){
							body.append("<td class=\"td_mgmt_right3_td1\"><span class=\"span_mgmt_right3_text3\">失效</span></td>");
							body.append("<td class=\"td_mgmt_right3_td3\"><a href=\"deletefocus?id="+data[i].id+"\" hidefocus=\"true\">取消关注</a></td>");
							}
						body.append("</tr>");
					}
				}
			}				
		});
	}
	//总记录数
	function getUserFocusTotalRowsAjax(search_content,display,currentPage){
		var url="getUserFocusTotalRowsAjax";
		$.ajax({
			url:url,
			data:{
				search_content:search_content,
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
﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>车辆信息</title>
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
                <div id="main_frame_left">
                    <%@ include  file="mysource_leftnav_mytrade.jsp"%>
                    <%@ include  file="mysource_leftnav_myresource.jsp"%>
                    <%@ include  file="mysource_leftnav_myplan.jsp"%>
                    <%@ include  file="mysource_leftnav_myanalysis.jsp"%>
                    <%@ include  file="mysource_leftnav_myaccount.jsp"%>
</div>
			</td>
			<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">查看车辆信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">牌照号码：</td>
                                    <td>${carInfo.carNum }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">定位方式：</td>
                                    <td>${carInfo.locationType } (终端ID：${carInfo.terminalId })</td>
                                </tr>
                               <%--  <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">当前位置：</td>
                                    <td>${carInfo.carLocation } &nbsp;&nbsp;<a href="javascript:;" hidefocus="true" title="刷新轨迹"><img src="images/btn_refresh1.png" />&nbsp;刷新</a>&nbsp;&nbsp;&nbsp;<a href="mgmt_r_car5.htm" hidefocus="true" title="查看地图"><img src="images/btn_map4.png" />查看</a></td>
                                </tr> --%>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">车型：</td>
                                    <td>${carInfo.carType } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">厢型：</td>
                                    <td>${carInfo.carBase } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">品牌：</td>
                                    <td>${carInfo.carBrand } </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">用途：</td>
                                    <td>${carInfo.carUse }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">规格：</td>
                                    <td>长${carInfo.carLength } × 宽 ${carInfo.carWidth } × 高 ${carInfo.carHeight } (米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">载重：</td>
                                    <td>${carInfo.carWeight } (吨)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">购置日期：</td>
                                    <td><fmt:formatDate value ="${carInfo.purchaseTime }" pattern= "yyyy-MM-dd" /></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">冷藏：</td>
                                    <td>${carInfo.storage }</td>
                                </tr>
                                <%-- <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机姓名：</td>
                                    <td>${driverInfo.driverName }</td>
                                </tr> --%>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机电话：</td>
                                    <td>${driverInfo.phone }</td>
                                </tr>
                                <%-- <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运营线路：</td>
                                    <td>${carInfo.startPlace }←→${carInfo.endPlace }</td>
                                </tr> --%>
                                <%-- <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">经停城市：</td>
                                    <td>${carInfo.stopPlace }</td>
                                </tr> --%>
                            </table>
                        </td>
                    </tr>
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
	}
</script>
</html>
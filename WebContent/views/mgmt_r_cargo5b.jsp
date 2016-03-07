<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物信息</title>
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
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch1a();">我的交易</span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch1b();">我的交易</span>
                    <div id="mgmt_nav1" class="div_mgmt_show1">
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的意向</a>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();">我的资源</span>
                    <span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();">我的资源</span>
                    <div id="mgmt_nav2" >
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav1" hidefocus="true">货物信息</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch4a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch4a();">统计分析</span>
                    <span id="mgmt_nav_switch4b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch4b();">统计分析</span>
                    <div id="mgmt_nav4" class="div_mgmt_show1">
                        <a href="getTransportAccuracyPage" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                        <a href="getFinancialInfoPage" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" class="div_mgmt_show1">
                        <a href="accountinfo" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
</div>
			</td>
				<td class="td_leftnav_top">
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2">
                    <tr>
                    	<td>
                        	<!-- <span class="span_mgmt_right2_text1">货物名称：北京发往华中地区，包括末端配送</span> -->
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
                        <td class="td_mgmt_right3_head">提交人</td>
                        <td width="120" class="td_mgmt_right3_head">电话</td>
                        <td width="80" class="td_mgmt_right3_head">提交日期</td>
                        <td width="60" class="td_mgmt_right3_head">状态</td>
                        <td width="80" class="td_mgmt_right3_head">操作</td>
                    </tr>
                    <c:forEach var="response" items="${respList }">
                    <tr>
                        <td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
                        <td class="td_mgmt_right3_td1">${response.committer }</td>
                        <td class="td_mgmt_right3_td1">${response.phone }</td>
                        <td class="td_mgmt_right3_td1">${response.relDate }</td>
                        <c:choose>
                        	<c:when test="${response.status == '已确认' }">
                        		 <td class="td_mgmt_right3_td2">${response.status }</td>
                        		<td class="td_mgmt_right3_td3"><a href="viewResponseDetailInfo?responseid=${response.id }" hidefocus="true">查看</a></td>
                        	</c:when>
                        	<c:otherwise>
                        		<td class="td_mgmt_right3_td1">${response.status }</td>
                        		<td class="td_mgmt_right3_td3"><a href="viewResponseDetailInfo?responseid=${response.id }" hidefocus="true">查看</a></td>
                        	</c:otherwise>
                        </c:choose>
                       
                       
                    </tr>
                    </c:forEach>
                   
                </table>
				<table border="0" cellpadding="0" cellspacing="0" class="table_recordnumber">
                    <tr>
	                    <td>
                            每页
                            <select>
                                <option value="" selected="selected">10</option>
                                <option value="a">20</option>
                                <option value="b">50</option>
                            </select>
                            条记录
                        </td>
                    </tr>
				</table>
            	<table border="0" cellpadding="0" cellspacing="0" class="table_pagenumber">
                    <tr>
	                    <td width="45" class="td_pagenumber">首页</td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">上页</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">1</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">2</a></td>
                        <td width="30" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">3</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">下页</a></td>
                        <td width="45" class="td_pagenumber"><a href="javascript:;" class="a_pagenumber" hidefocus="true">末页</a></td>
					</tr>
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
	}
</script>
</html>
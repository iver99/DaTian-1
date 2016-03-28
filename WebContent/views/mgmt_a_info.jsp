<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帐户信息</title>
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

	<%@ include file="topFrame.jsp"%>

	<div id="main_frame">
		<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的帐户
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left">
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
                    <span id="mgmt_nav_switch2a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch2a();">我的资源</span>
                    <span id="mgmt_nav_switch2b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch2b();">我的资源</span>
                    <div id="mgmt_nav2" class="div_mgmt_show1">
                     <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="fulltruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">整车资源信息</a>
                        <a href="lesstruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">零担资源信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">落地配资源信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆资源信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库资源信息</a>
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
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" >
                        <a href="accountinfo" class="a_mgmt_leftnav1" hidefocus="true">帐户信息</a>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属账户</a>
                      <% } %>    <!-- 企业用户 -->
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
					</div>
				</td>
				<td class="td_leftnav_top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="table_mgmt_right2">
						<tr>
							<td><span class="span_mgmt_right2_text1">帐户信息</span></td>
						</tr>
					</table>
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="table_mgmt_right3">
						<tr>
							<td width="20" height="40" class="td_mgmt_right3_head1">&nbsp;</td>
							<td class="td_mgmt_right3_head">类别&nbsp;&nbsp;${msg }</td>
							<td width="120" class="td_mgmt_right3_head">状态</td>
							<td width="80" class="td_mgmt_right3_head">操作</td>
						</tr>
						<tr>
							<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
							<td class="td_mgmt_right3_td1">基本信息</td>
							<td class="td_mgmt_right3_td3"><img
								src="images/btn_hint1.png" />&nbsp;已完成</td>
							<td class="td_mgmt_right3_td3"><a href="basicuserinfo"
								hidefocus="true">查看</a></td>
						</tr>

						<tr>
							<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
							<td class="td_mgmt_right3_td1">用户头像</td>
							<c:choose>
								<c:when test="${headCheck==true}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint1.png" />&nbsp;已设置</td>
									<td class="td_mgmt_right3_td3">
										<div id="handlebox" style="z-index: 202;">
											<ul class="quickmenu">
												<li class="menuitem">
													<div class="menu">
														<a href="getuserpicture" class="menuhd"
															hidefocus="true">查看</a>
														<div class="menubd">
															<div class="menubdpanel">
																<a href="getSetHeadIconPage" class="a_top3"
																	hidefocus="true">更新</a>
															</div>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</td>
								</c:when>
								<c:otherwise >
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint2.png" />&nbsp;未设置</td>
									<td class="td_mgmt_right3_td3"><a href="getSetHeadIconPage"
										hidefocus="true">设置</a></td>
								</c:otherwise>
							</c:choose>

						</tr>
						<%  /* if((Integer)session.getAttribute("userKind") ==2){ %>
						<tr>
							<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
							<td class="td_mgmt_right3_td1">
								认证信息(个人)</td>
							<c:choose>
								<c:when test="${status=='审核中'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint3.png" />&nbsp;审核中</td>
									<td class="td_mgmt_right3_td3"><a href="viewClientInfoDetail"
										hidefocus="true">查看</a></td>
								</c:when>
								<c:when test="${status=='已审核'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint1.png" />&nbsp;已审核</td>
									<td class="td_mgmt_right3_td3">
										<div id="handlebox" style="z-index: 202;">
											<ul class="quickmenu">
												<li class="menuitem">
													<div class="menu">
														<a href="viewClientInfoDetail" class="menuhd" hidefocus="true">查看</a>
														<div class="menubd">
															<div class="menubdpanel">
																<a href="getupdateUserinfoForm" class="a_top3" hidefocus="true">更新</a>
															</div>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</td>
								</c:when>
								<c:when test="${status=='未验证'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint2.png" />&nbsp;未验证</td>
									<td class="td_mgmt_right3_td3"><a href="getvalidateform"
										hidefocus="true">立即验证</a></td>
								</c:when>
							</c:choose>

						</tr> 
						<%}  */
							if((Integer)session.getAttribute("userKind") ==3){
						%>
						<tr>
						<td height="60" class="td_mgmt_right3_td1d">&nbsp;</td>
							<td class="td_mgmt_right3_td1">认证信息(公司)</td>
						<c:choose>
								<c:when test="${status=='审核中'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint3.png" />&nbsp;审核中</td>
									<td class="td_mgmt_right3_td3"><a href="detailcompanycertificate?flag=0"
										hidefocus="true">查看</a></td>
								</c:when>
								<c:when test="${status=='已审核'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint1.png" />&nbsp;已审核</td>
									<td class="td_mgmt_right3_td3">
										<div id="handlebox" style="z-index: 202;">
											<ul class="quickmenu">
												<li class="menuitem">
													<div class="menu">
														<a href="detailcompanycertificate?flag=0" class="menuhd" hidefocus="true">查看</a>
														<div class="menubd">
															<div class="menubdpanel">
																<a href="detailcompanycertificate?flag=1" class="a_top3" hidefocus="true">更新</a>
															</div>
														</div>
													</div>
												</li>
											</ul>
										</div>
									</td>
								</c:when>
								<c:when test="${status=='未验证'}">
									<td class="td_mgmt_right3_td3"><img
										src="images/btn_hint2.png" />&nbsp;未验证</td>
									<td class="td_mgmt_right3_td3"><a href="getcompanyvalidateform"
										hidefocus="true">立即验证</a></td>
								</c:when>
							</c:choose>
							
							
						<%} %>
					</table> <br /> <img src="images/btn_help.png" />&nbsp;&nbsp;个人或公司均可发布资源信息。
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
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<%@ include file="jsTool.jsp" %>
<script type="text/javascript"> 
	$(function() {
		$('input, textarea').placeholder(); 
	});
</script>
</head>

<body>

<%@ include file="qq.jsp"%>

<%@ include file="topFrame.jsp"%>

	<div id="main_frame">
		<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的帐户
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="230" class="td_leftnav_top">
					<div id="main_frame_left" >
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch1a();">我的交易</span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch1b();">我的交易</span>
                    <div id="mgmt_nav1" class="div_mgmt_show1" >
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                        <a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的意向</a>
                        <a href="mysettlement" class="a_mgmt_leftnav" hidefocus="true">我的结算</a>
                        <a href="mycomplaint" class="a_mgmt_leftnav" hidefocus="true">我的投诉</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch2a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch2a();">我的资源</span>
                    <span id="mgmt_nav_switch2b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch2b();">我的资源</span>
                    <div id="mgmt_nav2" class="div_mgmt_show1">
                        <a href="goodsform?flag=1" class="a_mgmt_leftnav" hidefocus="true">货物信息</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch4a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch4a();">统计分析</span>
                    <span id="mgmt_nav_switch4b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch4b();">统计分析</span>
                    <div id="mgmt_nav4" class="div_mgmt_show1">
                        <a href="getTransportAccuracyPage" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                        <a href="getFinancialInfoPage" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" >
                        <a href="accountinfo" class="a_mgmt_leftnav1" hidefocus="true">帐户信息</a>
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
					</div>
				</td>
            <td class="td_leftnav_top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
					<tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">认证信息</span>
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
									<td width="120" height="40" class="td_mgmt_right3_td1b">用户名：</td>
									<td><%=request.getSession().getAttribute("username") %></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司名称：</td>
									<td>${detailCompanyCertificate.companyName }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">组织机构代码：</td>
									<td>${detailCompanyCertificate.divisionCode }</td>
								</tr>
								<!-- <tr>
									<td height="40" class="td_mgmt_right3_td1b">法人姓名：</td>
									<td>${detailCompanyCertificate.legalName }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">法人身份证号：</td>
									<td>${detailCompanyCertificate.legalIDCard }</td>
								</tr> -->
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司地址：</td>
									<td>${detailCompanyCertificate.companyAddr }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司性质：</td>
									<td>${detailCompanyCertificate.companyType }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">公司规模：</td>
									<td>${detailCompanyCertificate.companyScale }</td>
								</tr>

								<!-- <tr>
									<td height="40" class="td_mgmt_right3_td1b">发票种类：</td>
									<td>${detailCompanyCertificate.invoiceKind }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">服务行业：</td>
                                    <td>${detailCompanyCertificate.serviceIndustry }</td>
								</tr> -->
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">业务种类：</td>
									<td>${detailCompanyCertificate.businessKind }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">联系人：</td>
									<td>${detailCompanyCertificate.companyContact }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">手机号：</td>
									<td>${detailCompanyCertificate.phone }</td>
								</tr>
								<!-- <tr>
									<td height="40" class="td_mgmt_right3_td1b">公司基本情况：</td>
									<td>
                                    	${detailCompanyCertificate.basicSituation }
                                    </td>
								</tr>		 -->						<tr>
									<td height="40" class="td_mgmt_right3_td1b">相关资质材料：</td>
									<td><a href="downloadcompanycertificatematerial?id=${detailCompanyCertificate.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a></td>
								</tr>
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
								</tr>
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
</html>
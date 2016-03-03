<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户验证</title>
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
	<a href="allcomplaint" hidefocus="true" class="a_text_main_title1">后台管理</a>&nbsp;&gt;&nbsp;客户服务
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top">
                <div id="main_frame_left">
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();">客户服务</span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();">客户服务</span>
                    <div id="mgmt_nav1">
                        <a href="allcomplaint" class="a_mgmt_leftnav" hidefocus="true">投诉管理</a>
                        <a href="authentic" class="a_mgmt_leftnav1" hidefocus="true">用户验证</a>
                    </div>
                    <!-- <hr class="hr_2" />
                    <span class="text_mgmt_leftnav1"><span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();"></span><span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();"></span>平台运营</span>
                    <div id="mgmt_nav2">
                        <a href="mgmt_m_pricetemplate.htm" class="a_mgmt_leftnav" hidefocus="true">报价模板信息</a>
                        <a href="mgmt_m_carmonitor.htm" class="a_mgmt_leftnav" hidefocus="true">车辆监控</a>
                    </div> -->
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
            	<form action="authenUserPass" method="post" id="authen_user">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
						<td class="td_mgmt_right3_td1a"> 
							<br /> 
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">用户名：</td>
									<td>${userinfo.username }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">姓名：</td>
									<td>${clientinfo.realName }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">性别：</td>
									<td>${clientinfo.sex }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">身份证号码：</td>
									<td>${clientinfo.idcard }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">联系电话：</td>
									<td>${clientinfo.phone }</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">身份证扫描件：</td>
									<td><a href="downloaduseridpicture?id=${clientinfo.id }" hidefocus="true"><img src="images/btn_filetype2.png" /></a></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">反馈：</td>
									<td>
                                    	<textarea class="textarea_rating" name="feedback" id="feedb1" placeholder="请输入内容..."></textarea>
                                    </td>
                                    <td>
                                		<!--     隐藏字段 -->
                                    <input type="hidden" name="user_id" value="${clientinfo.id }"/>
                                    </td>
								</tr>
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
									<td><input type="submit" id="btn1" value="通过" class="btn_mgmt1" 
									hidefocus="true"  />
									    <input type="submit" id="btn1" value="拒绝" class="btn_mgmt2"
									     hidefocus="true" onclick="changeAction()"/></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				</form>
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
	
	//修改action
	function changeAction(){
		
		var url="authenUserDeny";
		var form =$("#authen_user");
		form.attr("action", url);
		form.submit();
	}
	
</script>
</html>
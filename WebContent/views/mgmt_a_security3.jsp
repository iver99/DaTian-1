<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String ctxPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>安全设置</title>
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
	<a href="myinfo" hidefocus="true" class="a_text_main_title1">我的信息</a>&nbsp;&gt;&nbsp;我的帐户
	<form id="removephone" action="gotochangephone" method="post">
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
                        <a href="getTransportAccuracyPage" class="a_mgmt_leftnav" hidefocus="true">运营指标</a>
                        <a href="getFinancialInfoPage" class="a_mgmt_leftnav" hidefocus="true">财务指标</a>
                    </div>
                    <hr class="hr_2" />
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" >
                        <a href="accountinfo" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属账户</a>
                      <% } %>    <!-- 企业用户 -->
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav1" hidefocus="true">安全设置</a>
                    </div>
                </div>
			</td>
            <td class="td_leftnav_top">
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
					<tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">解除已绑定手机号</span>
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
									<td width="120" height="40" class="td_mgmt_right3_td1b">原手机号：</td>
									<td><input type="text" id="phonehide" class="input_mgmt1" style="width:176px;" value="${phonehide} " readonly="readonly" /></td>
									<td><input type="hidden" id="phone" value="${phone}"/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">手机验证码：</td>
									<td>
                                        <input type="text" class="input_mgmt1" id="validationkey" name="validationkey" style="width:86px;" required />
                                        <input type="button" id="btn_t" value="获取验证码" onclick="doclick;" hidefocus="true" class="btn_register_t" />
                                        <input id="vcode" type="hidden"  class="btn_register_t" />
                                        <script type="text/javascript">
                                        var wait=60;
                    					var time=function time(t) {
                    						if (wait == 0) {
                								t.removeAttribute("disabled");            
                								t.value="获取验证码";
                								wait = 60;
                							}
                							else {
                								t.setAttribute("disabled", true);
                								t.style.color="#999";
                								t.style.cursor="default";
                								t.value="重新发送(" + wait + ")";
                								wait--;
                								setTimeout(function(){
                									time(t)
                								},
                								1000)
                							}
                						}	
                    					//send sms
                    					var sms=function sendSms(){
                    						var phone=$("#phone").val();
                    						var smsContent=$("#smsContent").val();
                    						var url="<%=ctxPath %>/sendVcodeToPcAjax";
                    						$.ajax({
                    							url:url,
                    							data:{
                    								phone:phone,
                    								smsContent:smsContent
                    							},
                    							type:"post",
                    							success:function(data,status){
                    								$("#vcode").val(data);
                                					alert($("#vcode").val());
                    							}
                    						});
                    					}
                    					
                    					var doclick=function(){
                    						time;
                    						sms;
                    					}
                    					document.getElementById("btn_t").onclick=function(){sms(this);time(this);}
                                        </script>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
									<td><input type="button" id="btn2" value="下一步" class="btn_mgmt1" hidefocus="true" onclick="validationCheck();" /><input type="button"  id="reset" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
    </table>
    </form>
</div>

<%@ include  file="popup1.jsp"%>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		Reset();
		formValidate();
	}
</script>
<script type="text/javascript">
	function formValidate(){
		$("#removephone").validate({
			rules : {
				validationkey : {
					required : true,
					number : true
				},
			}
		});
	}
	function Reset(){
			$("#reset").click(function(){
			   $("#validationkey").val("");
			});
	}
	function validationCheck(){
		 var validationkey=$("#validationkey").val();
	 	 var vcode=$("#vcode").val();
	 	 var url="vcodecheckAjax";
	 	 if(vcode==null||vcode==""){
	 		 alert("请获取验证码");
	 	 }
	 	 else{
	 		$.ajax({
				type : "GET",
				url : url,
				data:{
					validationkey:validationkey
				},
				success : function(msg) {
					if (msg) {
						$("#removephone").submit();
					} else {
						alert("验证码错误，请重新输入");
					}
				}
			});
	 	 }
	} 
</script>
</html>
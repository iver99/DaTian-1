<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String ctxPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<title>短信测试页面</title>
</head>
<body>
<h1>短信测试接口</h1>
<!-- <h3>step1：注册序列号</h3>
<button onclick="regSN();">注册SN</button>
<h3>step2：注册企业信息</h3>
<button onclick="regEnterpriseInfo();">注册企业信息</button>
<h3>step3：发送短信</h3> -->
<form  method="POST">
	手机号<input type="text" name="phone" id="phone"/>
	<br/>
	短信内容<input type="text" name="smsContent" id="smsContent"/>
	<br/>
	<input type="button" onclick="sendSms();" value="发送"/>
</form>
<h3>【注意】</h3>
短信内容不要出现“测试”，“移动”，“联通”，“电信”以及其它敏感词汇<br/>
<h1 id="balance"></h1>
<br/><br/>
<h2>【安卓】端短信接口url：http://123.56.143.59:8585/DaTian/sendVcodeToPhoneAjax?phone=15000000000</h2>
<h2><a href="<%=ctxPath %>/views/smsLog.jsp">短信日志</a></h2>
</body>
<script type="text/javascript"> 
	$(function() {
		getSMSBalance();
	});
	//注册sn
	function regSN(){
		var url="<%=ctxPath %>/regSerialSnAjax";
		$.ajax({
			url:url,
			type:"get",
			success:function(data,status){
				alert(data);
			}
		});
	}
	//注册企业信息
	function regEnterpriseInfo(){
		var url="<%=ctxPath %>/regEnterpriseInfoAjax";
		$.ajax({
			url:url,
			type:"get",
			success:function(data,status){
				alert(data);
			}
		});
	}
	//send sms
	function sendSms(){
		var phone=$("#phone").val();
		var smsContent=$("#smsContent").val();
		var url="<%=ctxPath %>/sendSMSAjax";
		$.ajax({
			url:url,
			data:{
				phone:phone,
				smsContent:smsContent
			},
			type:"post",
			success:function(data,status){
				alert(data);
			}
		});
	}
	
	//短信余额
	function getSMSBalance(){
		var url="<%=ctxPath %>/getSMSBalanceAjax";
		$.ajax({
			url:url,
			type:"get",
			success:function(data,status){
				$("#balance").html("短信余额："+data);
			}
		});
	}
</script>
</html>
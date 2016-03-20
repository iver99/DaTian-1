<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String ctxPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户注册</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no" />
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css" />
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
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

<div class="div_register_title_frame">
    <div class="div_register_title">加入我们</div>
</div>
<div id="login_main_frame">
    <div class="div_register_content1">
    	欢迎您的访问，填写基本信息后即可成为会员！
    </div>
    <form id="register_form" action="register" method="post">
    <table border="0" cellspacing="0" cellpadding="0" class="table_register1">
        <tr>
            <td width="120" height="40" class="td_mgmt_right3_td1b">用户名：</td>
            <td><input type="text" class="input_mgmt1" style="width:300px;" name="username" id="username"/>&nbsp;&nbsp;<a href="javascript:;" hidefocus="true" onclick="loadXMLDoc(0)">检查用户名</a></td>
        </tr>
        <tr>
        	<td width="120" height="40" class="td_mgmt_right3_td1b">用户类型：</td>
        	<td><input type="radio" name="userkind" value="2" checked="checked"/>&nbsp;个人用户&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        		<input type="radio" name="userkind" value="3"/>企业用户
        </tr>
        <tr>
            <td height="40" class="td_mgmt_right3_td1b">手机验证码：</td>
            <td>
            	<input type="text" class="input_mgmt1" style="width:150px;" placeholder="填写本人手机号码" name="phone" id="phone" required="true"/>
                <input type="text" id="validationkey" class="input_mgmt1" style="width:48px;" name="validationkey" required/>
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
								setTimeout(function() {
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
								alert(data);
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
            <td height="40" class="td_mgmt_right3_td1b">密码：</td>
            <td><input type="password" class="input_mgmt1" style="width:300px;" name="password" id="password" required/></td>
        </tr>
        <tr>
            <td height="40" class="td_mgmt_right3_td1b">确认密码：</td>
            <td><input type="password" class="input_mgmt1" style="width:300px;" name="passwordRepeat" id="passwordRepeat"  required/></td>
        	<td vertical-align="middle"><div vertical-align="middle" id="passwordfail"></div></td>
        </tr>
    </table>
    <div class="div_register_content1a"></div>
    <table border="0" cellspacing="0" cellpadding="0" class="table_register1">
        <tr>
            <td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
            <td><input name="" type="checkbox" value="" required/>&nbsp;<a href="javascript:;" hidefocus="true" target="_blank">我同意并遵守《平台服务协议》</a></td>
        </tr>
        <tr>
            <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
            <td>
                <input type="button" id="btn2" value="注册" class="btn_register_submit" hidefocus="true" onclick="loadXMLDoc(1)" />
                <input type="button" id="btn2" value="取消" class="btn_register_cancel" hidefocus="true" />
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
		formValidate();//表单验证
		
	}
</script>
<script type="text/javascript">

function formValidate() {
	$("#register_form").validate({
		rules : {
			username : {
				required : true,
			},
			phone : {
				required : true,
				number : true
			},
			validationkey : {
				required : true,
				number : true
			},
			password : {
				required : true,
			},
			passwordRepeat : {
				required : true,
				equalTo:'#password'
			},
		}
	});
}

function loadXMLDoc(flag)
{
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/usercheck",//请求的后台地址
		   data: "username=" + document.getElementById("username").value,//前台传给后台的参数
		   success: function(msg){//msg:返回值
			   if(flag ==0 && msg == "true"){
				   alert("该用户名可以使用");
			   }else if(msg == "null"){
				   alert("用户名不能为空");  
			   }else if(msg == "false"){
				   alert("该用户名已被使用！");
			   }
			   if(flag == 1 && msg == "true"){
				   
				   var validationkey=$("#validationkey").val();
				   var vcode=$("#vcode").val();
				   
				   if(validationkey==vcode){ 
					
					$("#register_form").submit();
					
				   }
				    else{
					   alert("验证码错误，请重新输入");
				   } 
			   }
		   }   
		});
}




</script>
</html>
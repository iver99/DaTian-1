<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我收到的意向</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/dynamic_div2.js"></script>
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
            	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                    	<td>
                        	<span class="span_mgmt_right2_text1">我收到的意向</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                            <br />
                            <form action="acceptOrder?orderid=${orderId }" method="post" id="accept_order">
                            
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">受理：</td>
                                    <td>
                                    <input type="hidden" value="${carNums }" id="carNumsString" >
                                    	<select class="input_mgmt2a" name="carNum1" id="carNum1" required="true">
											<option value="" selected="selected">选择车牌号</option>
											<c:forEach var="car" items="${carNumList }">
											   <option value="${car.carNum }">${car.carNum }</option>
											</c:forEach>
                                        </select>
                                        <span class="span_mgmt_dynamic1">--</span>
                                        <input type="hidden" value="${drivers }" id="driversString" >
                                        <select class="input_mgmt2a" name="driver1" id="driver1" required="true">
											<option value="" selected="selected">选择随车司机</option>
                                            <c:forEach var="driver" items="${driverList }">
											   <option value="${driver.driverName }">${driver.driverName }</option>
											</c:forEach>
                                        </select>

                                        <span class="span_mgmt_dynamic1">--</span>
                                        <input type="text" class="input_mgmt2" placeholder="请输入运单号" required="true"/>
                                        <img src="images/btn_add2.png" hidefocus="true" style="cursor:pointer;" title="添加" onclick="additem();" />
                                    </td>
                                </tr>
                                <tr>
                                    <td height="1"></td>
                                    <td><div id="dym_itemlist"></div></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td>
                                        <input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                        <input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" />
                                    </td>
                                </tr>
                            </table>
                            </form>
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
		//表单验证
		formValidate();
	}
	//验证表单
	function formValidate(){
		$("#accept_order").validate({
			rules : {
				carNum : {required: true},
				driver : {required: true},
			}
		});
	}
	$(function(){
		$('reset:button').click(function(){
		   $('.select').val("");
		});
    })
</script>
</html>
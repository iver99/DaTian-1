<%@ include  file="popup1.jsp"%><%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>国内空运资源信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
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
               <div id="main_frame_left" >
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
                    <span id="mgmt_nav_switch2a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch2a();">我的资源</span>
                    <span id="mgmt_nav_switch2b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch2b();">我的资源</span>
                    <div id="mgmt_nav2" >
                     <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="fulltruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">整车资源信息</a>
                        <a href="lesstruckload?flag=1" class="a_mgmt_leftnav" hidefocus="true">零担资源信息</a>
                        <a href="cityline?flag=1" class="a_mgmt_leftnav" hidefocus="true">落地配资源信息</a>
                        <a href="car?flag=1" class="a_mgmt_leftnav" hidefocus="true">车辆资源信息</a>
                        <a href="warehouse?flag=1" class="a_mgmt_leftnav" hidefocus="true">仓库资源信息</a>
                        <a href="airline?flag=1" class="a_mgmt_leftnav1" hidefocus="true">国内空运资源信息</a>
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
                    <span id="mgmt_nav_switch5a" class="span_mgmt_nav1a" title="收起" onclick="mgmt_nav_switch5a();">我的帐户</span>
                    <span id="mgmt_nav_switch5b" class="span_mgmt_nav2a" title="展开" onclick="mgmt_nav_switch5b();">我的帐户</span>
                    <div id="mgmt_nav5" class="div_mgmt_show1">
                        <a href="accountinfo" class="a_mgmt_leftnav" hidefocus="true">帐户信息</a>
                      <% if((Integer)session.getAttribute("userKind") ==3) {%>
                        <a href="getsubaccount" class="a_mgmt_leftnav" hidefocus="true">附属账户</a>
                      <% } %>    <!-- 企业用户 -->
                        <a href="getaddress" class="a_mgmt_leftnav" hidefocus="true">常用地址</a>
                        <a href="mysecurity" class="a_mgmt_leftnav" hidefocus="true">安全设置</a>
                    </div>
</div>
			</td>
			<td class="td_leftnav_top">
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right2a">
                    <tr>
                        <td>
                            <span class="span_mgmt_right2_text1">更新国内空运资源信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />
                            <%-- <c var="goodsdetail" items="${linetransportInfo }"> --%>
				
                            <form action="updateairline?id=${airlineInfo.id }" method="post" enctype="multipart/form-data">	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">始发港：</td>
                                    <td id="cityselector"><input id="city1" type="text" value="${airlineInfo.startCity }"  name="startCity" class="input_city1" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">到达港：</td>
                                    <td id="cityselector"><input id="city2" type="text" value="${airlineInfo.endCity }" name="endCity" class="input_city1" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">抵运时间：</td>
                                    <td>
                                        <select id="onwayTime" name="onwayTime" style="width:120px;" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="12小时">12小时</option>
                                            <option value="24小时">24小时</option>
                                            <option value="48小时">48小时</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">航班周期：</td>
                                    <td>
                                      <input type="checkbox" name="airCycle" value="一" />星期一&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="二" />星期二&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="三" />星期三&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="四" />星期四&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="五" />星期五&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="六" />星期六&nbsp;&nbsp;&nbsp;&nbsp;
									  <input type="checkbox" name="airCycle" value="日" />星期日&nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">增值服务：</td>
                                    <td>
                                        <c:if test="${airlineInfo.extraService=='没有' }">
                                        <select id="valueadd" style="width:120px;" onchange="change1();">
                                            <option value="" >请选择</option>
                                            <option value="有">有</option>
                                            <option value="无" selected="selected">无</option>
                                        </select>
                                        <div id="v_detail" style="display:none;">
                                            <input type="text" name="extraService" class="input_mgmt1" style="width:176px;" placeholder="请输入内容..." />
                                        </div>
                                     </c:if>
                                     <c:if test="${airlineInfo.extraService!='没有' }">
                                        <select id="valueadd" style="width:120px;" onchange="change1();">
                                            <option value="" >请选择</option>
                                            <option value="有" selected="selected">有</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="v_detail" style="display:inline;">
                                            <input type="text" name="extraService" class="input_mgmt1" style="width:176px;" value="${airlineInfo.extraService }" />
                                        </div>
                                     </c:if>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">M：</td>
                                    <td><input type="text" name="price1" id="price1" value="${airlineInfo.price1 }" class="input_mgmt1" style="width:112px;" required/>
                                    (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">N：</td>
                                    <td><input type="text" name="price2" id="price2" value="${airlineInfo.price2 }" class="input_mgmt1" style="width:112px;" required/>
                                    (元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+100：</td>
                                    <td><input type="text" name="price3" id="price3" value="${airlineInfo.price3 }" class="input_mgmt1" style="width:112px;" required/>
                                    (元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+300：</td>
                                    <td><input type="text" name="price4" id="price4" value="${airlineInfo.price4 }" class="input_mgmt1" style="width:112px;" required/>
                                    (元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+500：</td>
                                    <td><input type="text" name="price5" id="price5" value="${airlineInfo.price5 }" class="input_mgmt1" style="width:112px;" required/>
                                    (元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">提货费：</td>
                                    <td><input type="text" name="pickFee" id="pickFee" value="${airlineInfo.pickFee }" class="input_mgmt1" style="width:112px;" required/>
                                    (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">送货费：</td>
                                    <td><input type="text" name="deliveryFee" id="deliveryFee" value="${airlineInfo.deliveryFee }" class="input_mgmt1" style="width:112px;" required/>
                                    (元)</td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">图片展示：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="${airlineInfo.picture }" />
                                        	<input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
     									    <input id="upload_btn4" type="file"  name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0];fileChange(/[^\\]+\.\w+$/.exec(this.value)[0]);" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" accept="image/*" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" id="remarks" name="remarks" placeholder="请输入内容..." >${airlineInfo.remarks }</textarea>
                                    </td>
								</tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                    <input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
                                </tr>
                            </table>
							</form>
							</c>
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
		//设置页面字段值（checkbox）
		setData();
	}
	function setData(){
		var airCycle = "${airlineInfo.airCycle}";
		$("#onwayTime").attr("value","${airlineInfo.onwayTime}");
		$('input:checkbox').each(function() {
			var value = $(this).val();
			if(airCycle.indexOf(value)>=0){
				$(this).attr('checked', true);
			}
		});
	}
</script>
</html>
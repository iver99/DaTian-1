<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript" src="js/calendar.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/citylist.js"></script>
<script type="text/javascript" src="js/cityquery.js"></script>
<script type="text/javascript" src="js/dynamic_div1.js"></script>
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
                        <a href="car?flag=1" class="a_mgmt_leftnav1" hidefocus="true">车辆资源信息</a>
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
                            <span class="span_mgmt_right2_text1">更新车辆信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />   
                              <form action="updateCar?id=${carInfo.id }" method="post">	   
                                     
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">牌照号码：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${carInfo.carNum }" readonly="readonly" name="carNum"/></td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">所属车队：</td>
                                    <td>
                                        <select style="width:120px;" name="carTeam" id="carTeam" required>
                                            <option value="" selected="selected">请选择</option>
                                           <!--  <option value="北京车队" >北京车队</option>
                                            <option value="天津车队">天津车队</option>
                                            <option value="上海车队">上海车队</option> -->
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">定位方式：</td>
                                    <td>
                                    	<select id="locationType" style="width:120px;" onchange="change_position();" name="locationType" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="GPS" >GPS</option>
                                            <option value="手机">手机</option>
                                            <option value="无">无</option>
                                        </select>
                                        <div id="pos_detail_1" style="display:none;">
                                            <input type="text" class="input_mgmt1" style="width:176px;" value="${carInfo.terminalId }" placeholder="请输入终端设备编码..." name="terminalId"/>
                                        </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">车型：</td>
                                   	<td>
                                        <select style="width:120px;" name="carType" id="carType" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="前四后四" >前四后四</option>
                                            <option value="单桥">单桥</option>
                                            <option value="其他">其他</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">厢型：</td>
                                    <td>
                                    	<select style="width:120px;" name="carBase" id="carBase" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通" >普通</option>
                                            <option value="平板">平板</option>
                                            <option value="厢式">厢式</option>
                                            <option value="开顶厢">开顶厢</option>
                                            <option value="集装厢">集装厢</option>
                                            <option value="高栏">高栏</option>
                                            <option value="其他结构">其他结构</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">品牌：</td>
                                    <td>
                                    <select class="select_apply1" style="width:120px;" id="carBrand" name="carBrand" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="解放">解放</option>
                                            <option value="福田" >福田</option>
                                            <option value="东风">东风</option>
                                    </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">用途：</td>
                                    <td>
                                     	<select style="width:120px;" name="carUse" id="carUse" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="普通运输" >普通运输</option>
                                            <option value="特殊">特殊</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">规格：</td>
                                    <td>
                                    长&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" value="${carInfo.carLength }" name="carLength" required/>
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;宽&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" value="${carInfo.carWidth }" name="carWidth" required/>
                                    (米)&nbsp;&nbsp;×&nbsp;&nbsp;高&nbsp;<input type="text" class="input_mgmt1" style="width:46px;" value="${carInfo.carHeight }" name="carHeight" required/>
                                    (米)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">载重：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${carInfo.carWeight }" name="carWeight" required/>
                                    (吨)
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">购置日期：</td>
                                    <td><input type="text" class="input_date1" title="点击此处选择" onclick="SelectDate(this,'yyyy-MM-dd')" value="${carInfo.purchaseTime }" readonly="readonly" name="carPurTime" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">冷藏：</td>
                                    <td>
                                    	<select style="width:120px;" name="storage" id="storage" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="冷藏" >是</option>
                                            <option value="非冷藏">否</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">司机姓名：</td>
                                    <td>
                                        <select style="width:120px;" name="driverId" required>
                                            <option value="" selected="selected">请选择</option>
                                            <d:forEach var="driverList" items="${driverList }">
                                            <option value="${driverList.id }">${driverList.driverName }</option>
                                            </d:forEach>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运营线路：</td>
                                    <td id="cityselector">
                                    <div>
                                        <input id="city1" type="text" value="${carInfo.startPlace }" class="input_city1" name="startPlace" required/>
                                        &nbsp;&nbsp;至&nbsp;&nbsp;
                                        <input id="city2" type="text" value="${carInfo.endPlace }" class="input_city1" name="endPlace" required/>
                                    </div>
                                    </td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">经停城市：</td>
                                    <td><input type="text" class="input_mgmt1" style="width:300px;" value="${carInfo.stopPlace }" name="stopPlace" required/>
                                </tr>
                                <tr>
                                    <td height="1"></td>
                                    <td><div id="dym_citylist"></div></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
                                    <td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
                                   <!--  <input type="reset" id="btn1" value="重填" class="btn_mgmt2" hidefocus="true" /> -->
                                    </td>
                                </tr>
                            </table>
                            </c>
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
		//获取公司车队列表
		getCompanyCarteamList();
		
		//设置数据
		setData();
		//$("#locationType").attr('value','GPS');
	}
	//设置数据
	function setData(){
		//alert("${carInfo.startPlace}");
		$("#locationType").attr("value","${carInfo.locationType}");
		$("#carBase").attr("value","${carInfo.carBase}");
		$("#carUse").attr("value","${carInfo.carUse}");
		$("#carType").attr("value","${carInfo.carType}");
		$("#carBrand").attr("value","${carInfo.carBrand}");
		$("#storage").attr("value","${carInfo.storage}");
		
	}
	
	 //获取公司车队列表
	function getCompanyCarteamList(){
		var url="getCompanyCarteamList";
		
		$.ajax({
			url:url,
			cache:false,
			dataType:"json",
			success:function(data,status){
				//alert(data);
				var carteam=$("#carTeam");
				for(var i=0;i<data.length;i++){
					var option=$("<option>").text(data[i].teamName).val(data[i].teamName);
					carteam.append(option);
				}
			}
		});
	}
</script>
</html>
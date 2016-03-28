<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<!-- <script type="text/javascript" src="js/rating2.js"></script> -->
<script type="text/javascript" src="js/jquery.raty.js"></script>
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
                    <span id="mgmt_nav_switch1a" class="span_mgmt_nav1" title="收起" onclick="mgmt_nav_switch1a();">我的交易</span>
                    <span id="mgmt_nav_switch1b" class="span_mgmt_nav2" title="展开" onclick="mgmt_nav_switch1b();">我的交易</span>
                    <div id="mgmt_nav1">
                        <a href="getallfocus" class="a_mgmt_leftnav" hidefocus="true">我的关注</a>
                         <% if((Integer)session.getAttribute("userKind") ==2) {%>
                         	<a href="sendorderinfo" class="a_mgmt_leftnav" hidefocus="true">我提交的意向</a>
                         <% } %>    <!-- 个人用户 -->
                         <% if((Integer)session.getAttribute("userKind") ==3) {%>
                            <a href="recieveorderinfo" class="a_mgmt_leftnav1" hidefocus="true">我收到的意向</a>
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
                        	<span class="span_mgmt_right2_text1">我收到的意向</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                    <tr>
                        <td class="td_mgmt_right3_td1a">
                        <div class="span_mgmt_right3_text4">物流信息</div>
                        	<c:forEach var="carNum" items="${carNums }">
                                <c:if test="${length!=0 }">
                                     <div class="span_mgmt_right3_text4"></div>
                                </c:if>
                                <c:forEach var="track" items="${loc }">
                                    <c:if test="${carNum==track.carNum }">
                                     <table width="90%" border="0" cellspacing="0" cellpadding="0" style="clear:both; margin-left:24px;">
                                        <c:if test="${track.event=='已接受任务' }">
                                           <tr>
                                               <td width="120" height="35" class="td_mgmt_right3_td1b">${track.time }</td>
                                               <td>${track.event }，车牌号：${track.carNum }<img src="images/btn_map3a.png" alt="GPS定位" /></td>
                                           </tr>
                                        </c:if>
                                        <c:if test="${track.event=='已取件' }">
                                           <tr>
                                               <td width="120" height="35" class="td_mgmt_right3_td1b">${track.time }</td>
                                               <td>${track.event }</td>
                                           </tr>
                                        </c:if>
                                        <c:if test="${track.event=='运输中' }">
                                           <tr>
                                               <td width="120" height="35" class="td_mgmt_right3_td1b">${track.time }</td>
                                               <td>货物已经达到${track.address }</td>
                                           </tr>
                                        </c:if>
                                        <c:if test="${track.event=='已签收' }">
                                           <tr>
                                               <td width="120" height="35" class="td_mgmt_right3_td1b">${track.time }</td>
                                               <td>货物${track.event }</td>
                                           </tr>
                                        </c:if>
                                     </table>
                                   </c:if>
                               </c:forEach>
                            </c:forEach>
                        	<div class="span_mgmt_right3_text4">基本信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">意向编号：</td>
                                    <td>${orderInfo.orderNum }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">承运方：</td>
                                    <td>${orderInfo.carrierName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源分类：</td>
									<td>${orderInfo.resourceType }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">资源名称：</td>
									<td>${orderInfo.resourceName }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">货物信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">货物名称：</td>
                                    <td>${orderInfo.goodsName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物重量：</td>
                                    <td>${orderInfo.goodsWeight } (公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物体积：</td>
                                    <td>${orderInfo.goodsVolume } (立方米)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">货物声明价值：</td>
                                    <td>${orderInfo.declaredPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">保险费：</td>
                                    <td>${orderInfo.insurance } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">地址信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">发货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td width="250">&nbsp;</td>
                                    <td width="100" class="td_mgmt_right3_td1b">收货人信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
                                    <td>&nbsp;</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.deliveryName }</td>
                                    <td class="td_mgmt_right3_td1b">姓名：</td>
                                    <td>${orderInfo.recieverName }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.deliveryAddr }</td>
                                    <td class="td_mgmt_right3_td1b">地址：</td>
                                    <td>${orderInfo.recieverAddr }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.deliveryPhone }</td>
                                    <td class="td_mgmt_right3_td1b">电话：</td>
                                    <td>${orderInfo.recieverPhone }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">备注信息</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">备注：</td>
                                    <td>${orderInfo.remarks }</td>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">签收图像</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                <c:forEach var="waybill" items="${waybills }">
                                    <td><a href="downloadwaybillpicture?id=${waybill.id }" hidefocus="true">
                                             <img src="images/btn_filetype1.png" />
                                        </a>
                                    </td>
                                </c:forEach>
                                </tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">最终运费</div>      	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">  
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">意向运费：</td>
                                    <td>${orderInfo.expectedPrice } (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">最终运费：</td>
                                    <td>${orderInfo.actualPrice } (元)</td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">说明：</td>
									<td>${orderInfo.explainReason }</td>
								</tr>
                            </table>
                        	<div class="span_mgmt_right3_text4">评价信息</div>      	          
                            <div id="div_rating">
                                  <div class="div_rating_sub">
                               		 <div class="div_rating_left1">服务态度</div>
                       			     <div id="rating1" class="div_rating_right1" data-score="0"></div>
                                	 <input type="hidden" value="" id="rate1"/> </br>
                                  </div>
                                  <div class="div_rating_sub">
                                     <div class="div_rating_left1">运输时效</div>
                                	 <div id="rating2" class="div_rating_right1"	data-score="0"></div>
                                	 <input type="hidden" value="" id="rate2"/> </br>
                                  </div>
                                  <div class="div_rating_sub">
                                     <div class="div_rating_left1">货物安全</div>
                                	 <div id="rating3" class="div_rating_right1" data-score="0"></div>
                                	 <input type="hidden" value="" id="rate3"/> </br>
                                  </div>  
                                <div class="div_rating_sub">
                                	补充：${comment.comment }
                                </div>
                            </div>
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
		
		//set comment star
		setStar();
	}
	//加载评论星形效果
	function setStar(){
		//var serviceAttitude="${comment.serviceAttitude}";
		var serviceAttitude="${avgComment.serviceAttitude}";
		var transportEfficiency="${avgComment.transportEfficiency}";
		var cargoSafety="${avgComment.cargoSafety}";
		var totalMoney="${avgComment.totalMoney}";
		 if(serviceAttitude == '很好'){
			  $("#rating1").attr("data-score","5");
		}else if(serviceAttitude =='好'){
			 $("#rating1").attr("data-score","4");
		}else if(serviceAttitude == '一般'){
			 $("#rating1").attr("data-score","3");
		}else if(serviceAttitude =='差'){
			 $("#rating1").attr("data-score","2");
		}else{
			 $("#rating1").attr("data-score","1");
		}  
		//rating1();
		//$('#rating1').attr('data-score',3);
		if(transportEfficiency == '很好'){
			 $("#rating2").attr("data-score","5");
		}else if(transportEfficiency =='好'){
			 $("#rating2").attr("data-score","4");
		}else if(transportEfficiency == '一般'){
			 $("#rating2").attr("data-score","3");
		}else if(transportEfficiency =='差'){
			 $("#rating2").attr("data-score","2");
		}else{
			 $("#rating2").attr("data-score","1");
		}
		//rating2();
		//评价三
		 if(cargoSafety == '很好'){
			 $("#rating3").attr("data-score","5");
		}else if(cargoSafety =='好'){
			$("#rating3").attr("data-score","4");
		}else if(cargoSafety == '一般'){
			$("#rating3").attr("data-score","3");
		}else if(cargoSafety =='差'){
			$("#rating3").attr("data-score","2");
		}else{
			$("#rating3").attr("data-score","1");
		}
		//rating3();
		//评价四
		if(totalMoney == '很好'){
			$("#rating4").attr("data-score","5");
		}else if(totalMoney =='好'){
			$("#rating4").attr("data-score","4");
		}else if(totalMoney == '一般'){
			$("#rating4").attr("data-score","3");
		}else if(totalMoney =='差'){
			$("#rating4").attr("data-score","2");
		}else{
			$("#rating4").attr("data-score","1");
		} 
		//rating4();
		$('#rating1').raty({
			half     : false,
			size     : 16,
			starOff  : 'images/star-off-small.png',
			starOn   : 'images/star-on-small.png',
			targetKeep: true,
			score: function() { 
			    return $("#rating1").attr('data-score');
			}
		  });
		  
		  $('#rating2').raty({
			half     : false,
			size     : 16,
			starOff  : 'images/star-off-small.png',
			starOn   : 'images/star-on-small.png',
			starHalf : 'images/star-half-small.png',
			targetKeep: true,
			score: function() {
			    return $("#rating2").attr('data-score');
			}
		  });
		  $('#rating3').raty({
			half     : false,
			size     : 16,
			starOff  : 'images/star-off-small.png',
			starOn   : 'images/star-on-small.png',
			starHalf : 'images/star-half-small.png',
			targetKeep: true,
			score: function() { 
			    return $("#rating3").attr('data-score');
			}
		  });
		  $('#rating4').raty({
			half     : false,
			size     : 16,
			starOff  : 'images/star-off-small.png',
			starOn   : 'images/star-on-small.png',
			targetKeep: true,
			score: function() { 
			    return $("#rating4").attr('data-score');
			}
		  });
		  $("#rating1").raty("readOnly",true);
		  $("#rating2").raty("readOnly",true);
		  $("#rating3").raty("readOnly",true);
		  $("#rating4").raty("readOnly",true);
	}
</script>
</html>
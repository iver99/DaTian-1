<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>国内资源详细信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/jquery.organictabs.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/backtop.js"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="js/focus_load.js"></script>
<!-- <script type="text/javascript" src="js/search_resource.js"></script>搜索资源
<script type="text/javascript" src="js/resource_select.js" charset="UTF-8"></script> -->
<script type="text/javascript" src="js/rating3.js"></script> 
<script type="text/javascript" src="js/jquery.raty.min.js"></script>
<!-- 引入工具js -->
<%@ include file="jsTool.jsp" %>
</head>

<body onload="OnLoad()">

<%@ include file="qq.jsp"%>

<%@ include  file="topFrame.jsp"%>
<div id="main_frame">
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;国内空运
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2a.jpg" /></td>
			<td class="td_detail_top">始发港：<span class="text_detail_title1">${airlineInfo.startCity }</span>
                <br />
                目的港：<span class="text_detail_title1">${airlineInfo.endCity }</span>
                <br />
                抵运时间：<span class="text_detail_title2">${airlineInfo.onwayTime }</span>
                <br />
                航班周期：<span class="text_detail_title2">${airlineInfo.airCycle }</span>
                <br />
                报价：<span class="text_detail_title2">M：${airlineInfo.price1 }元、N：${airlineInfo.price2 }元/公斤、+100：${airlineInfo.price3 }元/公斤、+300：${airlineInfo.price4 }元/公斤、+500：${airlineInfo.price5 }元/公斤</span>
                <br />
                提货费：<span class="text_detail_title2">${airlineInfo.pickFee }元/方</span>
                <br />
                送货费：<span class="text_detail_title2">${airlineInfo.deliveryFee }元</span>
                <br />
               增值服务：${airlineInfo.extraService }
               <br />
               发布日期：${airlineInfo.relDate }
               <br />
               所有者：${carrierInfo.companyName }
                <br />
                <hr class="hr_1" />
                <input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${airlineInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${airlineInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${airlineInfo.id }');hidefav(this);\" />" );
				</script>
                
                <%-- <input type="button" id="btn2" value="提交订单" class="input_detail2" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${linetransportInfo.carrierId}&flag=1&resourceId=${linetransportInfo.id}'" /> --%>
                <c:choose>
                     <c:when test="${sessionScope.username!=null }">
                         <input type="button" id="btn2" value="查看联系方式" class="input_detail2" hidefocus="true" onclick="showid('popup1');" />
                     </c:when>
                     <c:otherwise>
                         <input type="button" id="btn2" value="登陆后查看联系方式" class="input_detail2" hidefocus="true" onclick="window.location.href='login'" />
                     </c:otherwise>
                </c:choose>
            </td>
		</tr>
		</tbody>
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top"></td>
            <td class="td_leftnav_top">
                <div id="detail_tab">
                    <ul class="nav">
                        <li><a href="#item1" class="current" hidefocus="true">补充信息</a></li>
                        <li><a href="#item2" hidefocus="true">所有者信息</a></li>
                        <li><a href="#item3" hidefocus="true">评价记录</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            ${airlineInfo.remarks }
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li>公司名称：${carrierInfo.companyName }</li>
                            <li>公司性质：${carrierInfo.companyType }</li>
                            <li>注册日期：${carrierInfo.relDate }</li>
                            <li>服务行业：${carrierInfo.serviceIndustry }</li>
                            <li>业务种类：专线卡车</li>
                            <li>信用等级：${carrierInfo.creditRate	 }级</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                        	<div id="div_rating3">
                                <div class="div_rating_left1">综合：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;服务态度</div>
                                	<div id="rating1" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate1"/>
                                <div class="div_rating_left1">运输时效</div>
                                	<div id="rating2" class="div_rating_right1"	data-score="0"></div>
                                	<input type="hidden" value="" id="rate2"/>
                                <div class="div_rating_left1">货物安全</div>
                                	<div id="rating3" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate3"/>
                                <div class="div_rating_left1">总体费用</div>
                                	<div id="rating4" class="div_rating_right1" data-score="0"></div>
                                	<input type="hidden" value="" id="rate4"/>
                            </div>
                            <br />
                        	<c:forEach var="comment" items="${commentList }">
                            <li class="item2a">${comment.comment }------------------ ${comment.relDate }</li>
                            </c:forEach>
                        </ul>
                    </div>
				</div>
			</td>
		</tr>
    </table>
</div>

<%-- <%@ include  file="popup2.jsp"%> --%>
<div id="popup1" class="popup" style="display:none;">
    <table border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td width="510"><div class="div_popup_title1">联系方式</div></td>
            <td>
                <div style="cursor:pointer;" onclick="hideid('popup1');">
                    <img src="images/btn_cancel1.png" title="关闭本窗口" />
                </div>
            </td>
        </tr>
    </table>
    <table width="540" border="0" cellspacing="0" cellpadding="0" style="border-top:1px solid #ddd;">
        <tr>
            <td width="120" height="50" class="td_mgmt_right3_td1b_1">联系人姓名：</td>
            <td class="td_mgmt_right3_td1b_2">${carrierInfo.companyContact }</td>
        </tr>
        <tr>
            <td height="50" class="td_mgmt_right3_td1b_1">手机号：</td>
            <td class="td_mgmt_right3_td1b_2">${carrierInfo.phone }</td>
        </tr>
    </table>
    <table width="540" border="0" cellpadding="0" cellspacing="0">
        <tr>
            <td height="100" align="center">
                <input type="button" id="btn2" value="提交意向" class="input_detail2a" hidefocus="true" onclick="window.location.href='getneworderform?carrierid=${airlineInfo.carrierId}&flag=6&resourceId=${airlineInfo.id}'" />
            </td>
        </tr>
    </table>
</div>

<div id="footer_frame">
	<iframe allowtransparency="true" width="100%" frameborder="0" hspace="0" marginheight="0" marginwidth="0" scrolling="no" vspace="0" src="footer.jsp"></iframe>
</div>

</body>
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
		//加载评论星形效果
		setStar();
	}
</script>
<script type="text/javascript">
function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate(); 
} 
function loadXMLDoc(id){
	var curWwwPath=window.document.location.href;
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
	$.ajax({
		   type: "GET",
		   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
		   data: "type=airline&id=" + id,//前台传给后台的参数
		   cache:false,
		   success: function(msg){//msg:返回值
			   if(msg == "login"){
				   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
			   }
			   loadFocus();
		   }
		});
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
	
}
</script>
</html>
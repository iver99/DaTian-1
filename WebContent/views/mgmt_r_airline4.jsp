<%@ page language="java" contentType="text/html; charset=utf-8"
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
                            <span class="span_mgmt_right2_text1">查看国内空运资源信息</span>
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
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">始发港：</td>
                                    <td>${airlineInfo.startCity }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">到达港：</td>
                                    <td>${airlineInfo.endCity }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">抵运时间：</td>
                                    <td>${airlineInfo.onwayTime }</td>
                                </tr> 
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">航班周期：</td>
                                    <td>${airlineInfo.airCycle }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">增值服务：</td>
                                    <td>${airlineInfo.extraService }</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">M：</td>
                                    <td>${airlineInfo.price1 }(元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">N：</td>
                                    <td>${airlineInfo.price2 }(元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+100：</td>
                                    <td>${airlineInfo.price3 }(元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+300：</td>
                                    <td>${airlineInfo.price4 }(元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">+500：</td>
                                    <td>${airlineInfo.price5 }(元/公斤)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">提货费：</td>
                                    <td>${airlineInfo.pickFee }(元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">送货费：</td>
                                    <td>${airlineInfo.deliveryFee }(元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">详细报价：</td>
                                    <td><a href="downloadairlinedetailprice?id=${airlineInfo.id }" hidefocus="true"><img src="images/btn_filetype1.png" /></a></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
                                    <td>${airlineInfo.remarks }</td>
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
<script type="text/javascript">
	function OnLoad() {
		loadFocus();
	}
</script>
</html>
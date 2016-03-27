<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>货物详细信息</title>
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
<!-- <script type="text/javascript" src="js/search_resource.js"></script>搜索资源 -->
<!-- 引入工具js -->
<%@ include file="jsTool.jsp" %>
</head>

<body onload="OnLoad()">
<%@ include file="qq.jsp"%>
<%@ include file="topFrame.jsp"%>
<div id="main_frame">
	<span class="text_main_title1">资源</span>&nbsp;&gt;&nbsp;货物
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tbody>
    		<tr>
			<td width="320" class="td_leftnav_top"><img src="images/illust_2g.png" /></td>
			<td class="td_detail_top">货物名称：<span class="text_detail_title1">${goodsformInfo.name }</span>
                <br />
                截止时间：<span class="text_detail_title2"><fmt:formatDate value ="${goodsformInfo.limitDate }" pattern= "yyyy-MM-dd" /></span>
                <br />
                发布日期：<fmt:formatDate value ="${goodsformInfo.relDate }" pattern= "yyyy-MM-dd" />
                <br />
                发布人：${goodsformInfo.realName }<img src="images/btn_level2a.png" />
                <br />
                浏览次数：309
                <br />
                <hr class="hr_1" />              
            	<input type="button" value="0" style="display:none" id="i"></input>
                <c:forEach var="focus" items="${focusList }">
					<c:if test="${goodsformInfo.id==focus.focusId}">
						<script>
							document.getElementById("i").value=1;
						</script>
					</c:if>
				</c:forEach>
				<script type="text/javascript">
					if(document.getElementById("i").value==1)
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"已关注\" class=\"input_detail3\" hidefocus=\"true\" onclick=\"loadXMLDoc('${goodsformInfo.id }');hidefav(this);\" />" );
					else
						document.write( "<input type=\"button\" id=\"btnfav\" value=\"关注\" class=\"input_detail1\" hidefocus=\"true\" onclick=\"loadXMLDoc('${goodsformInfo.id }');hidefav(this);\" />" );
				</script>                           
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
    </table>
    <table width="100%" border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="230" class="td_leftnav_top"></td>
            <td class="td_leftnav_top">
                <div id="detail_tab">
                    <ul class="nav">
                        <li><a href="#item1" class="current" hidefocus="true">补充信息</a></li>
                        <li><a href="#item2" hidefocus="true">运输要求</a></li>
                        <li><a href="#item3" hidefocus="true">费用要求</a></li>
                    </ul>
                    <div class="list_wrap">
                        <ul id="item1">
                            <li class="item2a">${goodsformInfo.remarks }</li>
                        </ul>
                        <ul id="item2" class="tab_hide">
                            <li class="item2a">${goodsformInfo.transportReq }</li>
                        </ul>
                        <ul id="item3" class="tab_hide">
                            <li class="item2a">${goodsformInfo.feeReq }</li>
                        </ul>
                    </div>
				</div>
			</td>
		</tr>
		</tbody>
    </table>
</div>

<%-- <%@ include  file="popup1.jsp"%> --%>
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
            <td class="td_mgmt_right3_td1b_2">${clientInfo.realName }</td>
        </tr>
        <tr>
            <td height="50" class="td_mgmt_right3_td1b_1">手机号：</td>
            <td class="td_mgmt_right3_td1b_2">${clientInfo.phone }</td>
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
		
		$("#search_content").css("height",36);
	}
	function loadXMLDoc(id){
		var curWwwPath=window.document.location.href;
	    var pathName=window.document.location.pathname;
	    var pos=curWwwPath.indexOf(pathName);
		$.ajax({
			   type: "GET",
			   url: curWwwPath.substring(0,pos) + "/DaTian/focus",//请求的后台地址
			   data: "type=goods&id=" + id,//前台传给后台的参数
			   cache:false,
			   success: function(msg){//msg:返回值
				   if(msg == "login"){
					   location.assign(curWwwPath.substring(0,pos) + "/DaTian/loginForm");
				   }
				   loadFocus();
			   }
			});
	}
</script>
</html>
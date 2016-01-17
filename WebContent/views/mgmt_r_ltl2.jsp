<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>零担资源信息</title>
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
                            <span class="span_mgmt_right2_text1">添加零担资源信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                    </tr>
                </table>
                <table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
                     <tr>
                        <td class="td_mgmt_right3_td1a"> 
                            <br />
                            <%-- <c var="goodsdetail" items="${linetransportInfo }"> --%>
				
                            <form action="insertlesstruckload"  method="post" name="insertlesstruckload" id="insertlesstruckload" enctype="multipart/form-data">  	          
                            <table width="90%" border="0" cellspacing="0" cellpadding="0">
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">始发城市：</td>
                                    <td id="cityselector"><input id="city1" type="text" value=""  name="startCity" class="input_city1" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">到达城市：</td>
                                    <td id="cityselector"><input id="city2" type="text" value="" name="endCity" class="input_city1" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">运输时限：</td>
                                    <td><input type="text" class="input_mgmt1" name="onwayTime" id="onwaytime" style="width:300px;" required/>
                                    (小时)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">提供回程：</td>
                                    <td>
                                        <select id="" name="offerReturn" style="width:120px;" required>
                                            <option value=""  selected="selected">请选择</option>
                                            <option value="有">有</option>
                                            <option value="无">无</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td width="120" height="40" class="td_mgmt_right3_td1b">增值服务：</td>
                                    <td>
                                        <select id="valueadd" style="width:120px;" onchange="change1();">
                                            <option value="" >请选择</option>
                                            <option value="A">有</option>
                                            <option value="B" selected="selected">无</option>
                                        </select>
                                        <div id="v_detail" style="display:none;">
                                            <input type="text" name="extraService" class="input_mgmt1" style="width:176px;" placeholder="请输入内容..." />
                                        </div>
                                    </td>
                                </tr>
                               <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">标准报价：</td>
                                    <td><input type="text" name="stanPrice1" id="stanPrice1" class="input_mgmt1" style="width:112px;" required/>
                                    (元/吨)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">标准报价：</td>
                                    <td><input type="text" name="stanPrice2" id="stanPrice2" class="input_mgmt1" style="width:112px;" required/>
                                    (元/方)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">提货费：</td>
                                    <td><input type="text" name="pickFee" id="pickFee" class="input_mgmt1" style="width:112px;" required/>
                                    (元)</td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">送货费：</td>
                                    <td><input type="text" name="deliveryFee" id="deliveryFee" class="input_mgmt1" style="width:112px;" required/>
                                    (元)</td>
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">图片展示：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="请上传文件..." />
                                        	<input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
     									    <input id="upload_btn4" type="file"  name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0]" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" id="remarks" name="remarks" placeholder="请输入内容..." required></textarea>
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
		//表单验证
		formValidate();
		
	}
	
	
	function formValidate() {
		$("#insertlesstruckload").validate({
			rules : {
				city1 : "required",
				city2 : "required",
				onwayTime : {
					required : true,
					number : true
				},
				stanPrice1 : {
					required : true,
					number : true
				},
				stanPrice2 : {
					required : true,
					number : true
				},
				pickFee : {
					required : true,
					number : true
				},
				deliveryFee : {
					required : true,
					number : true
				},
				/* type : {
					required : true,
					minlength : 1
				}, */
				remarks : "required"

			}
		});
	}
	$(function() {
		$('reset:button').click(function() {
			$('.input').val("");
			$('.select').val("");
			$('.checkbox').val("");
		});
	})
</script>
</html>
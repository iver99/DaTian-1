﻿<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>合同信息</title>
<META HTTP-EQUIV="imagetoolbar" CONTENT="no">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
<link type="text/css" rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
<script type="text/javascript" src="js/top_search.js"></script>
<script type="text/javascript" src="js/main_nav.js"></script>
<script type="text/javascript" src="js/mgmt.js"></script>
<script type="text/javascript" src="js/calendar.js"></script>
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
                        	<span class="span_mgmt_right2_text1">添加合同信息</span>
                            <span class="span_mgmt_right2_text2"><a href="javascript:history.go(-1);" hidefocus="true"><img src="images/btn_back1.png" class="span_mgmt_right2_pic1" title="返回" /></a></span>
                        </td>
                	</tr>
            	</table>
				<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table_mgmt_right3">
					<tr>
						<td class="td_mgmt_right3_td1a"> 
						<br />
						<form action="insertContract" id="insertContract" method="post" enctype="multipart/form-data">   	          
							<table width="90%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">合同编号：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="${id }" readonly="readonly" name="id"/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">合同名称：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" id="name" name="name" required/></td>
								</tr>
                            <tr>
                                <td height="40" class="td_mgmt_right3_td1b">承运方帐户：</td>
                                <td>
                                    <select id="carrierId" name="carrierId" data-placeholder="请选择" style="width:308px;" required>
                                            <%-- <c:forEach var="companyList" items="${companyList }">
                                            <option value="${companyList.id }">${companyList.companyName }</option>
                                            </c:forEach> --%>
                                    </select>
                                   <!--  <script type="text/javascript">
                                        $("#carrierId").chosen({
                                            no_results_text: "无此信息",
                                            search_contains: true,
                                        });
                                    </script>    -->                             </td>
                            </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">合同开始日期：</td>
                                    <td><input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="readonly" title="点击此处选择" id="startDate" name="startDate" required/></td>
                                </tr>
                                <tr>
                                    <td height="40" class="td_mgmt_right3_td1b">合同截止日期：</td>
                                    <td><input type="text" class="input_date1" onclick="SelectDate(this,'yyyy-MM-dd')" readonly="readonly" title="点击此处选择" id="endDate" name="endDate" required/></td>
                                    
                                </tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">结算方式：</td>
									<td>
                                        <select id="caculateType" style="width:120px;" onchange="changeCaculateType();" name="caculateType" required>
                                            <option value="" selected="selected">请选择</option>
                                            <option value="月结">月结</option>
                                            <option value="现付">现付</option>
                                            <option value="到付">到付</option>
                                        </select>
                                        <div id="v_detail" style="display:none;">
                                            <select style="width:80px;" name="monthlyStatementDays" id="monthlyStatementDays">
                                                <option value="" selected="selected">请选择</option>
                                                <option value="30天">30天</option>
                                                <option value="60天">60天</option>
                                                <option value="90天">90天</option>
                                            </select>
                                        </div>
									</td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">联系人：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" name="contact" id="contact" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">手机号：</td>
									<td><input type="text" class="input_mgmt1" style="width:300px;" value="" name="phone" id="phone" required/></td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">相关材料：</td>
									<td>
                                    	<div style="position:relative;">
                                        	<input id="apply_attachment1" type="text" class="input_attachment1" style="width:230px;" value="" /><input id="upload_btn3" type="button" value="添加" class="input_attachment_btn1" style="width:60px; margin-left:10px;" />
      <input id="upload_btn4" type="file" name="file" onchange="document.getElementById('apply_attachment1').value=/[^\\]+\.\w+$/.exec(this.value)[0];fileChange(/[^\\]+\.\w+$/.exec(this.value)[0]);" class="input_attachment_btn1_hidden" style="width:300px;" hidefocus="true" required/>
                                        </div>
                                    </td>
								</tr>
								<tr>
									<td height="40" class="td_mgmt_right3_td1b">补充信息：</td>
									<td>
                                    	<textarea class="textarea_rating" placeholder="请输入内容..." name="remarks" id="remarks" required></textarea>
                                    </td>
								</tr>
								<tr>
									<td width="120" height="40" class="td_mgmt_right3_td1b">&nbsp;</td>
									<td><input type="submit" id="btn1" value="提交" class="btn_mgmt1" hidefocus="true" />
									<input type="reset" id="reset" value="重填" class="btn_mgmt2" hidefocus="true" /></td>
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
		//获取已审核 的公司列表
		getCompanyList();
		
		//validate
		formValidate();
	}
	
	function formValidate(){
		$("#insertContract").validate({
			rules : {
				carrierId : "required",
				name : "required",
				startDate : "required",
				calculateType : "required",
				monthluStatementDays : "required",
				contract : "required",
				phone : {
					required : true,
					number : true
				},
				remarks : "required"
				
			}
		});
	}
	
	$(function(){
		$('reset:button').click(function(){
		   $('.input').val("");
		   $('.select').val("");
		});
    })
    
    //获取承运方列表（已通过审核的）
	function getCompanyList(){
		var url="getCertificatedCompanyAjax";
		$.ajax({
			url:url,
			dataType:"json",
			cache:false,
			success:function(data,status){
				var f=$("#carrierId");
				for(var i =0;i<data.length;i++){
					var option=$("<option>").text(data[i].companyName).val(data[i].id);
					f.append(option);
				}
			}
		})
	}
</script>
</html>
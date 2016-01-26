<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
	String ctxPath=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="icon" href="/images/fav.ico" type="image/x-icon" />
	<link rel="bookmark" href="/images/fav.ico" type="image/x-icon" />
	<link type="text/css" rel="stylesheet" href="css/index.css">
		<script type="text/javascript" src="js/jquery.min.1.7.2.js"></script>
		<script type="text/javascript" src="js/top_search.js"></script>
		<script type="text/javascript" src="js/main_nav.js"></script>
		<script type="text/javascript" src="js/resource_select.js" charset="UTF-8"></script>
		<script type="text/javascript" src="js/jquery.tablesorter.pack.js"></script>
		<script type="text/javascript" src="js/jquery.placeholder.min.js"></script>
		<!-- <script type="text/javascript" src="js/splitPage.js"></script> <!-- 新增 -->
		<script type="text/javascript" src="js/focus_load.js"></script>
<title>短信日志页面</title>
</head>
<body>
<script type="text/javascript"> 
$(function() {
	getSMSLog();
});

function getSMSLog(){
	var url="<%=ctxPath %>/getSmsLogAjax";
	
	$.ajax({
		url:url,
		type:"get",
		success:function(data,status){
			  $("#testbody").empty();
				for(var i=0; i<data.length; i++) {
					var str="<tr>";
					str+="<td class=\"td_main_list_content\"></td>";
					str+="<td class=\"td_main_list_content\">"+data[i].id+"</td>";
					str+="<td class=\"td_main_list_content\">"+data[i].terminal+"</td>";
					str+="<td class=\"td_main_list_content\">"+data[i].type+"</td>";
					str+="<td class=\"td_main_list_content\">"+data[i].phone+"</td>";
					str+="<td class=\"td_main_list_content\">"+data[i].smsContent+"</td>";
					str+="<td class=\"td_main_list_content\">"+renderTime(data[i].time)+"</td>";
					if(data[i].status == 0)
					{
						str+="<td class=\"td_main_list_content\">成功</td>";
					}else{
						str+="<td class=\"td_main_list_content\">失败</td>";
					}
					str+="<td class=\"td_main_list_content\">"+data[i].comment+"</td>";
					/* if(data[i].status == "有效"){
						str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1b\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
					}else{
						str+="<td class=\"td_main_list_content\"><a href=\"javascript:;\" class=\"a_main_list_handle_icon1a\" hidefocus=\"true\" onclick=\"hide(this);loadXMLDoc('"+data[i].id+"')\"></a></td>";
					} */
					str+="</tr>";
					 $("#testbody").append(str);
				}
		}
	})
}

//时间转换
function renderTime(date){ 
	var da = new Date(parseInt(date)); 
	return da.getFullYear()+"-"+ (da.getMonth()+1)+"-" +da.getDate()+"-"+da.getHours()+":"+da.getMinutes()+":"+da.getSeconds(); 
}

</script>
<h4>短信日志页面</h4>
<b>【注意】1、为了方便，暂时没有实现分页功能，所以只显示了最新的200条日志</b>
<br/><br/>
<table border="0" cellspacing="0" cellpadding="0"
						 id="list">
						<thead id="thead">
							<tr>
								<td width="15" class="td_main_list_head"></td>
								<td width="170" class="td_main_list_head">id</td>
								<td width="170" class="td_main_list_head">终端</td>
								<td width="170" class="td_main_list_head">短信类别</td>
								<td class="td_main_list_head" width="155">手机</td>
                                <td class="td_main_list_head" width="400">短信内容</td>
                                <td class="td_main_list_head" width="175">日期</td>
                                <td class="td_main_list_head" width="175">状态</td>
                                <td class="td_main_list_head" width="155">备注</td>
							</tr>
						</thead>
						<tbody id="testbody"></tbody>
						<tbody>
							
						</tbody>
					</table>

</body>
</html>
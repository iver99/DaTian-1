<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试安卓端接口</title>
</head>
<body>
<div id="driverlogin">
    <h1>司机登陆接口</h1>
    <form action="/DaTian/driverlogin" method="get">
        手机号：<input type="text" name="phone" /><br>
        密&nbsp;码：<input type="password" name="passwd" />
        <br>
        <input type="submit" value="提交" />
    </form>
</div>
<br><br>
<div id="showcurrenttask">
    <h1>当前任务接口</h1>
    <form action="/DaTian/showcurrenttask" method="get" >
        司机手机号：<input type="text" name="phone" />
        <br />
        <input type="submit" value="提交"/>
    </form>
</div>
<br><br>
<div id="shownewtask">
     <h1>新任务接口</h1>
     <form action="/DaTian/shownewtask" method="get">
        司机手机号：<input type="text" name="phone" />
        <br>
        <input type="submit" value="提交" />
     </form>
</div>
<br><br>
<div id="showfinishedtask">
     <h1>已完成任务接口</h1>
     <form action="/DaTian/showfinishedtask" method="get">
        司机手机号：<input type="text" name="phone" />
        <br>
        <input type="submit" value="提交" />
     </form>
</div>
<br><br>
<div id="driverconfirm">
   <h1>司机接受任务接口</h1>
   <form action="/DaTian/driverconfirm" method="get" >
        运单号（waybillNum）：<input type="text" name="waybillNum" />
        <br>
        <input type="submit" value="提交" />
   </form>
</div>
<br><br>
<div id="TakeoverNumber">
   <h1>司机接货接口</h1>
   <form action="/DaTian/upload/TakeoverNumber" method="post">
        运单号（waybillNum）：<input type="text" name="waybillNum" />
        <br>
        <input type="submit" value="提交" />
   </form>
</div>
<br><br>
<div id="CompleteNumber">
   <h1>司机送达接口</h1>
   <form action="/DaTian/upload/CompleteNumber" method="post">
        运单号（waybillNum）：<input type="text" name="waybillNum" /><br>
        运费（必须输入数字）：<input type="text" name="price" /><br>
        图片（已解析成字符串）：<input type="text" name="strImageContent" /><br>
        <input type="submit" value="提交" />
   </form>
</div>
<br><br>
<div id="Location">
   <h1>上传地理位置信息</h1>
   <form action="/DaTian/upload/Location" method="post">
        运单号（waybillNum）：<input type="text" name="waybillNum" /><br>
        车牌号：<input type="text" name="carNum" /><br>
        地址：<input type="text" name="address" /><br>
        时间（格式为“2016-03-21 21:23:45”）：<input type="text" name="time" /><br>
        纬度（必须为数值）：<input type="text" name="latitude" /><br>
        经度（必须为数值）：<input type="text" name="longtitude" /><br>
        事件：<input type="text" name="event" /><br>
        <input type="submit" value="提交" />
   </form>
</div>
<br><br>
<div id="location">
    <h1>回传地理位置信息接口</h1>
    <form action="/DaTian/location" method="post">
        运单号（waybillNum）：<input type="text" name="waybillNum" /><br>
        <input type="submit" value="提交" />
    </form>
</div>
</body>
</html>
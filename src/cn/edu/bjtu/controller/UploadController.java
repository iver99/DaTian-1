package cn.edu.bjtu.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Track;

@Controller
@RequestMapping("/upload")
public class UploadController extends BaseDaoImpl<Track> {
	@Autowired
	OrderService orderService;
	@Autowired
	CarService carService;
    @Autowired
	TrackService trackService;
	//安卓端上传收货订单号，即开始任务
	@RequestMapping(value="TakeoverNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadtakeoverNumber(HttpServletRequest request,HttpServletResponse response){
		
		String orderId = request.getParameter("orderId");
		String takeoverNumber = request.getParameter("TakeoverNumber");
		orderService.settakeoverNumber(orderId, takeoverNumber);
	}
	
	//安卓端上传送达订单号，即结束任务
	@RequestMapping(value="CompleteNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadcompleteNumber(HttpServletRequest request,HttpServletResponse response){
		String carState = "停歇";
		String orderId = request.getParameter("orderId");
		String completeNumber = request.getParameter("CompleteNumber");
		Float price = Float.valueOf(request.getParameter("price"));
		//此处已修改订单状态为已完成
		orderService.setcompleteNumber(orderId, completeNumber, price);
		//同时修改汽车状态为“停歇”
		Orderform order = orderService.getOrderInfo(orderId);
		String carNum = order.getCarNum();
		carService.setcarState(carNum, carState);	
	}
	
	//安卓端上传地理位置信息
	@RequestMapping("Location")
	@ResponseBody
	public void uploadLocation(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		String orderId = request.getParameter("orderId");
		String carNum = request.getParameter("carNum");
		String address = request.getParameter("address");
		String orgintime = request.getParameter("time");
		String latitude = request.getParameter("latitude");
		String longtitude = request.getParameter("longtitude");
		String id = IdCreator.createTrackId();
		Double locLatitude = Double.parseDouble(latitude);
		Double locLongtitude = Double.parseDouble(longtitude);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = formatter.parse(orgintime);
		
		trackService.createNewTrack(id, orderId, carNum, locLongtitude, locLatitude, time, address);
		
	}

}

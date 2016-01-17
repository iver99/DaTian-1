package cn.edu.bjtu.controller;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;

@Controller
@RequestMapping("/upload")
public class UploadController {
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
		
		String orderNum = request.getParameter("orderNum");
		String state = "待收货";
		Orderform order = orderService.getOrderByOrderNum(orderNum);
		String orderId = order.getId();
		orderService.setState(orderId, state);
	}
	
	//安卓端上传送达订单号，即结束任务
	@RequestMapping(value="CompleteNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadcompleteNumber(HttpServletRequest request,HttpServletResponse response){
		String carState = "停歇";
		String orderNum = request.getParameter("orderNum");
		float price = Float.parseFloat(request.getParameter("price"));
		Orderform order = orderService.getOrderByOrderNum(orderNum);
		String orderId = order.getId();
		//此处已修改订单状态为待评价
		orderService.setcompleteNumber(orderId, price);
		//同时修改汽车状态为“停歇”
		String carNum = order.getCarNum();
		carService.setcarState(carNum, carState);	
	}
	
	//安卓端上传地理位置信息
	@RequestMapping(value="Location",method=RequestMethod.POST)
	@ResponseBody
	public void uploadLocation(HttpServletRequest request,HttpServletResponse response) throws ParseException{
		String orderNum = request.getParameter("orderNum");
		String carNum = request.getParameter("carNum");
		String address = request.getParameter("address");
		String time = request.getParameter("time");
		String latitude = request.getParameter("latitude");
		String longtitude = request.getParameter("longtitude");
		String id = IdCreator.createTrackId();
		Double locLatitude = Double.parseDouble(latitude);
		Double locLongtitude = Double.parseDouble(longtitude);
		Orderform order = orderService.getOrderByOrderNum(orderNum);
		String orderId = order.getId();
		
		trackService.createNewTrack(id, orderId,orderNum, carNum, locLongtitude, locLatitude, time, address);
		
	}

}

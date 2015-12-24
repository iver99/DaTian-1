package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.vo.Orderform;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	OrderService orderService;
	@Autowired
	CarService carService;
	
	@RequestMapping(value="TakeoverNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadtakeoverNumber(HttpServletRequest request,HttpServletResponse response){
		
		String orderId = request.getParameter("orderId");
		String takeoverNumber = request.getParameter("TakeoverNumber");
		orderService.settakeoverNumber(orderId, takeoverNumber);
	}
	
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

}

package cn.edu.bjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.OrderService;

@Controller
public class DriverConfirmController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/driverconfirm")
	@ResponseBody
	public void driverConfirm(@RequestParam(value="orderid",required=false) String orderid){
		
		orderService.setConfirm(orderid);
		orderService.acceptOrder(orderid);
		System.out.println("ÐÞ¸Ä³É¹¦");
		
	}

}

package cn.edu.bjtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.WayBill;

@Controller
public class DriverConfirmController {
	
	@Autowired
	OrderService orderService;
	@Autowired
	WayBillService waybillService;
	
	@RequestMapping("/driverconfirm")
	@ResponseBody
	public void driverConfirm(@RequestParam(value="waybillNum",required=false) String waybillNum){
		WayBill waybill = waybillService.getWayBillBywaybillNum(waybillNum);
		String waybillid = waybill.getId();
		waybillService.setConfirm(waybillid);
		
	}

}

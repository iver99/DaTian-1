package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Orderform;
import net.sf.json.JSONArray;

@Controller
public class ShowDriverTaskController {

	@Autowired
	DriverService driverService;
	@Autowired
	Driverinfo driverinfo;
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/showdrivertask")
	@ResponseBody
	public String showTask(@RequestParam(value="phone",required=false) String phone){
		
		//获取司机名字，以便搜索订单表
		//System.out.println(phone);
		driverinfo = driverService.getDriverByPhone(phone);
		String name = driverinfo.getDriverName();
		//System.out.println(name);
		
		//将List集合转化为JSONArray.
		List<Orderform> l = orderService.getOrderByDriverName(name);
		JSONArray orderResult = JSONArray.fromObject(l);
		//System.out.println(orderResult);
		//Orderform o = (Orderform)l.get(0);
		//String test = o.toString();
		//System.out.println(test);
		
		return orderResult.toString();
	}
}

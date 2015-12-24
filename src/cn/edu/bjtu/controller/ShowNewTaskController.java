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
public class ShowNewTaskController {
	
	@Autowired
	DriverService driverService;
	@Autowired
	Driverinfo driverinfo;
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/shownewtask",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showNewTask(@RequestParam(value="phone",required=false) String phone){
		
		String f = "true";
		String s = "已受理";
		//获取司机名字，以便搜索订单表
		driverinfo = driverService.getDriverByPhone(phone);
		String name = driverinfo.getDriverName();
		
		//将List集合转化为JSONArray.
		List<Orderform> l = orderService.getOrderByDriverName(name);
		
		//筛选符合要求的任务
		for(int i=0;i < l.size(); i++){
			Orderform o = (Orderform)l.get(i);
			if((f.equals(o.getConfirm()))||(!(s.equals(o.getState())))){
				l.remove(i);
				i=i-1;
			}
		}
		JSONArray orderResult = JSONArray.fromObject(l);
		return orderResult.toString();
	}

}

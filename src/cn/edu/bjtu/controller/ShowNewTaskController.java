package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.WayBill;
import net.sf.json.JSONArray;

@Controller
public class ShowNewTaskController {
	
	@Autowired
	DriverService driverService;
	@Autowired
	WayBillService waybillService;
	
	@RequestMapping(value="/shownewtask",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showNewTask(@RequestParam(value="phone",required=false) String phone){
		//获取司机名字，以便搜索订单表
		Driverinfo driverinfo = driverService.getDriverByPhone(phone);
		String name = driverinfo.getDriverName();
		
		//将List集合转化为JSONArray.
		List<WayBill> l = waybillService.getWayBillByDriverName(name);
		
		//筛选符合要求的任务
		for(int i=0;i < l.size(); i++){
			WayBill waybill = (WayBill)l.get(i);
			if((!((waybill.getConfirm()).equals("false")))||(!((waybill.getWaybillState()).equals("未确认")))){
				l.remove(i);
				i=i-1;
			}
		}
		JSONArray waybillResult = JSONArray.fromObject(l);
		return waybillResult.toString();
	}

}

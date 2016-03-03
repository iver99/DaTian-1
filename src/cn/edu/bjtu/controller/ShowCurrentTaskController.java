package cn.edu.bjtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.WayBill;
import net.sf.json.JSONArray;

@Controller
public class ShowCurrentTaskController {
	
	@Autowired
	DriverService driverService;
	@Autowired
	OrderService orderService;
	@Autowired
	WayBillService waybillService;
	
	@RequestMapping(value="/showcurrenttask",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String showCurrentTask(@RequestParam(value="phone",required=false) String phone){
		//��ȡ˾�����֣��Ա�����������
		//System.out.println(phone);
		Driverinfo driverinfo = driverService.getDriverByPhone(phone);
		String name = driverinfo.getDriverName();
		
		//��List����ת��ΪJSONArray.
		List<WayBill> l = waybillService.getWayBillByDriverName(name);
		//ɸѡ����Ҫ�������
		for(int i=0;i < l.size(); i++){
			WayBill waybill = (WayBill)l.get(i);
			if((!((waybill.getConfirm()).equals("true")))||((!((waybill.getWaybillState()).equals("������")))&&(!((waybill.getWaybillState()).equals("������"))))){
				l.remove(i);
				i=i-1;
			}
		}
		JSONArray waybillResult = JSONArray.fromObject(l);
		return waybillResult.toString();
	}

}

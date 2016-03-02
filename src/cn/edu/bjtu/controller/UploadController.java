package cn.edu.bjtu.controller;

import java.text.ParseException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.WayBill;

@Controller
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	OrderService orderService;
    @Autowired
	TrackService trackService;
    @Autowired
	WayBillService waybillService;
	//安卓端上传收货订单号，即开始任务
	@RequestMapping(value="TakeoverNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadtakeoverNumber(HttpServletRequest request,HttpServletResponse response){
		String waybillNum = request.getParameter("waybillNum");
		WayBill waybill = waybillService.getWayBillBywaybillNum(waybillNum);
		String waybillid = waybill.getId();
		waybillService.startTask(waybillid);
	}
	
	//安卓端上传送达订单号，即结束任务
	@RequestMapping(value="CompleteNumber",method=RequestMethod.POST)
	@ResponseBody
	public void uploadcompleteNumber(HttpServletRequest request,HttpServletResponse response){
		String waybillNum = request.getParameter("waybillNum");
		String price = request.getParameter("price");
		String picture = request.getParameter("picture");
		waybillService.finishTask(waybillNum, price, picture);
			
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
		String event = request.getParameter("event");
		String id = IdCreator.createTrackId();
		Double locLatitude = Double.parseDouble(latitude);
		Double locLongtitude = Double.parseDouble(longtitude);
		Orderform order = orderService.getOrderByOrderNum(orderNum);
		String orderId = order.getId();
		
		trackService.createNewTrack(id, orderId,orderNum, carNum, event,locLongtitude, locLatitude, time, address);
		
	}

}

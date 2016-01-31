package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Track;
import net.sf.json.JSONArray;

@Controller
public class LocationController {
	
	@Autowired
	TrackService trackService;
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/location",produces="text/html;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String location(HttpServletRequest request,HttpServletResponse response){
		
		String orderNum = request.getParameter("orderNum");
		Orderform order = orderService.getOrderByOrderNum(orderNum);
		String orderId = order.getId();
		List<Track> loc = trackService.getTrackByOrderIdDesc(orderId);
		JSONArray location = JSONArray.fromObject(loc);
		
		return location.toString();
	}

}

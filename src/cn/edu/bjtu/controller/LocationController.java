package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.vo.Track;
import net.sf.json.JSONArray;

@Controller
public class LocationController {
	
	@Autowired
	TrackService trackService;
	
	@RequestMapping(value="/location",method=RequestMethod.POST)
	@ResponseBody
	public String location(HttpServletRequest request,HttpServletResponse response){
		
		String orderId = request.getParameter("orderId");
		List<Track> loc = trackService.getTrackByOrderId(orderId);
		JSONArray location = JSONArray.fromObject(loc);
		
		return location.toString();
	}

}

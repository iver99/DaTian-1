package cn.edu.bjtu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.AirLineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.FullTruckLoadService;
import cn.edu.bjtu.util.PageUtil;

/**
 * @author solitudeycq
 *
 */
@Controller
public class AirLineController {
	
	@Autowired
    AirLineService airlineService;
	@Autowired
	FocusService focusService;
	@Resource
	CompanyService companyService;
	@Autowired
	CommentService commentService;
	
	/**
     * 资源栏所有空运信息
     * @return
     */
	@RequestMapping(value="/airline",params="flag=0")
	public String getallAirLine(){
		return "resource_list7";
		
	}
	
	/**
	 * 资源栏空运筛选
	 * @return
	 */
	@RequestMapping(value="airlineAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sirlineAjax(AirLineSearchBean airlineBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model){
		JSONArray airlineArray = airlineService.getSelectedAirLineNew(airlineBean, page, session);
		return airlineArray.toString();	
	}

}

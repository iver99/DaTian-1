package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Linetransport;

@Controller
public class LesstruckloadController {
	@Autowired
	CommentService commentService;
	@Autowired
	LesstruckloadService LesstruckloadService;
	@Resource
	CompanyService companyService;
	
	@Resource
	LinetransportService linetransportService;
	@Autowired
	FocusService focusService;

	ModelAndView mv = new ModelAndView();

	/**
	 * 资源栏-零担信息
	 * @return
	 */
	@RequestMapping(value="/lesstruckload",params="flag=0")
	public String getAllTruck() {
		return "resource_list3";
	}
	
/*	*//**
	 * 获取我的信息-零担信息（未修改公司后台，待修改）
	 * @return
	 *//*
	@RequestMapping(value="/car",params="flag=1")
	public String getMyInfoCar(HttpServletRequest request){
		return "mgmt_r_car";
		
	}
	*/
	
	
	/**
	 * 资源栏获取筛选后的零担信息
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getCarSelected(TruckBean truckBean,PageUtil pageUtil,HttpSession session){
		
		JSONArray jsonArray = LesstruckloadService.getSelectedLesstruckloadNew(truckBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 返回资源-零担信息筛选记录总条数
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean){
		Integer count=LesstruckloadService.getSelectedLesstruckloadTotalRows(truckBean);
		return count;
	}
}




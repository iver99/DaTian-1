package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.service.AirLineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.AirLine;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;

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
	
	ModelAndView mv = new ModelAndView();
	
	/**
     * 资源栏所有空运信息
     * @return
     */
	@RequestMapping(value="/airline",params="flag=0")
	public String getallAirLine(){
		return "resource_list7";
		
	}
	
	/**
     * 资源栏所有空运信息
     * @return
     */
	@RequestMapping(value="/airline",params="flag=1")
	public String getAllAirLine(){
		return "mgmt_r_airline";
		
	}
	
	/**
	 * 资源栏空运筛选
	 * @return
	 */
	@RequestMapping(value="airlineAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String airlineAjax(AirLineSearchBean airlineBean,PageUtil page, HttpSession session, HttpServletResponse response,Model model){
		JSONArray airlineArray = airlineService.getSelectedAirLineNew(airlineBean, page, session);
		return airlineArray.toString();	
	}
	
	/**
	 * 返回资源-国内空运信息筛选记录总条数
	 */
	@RequestMapping(value="airlineTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer airlineTotalRowsAjax(AirLineSearchBean airlineBean){
		
		Integer count = airlineService.getSelectedAirLineTotalRows(airlineBean);
		return count;
	}
	/**
	 * 获取国内空运资源详情
	 * @param truckId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/airlinedetail",method = RequestMethod.GET)
	public ModelAndView getFullTruckLoadInfo(
			@RequestParam("airlineId") String airlineId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request){
		AirLine airlineInfo = airlineService.getAirLineInfo(airlineId);
		if(airlineInfo.getExtraService()==null){
			airlineInfo.setExtraService("没有");	
		} else if(airlineInfo.getExtraService().equals("")){
			airlineInfo.setExtraService("没有");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"airline");
		mv.addObject("focusList", focusList);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//需要获取资源对应的公司的评价平均数bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("airlineInfo", airlineInfo);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail7");// 资源栏点击详情的页面
		} else if (flag == 1) {// 详情
			mv.addObject("airlineInfo", airlineInfo);
			mv.setViewName("mgmt_r_airline4");
		} else if (flag == 2) {// 更新
			String temp = clientId + "_";
			if(airlineInfo.getPicture()!=null){
			    if(airlineInfo.getPicture().indexOf(temp)!=-1){
			    	String[] s = airlineInfo.getPicture().split(temp);
			    	airlineInfo.setPicture(s[1]);
			    	}else{
			    		airlineInfo.setPicture("请上传文件...");
				}
			}
			if(airlineInfo.getAirCycle().equals("每天")){
				airlineInfo.setAirCycle("周一二三四五六日");
			}
			mv.addObject("airlineInfo", airlineInfo);
			mv.setViewName("mgmt_r_airline3");
			}
		return mv;
	}
	
	/**
	 * 我的信息-空运资源 
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping(value="getAirLineResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getAirLineResource(HttpSession session,PageUtil pageUtil) {
		
		JSONArray jsonArray=airlineService.getAirLineResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	/**
	 * 我的信息-空运资源-总记录条数
	 */
	@RequestMapping(value="getAirLineResourceTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedAirLineResourceTotalRows(HttpSession session){
		
		return airlineService.getSelectedAirLineResourceTotalRows(session);
	}
	
	/**
	 * 新增国内空运资源
	 * @param line
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertairline", method = RequestMethod.POST)
	public String insertNewLinetransport(AirLine airline,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=airlineService.insertNewAirLine(airline,request,file);
		return "redirect:airline?flag=1";
	}
	
	/**
	 * 更新国内空运资源信息
	 * @param line
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updateairline",method=RequestMethod.POST)
	public String updateLinetransport(AirLine airline,MultipartFile file,HttpServletRequest request) {
		boolean flag = airlineService.updateAirLine(airline,request,file);
		return "redirect:airline?flag=1";
	}
	
	/**
	 * 删除国内空运资源
	 */
	@RequestMapping(value = "airlinedelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		airlineService.deleteairline(id);
		return "redirect:airline?flag=1";

	}
	
	@RequestMapping(value = "downloadairlinedetailprice", method = RequestMethod.GET)
	public ModelAndView downloadAirLineDetailPrice(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		AirLine airlineInfo = airlineService.getAirLineInfo(id); // 需要重构,返回一条具体的线路不是list
			String file = airlineInfo.getPicture();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}

}

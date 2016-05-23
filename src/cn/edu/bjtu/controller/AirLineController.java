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
     * ��Դ�����п�����Ϣ
     * @return
     */
	@RequestMapping(value="/airline",params="flag=0")
	public String getallAirLine(){
		return "resource_list7";
		
	}
	
	/**
     * ��Դ�����п�����Ϣ
     * @return
     */
	@RequestMapping(value="/airline",params="flag=1")
	public String getAllAirLine(){
		return "mgmt_r_airline";
		
	}
	
	/**
	 * ��Դ������ɸѡ
	 * @return
	 */
	@RequestMapping(value="airlineAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String airlineAjax(AirLineSearchBean airlineBean,PageUtil page, HttpSession session, HttpServletResponse response,Model model){
		JSONArray airlineArray = airlineService.getSelectedAirLineNew(airlineBean, page, session);
		return airlineArray.toString();	
	}
	
	/**
	 * ������Դ-���ڿ�����Ϣɸѡ��¼������
	 */
	@RequestMapping(value="airlineTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer airlineTotalRowsAjax(AirLineSearchBean airlineBean){
		
		Integer count = airlineService.getSelectedAirLineTotalRows(airlineBean);
		return count;
	}
	/**
	 * ��ȡ���ڿ�����Դ����
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
			airlineInfo.setExtraService("û��");	
		} else if(airlineInfo.getExtraService().equals("")){
			airlineInfo.setExtraService("û��");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"airline");
		mv.addObject("focusList", focusList);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//��Ҫ��ȡ��Դ��Ӧ�Ĺ�˾������ƽ����bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("airlineInfo", airlineInfo);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail7");// ��Դ����������ҳ��
		} else if (flag == 1) {// ����
			mv.addObject("airlineInfo", airlineInfo);
			mv.setViewName("mgmt_r_airline4");
		} else if (flag == 2) {// ����
			String temp = clientId + "_";
			if(airlineInfo.getPicture()!=null){
			    if(airlineInfo.getPicture().indexOf(temp)!=-1){
			    	String[] s = airlineInfo.getPicture().split(temp);
			    	airlineInfo.setPicture(s[1]);
			    	}else{
			    		airlineInfo.setPicture("���ϴ��ļ�...");
				}
			}
			if(airlineInfo.getAirCycle().equals("ÿ��")){
				airlineInfo.setAirCycle("��һ������������");
			}
			mv.addObject("airlineInfo", airlineInfo);
			mv.setViewName("mgmt_r_airline3");
			}
		return mv;
	}
	
	/**
	 * �ҵ���Ϣ-������Դ 
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
	 * �ҵ���Ϣ-������Դ-�ܼ�¼����
	 */
	@RequestMapping(value="getAirLineResourceTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedAirLineResourceTotalRows(HttpSession session){
		
		return airlineService.getSelectedAirLineResourceTotalRows(session);
	}
	
	/**
	 * �������ڿ�����Դ
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
	 * ���¹��ڿ�����Դ��Ϣ
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
	 * ɾ�����ڿ�����Դ
	 */
	@RequestMapping(value = "airlinedelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		airlineService.deleteairline(id);
		return "redirect:airline?flag=1";

	}
	
	@RequestMapping(value = "downloadairlinedetailprice", method = RequestMethod.GET)
	public ModelAndView downloadAirLineDetailPrice(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		AirLine airlineInfo = airlineService.getAirLineInfo(id); // ��Ҫ�ع�,����һ���������·����list
			String file = airlineInfo.getPicture();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}

}

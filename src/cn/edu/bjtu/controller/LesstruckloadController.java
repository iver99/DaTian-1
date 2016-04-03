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

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Truck;

@Controller
public class LesstruckloadController {
	@Autowired
	CommentService commentService;
	@Autowired
	LesstruckloadService LesstruckloadService;
	@Resource
	CompanyService companyService;
	
	@Autowired
	FocusService focusService;

	ModelAndView mv = new ModelAndView();

	/**
	 * ��Դ��-�㵣��Ϣ
	 * @return
	 */
	@RequestMapping(value="/lesstruckload",params="flag=0")
	public String getAllTruck() {
		return "resource_list3";
	}
	
	
	
	/**
	 * ��Դ����ȡɸѡ����㵣��Ϣ
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedLesstruckloadAjax(TruckBean truckBean,PageUtil pageUtil,HttpSession session){
		
		
		JSONArray jsonArray = LesstruckloadService.getSelectedLesstruckloadNew(truckBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * ������Դ-�㵣��Ϣɸѡ��¼������
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean){
		Integer count=LesstruckloadService.getSelectedLesstruckloadTotalRows(truckBean);
		return count;
	}
	
	/**
	 * ��ȡ�㵣��Դ����detail
	 * @param truckId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/lesstruckloaddetail",method = RequestMethod.GET)
	public ModelAndView getLessTruckLoadInfo(
			@RequestParam("truckId") String truckId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request){
		Truck truckInfo = LesstruckloadService.getLesstruckloadInfo(truckId);
		if(truckInfo.getExtraService()==null){
			truckInfo.setExtraService("û��");	
		} else if(truckInfo.getExtraService().equals("")){
			truckInfo.setExtraService("û��");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"lesstruckload");
		mv.addObject("focusList", focusList);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("truckInfo", truckInfo);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//��Ҫ��ȡ��Դ��Ӧ�Ĺ�˾������ƽ����bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail3");// ��Դ����������ҳ��
		} else if (flag == 1) {// ����
			mv.addObject("truckInfo", truckInfo);
			mv.setViewName("mgmt_r_ltl4");
		} else if (flag == 2) {// ����
			String temp = clientId + "_";
			if(truckInfo.getPicture()!=null){
			    if(truckInfo.getPicture().indexOf(temp)!=-1){
			    	String[] s = truckInfo.getPicture().split(temp);
			    	truckInfo.setPicture(s[1]);
			    	}else{
			    		truckInfo.setPicture("���ϴ��ļ�...");
				}
			}
			mv.addObject("truckInfo", truckInfo);
			mv.setViewName("mgmt_r_ltl3");
			}
		return mv;
	}
	
	/**
	 * �ҵ���Ϣ-�㵣��Դ����������ת
	 * @param flag
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/lesstruckload",params="flag=1")
	public String getAllLessTruckLoad(@RequestParam int flag,
			PageUtil page, HttpSession session) {
		return "mgmt_r_ltl";
	}
	
	/**
	 * �ҵ���Ϣ-�㵣��Դ�� ��ʾ��Դ
	 * @param session
	 * @param lineBean
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping(value="getLessTruckLoadResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedLesstruckloadresourceAjax(HttpSession session,PageUtil pageUtil) {
		
		JSONArray jsonArray=LesstruckloadService.getSelectedLesstruckloadresourceloadNew(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-�㵣��Ϣ-�ܼ�¼����
	 */
	@RequestMapping(value="getLessTruckLoadResourceTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedLesstruckloadresourceTotalRows(HttpSession session){
		
		return LesstruckloadService.getSelectedLesstruckloadresourceTotalRows(session);
	}
	
	/**
	 * ����������Դ
	 * @param line
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertlesstruckload", method = RequestMethod.POST)
	public String insertNewLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=LesstruckloadService.insertNewLesstruckload(truck,request,file);
		return "redirect:lesstruckload?flag=1";
	}
	
	/**
	 * ɾ��������Դ
	 */
	@RequestMapping(value = "lesstruckloaddelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		LesstruckloadService.deleteLesstruckload(id);
		return "redirect:lesstruckload?flag=1";

	}
	
	/**
	 * ����������Դ��Ϣ
	 * @param line
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updatelesstruckload",method=RequestMethod.POST)
	public String updateLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
	
		boolean flag = LesstruckloadService.updateLesstruckload(truck,request,file);
		return "redirect:lesstruckload?flag=1";
	}
	
	/**
	 * ͼƬչʾ����
	 */
	@RequestMapping(value="downloadlesstruckloaddetailprice", method = RequestMethod.GET)
	public ModelAndView downloadDetailPrice(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Truck truckInfo = LesstruckloadService.getLesstruckloadInfo(id); // ��Ҫ�ع�,����һ���������·����list
		String file = truckInfo.getPicture();
		DownloadFile.downloadFile(file,request,response);
		
		return mv;

	}


}




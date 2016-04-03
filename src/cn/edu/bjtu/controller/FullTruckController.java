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

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.FullTruckLoadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Truck;

/**
 * @author solitudeycq
 * �������
 *
 */
@Controller
public class FullTruckController {
	@Autowired
    FullTruckLoadService fulltruckloadService;
	@Autowired
	FocusService focusService;
	@Resource
	CompanyService companyService;
	@Autowired
	CommentService commentService;
	
	ModelAndView mv = new ModelAndView();
	
	
    /**
     * ��Դ������������Ϣ
     * @return
     */
	@RequestMapping(value="/fulltruckload",params="flag=0")
	public String getallFullTruckLoad(){
		return "resource_list";
		
	}
	
	/**
	 * ��Դ������ɸѡ
	 * @return
	 */
	@RequestMapping(value="getSelectedFulltruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedLesstruckloadAjax(TruckBean truckBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model){
		JSONArray fulltruckloadArray = fulltruckloadService.getSelectedFulltruckloadNew(truckBean, page, session);
		return fulltruckloadArray.toString();	
	}
	
	/**
	 * ������Դ-������Ϣɸѡ��¼������
	 * @return
	 */
	@RequestMapping(value="getSelectedFulltruckloadTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean){
		Integer count=fulltruckloadService.getSelectedFulltruckloadTotalRows(truckBean);
		return count;
	}
	
	/**
	 * ��ȡ������Դ����
	 * @param truckId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/fulltruckloaddetail",method = RequestMethod.GET)
	public ModelAndView getFullTruckLoadInfo(
			@RequestParam("truckId") String truckId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request){
		Truck truckInfo = fulltruckloadService.getfulltruckloadInfo(truckId);
		if(truckInfo.getExtraService()==null){
			truckInfo.setExtraService("û��");	
		} else if(truckInfo.getExtraService().equals("")){
			truckInfo.setExtraService("û��");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"fulltruckload");
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
			mv.setViewName("resource_detail1");// ��Դ����������ҳ��
		} else if (flag == 1) {// ����
			mv.addObject("truckInfo", truckInfo);
			mv.setViewName("mgmt_r_line4");
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
			mv.setViewName("mgmt_r_line3");
			}
		return mv;
	}
	
	/**
	 * �ҵ���Ϣ-������Դ
	 * @param flag
	 * @param page
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/fulltruckload",params="flag=1")
	public String getAllFullTruckLoad(@RequestParam int flag,
			PageUtil page, HttpSession session) {
		return "mgmt_r_line";
	}
	
	/**
	 * �ҵ���Ϣ-������Դ 
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping(value="getUserFullTruckLoadResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserFullTruckLoadResource(HttpSession session,PageUtil pageUtil) {
		
		JSONArray jsonArray=fulltruckloadService.getUserFullTruckLoadResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * ����������Դ
	 * @param line
	 * @param file
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "insertfulltruckload", method = RequestMethod.POST)
	public String insertNewLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=fulltruckloadService.insertNewFullTruckLoad(truck,request,file);
		return "redirect:fulltruckload?flag=1";
	}
	
	/**
	 * ɾ��������Դ
	 */
	@RequestMapping(value = "fulltruckloaddelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		fulltruckloadService.deletefulltruckLoad(id);
		return "redirect:fulltruckload?flag=1";

	}
	
	/**
	 * ����������Դ��Ϣ
	 * @param line
	 * @param request
	 * @param response
	 */
	@RequestMapping(value="updatefulltruckload",method=RequestMethod.POST)
	public String updateLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
		boolean flag = fulltruckloadService.updateFullTruckLoad(truck,request,file);
		return "redirect:fulltruckload?flag=1";
	}
	
	/**
	 * ͼƬչʾ����
	 */
	@RequestMapping(value="downloadfulltruckloaddetailprice", method = RequestMethod.GET)
	public ModelAndView downloadDetailPrice(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Truck truckInfo = fulltruckloadService.getfulltruckloadInfo(id); // ��Ҫ�ع�,����һ���������·����list
		String file = truckInfo.getPicture();
		DownloadFile.downloadFile(file,request,response);
		
		return mv;

	}


}

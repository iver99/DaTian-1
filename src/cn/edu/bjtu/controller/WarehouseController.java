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

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.WarehouseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;

@Controller
public class WarehouseController {
	@Autowired
	CommentService commentService;
	@Resource
	WarehouseService warehouseService;
	@Resource
	CompanyService companyService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();

	
	/**
	 * �������вֿ���Ϣ����ͼ��ѯ��
	 * @return
	 */
	@RequestMapping(value="/warehouse",params="flag=0")
	public String getAllWarehouse() {
		return "resource_list4";
	}
	
	/**
	 * ���زֿ�ɸѡ���
	 * @param warehouseBean
	 * @param pageUtil
	 * @param sesion
	 * @return
	 */
	@RequestMapping(value="getSelectedWarehouseAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedWarehouseAjax(WarehouseSearchBean warehouseBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = warehouseService.getSelectedWarehouseNew(warehouseBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * ���زֿ�ɸѡҳ���ܼ�¼��
	 * @param warehouseBean
	 * @return
	 */
	@RequestMapping("getSelectedWarehouseTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedWarehouseTotalRowsAjax(WarehouseSearchBean warehouseBean){
		Integer count=warehouseService.getSelectedWarehouseTotalRows(warehouseBean);
		return count;
	}
	
	/**
	 * �ҵ���Ϣ-�ֿ���Ϣ
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/warehouse",params="flag=1")
	public String getMyInfoWarehouse(){
		return "mgmt_r_warehouse";
	}

	/**
	 * ��ȡ�ض��Ĳֿ���Ϣ
	 * ͬʱ���ع�˾�Ͳֿ����������Ϣ
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/warehousedetail", method = RequestMethod.GET)
	public ModelAndView getWarehouseInfo(
			@RequestParam("warehouseId") String warehouseid,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request) {
		Warehouse warehouseInfo = warehouseService.getWarehouseInfo(warehouseid);
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"warehouse");
		mv.addObject("focusList", focusList);
		if (flag == 0) {// ��Ӧ��Դ���ֿ�����
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			//List<Comment> commentList=commentService.getWarehouseCommentById(warehouseid,carrierId);
			//mv.addObject("commentList",commentList);
			mv.addObject("warehouseInfo", warehouseInfo);
			mv.addObject("carrierInfo", carrierInfo);
			mv.setViewName("resource_detail4");
		} else if (flag == 1){// ��Ӧ�ҵ���Ϣ���ֿ�����
			mv.addObject("warehouseInfo", warehouseInfo);
			mv.setViewName("mgmt_r_warehouse4");
		}else if (flag == 2){
			// �ҵ���Ϣ���ֿ����
			String temp = clientId + "_";
			if(warehouseInfo.getDetailPrice()!=null){
			    if(warehouseInfo.getDetailPrice().indexOf(temp)!=-1){
			    	String[] s = warehouseInfo.getDetailPrice().split(temp);
			    	warehouseInfo.setDetailPrice(s[1]);
			    	}else{
			    		warehouseInfo.setDetailPrice("���ϴ��ļ�...");
				}
			}
			mv.addObject("warehouseInfo", warehouseInfo);
			mv.setViewName("mgmt_r_warehouse3");
		}
		return mv;
	}


	/**
	 * �����ֿ�
	 */
	@RequestMapping(value = "/insertWarehouse", method = RequestMethod.POST)
	public String insertNewWarehouse(Warehouse warehouse,MultipartFile file,
			HttpServletRequest request) {
		warehouseService.insertNewWarehouse(warehouse,request,file);
		return "redirect:warehouse?flag=1";
	}
	
	
	@RequestMapping(value = "/updateWarehouse", method = RequestMethod.POST)
	public String updateNewWarehouse(Warehouse warehouse,MultipartFile file,HttpServletRequest request) {
		boolean flag=warehouseService.updateNewWarehouse(warehouse,request,file);
		return "redirect:warehouse?flag=1";
	}
	
	
	/**
	 * ɾ��
	 */
	@RequestMapping(value = "warehousedelete", method = RequestMethod.GET)
	public String deleteWarehouse(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		warehouseService.deleteWarehouse(id);
		return "redirect:warehouse?flag=1";

	}
	
	/**
	 * �����ļ�
	 */
	@RequestMapping(value = "downloadwarehousedetailprice", method = RequestMethod.GET)
	public ModelAndView downloadWarehouseDetailPrice(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		    Warehouse warehouseInfo = warehouseService.getWarehouseInfo(id);
			String file = warehouseInfo.getDetailPrice();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ
	 * @Title: getUserWarehouseResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:26:28
	 */
	@RequestMapping(value="getUserWarehouseResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserWarehouseResource(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=warehouseService.getUserWarehouseResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-�ҵĻ���-�ܼ�¼����
	 * @Title: getUserWarehouseResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:28:43
	 */
	@RequestMapping("getUserWarehouseResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserWarehouseResourceTotalRows(HttpSession session){
		return warehouseService.getUserWarehouseResourceTotalRows(session);
	}

}

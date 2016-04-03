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

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Comment;
import com.alibaba.fastjson.JSONArray;

@Controller
/**
 * �����������
 * @author RussWest0
 *
 */
public class CitylineController {
	@Autowired
	CommentService commentService;
	@Resource
	CitylineService citylineService;
	@Resource
	CompanyService companyService;
	@Autowired
	FocusService focusService;
	ModelAndView mv = new ModelAndView();
	
	/**
	 * ��Դ�����г���������·��Ϣ
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/cityline",params="flag=0")
	public String getAllCityline() {
		
		return "resource_list2";
		
	}
	/**
	 * ��Դ����������ɸѡ
	 * @param citylineBean
	 * @param page
	 * @param session
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value="getCityLineAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getCitylineAjax(CityLineSearchBean citylineBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model) {
		JSONArray linetransportArray = citylineService.getSelectedLineNew(
				citylineBean,page,session);
		//model.addAttribute("count", 100);
		return linetransportArray.toString();
	}
	
	/**
	 * ��ȡ��������ɸѡ������
	 * @param lineBean
	 * @return
	 */
	@RequestMapping("getSelectedCityLineTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedLineTotalRows(CityLineSearchBean citylineBean){
		Integer count=citylineService.getSelectedCityLineTotalRows(citylineBean);
		return count;
	}
	
	/**
	 * �ҵ���Ϣ-�û������г���������·��Ϣ
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/cityline",params="flag=1")
	public String getUserCityline(@RequestParam int flag,
			HttpServletRequest request) {
		return "mgmt_r_city";// �����߳���������ʾ������Ϣ
	}

	@RequestMapping(value = "/citylinedetail", method = RequestMethod.GET)
	/**
	 * ��ȡ����������·����
	 * @param citylineId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	public ModelAndView getCitylineInfo(
			@RequestParam("citylineId") String citylineId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request) {
		Cityline citylineInfo = citylineService.getCitylineInfo(citylineId); // ��Ҫ�ع�,����һ���������·����list
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"cityline");
		mv.addObject("focusList", focusList);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//��Ҫ��ȡ��Դ��Ӧ�Ĺ�˾������ƽ����bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("citylineInfo", citylineInfo);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail2");// ��Դ����������ҳ��
		} else if (flag == 1){
			mv.addObject("citylineInfo", citylineInfo);
			mv.setViewName("mgmt_r_city");
		}// 3���и��º�ɾ��������ҳ��
		else if (flag == 2){
			mv.addObject("citylineInfo", citylineInfo);
			mv.setViewName("mgmt_r_city4");
		}// 4�ǵ�������ҳ��
		else if (flag == 3){
			String temp = clientId + "_";
			if(citylineInfo.getDetailPrice()!=null){
			    if(citylineInfo.getDetailPrice().indexOf(temp)!=-1){
			    	String[] s = citylineInfo.getDetailPrice().split(temp);
			    	citylineInfo.setDetailPrice(s[1]);
			    	}else{
			    		citylineInfo.setDetailPrice("���ϴ��ļ�...");
				}
			}
			mv.addObject("citylineInfo", citylineInfo);
			mv.setViewName("mgmt_r_city3");
			}// ������� ��ҳ��
		return mv;
	}


	/**
	 * ��������������·
	 */
	@RequestMapping(value = "/insertCityLine", method = RequestMethod.POST)
	public String insertNewCityline(Cityline cityline,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=citylineService.insertNewCityline(cityline,request,file);
		return "redirect:cityline?flag=1";
	}
	
	@RequestMapping(value = "/updateCityline", method = RequestMethod.POST)
	public String updateNewCityline(Cityline cityline,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=citylineService.updateNewCityline(cityline,request,file);
		return "redirect:cityline?flag=1";
	}
	
	//public 

	/**
	 * ɾ��
	 */
	@RequestMapping(value = "citydelete", method = RequestMethod.GET)
	public String deleteCityline(@RequestParam String id) {
		citylineService.deleteCityline(id);
			return "redirect:cityline?flag=1";

	}

	@RequestMapping(value = "downloaddetailprice", method = RequestMethod.GET)
	/**
	 * ɾ��
	 */
	public ModelAndView downloadDetailPrice(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Cityline citylineInfo = citylineService.getCitylineInfo(id); // ��Ҫ�ع�,����һ���������·����list
			String file = citylineInfo.getDetailPrice();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * �ҵ���Ϣ-��������
	 * @Title: getUserCitylineResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����9:53:18
	 */
	@RequestMapping(value="getUserCitylineResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserCitylineResource(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=citylineService.getUserCitylineResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-��������-�ܼ�¼��
	 * @Title: getUserCitylineResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����9:55:10
	 */
	@RequestMapping("getUserCitylineResourceTotalRows")
	@ResponseBody
	public Integer getUserCitylineResourceTotalRows(HttpSession session){
		
		return citylineService.getUserCitylineResourceTotalRows(session);
	}
	
	/**
	 * �ӹ�˾����ҳ����붩�����س���������Դ 
	 * @param carrierId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCompanyCitylineAjax",produces = "text/html;charset=UTF-8")
	public String getCompanyCitylineAjax(String carrierId){
		
		return citylineService.getCompanyCitylineResource(carrierId);
	}

}

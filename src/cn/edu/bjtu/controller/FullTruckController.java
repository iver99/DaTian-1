/**
 * 
 */
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
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Truck;

/**
 * @author solitudeycq
 * 整车相关
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
     * 资源栏所有整车信息
     * @return
     */
	@RequestMapping(value="/fulltruckload",params="flag=0")
	public String getallFullTruckLoad(){
		return "resource_list";
		
	}
	
	/**
	 * 资源栏整车筛选
	 * @return
	 */
	@RequestMapping(value="fulltruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String fulltrackloadAjax(TruckBean truckBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model){
		JSONArray fulltruckloadArray = fulltruckloadService.getSelectedFullTruckLoadNew(truckBean, page, session);
		return fulltruckloadArray.toString();	
	}
	
	/**
	 * 获取整车资源详情
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
			truckInfo.setExtraService("没有");	
		} else if(truckInfo.getExtraService().equals("")){
			truckInfo.setExtraService("没有");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"fulltruckload");
		mv.addObject("focusList", focusList);
		mv.addObject("truckInfo", truckInfo);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//需要获取资源对应的公司的评价平均数bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail1");// 资源栏点击详情的页面
		} else if (flag == 1) {// 详情
			mv.setViewName("mgmt_r_line4");
		} else if (flag == 2) {// 更新
			mv.setViewName("mgmt_r_line3");
			}
		return mv;
	}
	
	/**
	 * 我的信息-整车资源
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
	 * 我的信息-整车资源 
	 * @param session
	 * @param lineBean
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
	 * 新增整车资源
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
	 * 删除整车资源
	 */
	@RequestMapping(value = "fulltruckloaddelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		fulltruckloadService.deletefulltruckLoad(id);
		return "redirect:fulltruckload?flag=1";

	}
	
	/**
	 * 更新整车资源信息
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


}

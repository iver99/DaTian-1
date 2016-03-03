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

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.CarTeamService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
public class CarController {
	@Autowired
	CommentService commentService;
	@Autowired
	CarService carService;
	@Resource
	CompanyService companyService;
	
	@Autowired
	CarTeamService carTeamService;
	
	@Autowired
	DriverService driverService;
	
	@Resource
	LinetransportService linetransportService;
	@Autowired
	FocusService focusService;

	ModelAndView mv = new ModelAndView();

	/**
	 * ��Դ��-������Ϣ
	 * @return
	 */
	@RequestMapping(value="/car",params="flag=0")
	public String getAllCar() {
		return "resource_list3";
	}
	
	/**
	 * ��ȡ�ҵ���Ϣ-������Ϣ
	 * @return
	 */
	@RequestMapping(value="car",params="flag=1")
	public String getMyInfoCar(HttpServletRequest request){
		return "mgmt_r_car";
		
	}
	
	/**
	 * ��Դ����ȡɸѡ��ĳ�����Ϣ
	 * @return
	 */
	@RequestMapping(value="getSelectedCarAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getCarSelected(CarSearchBean carBean,PageUtil pageUtil,HttpSession session){
		
		JSONArray jsonArray = carService.getSelectedCarNew(carBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * ������Դ-����ɸѡ��¼������
	 * @return
	 */
	@RequestMapping(value="getSelectedCarTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedCarTotalRows(CarSearchBean carBean){
		Integer count=carService.getSelectedCarTotalRows(carBean);
		return count;
	}

	/**
	 * ��ȡ�ض��ĳ�����Ϣ
	 * ͬʱ���ع�˾�ͳ������������Ϣ
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/cardetail", method = RequestMethod.GET)
	public ModelAndView getCarInfo(@RequestParam("carId") String carId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("linetransportId") String linetransportId,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Carinfo carInfo = carService.getCarInfo(carId);// ������Ϣ
		mv.addObject("carInfo", carInfo);
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"car");
		Linetransport line = linetransportService
				.getLinetransportInfo(linetransportId);// ������Ϣ
		mv.addObject("focusList", focusList);
		mv.addObject("linetransportInfo", line);
		if (flag == 0) {// ��Ӧ��Դ����������
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			//��Ҫ��ȡ��Դ��Ӧ�Ĺ�˾������ƽ����bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.addObject("commentList",commentList);
			
			mv.addObject("carrierInfo", carrierInfo);

			mv.setViewName("resource_detail3");
		} else if (flag == 1)// ��Ӧ�ҵ���Ϣ�г�����Ϣ
		{
			// ��Ҫ˾����Ϣ
			Driverinfo driverinfo = driverService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			mv.setViewName("mgmt_r_car4");
		} else if (flag == 2)// ��Ӧ�ҵ���Ϣ-����-����
		{
			// ��Ҫ˾����Ϣ
			Driverinfo driverinfo = driverService.getDriverByCarId(carId);
			mv.addObject("driverInfo", driverinfo);
			List driverList = driverService.getAllDriver(carrierId);
			mv.addObject("driverList", driverList);
			mv.setViewName("mgmt_r_car3");
		}
		return mv;
	}

	

	/**
	 * ����������Ϣ
	 */
	@RequestMapping(value = "insertCar", method = RequestMethod.POST)
	public String insertNewCar(Carinfo car,
			HttpServletRequest request) {
		boolean flag=carService.insertNewCar(car,request);
		return "redirect:car?flag=1";
	}

	/**
	 * ����˾��
	 */
	@RequestMapping(value = "/insertDriver", method = RequestMethod.POST)
	public String insertNewDriver(Driverinfo driver,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=driverService.insertNewDriver(driver,request,file);
		return "redirect:driver?flag=1";
	}
	

	@RequestMapping(value = "updateCar", method = RequestMethod.POST)
	public String updateNewCar(Carinfo car,
			HttpServletRequest request) {
		boolean flag=carService.updateNewCar(car,request);
		return "redirect:car?flag=1";
	}
	

	/**
	 * ɾ��
	 */
	@RequestMapping(value = "cardelete", method = RequestMethod.GET)
	public String deleteCar(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		carService.deleteCar(id);
		return "redirect:car?flag=1";

	}

	

	/**
	 * ��ȡ�����б�
	 * @return
	 */
	@RequestMapping("carteam")
	public ModelAndView getCarteam(HttpServletRequest request,
			HttpServletResponse response) {
		// ��session��ȡ��id��ѯ
		// ������sessionȡid
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		// String carrierId = "C-0002";// ɾ��
		List<Carteam> carteamList = carTeamService.getCarteam(carrierId);
		mv.addObject("carteamList", carteamList);
		mv.setViewName("mgmt_r_car_fleet");

		return mv;
	}

	/**
	 * ��ȡ�ض��ĳ�����Ϣ
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/carteamdetail", method = RequestMethod.GET)
	public ModelAndView getCarteamDetail(@RequestParam String id,
			@RequestParam("flag") int flag, HttpServletRequest request) {
		Carteam carteaminfo = carTeamService.getCarteamInfo(id);// ������Ϣ
		mv.addObject("carteaminfo", carteaminfo);
		if (flag == 1)// ��Ӧ������Ϣ�鿴
		{
			mv.setViewName("mgmt_r_car_fleet4");
		} else if (flag == 2)// ��Ӧ������Ϣ����
		{
			mv.setViewName("mgmt_r_car_fleet3");
		}
		return mv;
	}

	/**
	 */
	@RequestMapping(value = "insertcarteam", method = RequestMethod.POST)
	public String insertCarteam(@RequestParam String teamName,
			@RequestParam String carCount, @RequestParam String chief,
			@RequestParam String phone, @RequestParam String explaination,
			HttpServletRequest request, HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		boolean flag = carTeamService.insertCarteam(teamName, carCount, chief, phone, explaination, carrierId);
		return "redirect:carteam";
	}

	/**
	 * ɾ��
	 */
	@RequestMapping(value = "deletecarteam", method = RequestMethod.GET)
	public String deleteCarteam(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {

		carTeamService.deleteCarteam(id);
		return "redirect:carteam";

	}

	@RequestMapping(value = "updatecarteam", method = RequestMethod.POST)
	public String updateCarteam(@RequestParam String id,
			@RequestParam String teamName, @RequestParam String carCount,
			@RequestParam String chief, @RequestParam String phone,
			@RequestParam String explaination, HttpServletRequest request,
			HttpServletResponse response) {
		carTeamService.updateCarteam(id, teamName, carCount, chief,
				phone, explaination);
		return "redirect:carteam";
	}
	
	@RequestMapping(value = "downloadidscans", method = RequestMethod.GET)
	/**
	 * ɾ��
	 */
	public ModelAndView downloadIdScans(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Driverinfo driverinfo = driverService.getDriverInfo(id);
			String file = driverinfo.getIdscans();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}
	
	/**
	 * �첽��ȡ��˾�ĳ����б�
	 * @Title: getCompanyCarteamList 
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 	
	 * @date: 2015��6��29�� ����5:32:46
	 */
	@RequestMapping(value="getCompanyCarteamList",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCompanyCarteamList(HttpSession session){
		List<Carteam> carTeamList=carService.getCompanyCarteamList(session);
		//JSONObject jsonObject=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		if(carTeamList!=null && carTeamList.size()>0){
			for(int i=0;i<carTeamList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carTeamList.get(i));
				jsonArray.add(jsonObject);
			}
		}
		return jsonArray.toString();
		
	}
	
	
	/**
	 * �ҵ���Ϣ-������Ϣ
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:10:00
	 */
	@RequestMapping(value="getUserCarResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserCarResource(HttpSession session,PageUtil pageUtil){
		
		JSONArray jsonArray=carService.getUserCarResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ-�ܼ�¼����
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:11:56
	 */
	@RequestMapping(value="getUserCarResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserCarResourceTotalRows(HttpSession session){
		
		return carService.getUserCarResourceTotalRows(session);
	}
	/**
	 * �ҵ���Ϣ-˾����Ϣ
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:10:00
	 */
	@RequestMapping(value="getUserDriverResourceAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUserDriverResource(HttpSession session,PageUtil pageUtil){
		
		JSONArray jsonArray=driverService.getUserDriverResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ-�ܼ�¼����
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:11:56
	 */
	@RequestMapping(value="getUserDriverResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserDriverResourceTotalRows(HttpSession session){
		
		return driverService.getUserDriverResourceTotalRows(session);
	}
	
	/**
	 * �ҵ���Դ-������Ϣ-����i��Ϣ
	 * @Title: getUserCarTeamResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��15�� ����11:17:55
	 */
	@RequestMapping(value="getUserCarTeamResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserCarTeamResource(HttpSession session,PageUtil pageUtil){
		return carTeamService.getUserCarTeamResource(session,pageUtil);
	}
	/**
	 * �ҵ���Դ-������Ϣ-����i��Ϣ-�ܼ�¼��
	 * @Title: getUserCarTeamResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��15�� ����11:19:43
	 */
	@RequestMapping("getUserCarTeamResourceTotalRowsAjax")
	@ResponseBody
	public Integer getUserCarTeamResourceTotalRows(HttpSession session){
		return carTeamService.getUserCarTeamResourceTotalRows(session);
	}

	
	/**
	 * �ӹ�˾����ҳ����붩�����ع�˾�ĳ�����Դ  
	 * @param carrierId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getCompanyCarAjax",produces="text/html;charset=UTF-8")
	public String getCompanyCarAjax(String carrierId){
		return carService.getCompanyCarAjax(carrierId);
		
	}
}

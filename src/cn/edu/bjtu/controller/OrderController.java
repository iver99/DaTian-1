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

import cn.edu.bjtu.bean.page.AcceptOrderBean;
import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.bean.page.TrackBean;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.service.AirLineService;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.FullTruckLoadService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.AirLine;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Track;
import cn.edu.bjtu.vo.Truck;
import cn.edu.bjtu.vo.WayBill;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @author RussWest0
 *
 */
@Controller
public class OrderController {

	@Resource
	OrderService orderService;
	@Autowired
    FullTruckLoadService fulltruckloadService;
	@Autowired
    LesstruckloadService lesstruckloadService;
	@Autowired
	CompanyDao companyDao;
	@Autowired
	AirLineService airlineService;
	@Resource(name = "carServiceImpl")
	CarService carService;
	@Resource
	LinetransportService linetransportService;
	@Resource
	CitylineService citylineService;
	@Autowired
	CompanyService companyService;
	@Autowired
	CommentService commentService;
	@Autowired
	GoodsInfoService goodsInfoService;
	@Autowired
	ResponseService responseService;
	
	@Autowired
	DriverService driverService;
	@Autowired
	TrackService trackService;
	@Autowired
	WayBillService waybillService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/sendorderinfo")
	/**
	 * ���ύ�Ķ�����Ϣ
	 * @return
	 */
	public String getAllSendOrderInfo(HttpSession session) {
		return "mgmt_d_order_s";
	}
	/**
	 * ��ת�������б�ҳ��
	 * @param session
	 * @return
	 */
	@RequestMapping("turnToOrderPage")
	public String orderPage(HttpSession session){
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		if(userKind==2){//�����û�
			return "mgmt_d_order_s";
		}else if(userKind==3){//��ҵ�û�
			return "mgmt_d_order_r";
		}
		return "index";
	}
	
	/**
	 * u��ȡ�û��ύ�Ķ���
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserSendOrderAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserSendOrder(HttpSession session,PageUtil pageUtil,Orderform order){
		JSONArray jsonArray=orderService.getUserSendOrder(session,pageUtil,order);
		
		return jsonArray.toString();
		
	}

	/**
	 * ���ύ�Ķ���-�ܼ�¼��
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUseSendOrderTotalRowsAjax")
	public Integer getUserSendOrderTotalRows(HttpSession session,Orderform order){
		return orderService.getUserSendOrderTotalRows(session,order);
	}

	@RequestMapping("/recieveorderinfo")
	/**
	 * ���յ��Ķ�����Ϣ
	 * @return
	 */
	public String  getAllRecieveOrderInfo(HttpServletRequest request,
			HttpServletResponse response) {
		return "mgmt_d_order_r";
	}
	
	/**
	 * ���յ��Ķ���
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getUserRecieveOrderAjax",produces="text/html;charset=UTF-8")
	public String getUserRecieveOrder(HttpSession session,PageUtil pageUtil,Orderform order){
		JSONArray jsonArray=orderService.getUserRecieveOrder(session,pageUtil,order);
		return jsonArray.toString();
	}
	
	/**
	 * ���յ��Ķ���-�ܼ�¼��
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserRecieveOrderTotalRowsAjax")
	public Integer getUserRevieveOrderTotalRows(HttpSession session,Orderform order){
		return orderService.getUserRecieveOrderTotalRows(session,order);
	}

	/**
	 * �ύ��������
	 * @param id
	 * @return
	 */
	@RequestMapping("/sendorderdetail")
	public ModelAndView getSendOrderDetail(@RequestParam String id) {
		OrderCarrierView sendorderdetail = orderService.getSendOrderDetail(id);
		mv.addObject("sendorderdetail", sendorderdetail);

		mv.setViewName("mgmt_d_order_s4");

		return mv;
	}

	/**
	 * �յ���������
	 * @param id
	 * @return
	 */
	@RequestMapping("/recieveorderdetail")
	public ModelAndView getAllRecieveOrderDetail(@RequestParam String id) {
		Orderform recieveorderdetail = orderService.getRecieveOrderDetail(id);
		mv.addObject("recieveorderdetail", recieveorderdetail);
		mv.setViewName("mgmt_d_order_r3");

		return mv;
	}

	/**
	 * ��ȡ���¶�����
	 * @param orderId
	 * @return
	 */
	@RequestMapping("getUpdateOrderForm")
	public ModelAndView getUpdateOrderForm(String orderId) {

		OrderCarrierView orderCarrierView = orderService
				.getOrderByOrderId(orderId);// ����ͼ��

		mv.addObject("orderinfo", orderCarrierView);
		mv.setViewName("mgmt_d_order_s3");
		return mv;
	}

	/**
	 * ��ȡ�����
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("acceptOrderForm")
	public ModelAndView getAcceptOrderForm(String orderid,
			HttpServletRequest request, HttpServletResponse response) {
		// ��Ҫ�����˾˾���б� add by RussWest0 at 2015��6��7��,����7:56:32 
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List<Driverinfo> driverList=driverService.getAllDriver(carrierId);
		String drivers = "";
		for(int i=0;i<driverList.size();i++){
			Driverinfo driver = driverList.get(i);
			if(i!=driverList.size()-1){
			    drivers = drivers + driver.getDriverName() + ",";
			}else{
				drivers = drivers + driver.getDriverName();
			}
		}
		mv.addObject("drivers",drivers);
		mv.addObject("driverList", driverList);
		//��Ҫ�����˾���ƺ��б�add by solitudeycq at 2015-12-24 0:46
		List<Carinfo> carNumList=carService.getAllcarNum(carrierId);
		String carNums ="";
		for(int i=0;i<carNumList.size();i++){
			Carinfo car = carNumList.get(i);
			if(i!=carNumList.size()-1){
			    carNums = carNums + car.getCarNum() + ",";
			}else{
				carNums = carNums + car.getCarNum();
			}
		}
		mv.addObject("carNums", carNums);
		mv.addObject("carNumList", carNumList);
		mv.addObject("orderId", orderid);
		mv.setViewName("mgmt_d_order_r2");
		return mv;
	}

	/**add comment by solitudeycq at 2015-12-19 13:48
	 * �������---�˴�����ʵ��Ϊ��������˾��
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("acceptOrder")
	public String acceptOrder(String orderid, HttpServletRequest request,
			HttpServletResponse response,AcceptOrderBean acceptorderBean) {
		
		orderService.acceptOrder(orderid,acceptorderBean);
		return "redirect:recieveorderinfo";
	}
	

	/**
	 * ��ȡǩ���ϴ���
	 * @param orderid
	 * @return
	 */
	@RequestMapping("getSignBillForm")
	public ModelAndView getSignBillForm(String orderid) {
		// �ϴ�ͼƬ�����ʵ���˷ѣ��޸Ķ���״̬Ϊ��ȷ��
		// ��Ҫ��ҳ������ʾ��ͬ�涨�˷Ѻ�Ԥ���˷�
		// �ϴ�ͼƬδʵ��
		float expectedMoney = orderService.getExpectedMoney(orderid);
		// System.out.println("ǩ���ϴ�+orderid+" + orderid);
		mv.addObject("expectedPrice", expectedMoney);
		mv.addObject("orderId", orderid);
		mv.setViewName("mgmt_d_order_r6");
		return mv;
	}

	/**
	 * ǩ���ϴ�
	 * @param file
	 * @param orderid
	 * @param actualPrice
	 * @param explainReason
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("signBill")
	public String SignBill(@RequestParam(required = false) MultipartFile file,String orderid, float actualPrice,
			String explainReason, HttpServletRequest request,
			HttpServletResponse response) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);

		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "signBill");
		orderService.signBill(orderid, actualPrice,
				explainReason,fileLocation);

		return "redirect:recieveorderinfo";
	}

	/**
	 * ��ȡȷ���ջ���
	 * @param orderid
	 * @return
	 */
	@RequestMapping("getConfirmForm")
	public ModelAndView getConfirmForm(String orderid) {
		// ����ȷ���ջ�ҳ��
		// ��Ҫ�涨���ã�ʵ�ʷ��ã�˵��
		Orderform order = orderService.getOrderInfo(orderid);
		Float expectedPrice = order.getExpectedPrice();
		Float actualPrice = order.getActualPrice();
		String explianReason = order.getExplainReason();
		mv.addObject("orderId", orderid);
		mv.addObject("expectedPrice", expectedPrice);
		mv.addObject("actualPrice", actualPrice);
		mv.addObject("explainReason", explianReason);
		mv.setViewName("mgmt_d_order_s5");
		return mv;
	}

	@RequestMapping("confirm")
	public String confirm(String orderid, HttpServletRequest request,
			HttpServletResponse response) {
		// �޸Ķ���Ϊ������
		boolean flag = orderService.confirmCargo(orderid);
		mv.addObject("orderId", orderid);


		return "redirect:turnToOrderPage";
	}

	@RequestMapping("getCommentForm")
	/**
	 * ��ȡ����ҳ��
	 * @param orderid
	 * @return
	 */
	public ModelAndView getCommentForm(String orderid,String ordernum)
	{

		mv.addObject("orderId", orderid);
		mv.addObject("orderNum", ordernum);
		mv.setViewName("mgmt_d_order_s8");
		return mv;
	}

	@RequestMapping("comment")
	public ModelAndView comment(String orderid, int serviceAttitude,
			int transportEfficiency, int cargoSafety, int totalMoney,
			HttpServletRequest request, HttpServletResponse response) {
		//FIXME
		// �޸Ķ���״̬Ϊ�����
		// �洢��������
		// ����ҳ�����

		return mv;
	}

	/**
	 * ��ȡ���¶���ҳ��
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "updateOrder")
	public ModelAndView getUpdateOrderPage(@RequestParam("orderid") String orderid,
			HttpServletRequest request) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s3");
		return mv;
	}

	
	/**
	 * ���¶���
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("doUpdate")
	public String updateOrder(HttpSession session,OrderBean orderBean){
		
		orderService.updateOrder(session, orderBean);
		return "redirect:turnToOrderPage";
		
	}

	/**
	 * ȡ������
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "cancelOrder")
	public ModelAndView cancelOrder(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s9");
		return mv;
	}

	/**
	 * ȡ������
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderCancelOrder")
	public ModelAndView getOrderCancelOrder(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r7");
		return mv;
	}

	/**
	 * ȡ������
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "doCancel", method = RequestMethod.POST)
	public String doCancel(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String cancelReason,
			String orderid) {
		boolean flag = orderService.cancel(cancelReason, orderid);
		return "redirect:turnToOrderPage";
	}

	/**
	 * ȡ������
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDoCancel", method = RequestMethod.POST)
	public String getOrderDoCancel(HttpServletRequest request,
			HttpServletResponse response, @RequestParam String cancelReason,
			String orderid) {
		 orderService.cancel(cancelReason, orderid);
		return "redirect:recieveorderinfo";
	}

	@RequestMapping(value = "orderDetail")
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	public ModelAndView orderDetail(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s4");
		return mv;
	}

	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "orderDetailWaitToReceive")
	public ModelAndView orderDetailWaitToReceive(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s6");
		return mv;
	}

	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "orderDetailAlreadyCancel")
	public ModelAndView orderDetailAlreadyCancel(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s4a");
		return mv;
	}

	/**
	 * 
	 * ������ɺ�鿴����
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "orderDetailFinish")
	public ModelAndView orderDetailFinish(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		List<WayBill> waybills = waybillService.getAllWayBillNumsPictureByOrderId(orderid);
		mv.addObject("waybills", waybills);
		//ҳ����Ҫ������Ϣ add by RussWest0 at 2015��6��7��,����4:04:16 
		Comment comment=commentService.getCommentByOrderId(orderid);
		mv.addObject("comment", comment);
		mv.setViewName("mgmt_d_order_s6a");
		return mv;
	}

	@RequestMapping(value = "orderDetailComment")
	public ModelAndView orderDetailComment(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		List<WayBill> waybills = waybillService.getAllWayBillNumsPictureByOrderId(orderid);
		mv.addObject("waybills", waybills);
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_s6b");
		return mv;
	}

	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDetail")
	public ModelAndView getOrderDetail(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r3");
		return mv;
	}

	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDetailCancel")
	public ModelAndView getOrderDetailCancel(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r3a");
		return mv;
	}

	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDetailWaitToReceive")
	public ModelAndView getOrderDetailWaitToReceive(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r4");
		return mv;
	}
	
	/**
	 * 
	 * 
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDetailWaitToConfirm")
	public ModelAndView getOrderDetailWaitToConfirm(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		List<WayBill> waybills = waybillService.getAllWayBillNumsPictureByOrderId(orderid);
		mv.addObject("waybills", waybills);
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r4a");
		return mv;
	}

	/**
	 * 
	 * ���˷�-���յ��Ķ���-�����-�鿴
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value = "getOrderDetailFinish")
	public ModelAndView getOrderDetailFinish(HttpServletRequest request,
			HttpServletResponse response, String orderid) {
		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		List<TrackBean> loc = trackService.getTrackBeanByOrderIdAsc(orderid);
		String[] carNums = (orderInfo.getCarNum()).split(",");
		int length = loc.size();
		mv.addObject("length", length);
		mv.addObject("loc", loc);
		mv.addObject("carNums", carNums);
		mv.addObject("orderInfo", orderInfo);
		List<WayBill> waybills = waybillService.getAllWayBillNumsPictureByOrderId(orderid);
		mv.addObject("waybills", waybills);
		//ҳ����Ҫ������Ϣ
		Comment comment=commentService.getCommentByOrderId(orderid);
		mv.addObject("comment",comment);
		mv.setViewName("mgmt_d_order_r4b");
		return mv;
	}

	@RequestMapping("getOrderWaitToConfirmUpdate")
	public ModelAndView getOrderWaitToConfirmUpdate(String orderid) {

		// ��Ҫ��ҳ������ʾ��ͬ�涨�˷Ѻ�Ԥ���˷�,ʵ���˷�,ԭ��
		// �ϴ�ͼƬδʵ��

		OrderCarrierView orderInfo = orderService.getOrderByOrderId(orderid);
		mv.addObject("orderInfo", orderInfo);
		mv.setViewName("mgmt_d_order_r6a");
		return mv;
	}

	/**
	 * ���˷�ǩ���ϴ���ĸ���
	 * @param orderid
	 * @param actualPrice
	 * @param explainReason
	 * @param request
	 * @param response
	 * @param file
	 * @return
	 */
	@RequestMapping("updateSignBill")
	public String updateSignBill(String orderid,
			float actualPrice, String explainReason,
			HttpServletRequest request, HttpServletResponse response,@RequestParam(required = false) MultipartFile file) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);

		String fileLocation=UploadFile.uploadFile(file, carrierId, "signBill");
		orderService.updateSignBill(orderid,
				actualPrice, explainReason,fileLocation);
		return "redirect:recieveorderinfo";
	}

	@RequestMapping("getneworderform")
	/**
	 * ��ȡ����������
	 * @return
	 */
	public ModelAndView getNewOrderForm(@RequestParam String carrierid,
			@RequestParam(required=false) String resourceId,@RequestParam int flag) {
		// ��Ҫȡ�����˷���˾����
		//flag��resourceType�б�ʶ1Ϊ������2Ϊ����䣬3Ϊ����,4Ϊ��˾,5Ϊ�㵣,6Ϊ���ڿ���
		int resourceType = 0;
		if(flag==4){//�ӹ�˾ҳ���ύ����
			Carrierinfo carrierInfo=companyService.getCompanyById(carrierid);
			mv.addObject("carrierInfo", carrierInfo);
			mv.addObject("carrierId", carrierid);
			
			mv.setViewName("mgmt_d_order_s2a");
			return mv;
		}
		if(flag==1){//��������Դ�ύ����
			Truck truckInfo = fulltruckloadService.getfulltruckloadInfo(resourceId);
			resourceType = 1;
			mv.addObject("resourceType", resourceType);
			mv.addObject("truckInfo", truckInfo);
		}
		if(flag==2){// ������������ύ����
			Cityline citylineInfo = citylineService.getCitylineInfo(resourceId);
			resourceType = 2;
			mv.addObject("resourceType", resourceType);
			mv.addObject("citylineInfo", citylineInfo);
		}
		if(flag==3){//�ӳ�����Դ�ύ����
			Carinfo carInfo = carService.getCarInfo(resourceId);
			resourceType = 3;
			mv.addObject("resourceType", resourceType);
			mv.addObject("carInfo", carInfo);
		}
		if(flag==5){//���㵣��Դ�ύ����
			Truck truckInfo = lesstruckloadService.getLesstruckloadInfo(resourceId);
			resourceType = 5;
			mv.addObject("resourceType", resourceType);
			mv.addObject("truckInfo", truckInfo);
		}
		if(flag==6){//�ӹ��ڿ�����Դ�ύ����
			AirLine airlineInfo = airlineService.getAirLineInfo(resourceId);
			resourceType = 6;
			mv.addObject("resourceType", resourceType);
			mv.addObject("airlineInfo", airlineInfo);
		}
		Carrierinfo company=companyService.getCompanyById(carrierid);
		mv.addObject("company", company);
		mv.addObject("companyName", company.getCompanyName());
		mv.addObject("carrierId", carrierid);
		mv.setViewName("mgmt_d_order_s2");
		return mv;
	}

	
	
	/**
	 * �½�����
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("createneworder")
	public String createNewOrder(HttpSession session,OrderBean orderBean){
		orderService.createOrder(session,orderBean);
		
		return "redirect:turnToOrderPage";
	}
	
	
	/**
	 * ���ҵĻ������¶���
	 * @param session
	 * @param orderBean
	 * @return
	 */
	@RequestMapping("createOrderFromCargo")
	public String createOrderFromCargo(HttpSession session,OrderBean orderBean){
		boolean flag=orderService.createOrder(session,orderBean);
		String goodsId=orderBean.getGoodsId();
		String responseId=orderBean.getResponseId();
		String carrierId=orderBean.getCarrierId();
		if (flag == true) {
			//�������޸�״̬
			responseService.confirmResponse(responseId,carrierId,goodsId);//�޸�ȷ�Ϸ�����ϢΪ��ȷ�ϣ�����������ϢΪ��ȡ��״̬
			//������޸�״̬
			goodsInfoService.confirmResponse(goodsId);
			return "redirect:turnToOrderPage";
		}
		return "redirect:mgmt_d_order_s";
	}
	/**
	 * ����ǩ��ͼƬ
	 * 
	 */
	@RequestMapping(value="downloadwaybillpicture",method=RequestMethod.GET)
	public ModelAndView downloadwaybillnumpicture(@RequestParam String id,
			HttpServletRequest request,HttpServletResponse response){
		WayBill waybill = waybillService.getWayBillInfoById(id);
		String file = waybill.getPicture();
		DownloadFile.downloadFile(file, request, response);
		return mv;
	}

}

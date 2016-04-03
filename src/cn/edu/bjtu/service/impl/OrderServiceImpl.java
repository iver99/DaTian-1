package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.AcceptOrderBean;
import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.dao.OrderCarrierViewDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.WayBillDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Driverinfo;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.WayBill;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author RussWest0
 *
 */
@Transactional
@Repository
public class OrderServiceImpl implements OrderService {

	@Resource
	OrderDao orderDao;
	@Autowired
	DriverDao driverDao;
	@Autowired
	CompanyDao companyDao;
	@Autowired
	AddressDao addressDao;
	@Autowired
	DriverService driverService;
	@Autowired
	OrderCarrierViewDao orderCarrierViewDao;
	@Autowired
	WayBillDao waybillDao;
	@Resource(name = "carServiceImpl")
	CarService carService;
	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, id);
	}

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		
		return orderDao.get(Orderform.class, id);
	}

	/**
	 * 通过订单编号获取某订单id
	 */
	@Override
	public Orderform getOrderByOrderNum(String orderNum) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderNum", orderNum);
		return orderDao.get("from Orderform where orderNum=:orderNum",params);
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, orderId);
	}
	/**
	 * 承运方修改订单状态为待收货
	 */
	@Override
	public boolean acceptOrder(String orderId,AcceptOrderBean acceptorderBean) {
		Orderform order = orderDao.get(Orderform.class, orderId);
		String strdriver = acceptorderBean.getDrivers();
		String strcarNum = acceptorderBean.getCarNums();
		String strwaybill = acceptorderBean.getWayBillNums();
		//分解三个参数
		String[] tempdrivers = strdriver.split(",");
		String[] tempcarNums = strcarNum.split(",");
		String[] tempwaybills = strwaybill.split(",");
		//除去三个参数中的为null的项
		String driver = null;
		String carNum = null;
		String waybill = null;
		for(int j=0;j<tempdrivers.length;j++){
			if((!(tempdrivers[j]==null))&&(!(tempdrivers[j].equals("")))&&(!(tempdrivers[j].equals("null")))){
				if(j==0){
					driver = tempdrivers[j];
					carNum = tempcarNums[j];
					waybill = tempwaybills[j];
				}else{
					driver = driver + "," +tempdrivers[j];
					carNum = carNum + "," + tempcarNums[j];
					waybill = waybill + "," + tempwaybills[j];
				}
			}
		}
		//生成运单
		String[] drivers = driver.split(",");
		String[] carNums = carNum.split(",");
		String[] waybills = waybill.split(",");
		for(int i=0;i<drivers.length;i++){
			    WayBill wayBill = new WayBill();
			    wayBill.setId(IdCreator.createWayBillId());
			    wayBill.setOrderId(orderId);
			    wayBill.setOrderNum(order.getOrderNum());
			    wayBill.setWaybillNum(waybills[i]);
			    wayBill.setDriver(drivers[i]);
			    wayBill.setCarNum(carNums[i]);
			    wayBill.setConfirm("false");
			    wayBill.setDeliveryAddr(order.getDeliveryAddr());
			    wayBill.setDeliveryName(order.getDeliveryName());
			    wayBill.setDeliveryPhone(order.getDeliveryPhone());
			    wayBill.setRecieverAddr(order.getRecieverAddr());
			    wayBill.setRecieverName(order.getRecieverName());
			    wayBill.setRecieverPhone(order.getRecieverPhone());
			    wayBill.setWaybillSubTime(new Date());
			    wayBill.setWaybillState("未确认");
			    wayBill.setGoodsName(order.getGoodsName());
			    wayBill.setGoodsVolume(order.getGoodsVolume());
			    wayBill.setGoodsWeight(order.getGoodsWeight());
			    wayBill.setResourceName(order.getResourceName());
			    waybillDao.save(wayBill);
			    carService.setcarState(carNums[i], "在途");
		}
		order.setState("待收货");
		order.setDriver(driver);
		order.setCarNum(carNum);
		order.setClientWayBillNum(waybill);
		orderDao.update(order);
		return true;
	}
	
	@Override
	public boolean setcompleteNumber(String orderId, Float price) {
		Orderform order = orderDao.get(Orderform.class, orderId);
		order.setActualPrice(price);
		order.setState("待评价");
		
		orderDao.update(order);
		return true;
	}

	@Override
	/**
	 * 返回预期运费
	 */
	public float getExpectedMoney(String orderId) {
		
		List list = orderDao.find("select expectedPrice from Orderform where id='" + orderId + "'");
		if (list != null)
		{
			//Orderform order=(Float)list.get(0);
			return ((Float)list.get(0)).floatValue();
		}
		else
			return 0.0f;
	}

	/**
	 * 签单上传操作
	 */
	@Override
	public boolean signBill(String orderId, float actualPrice,
			String explainReason,String fileLocation) {
		Orderform order = orderDao.get(Orderform.class, orderId);
		order.setState("待评价");//修改 订单状态
		Date finishDate = new Date();
		order.setFinishTime(finishDate);
		order.setActualPrice(actualPrice);
		order.setExplainReason(explainReason);
		order.setAcceptPicture(fileLocation);
		if(!((order.getResourceType()).equals("落地配"))){
			long onwayTime = (order.getOnwayTime())*60*60*1000;
			long finishTime = finishDate.getTime();
			long subTime = order.getSubmitTime().getTime();
			long realOnwaytime = finishTime - subTime;
			if(realOnwaytime<=onwayTime){
				order.setIsOntime(1);
			}
		}
		
		orderDao.update(order);
		return true;
		
	}

	@Override
	public Orderform getOrderInfo(String orderId) {
		
		return orderDao.get(Orderform.class, orderId);
	}

	/**
	 * 确认收货操作
	 */
	@Override
	public boolean confirmCargo(String orderId) {
		Orderform order=orderDao.get(Orderform.class, orderId);
		order.setState("待评价");
		
		orderDao.update(order);
		return true;
	}

	/**
	 * cancel order
	 */
	@Override
	public boolean cancel(String cancelReason, String orderId) {
		Orderform order=orderDao.get(Orderform.class, orderId);
		order.setCancelReason(cancelReason);
		order.setState("已取消");
		order.setFinishTime(new Date());
		
		orderDao.update(order);
		return true;
	}

	

	/**
	 * 承运方签单上传后的更新
	 */
	@Override
	public boolean updateSignBill(String orderId,
			float actualPrice, String explainReason,String fileLocation) {
		
		Orderform order=orderDao.get(Orderform.class, orderId);
		order.setActualPrice(actualPrice);
		order.setExplainReason(explainReason);
		order.setAcceptPicture(fileLocation);
		
		orderDao.update(order);
		
		return true;
		//return orderDao.signBill(orderId, actualPrice, explainReason,path,fileName);
	}

	/**
	 * 更新订单
	 */
	@Override
	public boolean updateOrder(HttpSession session, OrderBean orderBean) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Orderform orderInstance=orderDao.get(Orderform.class,orderBean.getId());

		orderInstance.setClientName(orderBean.getClientName());
		orderInstance.setIsLinkToClientWayBill(orderBean.getIsLinkToClientWayBill());
		orderInstance.setClientWayBillNum(orderBean.getClientWayBillNum());
		orderInstance.setContractId(orderBean.getContractId());
		orderInstance.setHasCarrierContract(orderBean.getHasCarrierContract());
		
		orderInstance.setGoodsName(orderBean.getGoodsName());
		orderInstance.setGoodsVolume(orderBean.getGoodsVolume());
		orderInstance.setGoodsWeight(orderBean.getGoodsWeight());
		orderInstance.setDeclaredPrice(orderBean.getDeclaredPrice());
		orderInstance.setInsurance(orderBean.getInsurance());
		orderInstance.setExpectedPrice(orderBean.getExpectedPrice());
		
		orderInstance.setDeliveryAddr(orderBean.getDeliveryAddr());
		orderInstance.setDeliveryName(orderBean.getDeliveryName());
		orderInstance.setDeliveryPhone(orderBean.getDeliveryPhone());
		orderInstance.setRecieverAddr(orderBean.getRecieverAddr());
		orderInstance.setRecieverName(orderBean.getRecieverName());
		orderInstance.setRecieverPhone(orderBean.getRecieverPhone());
		
		orderInstance.setRemarks(orderBean.getRemarks());
		
		orderDao.update(orderInstance);
		
		//如果需要，保存常用收发货地址
		saveAddress(orderBean, userId);
		
		return true;
		
	}

	
	/**
	 * 新建订单
	 */
	@Override
	public boolean createOrder(HttpSession session, OrderBean orderBean) {

		String userId=(String)session.getAttribute(Constant.USER_ID);
		Orderform orderInstance=new Orderform();
		BeanUtils.copyProperties(orderBean, orderInstance);
		orderInstance.setId(IdCreator.createOrderId());
		orderInstance.setOrderNum(IdCreator.createOrderNum());
		orderInstance.setState("待受理");
		orderInstance.setSubmitTime(new Date());
		orderInstance.setClientId(userId);
		orderInstance.setSettlementState("未生成");
		orderInstance.setSettlementStateCompany("未生成");
		orderInstance.setIsOntime(0);
		orderInstance.setFlag(1);
		
		orderDao.save(orderInstance);
		
		saveAddress(orderBean, userId);
				
		return true;
	}
	
	//如果选中了保存常用地址，则进行常用地址保存
    //发货人信息 
	private void saveAddress(OrderBean orderBean, String userId) {
		
		if("on".equals(orderBean.getSender_info())){
			Address address=new Address();
			address.setName(orderBean.getDeliveryName());
			address.setPhone(orderBean.getDeliveryPhone());
			address.setAddress(orderBean.getDeliveryAddr());
			address.setId(IdCreator.createAddressId());
			address.setRelDate(new Date());
			address.setClientId(userId);
			address.setKind(1);
			addressDao.save(address);
			
		}
		//收货人信息
		if("on".equals(orderBean.getReciever_info())){
			Address address=new Address();
			address.setName(orderBean.getRecieverName());
			address.setPhone(orderBean.getRecieverPhone());
			address.setAddress(orderBean.getRecieverAddr());
			address.setId(IdCreator.createAddressId());
			address.setRelDate(new Date());
			address.setClientId(userId);
			address.setKind(2);
			addressDao.save(address);
		}
	}

	/**
	 * 返回用户待受理订单数
	 */
	@Override
	public Long getUserWaitToAcceptNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and t.state='待受理'";
		Long count= orderDao.count(hql, params);
		return count==null?0L:count;
		
	}

	/**
	 * 返回用户待接收订单数
	 */
	@Override
	public Long getUserWaitToReceiveNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and t.state='待收货'";
		Long count =orderDao.count(hql, params);
		return count==null?0L:count;
	}

	/**
	 * 返回用户待结算订单数
	 */
	@Override
	public Long getUserWaitToSettleNum(HttpSession session) {
		/*String hql="from Orderform t where t.state=''";
		Map<String,Object> params=new HashMap<String,Object>();
		return orderDao.count(hql+whereSql(session,params), params);*/
		return 0L;
	}

	/**
	 * 返回用户已完成订单数
	 */
	@Override
	public Long finishedNum(HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Orderform t "+whereSql(session,params)+" and  t.state='已完成'";
		Long count =orderDao.count(hql, params);
		return count==null?0L:count;
	}
	
	/**
	 * where sql 
	 * @param session
	 * @param params
	 * @return
	 */
	private String whereSql(HttpSession session,Map<String,Object> params){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String wheresql=" where 1=1 ";
		if(userKind==2){//个人用户
			wheresql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind==3){//企业用户
			wheresql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		
		return wheresql;
		
	}

	/*
	 * 我提交的订单总记录数(non-Javadoc)
	 * @see cn.edu.bjtu.service.OrderService#getUserSendOrderTotalRows(javax.servlet.http.HttpSession)
	 */
	@Override
	public Integer getUserSendOrderTotalRows(HttpSession session,Orderform order) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Orderform t "+whereHql(order,params);
		hql+=" and t.clientId=:clientId";
		params.put("clientId", userId);
		
		Long count=orderDao.count(hql, params);
		
		return count.intValue();
	}

	/**
	 * 我提交的订单
	 */
	@Override
	public JSONArray getUserSendOrder(HttpSession session,PageUtil pageUtil,Orderform order) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Orderform t "+whereHql(order,params);
		hql+=" and t.clientId=:clientId order by t.submitTime desc";
		params.put("clientId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> orderList=orderDao.find(hql,params,page,display);
		List<OrderBean> beanList=new ArrayList<OrderBean>();
		for(Orderform orderIns:orderList){
			OrderBean bean=new OrderBean();
			BeanUtils.copyProperties(orderIns, bean);
			Carrierinfo company=companyDao.get(Carrierinfo.class, orderIns.getCarrierId());
			
			bean.setCompanyName(company.getCompanyName());
			beanList.add(bean);
		}
		
		JSONArray jsonArray=new JSONArray();
		for(OrderBean orderBean:beanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(orderBean);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	/**
	 * where hql 用于搜索功能
	 * @param order
	 * @param params
	 * @return
	 */
	private String whereHql(Orderform order,Map<String,Object> params){
		String hql=" where 1=1 ";
		if(order!= null){
			if(!"".equals(order.getOrderNum()) && order.getOrderNum() !=null){
				hql+=" and t.orderNum like '%"+order.getOrderNum()+"%'";
			}
		}
		return hql;
	}
	
	/**
	 * 我收到的订单
	 */
	@Override
	public JSONArray getUserRecieveOrder(HttpSession session,PageUtil pageUtil,Orderform order) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Orderform t "+whereHql(order,params);
		hql+=" and t.carrierId=:carrierId order by t.submitTime desc";
		params.put("carrierId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> orderList=orderDao.find(hql,params,page,display);
		List<OrderBean> beanList=new ArrayList<OrderBean>();
		for(Orderform orderIns:orderList){
			OrderBean bean=new OrderBean();
			BeanUtils.copyProperties(orderIns, bean);
			Carrierinfo company=companyDao.get(Carrierinfo.class, orderIns.getCarrierId());
			
			bean.setCompanyName(company.getCompanyName());
			beanList.add(bean);
		}
		
		JSONArray jsonArray=new JSONArray();
		for(OrderBean orderBean:beanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(orderBean);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	/**
	 * 我收到的订单-总记录数
	 */
	@Override
	public Integer getUserRecieveOrderTotalRows(HttpSession session,Orderform order) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Orderform t "+whereHql(order,params);
		hql+=" and t.carrierId=:carrierId";
		params.put("carrierId", userId);
		
		Long count=orderDao.count(hql, params);
		
		return count.intValue();
	}	
}

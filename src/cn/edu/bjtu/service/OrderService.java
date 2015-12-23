package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

import com.alibaba.fastjson.JSONArray;

public interface OrderService {

	public OrderCarrierView getSendOrderDetail(String id);

	public Orderform getRecieveOrderDetail(String id);
	
	//add by solitudeycq at 2015-12-19 17:21
	//获取订单
	public List<Orderform> getOrderByDriverName(String driver);

	public Orderform getOrderByOrderNum(String orderNum);

	public OrderCarrierView getOrderByOrderId(String orderId);

	public boolean acceptOrder(String orderId);
	
	//add by solitudeycq at 2015-12-18 22:21 为订单分配司机
	public boolean setDriver(String orderId,String driver);
	//add by solitudeycq at 2015-12-24 1:52 为订单分配车牌号
	public boolean setcarNum(String orderId,String carNum);
	
	//add by solitudeycq at 2015-12-23 14:12司机确认
	public boolean setConfirm(String orderId);

	public float getExpectedMoney(String orderId);

	public boolean signBill(String orderId, float actualPrice,
			String explainReason,String fileLocation);

	public Orderform getOrderInfo(String orderId);

	public boolean confirmCargo(String orderId);

	public boolean cancel(String cancelReason, String orderId);
	public boolean updateSignBill(String orderId,
			float actualPrice, String explainReason,String fileLocation);
	

	
	/**
	 * 返回用户待受理订单数
	 * @param session
	 * @return
	 */
	public Long getUserWaitToAcceptNum(HttpSession session);
	
	/**
	 * 返回用户待收货订单数
	 * @param session
	 * @return
	 */
	public Long getUserWaitToReceiveNum(HttpSession session);
	
	/**
	 * 返回用户待结算数目 
	 * @param session
	 * @return
	 */
	public Long getUserWaitToSettleNum(HttpSession session);
	
	/**
	 * 返回用户已完成订单数
	 * @param session
	 * @return
	 */
	public Long finishedNum(HttpSession session);
	
	/**
	 * 新建订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean createOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * 更新订单
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean updateOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * 我提交的订单-总记录数
	 * @param session
	 * @return
	 */
	public Integer getUserSendOrderTotalRows(HttpSession session,Orderform order);
	
	/**
	 *  我提叫的订单
	 * @param session
	 * @return
	 */
	public JSONArray getUserSendOrder(HttpSession session,PageUtil pageUtil,Orderform order);

	/**
	 * 我收到的订单
	 * @param session
	 * @return
	 */
	public JSONArray getUserRecieveOrder(HttpSession session,PageUtil pageUtil,Orderform order);
	
	/**
	 * 我收到的订单-总记录是
	 * @param session
	 * @return
	 */
	public Integer getUserRecieveOrderTotalRows(HttpSession session,Orderform order);

}

package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

public interface OrderDao extends BaseDao<Orderform> {
	public OrderCarrierView getSendOrderDetail(String id);
	public Orderform getRecieveOrderDetail(String id);
	/**
	 * 根据订单编号获取订单
	 * @param orderNum
	 * @return
	 */
	public Orderform getOrderByOrderNum(String orderNum);
	
	public List<Orderform> getOrderByDriverName(String driver);
	
	public OrderCarrierView getOrderByOrderId(String orderId);
	
	public boolean acceptOrder(String orderId);
	
	
	//add by solitudeycq at 2015-12-18 22:09 修改订单里的司机
	public boolean setDriver(String orderId,String driver);
	
	//add by solitudeycq at 2015-12-24 1:54 修改订单里的carNum
	public boolean setcarNum(String orderId,String carNum);
	
	//add by solitudeycq at 2015-12-23 14:07 司机确认
	public boolean setConfirm(String orderId);
	
	public boolean setState(String orderId,String state);
	
	public boolean setcompleteNumber(String orderId, Float price);
	
	public float getExpectedMoney(String orderId);
	
	
	public Orderform getOrderInfo(String orderId);
	
	public boolean confirmCargo(String orderId);
	
	public boolean cancel(String cancelReason,String orderId);
	
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,float actualPrice,String explainReason);

	public boolean createNewOrder(String userId,String hasCarrierContract,String remarks,
			String goodsName,float goodsVolume,float goodsWeight,float expectedPrice,
			float declaredPrice,float insurance,String contractId,String deliveryName,
			String deliveryPhone,String deliveryAddr,String receiverName,String receiverPhone,
			String receiverAddr,String carrierId,String isLinkToClientWayBill,
			String clientWayBillNum, String resourceName, String resourceType,String companyName,String clientName);
	
	
	
}

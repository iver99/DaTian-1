package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.dao.WayBillDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.WayBill;

/**
 * @author solitudeycq
 *
 */
@Transactional
@Repository
public class WayBillServiceImpl implements WayBillService {
    
	@Autowired
	WayBillDao waybillDao;
	@Autowired
	OrderService orderService;
	@Autowired
	TrackDao trackDao;
	@Autowired
	CarService carService;
	@Autowired
	OrderDao orderDao;
	
	@Override
	public List<WayBill> getWayBillByDriverName(String driver) {
		String hql="from WayBill where driver=:driver";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("driver", driver); 
		return waybillDao.find(hql, params);
	}

	@Override
	public WayBill getWayBillBywaybillNum(String waybillNum) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("waybillNum", waybillNum);
		return waybillDao.get("from WayBill where waybillNum=:waybillNum",params);
	}

	@Override
	public boolean setConfirm(String waybillId) {
		//更改运单表相关字段
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setConfirm("true");
		waybill.setWaybillState("已确认");
		waybillDao.update(waybill);
		return true;
	}

	@Override
	public boolean startTask(String waybillId) {
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setWaybillState("运输中");
		waybillDao.update(waybill);
		return true;
	}
	@Override
	public boolean finishTask(String waybillNum, String price, String picture) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("waybillNum", waybillNum);
		Float realPrice = Float.parseFloat(price);
		WayBill waybill = waybillDao.get("from WayBill where waybillNum=:waybillNum",params);
		waybill.setWaybillState("已签收");
		waybill.setWaybillFinishTime(new Date());
		waybill.setPrice(realPrice);
		//存储图片，地址存入运单表
		String savePath = UploadFile.mobileuploadFile(picture, waybillNum);
		waybill.setPicture(savePath);
		//检查订单状态是否可以修改为待评价，如果可以则设置
		String orderId = waybill.getOrderId();
		Orderform order = orderService.getOrderInfo(orderId);
		List<WayBill> waybills = waybillDao.find("from WayBill where orderId="+"'"+orderId+"'"+" "+"and "+"waybillNum!="+"'"+waybillNum+"'");
		if(waybills.size()!=0){
		   for(int i=0;i<waybills.size();i++){
			   WayBill tempwaybill = (WayBill)waybills.get(i);
			   System.out.println(tempwaybill.getWaybillState());
			   if((tempwaybill.getWaybillState()).equals("已签收")){
				   if(i==(waybills.size())-1){
					   order.setState("待评价");
					   order.setFinishTime(new Date());
				   }
			   }
		   }
		}else{
			order.setFinishTime(new Date());
			order.setState("待评价");
		}
		//设置订单运费
		Float actualPrice = order.getActualPrice();
		if(actualPrice!=null){
			actualPrice = actualPrice + realPrice;
		}else{
			actualPrice = realPrice;
		}
		order.setActualPrice(actualPrice);
		//设置签收图片保存位置,存入订单表
		String acceptPicture = order.getAcceptPicture();
		if((!(acceptPicture==null))&&(!(acceptPicture.equals("")))&&(!(acceptPicture.equals("null")))){
			acceptPicture = acceptPicture + "," + savePath;
		}else{
			acceptPicture = savePath;
		}
		order.setAcceptPicture(acceptPicture);
		//更新订单表和运单表
		orderDao.update(order);
		waybillDao.update(waybill);
		//更新汽车状态
		carService.setcarState(waybill.getCarNum(), "停歇");
		return true;
	}

}

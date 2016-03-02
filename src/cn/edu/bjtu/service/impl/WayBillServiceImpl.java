package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.dao.WayBillDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.WayBillService;
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
		waybill.setWaybillState("已接受");
		waybillDao.update(waybill);
		return true;
	}

	@Override
	public boolean startTask(String waybillId) {
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setWaybillState("运输中");
		/*Orderform order = orderService.getOrderInfo(waybill.getOrderId());
		Track track = new Track();
		track.setId(IdCreator.createTrackId());
		track.setOrderId(order.getId());
		track.setOrderNum(order.getOrderNum());
		track.setCarNum(waybill.getCarNum());
		track.setWaybillNum(waybill.getWaybillNum());
		track.setTime(ParseDate.DateToStringFull(new Date()));
		track.setEvent("已取件");
		trackDao.save(track);*/
		return true;
	}
	@Override
	public boolean finishTask(String waybillNum, String price, String picture) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("waybillNum", waybillNum);
		Float realPrice = Float.parseFloat(price);
		WayBill waybill = waybillDao.get("from WayBill where waybillNum=:waybillNum",params);
		waybill.setWaybillState("已签收");
		carService.setcarState(waybill.getCarNum(), "停歇");
		//应添加代码，检查订单状态是否可以设置为待评价，以及设置订单运费，以及签收图片
		//代码
		//代码
		return true;
	}

}

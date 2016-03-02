/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.dao.WayBillDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Track;
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
		//生成一条轨迹，将事件设置为已接受任务
		Orderform order = orderService.getOrderInfo(waybill.getOrderId());
		Track track = new Track();
		track.setId(IdCreator.createTrackId());
		track.setOrderId(order.getId());
		track.setOrderNum(order.getOrderNum());
		track.setCarNum(waybill.getCarNum());
		track.setWaybillNum(waybill.getWaybillNum());
		track.setTime(ParseDate.DateToStringFull(new Date()));
		track.setEvent("已接受任务");
		trackDao.save(track);
		waybillDao.update(waybill);
		return true;
	}

	@Override
	public boolean startTask(String waybillId) {
				WayBill waybill = waybillDao.get(WayBill.class, waybillId);
				//生成一条轨迹，将事件设置为已取件
				Orderform order = orderService.getOrderInfo(waybill.getOrderId());
				Track track = new Track();
				track.setId(IdCreator.createTrackId());
				track.setOrderId(order.getId());
				track.setOrderNum(order.getOrderNum());
				track.setCarNum(waybill.getCarNum());
				track.setWaybillNum(waybill.getWaybillNum());
				track.setTime(ParseDate.DateToStringFull(new Date()));
				track.setEvent("已取件");
				trackDao.save(track);
				return true;
	}

}

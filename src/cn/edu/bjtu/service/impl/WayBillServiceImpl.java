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
		//�����˵�������ֶ�
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setConfirm("true");
		waybill.setWaybillState("��ȷ��");
		//����һ���켣�����¼�����Ϊ�ѽ�������
		Orderform order = orderService.getOrderInfo(waybill.getOrderId());
		Track track = new Track();
		track.setId(IdCreator.createTrackId());
		track.setOrderId(order.getId());
		track.setOrderNum(order.getOrderNum());
		track.setWaybillNum(waybill.getWaybillNum());
		track.setTime((new Date()).toString());
		track.setEvent("�ѽ�������");
		trackDao.save(track);
		waybillDao.update(waybill);
		return true;
	}

	@Override
	public boolean startTask(String waybillId) {
				WayBill waybill = waybillDao.get(WayBill.class, waybillId);
				//����һ���켣�����¼�����Ϊ��ȡ��
				Orderform order = orderService.getOrderInfo(waybill.getOrderId());
				Track track = new Track();
				track.setId(IdCreator.createTrackId());
				track.setOrderId(order.getId());
				track.setOrderNum(order.getOrderNum());
				track.setWaybillNum(waybill.getWaybillNum());
				track.setTime((new Date()).toString());
				track.setEvent("��ȡ��");
				trackDao.save(track);
				return true;
	}

}
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
		//�����˵�������ֶ�
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setConfirm("true");
		waybill.setWaybillState("�ѽ���");
		waybillDao.update(waybill);
		return true;
	}

	@Override
	public boolean startTask(String waybillId) {
		WayBill waybill = waybillDao.get(WayBill.class, waybillId);
		waybill.setWaybillState("������");
		/*Orderform order = orderService.getOrderInfo(waybill.getOrderId());
		Track track = new Track();
		track.setId(IdCreator.createTrackId());
		track.setOrderId(order.getId());
		track.setOrderNum(order.getOrderNum());
		track.setCarNum(waybill.getCarNum());
		track.setWaybillNum(waybill.getWaybillNum());
		track.setTime(ParseDate.DateToStringFull(new Date()));
		track.setEvent("��ȡ��");
		trackDao.save(track);*/
		return true;
	}
	@Override
	public boolean finishTask(String waybillNum, String price, String picture) {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("waybillNum", waybillNum);
		Float realPrice = Float.parseFloat(price);
		WayBill waybill = waybillDao.get("from WayBill where waybillNum=:waybillNum",params);
		waybill.setWaybillState("��ǩ��");
		carService.setcarState(waybill.getCarNum(), "ͣЪ");
		//Ӧ��Ӵ��룬��鶩��״̬�Ƿ��������Ϊ�����ۣ��Լ����ö����˷ѣ��Լ�ǩ��ͼƬ
		//����
		//����
		return true;
	}

}

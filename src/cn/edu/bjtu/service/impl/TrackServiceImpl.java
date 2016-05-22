package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.TrackBean;
import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.service.TrackService;
import cn.edu.bjtu.service.WayBillService;
import cn.edu.bjtu.vo.Track;
import cn.edu.bjtu.vo.WayBill;

@Transactional
@Repository
public class TrackServiceImpl implements TrackService {
	
	@Resource
	TrackDao trackDao;
	@Resource
	WayBillService waybillService;

	@Override
	public boolean createNewTrack(String id, String orderId,String orderNum, String carNum,String event, Double locLongitude, Double locLatitude,
			String time, String address,String waybillNum) {
		Track track = new Track();
		track.setAddress(address);
		track.setCarNum(carNum);
		track.setId(id);
		track.setLocLatitude(locLatitude);
		track.setLocLongitude(locLongitude);
		track.setOrderId(orderId);
		track.setTime(time);
		track.setOrderNum(orderNum);
		track.setEvent(event);
		track.setWaybillNum(waybillNum);
		trackDao.save(track);
		
		return true;
	}

	@Override
	public List<Track> getTrackByOrderIdDesc(String orderId) {
		String hql="from Track where orderId=:orderId order by time desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderId", orderId);
		return trackDao.find(hql, params);
	}
	
	@Override
	public List<Track> getTrackByOrderIdAsc(String orderId) {
		String hql="from Track where orderId=:orderId order by time asc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderId", orderId);
		return trackDao.find(hql, params);
	}
	/* 
	 * 这个方法主要是在track中添加个driver
	 */
	@Override
	public List<TrackBean> getTrackBeanByOrderIdAsc(String orderId) {
		String hql="from Track where orderId=:orderId order by time asc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderId", orderId);
		List<Track> tracks = trackDao.find(hql, params);
		List<TrackBean> trackBeans = new ArrayList<TrackBean>();
		for(int i =0;i<tracks.size();i++){
			Track track = tracks.get(i);
			WayBill wayBill = waybillService.getWayBillBywaybillNum(track.getWaybillNum());
			TrackBean trackBean = new TrackBean();
			trackBean.setAddress(track.getAddress());
			trackBean.setCarNum(track.getCarNum());
			trackBean.setDriver(wayBill.getDriver());
			trackBean.setEvent(track.getEvent());
			trackBean.setId(track.getId());
			trackBean.setLocLatitude(track.getLocLatitude());
			trackBean.setLocLongitude(track.getLocLongitude());
			trackBean.setOrderId(track.getOrderId());
			trackBean.setOrderNum(track.getOrderNum());
			trackBean.setTime(track.getTime());
			trackBean.setWaybillNum(track.getWaybillNum());
			trackBeans.add(trackBean);
		}
		return trackBeans;
	}

	@Override
	public List<Track> getTrackByWayBillNumDesc(String waybillNum) {
		String hql = "from Track where waybillNum=:waybillNum order by time desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("waybillNum", waybillNum);
		return trackDao.find(hql, params);
	}
	
}

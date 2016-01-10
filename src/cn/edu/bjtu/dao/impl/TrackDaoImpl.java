package cn.edu.bjtu.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.vo.Track;

@Repository
public class TrackDaoImpl extends BaseDaoImpl<Track> implements TrackDao {

	@Override
	public boolean createNewTrack(String id, String orderId, String orderNum,String carNum, Double locLongitude, Double locLatitude,
			String time, String address) {
		Track track = new Track();
		track.setAddress(address);
		track.setCarNum(carNum);
		track.setId(id);
		track.setLocLatitude(locLatitude);
		track.setLocLongitude(locLongitude);
		track.setOrderId(orderId);
		track.setTime(time);
		track.setOrderNum(orderNum);
		this.save(track);
		
		return true;
	}

	@Override
	public List<Track> getTrackByOrderId(String orderId) {
		String hql="from Track where orderId=:orderId order by time desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderId", orderId);
		return this.find(hql, params);
	}

}

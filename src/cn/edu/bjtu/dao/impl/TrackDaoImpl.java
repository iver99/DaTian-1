package cn.edu.bjtu.dao.impl;

import java.util.Date;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.TrackDao;
import cn.edu.bjtu.vo.Track;

@Repository
public class TrackDaoImpl extends BaseDaoImpl<Track> implements TrackDao {

	@Override
	public boolean createNewTrack(String id, String orderId, String carNum, Double locLongitude, Double locLatitude,
			Date time, String address) {
		// TODO 自动生成的方法存根
		Track track = new Track();
		track.setAddress(address);
		track.setCarNum(carNum);
		track.setId(id);
		track.setLocLatitude(locLatitude);
		track.setLocLongitude(locLongitude);
		track.setOrderId(orderId);
		track.setTime(time);
		this.save(track);
		
		return true;
	}

}

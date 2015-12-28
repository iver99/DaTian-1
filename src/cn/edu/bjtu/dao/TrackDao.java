package cn.edu.bjtu.dao;

import java.util.Date;
import java.util.List;

import cn.edu.bjtu.vo.Track;

public interface TrackDao extends BaseDao<Track> {
	public boolean createNewTrack(String id,String orderId,String orderNum,String carNum,Double locLongitude,Double locLatitude,Date time,String address);
	public List<Track> getTrackByOrderId(String orderId);
}

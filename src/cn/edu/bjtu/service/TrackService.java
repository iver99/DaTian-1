package cn.edu.bjtu.service;

import java.util.Date;
import java.util.List;

import cn.edu.bjtu.vo.Track;

public interface TrackService {
	public boolean createNewTrack(String id,String orderId,String carNum,Double locLongitude,Double locLatitude,Date time,String address);
	public List<Track> getTrackByOrderId(String orderId);
}

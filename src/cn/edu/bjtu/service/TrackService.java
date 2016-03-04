package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Track;

public interface TrackService {
	public boolean createNewTrack(String id,String orderId,String orderNum,String carNum,String event,Double locLongitude,Double locLatitude,String time,String address,String waybillNum);
	public List<Track> getTrackByOrderIdDesc(String orderId);
	public List<Track> getTrackByOrderIdAsc(String orderId);
}

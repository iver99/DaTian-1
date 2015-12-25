package cn.edu.bjtu.service;

import java.util.Date;

public interface TrackService {
	public boolean createNewTrack(String id,String orderId,String carNum,Double locLongitude,Double locLatitude,Date time,String address); 
}

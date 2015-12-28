package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.Driverinfo;

public interface DriverLoginService {
	
	public Driverinfo checkLogin(String phone,String passwd);

}

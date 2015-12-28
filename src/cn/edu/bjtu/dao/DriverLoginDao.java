package cn.edu.bjtu.dao;

import cn.edu.bjtu.vo.Driverinfo;

public interface DriverLoginDao extends BaseDao<Driverinfo> {
	
	public Driverinfo checkLogin(String phone,String passwd);

}

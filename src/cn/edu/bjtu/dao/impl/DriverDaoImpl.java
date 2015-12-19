package cn.edu.bjtu.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.vo.Driverinfo;
@Repository
public class DriverDaoImpl extends BaseDaoImpl<Driverinfo> implements DriverDao{

	@Override
	public Driverinfo getDriverInfo(String driverId) {
		
		return this.get(Driverinfo.class,driverId);
	}
	@Override
	public Driverinfo getDriverInfoByPhone(String phone) {
		// TODO 自动生成的方法存根
		String hql="from Driverinfo where phone=:phone";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("phone", phone);
		
		return this.get(hql, params);
	}
	@Override
	/**
	 * 获取某公司的所有司机姓名 
	 */
	public List getAllDriverName(String carrierId) {
		
		return this.find("select driverName from Driverinfo where carrierId='"+carrierId+"'");
	}

	@Override
	/**
	 * 获取某公司的所有司机信息 
	 */
	public List getAllDriver(String carrierId) {
		
		
		return this.find("from Driverinfo where carrierId='"+carrierId+"'");
	}
	

	@Override
	public String getDriverIdByName(String driverName) {
		
		return "";
	}
	


}

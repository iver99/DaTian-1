package cn.edu.bjtu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.DriverLoginDao;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class DriverLoginDaoImpl extends BaseDaoImpl<Driverinfo> implements DriverLoginDao {
	
	@Resource
	Driverinfo driverinfo;

	@Override
	public Driverinfo checkLogin(String phone) {
		
		//ÐèÒªÐÞ¸Ä 
		String hql="from Driverinfo where phone=:phone";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("phone", phone);
		
		return this.get(hql, params);
	}
	

}

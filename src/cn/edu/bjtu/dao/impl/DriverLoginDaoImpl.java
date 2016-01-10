package cn.edu.bjtu.dao.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.DriverLoginDao;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class DriverLoginDaoImpl extends BaseDaoImpl<Driverinfo> implements DriverLoginDao {
	

	@Override
	public Driverinfo checkLogin(String phone,String passwd) {
		
		//ÐèÒªÐÞ¸Ä 
		String hql="from Driverinfo where phone=:phone and passwd=:passwd";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("phone", phone);
		params.put("passwd", passwd);
		
		return this.get(hql, params);
	}
	

}

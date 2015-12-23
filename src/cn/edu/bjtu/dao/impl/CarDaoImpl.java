package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.CarDao;

import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Driverinfo;

@Repository
public class CarDaoImpl extends BaseDaoImpl<Carinfo> implements CarDao{

	@Override
	public List<Carinfo> getAllcarNum(String carrierId) {
		// TODO 自动生成的方法存根
		return this.find("from Carinfo where carrierId='"+carrierId+"'");
	}
	
	
}

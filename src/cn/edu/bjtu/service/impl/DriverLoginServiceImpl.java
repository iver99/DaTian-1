package cn.edu.bjtu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.DriverLoginDao;
import cn.edu.bjtu.service.DriverLoginService;
import cn.edu.bjtu.vo.Driverinfo;


@Service
@Transactional
public class DriverLoginServiceImpl implements DriverLoginService {
	
	@Resource(name="driverLoginDaoImpl")
	private DriverLoginDao driverLoginDao;
	
	@Override
	public Driverinfo checkLogin(String phone) {
		
		
		
		return driverLoginDao.checkLogin(phone); 
	}

}

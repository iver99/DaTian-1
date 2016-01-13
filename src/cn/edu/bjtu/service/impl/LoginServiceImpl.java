package cn.edu.bjtu.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.LoginDao;
import cn.edu.bjtu.service.LoginService;
import cn.edu.bjtu.vo.Userinfo;
@Service
@Transactional
public class LoginServiceImpl implements LoginService{	
	
	@Resource(name="loginDaoImpl")
	private LoginDao loginDao;
	
	@Override
	public Userinfo checkLogin(String username, String password,int userKind) {
		
		//ÐèÒªÐÞ¸Ä 
				String hql="from Userinfo where username=:username and password=:password and userKind=:userKind";
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("username", username);
				params.put("password", password);
				params.put("userKind", userKind);
				
				return loginDao.get(hql, params);
	}

}

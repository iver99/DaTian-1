package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.AuthenticationService;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Transactional
@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	AuthenticationDao authenticationDao;
	@Autowired
	UserinfoDao userinfoDao;	
	@Autowired
	ClientDao clientInfoDao;
	
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		return userinfoDao.get(Userinfo.class,clientId);
	}
	@Override
	/**
	 * 获取个人信息
	 * @param clientId
	 * return
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return clientInfoDao.get(Clientinfo.class, clientId);
	}
	
	 @Override
	 /**
	  * 更新认证状态
	  * @param clientId
	  * @param status
	  */
	public boolean updateAuthenticStatus(String feedback, String clientId,String status) {
			
		Userinfo userinfo = getMyUserDetail(clientId);
		userinfo.setFeedback(feedback);
		userinfo.setStatus(status);
		authenticationDao.update(userinfo);//保存实体
		 return true;
	}
	 
	@Override
	public List getFindUser(String username) {
		
		String sql = "from Userinfo where (status = '审核中' or status = '已审核') ";
		if (username.equals("用户名")) {
			// 查找时不考虑用户名
		} else
			sql += "and username like '%" + username + "%'";
	return userinfoDao.find(sql);
	}
	
	/**
	 * 个人用户审核拒绝
	 */
	@Override
	public boolean authenUserDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("未验证");
		userinfo.setFeedback(feedback);
		
		userinfoDao.update(userinfo);
		return true;
	}
	
	/**
	 * 个人用户审合通过
	 */
	@Override
	public boolean authenUserPass(String feedback, String user_id) {
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, user_id);

		userinfo.setStatus("已审核");
		userinfo.setFeedback(feedback);

		userinfoDao.update(userinfo);
		return true;
	}
	/**
	 * 公司用户验证拒绝
	 */
	@Override
	public boolean authenCompanyDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("未验证");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
		
	}
	
	/**
	 * 公司用户验证通过
	 */
	@Override
	public boolean authenCompanyPass(String feedback, String user_id) {

Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("已审核");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
	
	}
	
	
	
}

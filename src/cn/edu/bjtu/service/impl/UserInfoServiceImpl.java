package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.dao.safety.PermissionDao;
import cn.edu.bjtu.service.UserInfoService;
import cn.edu.bjtu.vo.Userinfo;
import cn.edu.bjtu.vo.safety.Permission;
import cn.edu.bjtu.vo.safety.Role;
import cn.edu.bjtu.vo.safety.UserRole;
@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService{

	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	PermissionDao permissionDao;
	/**
	 * 根据用户获取权限
	 * @param username
	 * @return
	 */
	@Override
	public List<String> getPermissionsByUserName(String username) {
		 Userinfo user = getUserByUserName(username);  
	        if (user == null) {  
	            return null;  
	        }  
	        List<String> list = new ArrayList<String>();  
	        for (UserRole userRole : user.getUserRoles()) {  
	            Role role = userRole.getRole();  
	            String hql="from Permission t where t.roleId=:roleId";
	            Map<String,Object> params=new HashMap<String,Object>();
	            params.put("roleId", role.getId());
	            List<Permission> permissions=permissionDao.find(hql, params);
	            for (Permission p : permissions) {  
	                list.add(p.getUrl());  
	            }  
	        }  
	        return list;  
	}

	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	@Override
	public Userinfo getUserByUserName(String username) {
		String hql="from Userinfo t where t.username=:username";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("username", username);
		return userinfoDao.get(hql, params);
		
	}

	
	
}

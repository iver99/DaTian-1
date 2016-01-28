package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Userinfo;

public interface UserInfoService {
	/**
	 * 根据用户获取权限
	 * @param username
	 * @return
	 */
	public List<String> getPermissionsByUserName(String username);
	/**
	 * 根据用户名获取用户
	 * @param username
	 * @return
	 */
	public Userinfo getUserByUserName(String username);
}

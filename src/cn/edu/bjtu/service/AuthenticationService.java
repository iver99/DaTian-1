package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

public interface AuthenticationService {
	
	public Clientinfo getAuthenticationInfo(String clientId);
	public boolean updateAuthenticStatus(String feedback, String clientId,String status);
	public Userinfo getMyUserDetail(String clientId);
	public List getFindUser(String username);
	public List<Userinfo> getAllAuthentication();
	
	
	/**
	 * �����û���֤�ܾ�
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenUserDeny(String feedback,String user_id);
	
	/**
	 * �����û���֤ͨ��
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenUserPass(String feedback,String user_id);
	
	/**
	 * ��˾��֤�ܾ�
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenCompanyDeny(String feedback,String user_id);
	
	/**
	 * ��˾��֤ͨ��
	 * @param feedback
	 * @param user_id
	 * @return
	 */
	public boolean authenCompanyPass(String feedback,String user_id);
}

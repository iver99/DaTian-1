package cn.edu.bjtu.service.impl;

import java.util.List;

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
	 * ��ȡ������Ϣ
	 * @param clientId
	 * return
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		return userinfoDao.get(Userinfo.class,clientId);
	}
	@Override
	/**
	 * ��ȡ������Ϣ
	 * @param clientId
	 * return
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return clientInfoDao.get(Clientinfo.class, clientId);
	}
	
	 @Override
	 /**
	  * ������֤״̬
	  * @param clientId
	  * @param status
	  */
	public boolean updateAuthenticStatus(String feedback, String clientId,String status) {
			
		Userinfo userinfo = getMyUserDetail(clientId);
		userinfo.setFeedback(feedback);
		userinfo.setStatus(status);
		authenticationDao.update(userinfo);//����ʵ��
		 return true;
	}
	 
	@Override
	public List getFindUser(String username) {
		
		String sql = "from Userinfo where (status = '�����' or status = '�����') ";
		if (username.equals("�û���")) {
			// ����ʱ�������û���
		} else
			sql += "and username like '%" + username + "%'";
	return userinfoDao.find(sql);
	}
	
	/**
	 * �����û���˾ܾ�
	 */
	@Override
	public boolean authenUserDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("δ��֤");
		userinfo.setFeedback(feedback);
		
		userinfoDao.update(userinfo);
		return true;
	}
	
	/**
	 * �����û����ͨ��
	 */
	@Override
	public boolean authenUserPass(String feedback, String user_id) {
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, user_id);

		userinfo.setStatus("�����");
		userinfo.setFeedback(feedback);

		userinfoDao.update(userinfo);
		return true;
	}
	/**
	 * ��˾�û���֤�ܾ�
	 */
	@Override
	public boolean authenCompanyDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("δ��֤");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
		
	}
	
	/**
	 * ��˾�û���֤ͨ��
	 */
	@Override
	public boolean authenCompanyPass(String feedback, String user_id) {

Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("�����");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
	
	}
	//��ȡ����δ��֤�û�
	@Override
	public List<Userinfo> getAllAuthentication() {
		List<Userinfo> validateList = userinfoDao.find("from Userinfo where status = '�����' or status = '�����'");
		return validateList;
	}
	
	
	
}

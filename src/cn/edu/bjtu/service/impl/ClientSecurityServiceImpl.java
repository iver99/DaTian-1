package cn.edu.bjtu.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.ClientSecurityDao;
import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;
@Service
@Transactional
public class ClientSecurityServiceImpl implements ClientSecurityService{

	
	@Autowired
	ClientSecurityDao clientSecurityDao;
	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	ClientDao clientDao;
	@Autowired
	CompanycertificateDao companyCertificateDao;
	
	@Override
	public boolean bindEmail(String email,HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		//return clientSecurityDao.bindEmail(email,userId);
		Userinfo user = userinfoDao.get(Userinfo.class, userId);
		user.setEmail(email);
		user.setEmailStatus("�Ѱ�");// �޸�״̬
		userinfoDao.update(user);
		if(userKind== 2){
			Clientinfo clientinfo = clientDao.get(Clientinfo.class, userId);
			clientinfo.setEmail(email);
			clientDao.update(clientinfo);
			
		}else if(userKind ==3){
			Companycertificate company=companyCertificateDao.get(Companycertificate.class, userId);
			company.setEmail(email);
			companyCertificateDao.update(company);
		}
		
		return true;

	}
	/**
	 * ��������
	 */
	@Override
	public boolean checkOldPassword(String oldPassword,String userId) {
		
		Userinfo user = userinfoDao.get(Userinfo.class, userId);

		if (user.getPassword().equals(oldPassword))
			return true;
		return false;
	}
	/**
	 * �޸�����
	 */
	@Override
	public boolean changePassword(String newPassword,String userId) {
		
		Userinfo user =userinfoDao.get(Userinfo.class, userId);
		user.setPassword(newPassword);
		userinfoDao.save(user);
		return true;
	}
	
	/**
	 * �����ֻ�
	 */
	@Override
	public boolean changePhone(String phone,HttpSession session){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Userinfo userinfo = userinfoDao.get(Userinfo.class, userId);
		userinfo.setPhone(phone);
		userinfoDao.save(userinfo);
		return true;
	}
	
	
	@Override
	public Userinfo getUserById(String userId) {
		
		return userinfoDao.get(Userinfo.class, userId);
	}
	

	@Override
	/**
	 * �޸İ�����
	 */
	public boolean changeBindEmail(String newEmail, HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		Userinfo userinfo = userinfoDao.get(Userinfo.class, userId);

		userinfo.setEmail(newEmail);
		userinfoDao.update(userinfo);
		if(userKind== 2){
			Clientinfo clientinfo = clientDao.get(Clientinfo.class, userId);
			clientinfo.setEmail(newEmail);
			clientDao.update(clientinfo);
			
		}else if(userKind ==3){
			Companycertificate company=companyCertificateDao.get(Companycertificate.class, userId);
			company.setEmail(newEmail);
			companyCertificateDao.update(company);
		}
		return true;
	}

	@Override
	public boolean setSecurityQuestion(String q1, String q2, String q3,
			String a1, String a2, String a3, String uId) {
		
		if(q1.equals("��ѡ��") || q2.equals("��ѡ��") || q3.equals("��ѡ��"))
			return false;
		if(a1.trim().equals("") || a2.trim().equals("")|| a3.trim().equals(""))
			return false;
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, uId);

		userinfo.setSecurityAnswerOne(a1.trim());
		userinfo.setSecurityAnswerTwo(a2.trim());
		userinfo.setSecurityAnswerThree(a3.trim());
		userinfo.setSecurityQuestionOne(q1.trim());
		userinfo.setSecurityQuestionTwo(q2.trim());
		userinfo.setSecurityQuestionThree(q3.trim());

		userinfo.setSecurityQuestionStatus("������");

		/*baseDao.update(userinfo);*/
		userinfoDao.update(userinfo);
		return true;
	}

	
	@Override
	public boolean checkAnswer(String a1, String a2, String a3,String uId) {
		
		if(a1.trim().equals("") || a2.trim().equals("") || a3.trim().equals(""))
			return false;
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, uId);

		if (a1.trim().endsWith(userinfo.getSecurityAnswerOne())
				&& a2.trim().equals(userinfo.getSecurityAnswerTwo())
				&& a3.trim().equals(userinfo.getSecurityAnswerThree()))
			return true;

		return false;
	}

	/**
	 * ���email��ʽ(δʵ��)
	 * @param email
	 * @return
	 *//*
	private boolean checkEmail(String email)
	{
		return true;//δʵ��
	}*/

}

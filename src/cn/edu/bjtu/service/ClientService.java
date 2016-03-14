package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

/**
 * 
 * @author RussWest0
 *
 */
public interface ClientService {
	/**
	 * ͨ��clientId����clientinfo����
	 *
	 * @param clientId
	 * @return
	 */
	public Clientinfo getClientInfo(String clientId);
	public Businessclient getBusinessclientInfo(String clientId);
	public boolean insertBusinessClient(String account,String clientName,String clientBusiness,
			String contact,String phone,String remarks,String carrierId,String path,String fileName);
	public boolean updateBusinessClient(String id, String account,String clientName,String clientBusiness,
			String contact,String phone,String remarks,String carrierId,String path,String fileName);
	public boolean deleteBusinessClient(String id);
	/**
	 * �鿴�û�������Ϣ
	 * @param userId
	 * @return
	 */
	public Userinfo getBasicUserInfo(HttpSession session);
	/**
	 * �鿴�û�ͷ��
	 * @param userId
	 * @return
	 */
	public Clientinfo getUserPicture(HttpSession session);
	public boolean checkHeadIconStatus(String userId);
	
	public String getStatus(String userId);
	
	public boolean validateUser(String userId,String realName,String phone,
			String IDCard,String sex, String path, String fileName);
	/**
	 * ���¸����û���Ϣ
	 * @param clientinfo
	 * @param path
	 * @param fileName
	 * @param userId
	 * @return
	 */
	public boolean updateClientinfo(Clientinfo clientinfo,String path,String fileName,String userId);
	
	/**
	 * ��ȡ�ҵ���Ϣ-�·��������
	 * @param session
	 * @return
	 */
	public String getTransactionInfo(HttpSession session);
	
	/**
	 * ��ȡ�ҵ���Ϣ-ͷ������
	 * @param session
	 * @return
	 */
	public boolean insertUserIdPicture(Clientinfo clientinfo,HttpServletRequest request,MultipartFile file);
}

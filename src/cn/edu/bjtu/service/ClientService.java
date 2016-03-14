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
	 * 通过clientId查找clientinfo对象
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
	 * 查看用户基本信息
	 * @param userId
	 * @return
	 */
	public Userinfo getBasicUserInfo(HttpSession session);
	/**
	 * 查看用户头像
	 * @param userId
	 * @return
	 */
	public Clientinfo getUserPicture(HttpSession session);
	public boolean checkHeadIconStatus(String userId);
	
	public String getStatus(String userId);
	
	public boolean validateUser(String userId,String realName,String phone,
			String IDCard,String sex, String path, String fileName);
	/**
	 * 更新个人用户信息
	 * @param clientinfo
	 * @param path
	 * @param fileName
	 * @param userId
	 * @return
	 */
	public boolean updateClientinfo(Clientinfo clientinfo,String path,String fileName,String userId);
	
	/**
	 * 获取我的信息-下方交易情况
	 * @param session
	 * @return
	 */
	public String getTransactionInfo(HttpSession session);
	
	/**
	 * 获取我的信息-头像设置
	 * @param session
	 * @return
	 */
	public boolean insertUserIdPicture(Clientinfo clientinfo,HttpServletRequest request,MultipartFile file);
}

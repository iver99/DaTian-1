package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.BusinessClientDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
/**
 * client服务层实现
 * @author RussWest0
 *
 */
@Service
@Transactional
public class ClientServiceImpl implements ClientService{

	@Autowired	
	ClientDao clientDao;
	@Autowired
	BusinessClientDao businessClientDao;
	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	OrderService orderService;
	
	/**
	 * 通过id获取客户信息
	 */
	@Override
	public Clientinfo getClientInfo(String clientId) {
		
		return clientDao.get(Clientinfo.class, clientId);
	}
	
	/**
	 * 获取客户信息(businessclient)
	 */
	@Override
	public Businessclient getBusinessclientInfo(String businessclientId) {
		
		return businessClientDao.get(Businessclient.class, businessclientId);
	}
	
	@Override
	/**
	 * 新增客户s
	 */
	public boolean insertBusinessClient(String account, String clientName,
			String clientBusiness, String contact, String phone,
			String remarks, String carrierId,String path,String fileName) {
		Businessclient businessClient=new Businessclient();
		businessClient.setAccount(account);
		businessClient.setCarrierId(carrierId);
		businessClient.setClientBusiness(clientBusiness);
		businessClient.setClientName(clientName);
		businessClient.setContact(contact);
		businessClient.setId(IdCreator.createBusinessClientId());
		businessClient.setPhone(phone);
		businessClient.setRelDate(new Date());
		businessClient.setRemarks(remarks);
		
		// 保存文件路径
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.save(businessClient);//保存实体
		return true;
	}
	
	/**
	 * 更新客户
	 */
	@Override
	public boolean updateBusinessClient(String id, String account, String clientName,
			String clientBusiness, String contact, String phone,
			String remarks, String carrierId,String path,String fileName) {
		
		Businessclient businessClient=getBusinessclientInfo(id);//根据id查找到客户信息
		businessClient.setAccount(account);
		businessClient.setClientName(clientName);
		businessClient.setClientBusiness(clientBusiness);
		businessClient.setContact(contact);
		businessClient.setPhone(phone);
		businessClient.setRelDate(new Date());
		businessClient.setRemarks(remarks);
		businessClient.setCarrierId(carrierId);
		
		// 保存文件路径
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.update(businessClient);//保存实体
		return true;
	}
	/**
	 * 删除客户
	 */
	@Override
	public boolean deleteBusinessClient(String id){
		Businessclient businessClient=getBusinessclientInfo(id);//根据id查找到客户信息
		businessClientDao.delete(businessClient);
		return true;
	}
	/**
	 * 返回用户的基本信息
	 */
	@Override
	public Userinfo getBasicUserInfo(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);	
		return userinfoDao.get(Userinfo.class, userId);
	}
	/**
	 * 返回用户头像
	 */
	@Override
	public Clientinfo getUserPicture(HttpSession session) {
		String clientId=(String)session.getAttribute(Constant.USER_ID);
		return clientDao.get(Clientinfo.class, clientId);
	}
	/**
	 * 检查用户头像设置的状态
	 */
	@Override
	public boolean checkHeadIconStatus(String userId) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, userId);
		if(userinfo !=null){
			if(userinfo.getHeadIcon().equals("已设置")){
				return true;//已设置头像
			}else 
				return false;//未设置头像
		}
		return false;
		
	}
	/**
	 * 获取账户状态
	 */
	@Override
	public String getStatus(String userId) {
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("id", userId);
		Userinfo userinfo=userinfoDao.get("from Userinfo t where t.id=:id",params);
		
		if(userinfo != null){
			return userinfo.getStatus();
		}else
			return "";
		
	}
	@Override
	/**
	 * 个人用户信息认证
	 */
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex, String path, String fileName) {
		
		Clientinfo clientInfo = clientDao.get(Clientinfo.class, userId);
		if (clientInfo == null) {// clientinfo找不到记录
			return false;
		}

		clientInfo.setRealName(realName);
		clientInfo.setPhone(phone);
		clientInfo.setIdcard(IDCard);
		clientInfo.setSex(sex);
		clientDao.update(clientInfo);
		Userinfo userInfo = userinfoDao.get(Userinfo.class, userId);
		userInfo.setStatus("审核中");
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientInfo.setIDPicture(fileLocation);//设置文件上传路径
		}
		userinfoDao.update(userInfo);

		// }

		return true;
	}
	@Override
	/**
	 *  更新个人用户信息
	 */
	public boolean updateClientinfo(Clientinfo clientinfo, String path,
			String fileName, String userId) {
		
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientinfo.setIDPicture(fileLocation);//设置文件上传路径
		}
		Userinfo userinfo=userinfoDao.get(Userinfo.class,userId);
		// add by RussWest0 at 2015年6月4日,下午8:23:30 
//		更新后显示审核中
		userinfo.setStatus("审核中");
		clientinfo.setId(userId);
		
		userinfoDao.update(userinfo);
		clientDao.update(clientinfo);//更新信息
		return true;
	}
	/**
	 * 获取我的信息-下方交易信息
	 */
	@Override
	public String getTransactionInfo(HttpSession session) {
		
//		String userId=(String)session.getAttribute(Constant.USER_ID);
//		String userKind=(String)session.getAttribute(Constant.USER_KIND);
		//待受理数目
		Long waitToAcceptNum=orderService.getUserWaitToAcceptNum(session);
		//待收货数目
		Long waitToReceiveNum=orderService.getUserWaitToReceiveNum(session);
		//待结算数目
		//未完成
		Long waitToSettleNum=orderService.getUserWaitToSettleNum(session);
		//已完成数目
		Long finishedNum=orderService.finishedNum(session);
		
		return waitToAcceptNum+"-"+waitToReceiveNum+"-"+waitToSettleNum+"-"+finishedNum;
		
		
		
	}
	/**
	 * 获取我的信息-头像设置
	 */
	@Override
	public boolean insertUserIdPicture(Clientinfo clientinfo,HttpServletRequest request,MultipartFile file) {
		
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		/*System.out.println(clientId);*/
		Clientinfo clientinfo1 = clientDao.get(Clientinfo.class, clientId);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, clientId, "userpicture");
		//设置文件位置 
		System.out.println(fileLocation);
		clientinfo1.setIDPicture(fileLocation);
		clientDao.update(clientinfo1);// 保存实体
		Userinfo userInfo = userinfoDao.get(Userinfo.class, clientId);
		userInfo.setHeadIcon("已设置");
		userinfoDao.update(userInfo);//保存头像状态

		return true;
	}
	
	
	
	
	
}

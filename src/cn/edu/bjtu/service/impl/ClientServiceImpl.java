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
 * client�����ʵ��
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
	 * ͨ��id��ȡ�ͻ���Ϣ
	 */
	@Override
	public Clientinfo getClientInfo(String clientId) {
		
		return clientDao.get(Clientinfo.class, clientId);
	}
	
	/**
	 * ��ȡ�ͻ���Ϣ(businessclient)
	 */
	@Override
	public Businessclient getBusinessclientInfo(String businessclientId) {
		
		return businessClientDao.get(Businessclient.class, businessclientId);
	}
	
	@Override
	/**
	 * �����ͻ�s
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
		
		// �����ļ�·��
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.save(businessClient);//����ʵ��
		return true;
	}
	
	/**
	 * ���¿ͻ�
	 */
	@Override
	public boolean updateBusinessClient(String id, String account, String clientName,
			String clientBusiness, String contact, String phone,
			String remarks, String carrierId,String path,String fileName) {
		
		Businessclient businessClient=getBusinessclientInfo(id);//����id���ҵ��ͻ���Ϣ
		businessClient.setAccount(account);
		businessClient.setClientName(clientName);
		businessClient.setClientBusiness(clientBusiness);
		businessClient.setContact(contact);
		businessClient.setPhone(phone);
		businessClient.setRelDate(new Date());
		businessClient.setRemarks(remarks);
		businessClient.setCarrierId(carrierId);
		
		// �����ļ�·��
		if(path!=null && fileName!=null) {
			String fileLocation = path + "//" + fileName;
			businessClient.setRelatedMaterial(fileLocation);
		}
		businessClientDao.update(businessClient);//����ʵ��
		return true;
	}
	/**
	 * ɾ���ͻ�
	 */
	@Override
	public boolean deleteBusinessClient(String id){
		Businessclient businessClient=getBusinessclientInfo(id);//����id���ҵ��ͻ���Ϣ
		businessClientDao.delete(businessClient);
		return true;
	}
	/**
	 * �����û��Ļ�����Ϣ
	 */
	@Override
	public Userinfo getBasicUserInfo(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);	
		return userinfoDao.get(Userinfo.class, userId);
	}
	/**
	 * �����û�ͷ��
	 */
	@Override
	public Clientinfo getUserPicture(HttpSession session) {
		String clientId=(String)session.getAttribute(Constant.USER_ID);
		return clientDao.get(Clientinfo.class, clientId);
	}
	/**
	 * ����û�ͷ�����õ�״̬
	 */
	@Override
	public boolean checkHeadIconStatus(String userId) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, userId);
		if(userinfo !=null){
			if(userinfo.getHeadIcon().equals("������")){
				return true;//������ͷ��
			}else 
				return false;//δ����ͷ��
		}
		return false;
		
	}
	/**
	 * ��ȡ�˻�״̬
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
	 * �����û���Ϣ��֤
	 */
	public boolean validateUser(String userId, String realName, String phone,
			String IDCard, String sex, String path, String fileName) {
		
		Clientinfo clientInfo = clientDao.get(Clientinfo.class, userId);
		if (clientInfo == null) {// clientinfo�Ҳ�����¼
			return false;
		}

		clientInfo.setRealName(realName);
		clientInfo.setPhone(phone);
		clientInfo.setIdcard(IDCard);
		clientInfo.setSex(sex);
		clientDao.update(clientInfo);
		Userinfo userInfo = userinfoDao.get(Userinfo.class, userId);
		userInfo.setStatus("�����");
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientInfo.setIDPicture(fileLocation);//�����ļ��ϴ�·��
		}
		userinfoDao.update(userInfo);

		// }

		return true;
	}
	@Override
	/**
	 *  ���¸����û���Ϣ
	 */
	public boolean updateClientinfo(Clientinfo clientinfo, String path,
			String fileName, String userId) {
		
		if (path != null && fileName != null) {
			String fileLocation = path + "//" + fileName;
			clientinfo.setIDPicture(fileLocation);//�����ļ��ϴ�·��
		}
		Userinfo userinfo=userinfoDao.get(Userinfo.class,userId);
		// add by RussWest0 at 2015��6��4��,����8:23:30 
//		���º���ʾ�����
		userinfo.setStatus("�����");
		clientinfo.setId(userId);
		
		userinfoDao.update(userinfo);
		clientDao.update(clientinfo);//������Ϣ
		return true;
	}
	/**
	 * ��ȡ�ҵ���Ϣ-�·�������Ϣ
	 */
	@Override
	public String getTransactionInfo(HttpSession session) {
		
//		String userId=(String)session.getAttribute(Constant.USER_ID);
//		String userKind=(String)session.getAttribute(Constant.USER_KIND);
		//��������Ŀ
		Long waitToAcceptNum=orderService.getUserWaitToAcceptNum(session);
		//���ջ���Ŀ
		Long waitToReceiveNum=orderService.getUserWaitToReceiveNum(session);
		//��������Ŀ
		//δ���
		Long waitToSettleNum=orderService.getUserWaitToSettleNum(session);
		//�������Ŀ
		Long finishedNum=orderService.finishedNum(session);
		
		return waitToAcceptNum+"-"+waitToReceiveNum+"-"+waitToSettleNum+"-"+finishedNum;
		
		
		
	}
	/**
	 * ��ȡ�ҵ���Ϣ-ͷ������
	 */
	@Override
	public boolean insertUserIdPicture(Clientinfo clientinfo,HttpServletRequest request,MultipartFile file) {
		
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		/*System.out.println(clientId);*/
		Clientinfo clientinfo1 = clientDao.get(Clientinfo.class, clientId);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, clientId, "userpicture");
		//�����ļ�λ�� 
		System.out.println(fileLocation);
		clientinfo1.setIDPicture(fileLocation);
		clientDao.update(clientinfo1);// ����ʵ��
		Userinfo userInfo = userinfoDao.get(Userinfo.class, clientId);
		userInfo.setHeadIcon("������");
		userinfoDao.update(userInfo);//����ͷ��״̬

		return true;
	}
	
	
	
	
	
}

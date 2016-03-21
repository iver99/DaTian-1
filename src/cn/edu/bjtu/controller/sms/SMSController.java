package cn.edu.bjtu.controller.sms;

import java.rmi.RemoteException;
import java.util.List;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.b2m.eucp.example.SingletonClient;
import cn.edu.bjtu.service.sms.SmsService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DataSourceContextHolder;
import cn.edu.bjtu.util.VCodeCreator;
import cn.edu.bjtu.vo.sms.SmsLog;
/**
 * ���Žӿ���صĿ�����
 * @author iver
 * @date   2016��1��25�� ����2:13:33
 */
/**
 * ���Žӿ���صĿ�����
 * @author iver
 * @date   2016��1��25�� ����2:13:33
 */
/**
 * ���Žӿ���صĿ�����
 * @author iver
 * @date   2016��1��25�� ����2:13:33
 */
@Controller
public class SMSController {
	
	@Autowired
	SmsService smsService;
	
	
	
	ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
	public final String password=bundle.getString("password");//password of sms interface
	//��ȡ������־��¼��
	public static Logger smsErrorLogger=Logger.getLogger("smsError");
	public static Logger smsHisLogger=Logger.getLogger("smsHis");
	/**
	 * ע�����к�
	 */
	@RequestMapping("/regSerialSnAjax")
	@ResponseBody
	public String regSmsSerialNo(){
		try {
			int i = SingletonClient.getClient().registEx(password);
//			System.out.println("testTegistEx:" + i);
			//��־
			if(i==0){
				smsHisLogger.info("�����кż���ɹ�����");
			}else{
				smsHisLogger.info("�����кż������ʧ�ܣ�����ֵΪ��:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!");
			}
			return "testTegistEx:" + i;
		} catch (RemoteException e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	/**
	 * ע����ҵ��Ϣ
	 */
	@RequestMapping("regEnterpriseInfoAjax")
	@ResponseBody
	public String regEnterpriseInfo(){
		try {

			/**
			 * ��ҵ��ϸ��Ϣע�� registDetailInfo(String eName, String linkMan, String
			 * phoneNum,String mobile, String email, String fax, String address,String
			 * postcode)
			 *  1��eName ��ҵ����(���60�ֽ�)
			 *   2��linkMan ��ϵ������(���20�ֽ�) 
			 *   3��phoneNum	 * ��ϵ�绰(���20�ֽ�) 
			 *   4��mobile ��ϵ�ֻ�(���15�ֽ�) 
			 *   5��email �����ʼ�(���60�ֽ�) 
			 *   6��fax	 * ��ϵ����(���20�ֽ�) 
			 * 7��address ��˾��ַ(���60�ֽ�) 
			 * 8��postcode ��������(���6�ֽ�)
			 * 9�����ϲ�����Ϣ��������д��ÿ������������Ϊ��
			 */
			int a = SingletonClient.getClient().registDetailInfo(
					bundle.getString("eName"), 
					bundle.getString("linkMan"),  
					bundle.getString("phoneNum"), 
					bundle.getString("mobile"),  
					bundle.getString("email"),  
					bundle.getString("fax"),  
					bundle.getString("address"),  
					bundle.getString("postcode"));
			if(a==0){
				smsHisLogger.info("����ҵ��Ϣע��ɹ�����");
			}else{
				smsHisLogger.info("����ҵ��Ϣע�����ʧ�ܣ�����ֵΪ��:"+a+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!");
			}
//			System.out.println("testRegistDetailInfo:" + a);
			return "testRegistDetailInfo:" + a;
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	/**
	 * ���ͼ�ʱ����
	 */
	@RequestMapping("sendSMSAjax")
	@ResponseBody
	public String sendSMS(String phone,String smsContent){
		//�л�����Դ
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "�����Ｏ����Դ��Ӧ������ƽ̨��"+smsContent, "",5);// ����չ��
			//���ͳɹ���¼��־
			if(i==0){
				smsHisLogger.info("�ֻ���:��"+phone+"��=====��������:��"+smsContent+"��");
				smsService.log(phone, smsContent, Constant.SMS_INFO,Constant.SMS_PC_TERM,Constant.SMS_SUCCESS);
			}else{
				smsHisLogger.info("��PC�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!");
				smsService.log(phone, "��PC�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!", Constant.SMS_WARNING,Constant.SMS_PC_TERM,Constant.SMS_FAIL);
			}
			return "testSendSMS=====" + i;
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	

	/**
	 * ��ȡ�������
	 */
	@RequestMapping("getSMSBalanceAjax")
	@ResponseBody
	public String getSMSBalance(){
		try {
			Double a = SingletonClient.getClient().getBalance();
			//��¼��־
			smsHisLogger.info("��������==="+a);
			//���ͳɹ���¼��־
			return  a.toString();
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	
	/**
	 * PC�˻�ȡ��֤��
	 * @return 
	 */
	@RequestMapping("sendVcodeToPcAjax")
	@ResponseBody
	public String pcSendSMSByPhoneNum(String phone){
		//�л�����Դ
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		String vCode=VCodeCreator.getVCode();
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "�����Ｏ����Դ��Ӧ������ƽ̨�����ã�������֤��Ϊ"+vCode, "",5);// ����չ��
			if(i==0){
				//FIXME
				//�洢��֤��
				smsHisLogger.info("��PC�����Ͷ��ųɹ�,�����ֻ���Ϊ��"+phone+"��"+",��֤��Ϊ��"+vCode+"��");
				smsService.log(phone, vCode, Constant.SMS_VCODE,Constant.SMS_PC_TERM,Constant.SMS_SUCCESS);
			}else{
				smsHisLogger.info("��PC�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!");
				smsService.log(phone, "��PC�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!", Constant.SMS_WARNING,Constant.SMS_PC_TERM,Constant.SMS_FAIL);
			}
		} catch (Exception e) {
			smsErrorLogger.error(e);
			e.printStackTrace();
		}
		return vCode;
	}
	/**
	 * ��׿�˻�ȡ��֤��ӿ�
	 * @return 
	 */
	@RequestMapping("sendVcodeToPhoneAjax")
	@ResponseBody
	public String androidSendSMSByPhoneNum(String phone){
		//�л�����Դ
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		JSONObject json = new JSONObject(); 
		try {
			String vCode=VCodeCreator.getVCode();
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "�����Ｏ����Դ��Ӧ������ƽ̨�����ã�������֤��Ϊ"+vCode, "",5);// ����չ��
/*			//���������ʱע�͵������Ź���
			int i =0;*/
			if(i==0){
				//FIXME
				//�洢��֤��
				smsHisLogger.info("����׿�����Ͷ��ųɹ�,�����ֻ���Ϊ��"+phone+"��"+",��֤��Ϊ��"+vCode+"��");
				smsService.log(phone, vCode, Constant.SMS_VCODE,Constant.SMS_ANDROID_TERM,Constant.SMS_SUCCESS);
				json.put("vcode", vCode);
			}else{
				smsHisLogger.info("����׿�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!");
				smsService.log(phone, "����׿�����Ͷ���ʧ��,����ֵΪ:"+i+",��鿴���Žӿ�˵���ĵ��鿴ԭ��!", Constant.SMS_WARNING,Constant.SMS_ANDROID_TERM,Constant.SMS_FAIL);
				json.put("vcode", "fail");

			}
		} catch (Exception e) {
			smsErrorLogger.error(e);
			e.printStackTrace();
		}
		return json.toString();
	}
	/**
	 * ��ȡ������־��Ϊ�˽�ʡ�����������Ҳ�����ҳ���ܣ�ֻ��ʾ���µ�200��
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getSmsLogAjax")
	public List<SmsLog> getSMSLog(){
		//�л�����Դ
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		return smsService.getSmsLog();
		
	}
}

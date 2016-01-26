package cn.edu.bjtu.controller.sms;

import java.rmi.RemoteException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.b2m.eucp.example.SingletonClient;
/**
 * 短信接口相关的控制器
 * @author iver
 * @date   2016年1月25日 下午2:13:33
 */
@Controller
public class SMSController {
	
	ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
	public final String password=bundle.getString("password");//password of sms interface
	//获取短信日志记录器
	public static Logger smsErrorLogger=Logger.getLogger("smsError");
	public static Logger smsHisLogger=Logger.getLogger("smsHis");
	/**
	 * 注册序列号
	 */
	@RequestMapping("/regSerialSnAjax")
	@ResponseBody
	public String regSmsSerialNo(){
		try {
			int i = SingletonClient.getClient().registEx(password);
//			System.out.println("testTegistEx:" + i);
			//日志
			if(i==0){
				smsHisLogger.info("【序列号激活成功！】");
			}else{
				smsHisLogger.info("【序列号激活操作失败，返回值为】:"+i+",请查看短信接口说明文档查看原因!");
			}
			return "testTegistEx:" + i;
		} catch (RemoteException e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	/**
	 * 注册企业信息
	 */
	@RequestMapping("regEnterpriseInfoAjax")
	@ResponseBody
	public String regEnterpriseInfo(){
		try {

			/**
			 * 企业详细信息注册 registDetailInfo(String eName, String linkMan, String
			 * phoneNum,String mobile, String email, String fax, String address,String
			 * postcode)
			 *  1、eName 企业名称(最多60字节)
			 *   2、linkMan 联系人姓名(最多20字节) 
			 *   3、phoneNum	 * 联系电话(最多20字节) 
			 *   4、mobile 联系手机(最多15字节) 
			 *   5、email 电子邮件(最多60字节) 
			 *   6、fax	 * 联系传真(最多20字节) 
			 * 7、address 公司地址(最多60字节) 
			 * 8、postcode 邮政编码(最多6字节)
			 * 9、以上参数信息都必须填写、每个参数都不能为空
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
				smsHisLogger.info("【企业信息注册成功！】");
			}else{
				smsHisLogger.info("【企业信息注册操作失败，返回值为】:"+a+",请查看短信接口说明文档查看原因!");
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
	 * 发送即时短信
	 */
	@RequestMapping("sendSMSAjax")
	@ResponseBody
	public String sendSMS(String phone,String smsContent){
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "【大田集团资源供应链管理平台】"+smsContent, "",5);// 带扩展码
			//System.out.println("testSendSMS=====" + i);
			//发送成功记录日志
			if(i==0){
				smsHisLogger.info("手机号:【"+phone+"】=====短信内容:【"+smsContent+"】");
			}else{
				smsHisLogger.info("【发送短信操作失败，返回值为】:"+i+",请查看短信接口说明文档查看原因!");
			}
			return "testSendSMS=====" + i;
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	/**
	 * 获取短信余额
	 */
	@RequestMapping("getSMSBalanceAjax")
	@ResponseBody
	public String getSMSBalance(){
		try {
			Double a = SingletonClient.getClient().getBalance();
//			System.out.println("testGetBalance:" + a);
			//发送成功记录日志
			return  a.toString();
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	
	/**
	 * 安卓端获取验证码接口
	 */
	@RequestMapping("sendVcodeToPhoneAjax")
	public void androidSendSMSByPhoneNum(String phone){
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "【大田集团资源供应链管理平台】您好，您的验证码为XXXX", "",5);// 带扩展码
//			System.out.println("testSendSMS=====" + i);
			if(i==0){
				smsErrorLogger.info("【安卓】发送短信成功,接收手机号为【"+phone+"】"+",验证码为【】");//FIXME
			}else{
				smsErrorLogger.info("【安卓】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!");
			}
		} catch (Exception e) {
			smsErrorLogger.error(e);
			e.printStackTrace();
		}
		
	}
}

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
 * 短信接口相关的控制器
 * @author iver
 * @date   2016年1月25日 下午2:13:33
 */
/**
 * 短信接口相关的控制器
 * @author iver
 * @date   2016年1月25日 下午2:13:33
 */
/**
 * 短信接口相关的控制器
 * @author iver
 * @date   2016年1月25日 下午2:13:33
 */
@Controller
public class SMSController {
	
	@Autowired
	SmsService smsService;
	
	
	
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
		//切换数据源
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "【大田集团资源供应链管理平台】"+smsContent, "",5);// 带扩展码
			//发送成功记录日志
			if(i==0){
				smsHisLogger.info("手机号:【"+phone+"】=====短信内容:【"+smsContent+"】");
				smsService.log(phone, smsContent, Constant.SMS_INFO,Constant.SMS_PC_TERM,Constant.SMS_SUCCESS);
			}else{
				smsHisLogger.info("【PC】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!");
				smsService.log(phone, "【PC】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!", Constant.SMS_WARNING,Constant.SMS_PC_TERM,Constant.SMS_FAIL);
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
			//记录日志
			smsHisLogger.info("【短信余额】==="+a);
			//发送成功记录日志
			return  a.toString();
		} catch (Exception e) {
			e.printStackTrace();
			smsErrorLogger.error(e);
			return "error!!!";
		}
	}
	
	/**
	 * PC端获取验证码
	 * @return 
	 */
	@RequestMapping("sendVcodeToPcAjax")
	@ResponseBody
	public String pcSendSMSByPhoneNum(String phone){
		//切换数据源
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		String vCode=VCodeCreator.getVCode();
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "【大田集团资源供应链管理平台】您好，您的验证码为"+vCode, "",5);// 带扩展码
			if(i==0){
				//FIXME
				//存储验证码
				smsHisLogger.info("【PC】发送短信成功,接收手机号为【"+phone+"】"+",验证码为【"+vCode+"】");
				smsService.log(phone, vCode, Constant.SMS_VCODE,Constant.SMS_PC_TERM,Constant.SMS_SUCCESS);
			}else{
				smsHisLogger.info("【PC】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!");
				smsService.log(phone, "【PC】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!", Constant.SMS_WARNING,Constant.SMS_PC_TERM,Constant.SMS_FAIL);
			}
		} catch (Exception e) {
			smsErrorLogger.error(e);
			e.printStackTrace();
		}
		return vCode;
	}
	/**
	 * 安卓端获取验证码接口
	 * @return 
	 */
	@RequestMapping("sendVcodeToPhoneAjax")
	@ResponseBody
	public String androidSendSMSByPhoneNum(String phone){
		//切换数据源
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		JSONObject json = new JSONObject(); 
		try {
			String vCode=VCodeCreator.getVCode();
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "【大田集团资源供应链管理平台】您好，您的验证码为"+vCode, "",5);// 带扩展码
/*			//方便测试暂时注释掉发短信功能
			int i =0;*/
			if(i==0){
				//FIXME
				//存储验证码
				smsHisLogger.info("【安卓】发送短信成功,接收手机号为【"+phone+"】"+",验证码为【"+vCode+"】");
				smsService.log(phone, vCode, Constant.SMS_VCODE,Constant.SMS_ANDROID_TERM,Constant.SMS_SUCCESS);
				json.put("vcode", vCode);
			}else{
				smsHisLogger.info("【安卓】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!");
				smsService.log(phone, "【安卓】发送短信失败,返回值为:"+i+",请查看短信接口说明文档查看原因!", Constant.SMS_WARNING,Constant.SMS_ANDROID_TERM,Constant.SMS_FAIL);
				json.put("vcode", "fail");

			}
		} catch (Exception e) {
			smsErrorLogger.error(e);
			e.printStackTrace();
		}
		return json.toString();
	}
	/**
	 * 获取短信日志，为了节省工作量，暂且不坐分页功能，只显示最新的200条
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getSmsLogAjax")
	public List<SmsLog> getSMSLog(){
		//切换数据源
		//DataSourceContextHolder.setDataSourceType(Constant.DATA_SOURCE_SMS);
		return smsService.getSmsLog();
		
	}
}

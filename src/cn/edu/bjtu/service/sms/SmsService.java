package cn.edu.bjtu.service.sms;

import java.util.List;

import cn.edu.bjtu.vo.sms.SmsLog;

public interface SmsService {
	
	/**
	 * 保存短信操作到数据库（日志)
	 * @param phone 手机号
	 * @param smsContent 发送的短信内容
	 * @param type 发送短信的类型
	 * @param terminal 发送短信的来源，安卓端或者pc端
	 * @return
	 */
	public boolean log(String phone,String smsContent,String type,String terminal,int status);
	
	
	/**
	 * 获取短信日志
	 * @return
	 */
	public List<SmsLog> getSmsLog();

}

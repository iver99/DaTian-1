package cn.edu.bjtu.service.sms.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.sms.SmsLogDao;
import cn.edu.bjtu.service.sms.SmsService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.sms.SmsLog;
/**
 * 短信接口相关
 * @author iver
 * @date   2016年1月26日 下午10:36:57
 */
@Service
@Transactional
public class SmsServiceImpl implements SmsService{

	@Autowired
	SmsLogDao smsLogDao;
	/**
	 * 短信操作日志到数据库
	 */
	@Override
	public boolean log(String phone, String smsContent, String type,
			String terminal,int status) {
		SmsLog smsLog=new SmsLog();
		smsLog.setPhone(phone);
		smsLog.setSmsContent(smsContent);
		smsLog.setType(type);
		smsLog.setTime(new Date());
		smsLog.setTerminal(terminal);
		smsLog.setStatus(status);
		smsLogDao.save(smsLog);
		
		return true;
	}

}

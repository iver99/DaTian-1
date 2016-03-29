package cn.edu.bjtu.service.sms.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.sms.SmsLogDao;
import cn.edu.bjtu.service.sms.SmsService;
import cn.edu.bjtu.util.RedisUtil;
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
	@Resource(name="redisUtil")
	RedisUtil redisUtil;
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
	/**
	 * 获取短信日志
	 */
	@Override
	public List<SmsLog> getSmsLog() {
		String hql="from SmsLog t order by t.id desc";
		//为了省工作量，暂时不做分页功能，只去日志的前200条记录
		List<SmsLog> logList=smsLogDao.find(hql, 1, 200);
		
		return logList;
	}
	/**
	 * 检查用户填写验证码是否正确
	 */
	@Override
	public boolean checkVCode(String vCode) {
		return redisUtil.exists(vCode);
	}
	
	
	
	

}

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
 * ���Žӿ����
 * @author iver
 * @date   2016��1��26�� ����10:36:57
 */
@Service
@Transactional
public class SmsServiceImpl implements SmsService{

	@Autowired
	SmsLogDao smsLogDao;
	@Resource(name="redisUtil")
	RedisUtil redisUtil;
	/**
	 * ���Ų�����־�����ݿ�
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
	 * ��ȡ������־
	 */
	@Override
	public List<SmsLog> getSmsLog() {
		String hql="from SmsLog t order by t.id desc";
		//Ϊ��ʡ����������ʱ������ҳ���ܣ�ֻȥ��־��ǰ200����¼
		List<SmsLog> logList=smsLogDao.find(hql, 1, 200);
		
		return logList;
	}
	/**
	 * ����û���д��֤���Ƿ���ȷ
	 */
	@Override
	public boolean checkVCode(String vCode) {
		return redisUtil.exists(vCode);
	}
	
	
	
	

}

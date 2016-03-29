package cn.edu.bjtu.service.sms;

import java.util.List;

import cn.edu.bjtu.vo.sms.SmsLog;

public interface SmsService {
	
	/**
	 * ������Ų��������ݿ⣨��־)
	 * @param phone �ֻ���
	 * @param smsContent ���͵Ķ�������
	 * @param type ���Ͷ��ŵ�����
	 * @param terminal ���Ͷ��ŵ���Դ����׿�˻���pc��
	 * @return
	 */
	public boolean log(String phone,String smsContent,String type,String terminal,int status);
	
	
	/**
	 * ��ȡ������־
	 * @return
	 */
	public List<SmsLog> getSmsLog();
	
	/**
	 * ����û���д��֤���Ƿ���ȷ
	 * @return
	 */
	public boolean checkVCode(String vCode);
		

}

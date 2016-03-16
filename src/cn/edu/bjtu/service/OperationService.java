package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.util.PageUtil;

public interface OperationService {
	
	/**
	 * ��������׼ȷ���б��ܼ�¼��
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,HttpSession session);

	/**
	 * ��������׼ȷ���б�
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public List<OperationBean> getTransportAccuracyList(OperationBean operationBean,HttpSession session, PageUtil pageUtil);

	/**
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ������list
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public List<OperationBean> getClientConsentList(OperationBean operationBean,HttpSession session, PageUtil pageUtil);
	/**
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ�������ܼ�¼�� 
	 * @param operationBean
	 * @param session
	 * @return
	 */
	public Long getClientConsentTotalRows(OperationBean operationBean,HttpSession session);
	/**
	 * ��ȡĳһ������ж���
	 * @param date
	 * @return
	 */
	public List<OrderBean> viewOperationDetails(HttpSession session,OperationBean operationBean,PageUtil pageUtil);
	
	/**
	 * ��ȡĪһ������ж������ܼ�¼��
	 * @param session
	 * @param financialBean
	 * @param pageUtil
	 * @return
	 */
	public Long viewOperationDetailsTotalRows(HttpSession session,OperationBean operationBean);
}

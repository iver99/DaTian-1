package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Orderform;

public interface OperationService {
	
	/**
	 * 返回运输准确率列表总记录数
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,HttpSession session);

	/**
	 * 返回运输准确率列表
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public List<OperationBean> getTransportAccuracyList(OperationBean operationBean,HttpSession session, PageUtil pageUtil);

	/**
	 * 统计分析-运营指标-客户满意度list
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public List<OperationBean> getClientConsentList(OperationBean operationBean,HttpSession session, PageUtil pageUtil);
	/**
	 * 统计分析-运营指标-客户满意度总记录数 
	 * @param operationBean
	 * @param session
	 * @return
	 */
	public Long getClientConsentTotalRows(OperationBean operationBean,HttpSession session);
	/**
	 * 获取某一天的所有订单
	 * @param date
	 * @return
	 */
	public List<Orderform> viewOperationDetails(HttpSession session,OperationBean operationBean,PageUtil pageUtil);
	
	/**
	 * 获取莫一天的所有订单的总记录数
	 * @param session
	 * @param financialBean
	 * @param pageUtil
	 * @return
	 */
	public Long viewOperationDetailsTotalRows(HttpSession session,OperationBean operationBean);
}

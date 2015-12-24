package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Orderform;

public interface FinancialService {
	/**
	 * 获取账户财务分析数据
	 * @param session
	 * @return
	 */
	public List<FinancialBean> getAccountFinancialInfo(FinancialBean financialBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 货物财务指标中记录数
	 * @param session
	 * @return
	 */
	public Long getAccountFinancialInfoTotalRows(FinancialBean financialBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 获取某一天的所有订单
	 * @param date
	 * @return
	 */
	public List<Orderform> viewFinancialDetails(HttpSession session,FinancialBean financialBean);
}

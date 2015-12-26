package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.service.FinancialService;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Orderform;

@Controller
/**
 * 统计分析-财务指标相关
 * @author iver
 * @date   2015年12月23日 下午7:43:31
 */
public class FinancialController {
	
	@Autowired
	FinancialService financialService;
	
	/**
	 * 财务指标页面
	 * @return
	 */
	@RequestMapping("getFinancialInfoPage")
	public String getFinancialInfoPage(){
		return "mgmt_s_fin";
	}
	
	/**
	 * 财务指数列表
	 * @param financialBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping("getFinancialInfoAjax")
	@ResponseBody
	public List<FinancialBean> getFinancialInfo(FinancialBean financialBean,PageUtil pageUtil,HttpSession session){
		List<FinancialBean> list=financialService.getAccountFinancialInfo(financialBean,pageUtil,session);
		
		return list;
	}
	
	/**
	 * 财务指标总记录数 
	 * @param session
	 * @return
	 */
	@RequestMapping("getFinalcialInfoTotalRowsAjax")
	@ResponseBody
	public Long getFinancialInfoTotalRows(FinancialBean financialBean,HttpSession session){
		return financialService.getAccountFinancialInfoTotalRows(financialBean,session);
	}
	
	/**
	 * 获取某一天的所有订单列表页面
	 * @param date
	 * @return
	 */
	@RequestMapping("FinancialDetailsPage")
	public String FinancialDetailsPage(){
		return "mgmt_s_fin2";
	}
	
	/**
	 * 点击查看时，返回某一天的订单
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@RequestMapping("viewFinancialDetailsAjax")
	@ResponseBody
	public List<Orderform> viewFinancialDetailsPage(HttpSession session,FinancialBean financialBean,PageUtil pageUtil){
		return financialService.viewFinancialDetails(session, financialBean,pageUtil);
	}
	
	/**
	 * 财务指标，查看页面的总记录数
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@RequestMapping("viewFinancialDetailsTotalRowsAjax")
	@ResponseBody
	public Long viewFinancialDetailsTotalRows(HttpSession session,FinancialBean financialBean){
		return financialService.viewFinancialDetailsTotalRows(session, financialBean);
	}
}

package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.PageUtil;

/**
 * 统计分析-运营指标相关
 * @author iver
 * @date   2015年12月26日 下午6:02:54
 */
@Controller
public class OperationController {
	
	@Autowired
	OperationService operationService;
	
	/**
	 * 统计分析-运营指标-运输准确率页面
	 * @return
	 */
	@RequestMapping("getTransportAccuracyPage")
	public String getTransportAccuracyPage(){
		return "mgmt_s_opr";
	}
	/**
	 * 统计分析-运营指标-运输准确率列表
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping("getTransportAccuracyListAjax")
	@ResponseBody
	public List<OperationBean> getTransportAccuracyListAjax(OperationBean operationBean,HttpSession session,PageUtil pageUtil){
		return operationService.getTransportAccuracyList(operationBean,session,pageUtil);
	}
	/**
	 * 统计分析-运营指标-运输准确率总记录数
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getTransportAccuracyTotalRowsAjax")
	public Long getTransportAccuracyListTotalRowsAjax(OperationBean operationBean,HttpSession session){
		return operationService.getTransportAccuracyListTotalRows(operationBean,session);
	}
	
	
	
	/**
	 * 统计分析-运营指标-客户满意度  页面
	 * @return
	 */
	@RequestMapping("getClientConsentPage")
	public String getClientConsentPage(){
		return "mgmt_s_opr3";
	}
	/**
	 * 统计分析-运营指标-客户满意度list
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@RequestMapping("getClientConsentInfoAjax")
	@ResponseBody
	public List<OperationBean> getClientConsentList(OperationBean operationBean,HttpSession session,PageUtil pageUtil){
		return operationService.getClientConsentList(operationBean,session,pageUtil);
	}
	
	/**
	 * 统计分析-运营指标-客户满意度总记录书数
	 * @param operationBean
	 * @param session
	 * @return
	 */
	@RequestMapping("getClientConsentTotalRowsAjax")
	@ResponseBody
	public Long getClientConsentTotalRows(OperationBean operationBean,HttpSession session){
		return operationService.getClientConsentTotalRows(operationBean,session);
	}
	
	
	
}

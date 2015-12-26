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
	
	@RequestMapping("getTransportAccuracyListAjax")
	@ResponseBody
	public List getTransportAccuracyListAjax(OperationBean operationBean,HttpSession session,PageUtil pageUtil){
		return operationService.getTransportAccuracyList(operationBean,session,pageUtil);
	}
	
	@ResponseBody
	@RequestMapping("")
	public Long getTransportAccuracyListTotalRowsAjax(OperationBean operationBean,HttpSession session,PageUtil pageUtil){
		return operationService.getTransportAccuracyListTotalRows(operationBean,session,pageUtil);
	}
	
	
	
	/**
	 * 统计分析-运营指标-客户满意度  页面
	 * @return
	 */
	@RequestMapping("getClientConsentPage")
	public String getClientConsentPage(){
		return "mgmt_s_opr3";
	}
	
}

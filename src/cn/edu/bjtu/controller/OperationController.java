package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.PageUtil;

/**
 * ͳ�Ʒ���-��Ӫָ�����
 * @author iver
 * @date   2015��12��26�� ����6:02:54
 */
@Controller
public class OperationController {
	
	@Autowired
	OperationService operationService;
	
	/**
	 * ͳ�Ʒ���-��Ӫָ��-����׼ȷ��ҳ��
	 * @return
	 */
	@RequestMapping("getTransportAccuracyPage")
	public String getTransportAccuracyPage(){
		return "mgmt_s_opr";
	}
	
	/**
	 * ����׼ʱ��-��ȡĳһ������ж����б�ҳ��
	 * @param date
	 * @return
	 */
	@RequestMapping("OperationDetailsPage2a")
	public String OperationDetailsPage2a(){
		return "mgmt_s_opr2a";
	}
	
	/**
	 * ͳ�Ʒ���-��Ӫָ��-����׼ȷ���б�
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
	 * ͳ�Ʒ���-��Ӫָ��-����׼ȷ���ܼ�¼��
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
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ������  ҳ��
	 * @return
	 */
	@RequestMapping("getClientConsentPage")
	public String getClientConsentPage(){
		return "mgmt_s_opr3";
	}
	/**
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ������list
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
	 * ͳ�Ʒ���-��Ӫָ��-�ͻ�������ܼ�¼����
	 * @param operationBean
	 * @param session
	 * @return
	 */
	@RequestMapping("getClientConsentTotalRowsAjax")
	@ResponseBody
	public Long getClientConsentTotalRows(OperationBean operationBean,HttpSession session){
		return operationService.getClientConsentTotalRows(operationBean,session);
	}

	/**
	 * �˿������-��ȡĳһ������ж����б�ҳ��
	 * @param date
	 * @return
	 */
	@RequestMapping("OperationDetailsPage2b")
	public String OperationDetailsPage2b(){
		return "mgmt_s_opr2b";
	}
	
	/**
	 * ����鿴ʱ������ĳһ��Ķ���
	 * @param session
	 * @param operationBean
	 * @return
	 */
	@RequestMapping("viewOperationDetailsAjax")
	@ResponseBody
	public List<OrderBean> viewFinancialDetailsPage(HttpSession session,OperationBean operationBean,PageUtil pageUtil){
		return operationService.viewOperationDetails(session, operationBean,pageUtil);
	}
	
	/**
	 * ����ָ�꣬�鿴ҳ����ܼ�¼��
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@RequestMapping("viewOperationDetailsTotalRowsAjax")
	@ResponseBody
	public Long viewFinancialDetailsTotalRows(HttpSession session,OperationBean operationBean){
		return operationService.viewOperationDetailsTotalRows(session, operationBean);
	}
}

package cn.edu.bjtu.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.SettlementRecordService;
import cn.edu.bjtu.service.SettlementService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.ExcelCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Settlement;
import cn.edu.bjtu.vo.SettlementCarrierView;

import com.alibaba.fastjson.JSONArray;

/**
 * �ҵĽ���-������
 * @author RussWest0
 *
 */
@Controller
public class SettlementController {
	public ModelAndView mv=new ModelAndView();
	@Resource(name="settlementServiceImpl")
	SettlementService settlementService;
	@Autowired
	SettlementRecordService settlementRecordService;
	
	/**
	 * ��ȡ��ǰ�û��Ľ���
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/mysettlement")
	public String getMySettlement(HttpSession session,HttpServletResponse response)
	{
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		if(userKind == 2){//��ͨ�û�ҳ��
			return "mgmt_d_settle_s";
		}else {//��ҵ�û�ҳ��
			return "mgmt_d_settle_r";
		}
	}
	
	/**
	 * �ҵĽ���(��settlement���޹أ��ɶ�����õ�)
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getUserSettlementAjax",produces="text/html;charset=UTF-8")
	public String getUserSettlement(HttpSession session,String name,PageUtil pageUtil){
		
		JSONArray jsonArray=settlementRecordService.getUserSettlement(session,name,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵļ���-�ܼ�¼����(��settlement���޹أ��ɶ�����õ�)
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserSettlementTotalRowsAjax")
	public Integer getUserSettlementTotalRows(HttpSession session){
		return settlementRecordService.getUserSettlementTotalRows(session);
	}
	
	
	/**
	 * ���ɵ������˵�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/createSingleStatement")
	public String createSingleStatement(HttpSession session,@RequestParam String orderNum,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		List orderList=settlementService.getOrderStatement(orderNum);
		SettlementCarrierView settlement = (SettlementCarrierView) orderList.get(0);
		String fname = "���˵�";
	    OutputStream os = response.getOutputStream();//ȡ�������
	    response.reset();//�������� 
	    //�����Ƕ������ļ����Ĵ���
	    response.setCharacterEncoding("UTF-8");//������Ӧ���ݵı����ʽ
	    fname = java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	    response.setContentType("application/msexcel");//�����������
	    ExcelCreator ec = new ExcelCreator();
	    ec.createSingleExcel(settlement,os);
	    //֮����Ҫ�޸Ľ���״̬Ϊ�ѽ��㣬��¼��ǰ������
	    settlementRecordService.finishSettlement(orderNum,session);
	    
	    /*RequestDispatcher dispatcher=request.getRequestDispatcher("mysettlement");
	    dispatcher.forward(request, response);*/
	    
	    return "redirect:mysettlement";
	}
	
	@RequestMapping("/createMultipleStatement")
	/**
	 * �����������˵�
	 * @param request
	 * @param response
	 * @return
	 */
	public String createMultipleStatement(HttpSession session,@RequestParam String checklist,HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		String[] statement=checklist.split(",");
		List<SettlementCarrierView> multipleStatement = new ArrayList<SettlementCarrierView>();
		for(int i=0;i<statement.length;i++)
		{
			List orderList=settlementService.getOrderStatement(statement[i]);
			SettlementCarrierView settlement = (SettlementCarrierView) orderList.get(0);
			multipleStatement.add(settlement);
			//֮����Ҫ�޸Ľ���״̬Ϊ�ѽ��㣬��¼��ǰ������
		    settlementRecordService.finishSettlement(settlement.getOrderNum(),session);
		}
		
		String fname = "�������˵�";
	    OutputStream os = response.getOutputStream();//ȡ�������
	    response.reset();//�������� 
	    //�����Ƕ������ļ����Ĵ���
	    response.setCharacterEncoding("UTF-8");//������Ӧ���ݵı����ʽ
	    fname = java.net.URLEncoder.encode(fname,"UTF-8");
	    response.setHeader("Content-Disposition","attachment;filename="+new String(fname.getBytes("UTF-8"),"GBK")+".xls");
	    response.setContentType("application/msexcel");//�����������
	    ExcelCreator ec = new ExcelCreator();
	    ec.createMultipleExcel(multipleStatement,os);
	    //settlementRecordService.finishMultipleSettlement(,session);
	    return "mgmt_d_settle_s";
	}
	
	
	/**
	 * �����ҵ���Ϣ-�����ѽ�����
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserSettlementInfoAjax")
	public String getUserSettlementInfoAjax(HttpSession session){
		Float finishedSettlementMoney=settlementService.getUserSettlementMoney(session,0);
		
		Float unFinishedSettlementMoney=settlementService.getUserSettlementMoney(session,1);
		
		return finishedSettlementMoney+"-"+unFinishedSettlementMoney;
		
		
	}
	
	@RequestMapping(value="viewSettlementRecord",produces="text/html;charset=UTF-8")
	public ModelAndView viewSettlementRecord(String orderNum){
		
		List<Settlement> settlmentList =settlementRecordService.getSettlementRecordByOrderNum(orderNum);
		
		mv.addObject("settlementList", settlmentList);
		mv.setViewName("mgmt_d_settle_s2");
		
		return mv;
		
	}
	
}

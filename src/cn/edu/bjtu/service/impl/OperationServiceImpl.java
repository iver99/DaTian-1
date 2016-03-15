package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;
@Service
@Transactional
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	OrderDao orderDao;	

	/**
	 * 财务分析-运营指标列表
	 */
	@Override
	public List<OperationBean> getTransportAccuracyList(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereHql(operationBean,session,params);
		hql+=" group by date(t.submitTime) order by t.submitTime desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> list=orderDao.find(hql, params,page,display);
		List<OperationBean> opList=new ArrayList<OperationBean>();
		//目前系统中没有关于准确率和准确意向的数据 FIXME
		for(Orderform order:list){
			OperationBean opBean=new OperationBean();
			opBean.setDate(order.getSubmitTime());
			opList.add(opBean);
		}
		
		return opList;
	}
	
	/**
	 * 财务分析-运营指标列表总记录数
	 */
	@Override
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,
			HttpSession session) {
		Map<String,Object> params=new HashMap<String,Object>();
		//hql不支持嵌套查询，所以采用sql查询
		String sql="select * from (select count(*) from (select * from Orderform t "+whereHql(operationBean,session,params);
		sql+=" group by date(t.submitTime) order by t.submitTime desc) as t2) as t3";
		return orderDao.countBySql(sql, params);
		
	}
	
	private String whereHql(OperationBean operationBean,
			HttpSession session, Map<String,Object> params){
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String whereHql=" where t.carrierId=:carrierId ";
		params.put("carrierId", userId);
		String startDate=operationBean.getStartDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getStartDate());
		String endDate=operationBean.getEndDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			whereHql+=" and t.submitTime>=:startDate ";
			params.put("startDate", operationBean.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			//这里的时间需要加一天，加到下一天的0点时间才能使结果更换准确
			whereHql+=" and t.submitTime<=:endDate ";
			params.put("endDate", operationBean.getEndDate());
		}
		return whereHql;
	}

	/**
	 * 统计分析-运营指标-客户满意度list
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	@Override
	public List<OperationBean> getClientConsentList(
			OperationBean operationBean, HttpSession session, PageUtil pageUtil) {

		//目前和运输准确率逻辑一样，故直接调用
		return getTransportAccuracyList(operationBean,session,pageUtil);
	}

	/**
	 * 统计分析-运营指标-客户满意度总记录数 
	 * @param operationBean
	 * @param session
	 * @return
	 */
	@Override
	public Long getClientConsentTotalRows(OperationBean operationBean,
			HttpSession session) {
		//目前逻辑和运输准确率一样，所以直接调用
		return getTransportAccuracyListTotalRows(operationBean,session);
	}

	
	/**
	 * 查看某一天 所有订单
	 */
	@Override
	public List<Orderform> viewOperationDetails(HttpSession session,OperationBean operationBean,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereHql(userId,operationBean,params);
		hql+=" order by t.submitTime desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> list=orderDao.find(hql, params,page,display);
		
		return list;
		
	}
	/**
	 * 获取某一天的所有订单的总记录数
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@Override
	public Long viewOperationDetailsTotalRows(HttpSession session,
			OperationBean operationBean) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Orderform t "+whereHql(userId, operationBean, params);
		hql+= " order by t.submitTime desc";
		
		return orderDao.count(hql,params);
		
	}
	
	private String whereHql(String userId,OperationBean operationBean,Map<String,Object> params){
		String wherehql="where t.carrierId=:userId ";
		params.put("userId", userId);
		String startDate=operationBean.getStartDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getStartDate());
		String endDate=operationBean.getEndDate()==null?"1970-01-01":ParseDate.DateToString(operationBean.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			wherehql+=" and t.submitTime>=:startDate ";
			params.put("startDate", operationBean.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			//这里的时间需要加一天，加到下一天的0点时间才能使结果更换准确
			wherehql+=" and t.submitTime<=:endDate ";
			params.put("endDate", operationBean.getEndDate());
		}
		//如果没有开始和结束时间则查出某一天的订单
		if("1970-01-01".equals(startDate) && "1970-01-01".equals(endDate)){
			wherehql+=" and date(t.submitTime)=:submitTime ";
			params.put("submitTime", operationBean.getDate());
		}
		
		return wherehql;
	}
}

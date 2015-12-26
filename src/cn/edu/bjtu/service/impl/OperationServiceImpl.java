package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.OperationService;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;

public class OperationServiceImpl implements OperationService{
	
	@Autowired
	OrderDao orderDao;	

	/**
	 * 财务分析-运营指标列表
	 */
	@Override
	public List getTransportAccuracyList(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select date(t.submitTime) from Orderform t "+whereHql(operationBean,session,params);
		hql+=" group by date(t.submitTime) order by t.submitTime desc";
		
		List<Orderform> list=orderDao.find(hql, params);
		List<OperationBean> opList=new ArrayList<OperationBean>();
		//目前系统中没有关于准确率和准确意向的数据 FIXME
		for(Orderform order:list){
			
		}
		
		return opList;
	}
	
	/**
	 * 财务分析-运营指标列表总记录数
	 */
	@Override
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,
			HttpSession session, PageUtil pageUtil) {
		return 0L;//FIXME
		
	}
	
	private String whereHql(OperationBean operationBean,
			HttpSession session, Map<String,Object> params){
		String whereHql=" where t.carrierId=:carrierId ";
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

	
	
}

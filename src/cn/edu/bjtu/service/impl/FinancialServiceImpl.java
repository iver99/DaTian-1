package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.v2.encounter.WeakEqualityEncounterCounter;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.service.FinancialService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.vo.Orderform;
@Service
@Transactional
public class FinancialServiceImpl implements FinancialService{

	@Autowired
	OrderDao orderDao;
	/**
	 * 获取账户财务分析数据
	 */
	@Override
	public List<FinancialBean> getAccountFinancialInfo(FinancialBean financialBean,PageUtil pageUtil,HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		//按天计算 
		Map<String,Object> params=new HashMap<String,Object>();
		String sql="select * from (select date(t.submitTime) as date,"
				+ "sum(t.actualPrice) as transportFee,"
				+ "sum(t.insurance) as totalInsurance"
				+ " from orderform t "+whereSql(userId,financialBean,params);
		sql+=" group by date(t.submitTime) order by date(t.submitTime) desc ) as t2";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objList=orderDao.findBySql(sql, params,page,display);
		List<FinancialBean> beanList=new ArrayList<FinancialBean>();
		for(Object[] obj:objList){
			FinancialBean bean=new FinancialBean();
			bean.setDate((Date)obj[0]);
			bean.setTransportFee((Double)obj[1]==null?0.0:(Double)obj[1]);
			bean.setTotalInsurance((Double)obj[2]==null?0.0:(Double)obj[2]);
			bean.setTotalFee(bean.getTotalInsurance()+bean.getTransportFee());
			beanList.add(bean);
		}
		return beanList;
	}
	private String whereSql(String userId,FinancialBean financialBean,Map<String,Object> params){
		
		String wheresql="where t.carrierId=:userId ";
		params.put("userId", userId);
		String startDate=financialBean.getStartDate()==null?"1970-01-01":ParseDate.DateToString(financialBean.getStartDate());
		String endDate=financialBean.getEndDate()==null?"1970-01-01":ParseDate.DateToString(financialBean.getStartDate());
		if(!"1970-01-01".equals(startDate)){
			wheresql+=" and t.submitTime>=:startDate";
			params.put("startDate", financialBean.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			//这里的时间需要加一天，加到下一天的0点时间才能使结果更换准确
			wheresql+=" and t.submitTime<=:endDate";
			params.put("endDate", financialBean.getEndDate());
		}
		
		return wheresql;
	}
	/**
	 * 财务指标总记录数
	 */
	@Override
	public Long getAccountFinancialInfoTotalRows(FinancialBean financialBean,HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		//按天计算
		/**不使用这么多层的嵌套查询，报
		 * [DaTian]org.hibernate.util.JDBCExceptionReporter WARN   - SQL Error: 0, SQLState: S0022
		   [DaTian]org.hibernate.util.JDBCExceptionReporter ERROR  - Column '' not found.
		 * 的错误
		 */
		Map<String,Object> params=new HashMap<String,Object>();
		String sql="select * from (select count(*) from (select date(t.submitTime) as date,"
				+ "sum(t.actualPrice) as transportFee,"
				+ "sum(t.insurance) as totalInsurance"
				+ " from orderform t "+whereSql(userId,financialBean,params);
		sql+=" group by date(t.submitTime) order by date(t.submitTime) desc ) as t2) as t3";
		
		Long count=orderDao.countBySql(sql, params);
		return count;
	}
	/**
	 * 查看某一天 所有订单
	 */
	@Override
	public List<Orderform> viewFinancialDetails(HttpSession session,FinancialBean financialBean,PageUtil pageUtil) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Orderform t "+whereHql(userId,financialBean,params);
		hql+=" order by t.submitTime desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> list=orderDao.find(hql, params,page,display);
		
		return list;
		
	}
	/**
	 * 获取莫一天的所有订单的总记录数
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@Override
	public Long viewFinancialDetailsTotalRows(HttpSession session,
			FinancialBean financialBean) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Orderform t "+whereHql(userId, financialBean, params);
		hql+= " order by t.submitTime desc";
		
		return orderDao.count(hql,params);
		
	}
	
	private String whereHql(String userId,FinancialBean financialBean,Map<String,Object> params){
		String wherehql="where t.carrierId=:userId ";
		params.put("userId", userId);
		String startDate=financialBean.getStartDate()==null?"1970-01-01":ParseDate.DateToString(financialBean.getStartDate());
		String endDate=financialBean.getEndDate()==null?"1970-01-01":ParseDate.DateToString(financialBean.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			wherehql+=" and t.submitTime>=:startDate ";
			params.put("startDate", financialBean.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			//这里的时间需要加一天，加到下一天的0点时间才能使结果更换准确
			wherehql+=" and t.submitTime<=:endDate ";
			params.put("endDate", financialBean.getEndDate());
		}
		//如果没有开始和结束时间则查出某一天的订单
		if("1970-01-01".equals(startDate) && "1970-01-01".equals(endDate)){
			wherehql+=" and date(t.submitTime)=:submitTime ";
			params.put("submitTime", financialBean.getDate());
		}
		
		return wherehql;
	}
	
	
	
	
	

}

package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.dao.SettlementRecordDao;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.service.SettlementRecordService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Orderform;
import cn.edu.bjtu.vo.Settlement;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Service
@Transactional
public class SettlementRecordServiceImpl implements SettlementRecordService{
	
	@Autowired
	OrderService orderService;
	@Autowired
	OrderDao orderDao;
	@Autowired
	SettlementRecordDao settlementRecordDao;
	@Autowired
	CompanyDao companyDao;
	/**
	 * 修改订单状态为已结算，并记录生成人
	 */
	@Override
	public boolean finishSettlement(String orderNum, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String username=(String)session.getAttribute(Constant.USER_NAME);
		String userKind = (Integer)session.getAttribute(Constant.USER_KIND)+"";
		Orderform order=orderService.getOrderByOrderNum(orderNum);
		if(userKind.equals("2")){ //个人用户
			order.setSettlementState("已生成");
		}else if(userKind.equals("3")){//公司用户
			order.setSettlementStateCompany("已生成");
		}
		Settlement settlement=new Settlement();
		settlement.setId(IdCreator.createSettlementId());
		settlement.setOrderNum(orderNum);
		settlement.setUserId(userId);
		settlement.setOrderId(order.getId());//add by RussWest0 at 2015年6月25日,下午9:33:21 
		settlement.setCreateTime(new Date());
		settlement.setUsername(username);
		settlementRecordDao.save(settlement);//保存生成对账单记录
		orderDao.update(order);
		
		return true;
		
	}
	
	/**
	 * 根据订单号获取结算生成记录
	 */
	@Override
	public List<Settlement> getSettlementRecordByOrderNum(String userId,String orderNum) {
		
		String hql="from Settlement t where t.orderNum=:orderNum and t.userId=:userId order by createTime desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderNum", orderNum);
		params.put("userId", userId);
		
		return settlementRecordDao.find(hql, params);
	}

	/**
	 * 我的结算(与settlement表无关，由订单表得到)
	 */
	@Override
	public JSONArray getUserSettlement(HttpSession session,String name,PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="from Orderform t "+whereHql(name,params);
		hql+=" and t.state='已完成' ";
		if(userKind==2){//个人用户
			hql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind ==3){//企业用户
			hql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		
		hql+=" order by t.submitTime desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Orderform> orderList=orderDao.find(hql, params,page,display);
		List<OrderBean> beanList=new ArrayList<OrderBean>();
		for(Orderform order:orderList){
			OrderBean bean=new OrderBean();
			BeanUtils.copyProperties(order, bean);
			Carrierinfo company=companyDao.get(Carrierinfo.class,order.getCarrierId());
			bean.setCompanyName(company.getCompanyName());
			
			beanList.add(bean);
		}
		
		JSONArray jsonArray=new JSONArray();
		for(OrderBean orderBean:beanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(orderBean);
			
			jsonArray.add(jsonObject);
		}
		return jsonArray;
		
	}
	/*
	 * wherer hql 供搜索使用
	 */
	private String whereHql(String name,Map<String,Object> params){
		String hql="where 1=1 ";
		if(name !=null && !"".equals(name)){
			//订单编号或者合同号 
			hql+="and t.orderNum like'%"+name+"%' or t.contractId like '%"+name+"%' ";
		}
		return hql;
	}

	/**
	 * 我的结算-总记录数(与settlement表无关，由订单表得到)
	 */
	@Override
	public Integer getUserSettlementTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="select count(*) from Orderform t where t.state='已完成' ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){//个人用户
			hql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind ==3){//企业用户
			hql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		Long count=orderDao.count(hql, params);
		return count.intValue();
		
	}
	
	
}

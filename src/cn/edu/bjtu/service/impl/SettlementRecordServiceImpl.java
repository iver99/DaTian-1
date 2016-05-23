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
	 * �޸Ķ���״̬Ϊ�ѽ��㣬����¼������
	 */
	@Override
	public boolean finishSettlement(String orderNum, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String username=(String)session.getAttribute(Constant.USER_NAME);
		String userKind = (Integer)session.getAttribute(Constant.USER_KIND)+"";
		Orderform order=orderService.getOrderByOrderNum(orderNum);
		if(userKind.equals("2")){ //�����û�
			order.setSettlementState("������");
		}else if(userKind.equals("3")){//��˾�û�
			order.setSettlementStateCompany("������");
		}
		Settlement settlement=new Settlement();
		settlement.setId(IdCreator.createSettlementId());
		settlement.setOrderNum(orderNum);
		settlement.setUserId(userId);
		settlement.setOrderId(order.getId());//add by RussWest0 at 2015��6��25��,����9:33:21 
		settlement.setCreateTime(new Date());
		settlement.setUsername(username);
		settlementRecordDao.save(settlement);//�������ɶ��˵���¼
		orderDao.update(order);
		
		return true;
		
	}
	
	/**
	 * ���ݶ����Ż�ȡ�������ɼ�¼
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
	 * �ҵĽ���(��settlement���޹أ��ɶ�����õ�)
	 */
	@Override
	public JSONArray getUserSettlement(HttpSession session,String name,PageUtil pageUtil) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="from Orderform t "+whereHql(name,params);
		hql+=" and t.state='�����' ";
		if(userKind==2){//�����û�
			hql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind ==3){//��ҵ�û�
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
	 * wherer hql ������ʹ��
	 */
	private String whereHql(String name,Map<String,Object> params){
		String hql="where 1=1 ";
		if(name !=null && !"".equals(name)){
			//������Ż��ߺ�ͬ�� 
			hql+="and t.orderNum like'%"+name+"%' or t.contractId like '%"+name+"%' ";
		}
		return hql;
	}

	/**
	 * �ҵĽ���-�ܼ�¼��(��settlement���޹أ��ɶ�����õ�)
	 */
	@Override
	public Integer getUserSettlementTotalRows(HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="select count(*) from Orderform t where t.state='�����' ";
		Map<String,Object> params=new HashMap<String,Object>();
		if(userKind==2){//�����û�
			hql+=" and t.clientId=:clientId ";
			params.put("clientId", userId);
		}else if(userKind ==3){//��ҵ�û�
			hql+=" and t.carrierId=:carrierId ";
			params.put("carrierId", userId);
		}
		Long count=orderDao.count(hql, params);
		return count.intValue();
		
	}
	
	
}

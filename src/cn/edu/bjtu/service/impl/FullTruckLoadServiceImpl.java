/**
 * 
 */
package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.dao.TruckDao;
import cn.edu.bjtu.service.FullTruckLoadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;

/**
 * @author solitudeycq
 *
 */
@Transactional
@Repository
public class FullTruckLoadServiceImpl implements FullTruckLoadService {
    
	@Autowired
	TruckDao truckDao;
	/**
	 * 资源栏获取筛选整车资源
	 * 
	 */
	@Override
	public JSONArray getSelectedFullTruckLoadNew(TruckBean truckBean, PageUtil pageUtil, HttpSession session) {
		truckBean.setResourceType("整车");
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.startCity,"
				+ "t1.endCity,"
				+ "t1.onwayTime,"
				+ "t1.carType,"
				+ "t1.carLength,"
				+ "t1.stanPrice1,"
				+ "t1.stanPrice2,"
				+ "t1.pickFee,"
				+ "t1.deliveryFee,"
				+ "t1.offerReturn,"
				+ "t1.extraService,"
				+ "t1.relDate,"
				+ "t1.carrierId,"
				+ "t1.remarks,"
				+ "t1.picture,"
				+ "t1.resourceType,"
				+ "t3.status "
				+ " from truck t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='fulltruckload' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='fulltruckload' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(truckBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=truckDao.findBySql(sql, params,page,display);
		
		List<TruckBean> fulltruckloadList=new ArrayList<TruckBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			TruckBean truckbean=new TruckBean();
			Object[] obj=it.next();
			truckBean.setId((String)obj[0]);
			truckBean.setStartCity((String)obj[1]);
			truckBean.setEndCity((String)obj[2]);
			truckBean.setOnwayTime((String)obj[3]);
			truckBean.setCarType((String)obj[4]);
			truckBean.setCarLength((String)obj[5]);
			truckBean.setStanPrice1((Float)obj[6]);
			truckBean.setStanPrice2((Float)obj[7]);
			truckBean.setPickFee((Float)obj[8]);
			truckBean.setDeliveryFee((Float)obj[9]);
			truckBean.setOfferReturn((String)obj[10]);
			truckBean.setExtraService((String)obj[11]);
			truckBean.setRelDate((Date)obj[12]);
			truckBean.setCarrierId((String)obj[13]);
			truckBean.setRemarks((String)obj[14]);
			truckBean.setPicture((String)obj[15]);
			truckBean.setResourceType((String)obj[16]);
			if((truckBean.getResourceType()).equals("整车")){
			     fulltruckloadList.add(truckBean);
			}
		}
		
		for(int i=0;i<fulltruckloadList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(fulltruckloadList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * where sql
	 * @param citylineBean
	 * @param params
	 * @return
	 */
	private String whereSql(TruckBean truckBean,Map<String,Object> params){
		
		String wheresql=" where 1=1 ";
		if (truckBean.getStartCity() != null
				&& !truckBean.getStartCity().trim().equals("中文或拼音")
				&& !truckBean.getStartCity().equals("")&& !truckBean.getStartCity().equals("全国")) {
			wheresql+=" and t1.startCity=:startCity ";
			params.put("startCity", truckBean.getStartCity());
		}
		if (truckBean.getEndCity() != null
				&& !truckBean.getEndCity().trim().equals("中文或拼音")
				&& !truckBean.getEndCity().equals("")&& !truckBean.getEndCity().equals("全国")) {
			wheresql+=" and t1.endCity=:endCity ";
			params.put("endCity", truckBean.getEndCity());
		}
		if (truckBean.getCarLength() != null && !truckBean.getEndCity().trim().equals("All")
				&& !truckBean.getCarLength().equals("")) {
			String  carLength = truckBean.getCarLength();
			if (carLength.equals("4.2米")) {
				wheresql+=" and t1.carLength=4.2";
			}
			if (carLength.equals("6.2米")) {
				wheresql+=" and t1.carLength=6.2";
			}
			if (carLength.equals("7.6米")) {
				wheresql+=" and t1.carLength=7.6";
			}
			if (carLength.equals("9.5米")) {
				wheresql+=" and t1.carLength=9.5";
			}
			if (carLength.equals("12.5米")) {
				wheresql+=" and t1.carLength=12.5";
			}
			if (carLength.equals("17.5米")) {
				wheresql+=" and t1.carLength=17.5";
			}
		}
		if (truckBean.getCarType() != null && !truckBean.getCarType().trim().equals("All")
				&& !truckBean.getCarType().equals("")) {
			wheresql+=" and t1.carType=:carType ";
			params.put("carType", truckBean.getCarType());
		}
		if(truckBean.getOnwayTime()!=null && !truckBean.getOnwayTime().trim().equals("") && !truckBean.getOnwayTime().trim().equals("All")){
			String onwayTime=truckBean.getOnwayTime().trim();
			if(onwayTime.equals("24小时以内")){
				wheresql+=" and t1.onwayTime <= 24 ";
			}
			if(onwayTime.equals("48小时以内")){
				wheresql+=" and t1.onwayTime >= 24 and t1.onwayTime <= 48 ";
			}
			if(onwayTime.equals("72小时以内")){
				wheresql+=" and t1.onwayTime >=48 and t1.onwayTime <= 72 ";
			}
		}
		return wheresql;
	}

}

package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.dao.TruckDao;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Truck;

@Transactional
@Service("LesstruckloadServiceImpl")
public class LesstruckloadServiceImpl implements LesstruckloadService {
		@Autowired
		TruckDao truckDao;

/*		@Autowired
		CarTeamDao carTeamDao;
		@Resource
		LinetransportService linetransportService;*/
		
		@Autowired
		FocusService focusService;
		
		
		/**
		 * 返回资源栏筛选零担
		 */
		@Override
		public JSONArray getSelectedLesstruckloadNew(TruckBean truckBean,PageUtil pageUtil, HttpSession session) {
			String userId=(String)session.getAttribute(Constant.USER_ID);
			Map<String,Object> params=new HashMap<String,Object>();
				String sql = "select t1.id,"
					+ "t1.startCity,"
					+ "t1.endCity,"
					+ "t1.carrierId,"
					+ "t1.onwayTime,"
					+ "t1.offerReturn,"
					+ "t1.stanPrice1,"
					+ "t1.stanPrice2,"
					+ "t1.relDate,"
					+ "t3.status "
					+ " from truck t1 "
					+ "left join ("
					+ "select * from focus t2 ";
					
			if(userId!=null){//如果当前有用户登录在条件中加入用户信息
				sql+=" where t2.focusType='lesstruckload' and t2.clientId=:clientId ";
				params.put("clientId", userId);
			}else{
				sql+=" where t2.focusType='lesstruckload' and t2.clientId='' ";
			}
			sql+=") t3 on t1.id=t3.focusId ";
			String wheresql=whereSql(truckBean,params);
			sql+=wheresql+" order by t1.relDate desc";
			
			JSONArray jsonArray = new JSONArray();
			int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
			List<Object[]> objectList=truckDao.findBySql(sql, params,page,display);
			
			List<TruckBean> lesstruckloadList=new ArrayList<TruckBean>();
			for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
				TruckBean truckbean=new TruckBean();
				Object[] obj=it.next();
				truckbean.setId((String)obj[0]);
				truckbean.setStartCity((String)obj[1]);
				truckbean.setEndCity((String)obj[2]);
				truckbean.setCarrierId((String)obj[3]);
				truckbean.setOnwayTime((String)obj[4]);
				truckbean.setOfferReturn((String)obj[5]);
				truckbean.setStanPrice1((Float)obj[6]);
				truckbean.setStanPrice2((Float)obj[7]);
				truckbean.setRelDate((Date)obj[8]);
				truckBean.setResourceType((String)obj[9]);
				if((truckBean.getResourceType()).equals("零担")){
				     lesstruckloadList.add(truckBean);
				}
			}
			
			for(int i=0;i<lesstruckloadList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lesstruckloadList.get(i));
				jsonArray.add(jsonObject);
			}
			return jsonArray;
		}

		/**
		 * where sql
		 * @param truckBean
		 * @param params
		 * @return
		 */
		private String whereSql(TruckBean truckBean,Map<String,Object> params){
			String wheresql=" where 1=1 ";
			if(truckBean.getStartCity()!=null && !truckBean.getStartCity().trim().equals("中文或拼音")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("全国")){
				wheresql+=" and t1.startCity=:startCity ";
				params.put("startCity", truckBean.getStartCity());
			}
			if(truckBean.getEndCity()!=null && !truckBean.getEndCity().trim().equals("中文或拼音")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("全国")){
				wheresql+=" and t1.endPlace=:endCity ";
				params.put("endPlace", truckBean.getEndCity());
			}
/*			if(carBean.getCarBase()!=null && !carBean.getCarBase().equals("") && !carBean.getCarBase().equals("All")){
				wheresql+=" and t1.carBase=:carBase ";
				params.put("carBase", carBean.getCarBase());
			}*/
			if(truckBean.getOnwayTime()!=null && !truckBean.getOnwayTime().trim().equals("All") && !truckBean.getOnwayTime().trim().equals("")){
				String onwayTime=truckBean.getOnwayTime();
				if (onwayTime.equals("24小时以内")) {
					wheresql+=" and t1.onwayTime <= 24";
				}
				if (onwayTime.equals("48小时以内")) {
					wheresql+="  and t1.onwayTime >= 24 and t1.onwayTime <= 48 ";
				}
				if (onwayTime.equals("72小时以内")) {
					wheresql+=" and t1.onwayTime >=48 and t1.onwayTime <= 72";
				}
			}
			if(truckBean.getOfferReturn()!=null && !truckBean.getOfferReturn().trim().equals("All")&& !truckBean.getOfferReturn().trim().equals("")){
				
				String offerReturn=truckBean.getOfferReturn();
				if (offerReturn.equals("提供回程")) {
					wheresql+=" and t1.offerReturn= '是'";
				}
				if (offerReturn.equals("不提供回程")) {
					wheresql+=" and t1.offerReturn='否' ";
				}
			}
			
			return wheresql;
		}
		
		
		
/*		@Override
		*//**
		 * 返回特定车辆信息
		 *//*
		public Truck getCarInfo(String carid) {
			

			return truckDao.get(Truck.class, carid);
		}*/
		
		
		
	
		/**
		 * 字符创转为日期类型
		 * @param str
		 * @return
		 */
		private static Date stringToDate(String str) {  
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        Date date = null;  
	        try {  
	            // Fri Feb 24 00:00:00 CST 2012  
	            date = format.parse(str);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        // 2012-02-24  
	        date = java.sql.Date.valueOf(str);  
	                                              
	        return date;  
			} 
		

		/**
		 * 返回资源栏-零担筛选记录总条数
		 */
		@Override
		public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean) {
			
			Map<String,Object> params=new HashMap<String,Object>();
			String hql="select count(*) from CarCarrierView t1"+whereSql(truckBean, params);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
		}


		
		/**
		 * 我的信息-零担信息-总记录条数(后台，未修改)
		 *//*
		@Override
		public Integer getLesstruckloadResourceTotalRows(HttpSession session) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			String hql="select count(*) from Carinfo t where t.carrierId=:carrierId";
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
			
		}

		*//**
		 * 我的信息-零担信息（后台，未修改）
		 *//*
		@Override
		public JSONArray getUserCarResource(HttpSession session,PageUtil pageUtil) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			String hql="from Carinfo t where t.carrierId=:carrierId order by t.relDate desc";
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
			List<Carinfo> carList=carDao.find(hql, params,page,display);
			JSONArray jsonArray=new JSONArray();
			for(Carinfo car:carList){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(car);
				jsonArray.add(jsonObject);
			}
			
			return jsonArray;
		}
*/
/*		
		 * 获取公司车辆 资源
		 * @see cn.edu.bjtu.service.CarService#getCompanyCarAjax(java.lang.String)
		 
		@Override
		public String getCompanyCarAjax(String carrierId) {
			String hql = "from Carinfo t where t.carrierId=:carrierId order by t.relDate desc";

			Map<String, Object> params = new HashMap<String, Object>();

			params.put("carrierId", carrierId);

			List<Carinfo> carList = carDao.find(hql, params);

			JSONArray jsonArray = new JSONArray();

			for (Carinfo car : carList) {
				JSONObject jsonObject = (JSONObject) JSONObject.toJSON(car);
				jsonArray.add(jsonObject);
			}

			return jsonArray.toString();
		}*/

	}



		

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.TruckDao;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Truck;

@Transactional
@Service("LesstruckloadServiceImpl")
public class LesstruckloadServiceImpl implements LesstruckloadService {
		@Autowired
		TruckDao truckDao;	
		@Autowired
		CompanyDao companyDao;
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
				Object[] obj=it.next();
				String carrierId = (String)obj[13];
				Carrierinfo carrierInfo = companyDao.get(Carrierinfo.class, carrierId);
				TruckBean truckBean1 = new TruckBean();
				truckBean1.setCompanyName(carrierInfo.getCompanyName());
				truckBean1.setId((String)obj[0]);
				truckBean1.setStartCity((String)obj[1]);
				truckBean1.setEndCity((String)obj[2]);
				truckBean1.setOnwayTime(((Integer)obj[3]).toString());
				//truckBean1.setCarType((String)obj[4]);
				//truckBean1.setCarLength(((Float)obj[5]).toString());
				truckBean1.setStanPrice1((Float)obj[6]);
				truckBean1.setStanPrice2((Float)obj[7]);
				truckBean1.setPickFee((Float)obj[8]);
				truckBean1.setDeliveryFee((Float)obj[9]);
				truckBean1.setOfferReturn((String)obj[10]);
				truckBean1.setExtraService((String)obj[11]);
				truckBean1.setRelDate((Date)obj[12]);
				truckBean1.setCarrierId((String)obj[13]);
				truckBean1.setRemarks((String)obj[14]);
				truckBean1.setPicture((String)obj[15]);
				truckBean1.setResourceType((String)obj[16]);
				truckBean1.setStatus((String)obj[17]);
				lesstruckloadList.add(truckBean1);
				/*if((truckBean1.getResourceType()).equals("零担")){
				     
				}*/
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
			String wheresql=" where 1=1 and t1.resourceType='零担' ";
			if(truckBean.getStartCity()!=null && !truckBean.getStartCity().trim().equals("中文或拼音")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("全国")){
				wheresql+=" and t1.startCity like '%"+truckBean.getStartCity()+"%' ";
				//params.put("startCity", truckBean.getStartCity());
			}
			if(truckBean.getEndCity()!=null && !truckBean.getEndCity().trim().equals("中文或拼音")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("全国")){
				wheresql+=" and t1.endCity like '%"+truckBean.getEndCity()+"%' ";
				//params.put("endPlace", truckBean.getEndCity());
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
					wheresql+="  and t1.onwayTime > 24 and t1.onwayTime <= 48 ";
				}
				if (onwayTime.equals("72小时以内")) {
					wheresql+=" and t1.onwayTime > 48 and t1.onwayTime <= 72";
				}
			}
			if(truckBean.getOfferReturn()!=null && !truckBean.getOfferReturn().trim().equals("All")&& !truckBean.getOfferReturn().trim().equals("")){
				
				String offerReturn=truckBean.getOfferReturn();
				if (offerReturn.equals("提供回程")) {
					wheresql+=" and t1.offerReturn= '是' or t1.offerReturn='有' ";
				}
				if (offerReturn.equals("不提供回程")) {
					wheresql+=" and t1.offerReturn='否' ";
				}
			}
			
			return wheresql;
		}
		
		
		@Override
		public Truck getLesstruckloadInfo(String truckId) {
			
			return truckDao.get(Truck.class, truckId);
		}
	    
	
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
			String hql="select count(*) from Truck t1"+whereSql(truckBean, params);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
		}


		
        /**
		 * 我的信息-零担信息-总记录条数
		 */
		@Override
		public Integer getSelectedLesstruckloadresourceTotalRows(HttpSession session) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			String hql="select count(*) from Truck t where t.carrierId=:carrierId";
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
			
		}

		/**
		 * 我的信息-零担信息，显示资源
		 */
		@Override
		public JSONArray getSelectedLesstruckloadresourceloadNew(HttpSession session, PageUtil pageUtil) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			String hql="from Truck  where carrierId=:carrierId order by relDate desc";
			int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
			List<Truck> list=truckDao.find(hql, params,page,display);
			
			JSONArray jsonArray=new JSONArray();
			for(int i=0;i<list.size();i++){
				Truck truckBean=new Truck();
				BeanUtils.copyProperties(list.get(i), truckBean);
				if(truckBean.getResourceType().equals("零担")){
					JSONObject jsonObject=(JSONObject)JSONObject.toJSON(truckBean);
					jsonArray.add(jsonObject);
				}
			}
			return jsonArray;
		}
		
		//添加
		@Override
		public boolean insertNewLesstruckload(Truck truck, HttpServletRequest request, MultipartFile file) {
			String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
			//保存文件
			String fileLocation=UploadFile.uploadFile(file, carrierId, "lesstruckload");
			
			truck.setRelDate(new Date());
			truck.setCarrierId(carrierId);
			truck.setId(IdCreator.createTruckId());
			truck.setResourceType("零担");
			
			//设置文件位置 
			truck.setPicture(fileLocation);
			truckDao.save(truck);// 保存实体
			return true;
		}

		@Override
		public boolean deleteLesstruckload(String id) {
		    Truck truck = getLesstruckloadInfo(id);
		    truckDao.delete(truck);
		    //把此关注表中的此干线信息设置为失效
			
		    focusService.setInvalid(id);
			return true;
		}
		
		//更新
		@Override
		public boolean updateLesstruckload(Truck truck, HttpServletRequest request, MultipartFile file) {
			String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
			//保存文件
			String fileLocation=UploadFile.uploadFile(file, carrierId, "lesstruckload");

			Truck truckInstance = truckDao.get(Truck.class,truck.getId());
			truckInstance.setStartCity(truck.getStartCity());
			truckInstance.setEndCity(truck.getEndCity());
			truckInstance.setOnwayTime(truck.getOnwayTime());
			truckInstance.setStanPrice1(truck.getStanPrice1());
			truckInstance.setStanPrice2(truck.getStanPrice2());
			truckInstance.setPickFee(truck.getPickFee());
			truckInstance.setDeliveryFee(truck.getDeliveryFee());
			truckInstance.setOfferReturn(truck.getOfferReturn());
			truckInstance.setExtraService(truck.getExtraService());
			truckInstance.setRemarks(truck.getRemarks());
			
			
			//设置文件位置 
			truckInstance.setPicture(fileLocation);

			//更新
			truckDao.update(truckInstance);
			return true;
		}


	}



		

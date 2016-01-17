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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.dao.AirLineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.service.AirLineService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.AirLine;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Truck;

/**
 * @author solitudeycq
 *
 */
@Transactional
@Repository
public class AirLineServiceImpl implements AirLineService {
	
	@Autowired
	AirLineDao airlineDao;
	@Autowired
	CompanyDao companyDao;
	@Autowired
	FocusService focusService;

	@Override
	public JSONArray getSelectedAirLineNew(AirLineSearchBean airlineBean, PageUtil pageUtil, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.startCity,"
				+ "t1.endCity,"
				+ "t1.onwayTime,"
				+ "t1.extraService,"
				+ "t1.price1,"
				+ "t1.price2,"
				+ "t1.price3,"
				+ "t1.price4,"
				+ "t1.price5,"
				+ "t1.pickFee,"
				+ "t1.deliveryFee,"
				+ "t1.picture,"
				+ "t1.remarks,"
				+ "t1.carrierId,"
				+ "t1.relDate,"
				+ "t3.status "
				+ " from airline t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//如果当前有用户登录在条件中加入用户信息
			sql+=" where t2.focusType='airline' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='airline' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(airlineBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=airlineDao.findBySql(sql, params,page,display);
		
		List<AirLineSearchBean> airlineList=new ArrayList<AirLineSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			Object[] obj=it.next();
			String carrierId = (String)obj[14];
			Carrierinfo carrierInfo = companyDao.get(Carrierinfo.class, carrierId);
			AirLineSearchBean airlineBean1 = new AirLineSearchBean();
			airlineBean1.setCompanyName(carrierInfo.getCompanyName());
			airlineBean1.setId((String)obj[0]);
			airlineBean1.setStartCity((String)obj[1]);
			airlineBean1.setEndCity((String)obj[2]);
			airlineBean1.setOnwayTime((String)obj[3]);
			airlineBean1.setExtraService((String)obj[4]);
			airlineBean1.setPrice1((Float)obj[5]);
			airlineBean1.setPrice2((Float)obj[6]);
			airlineBean1.setPrice3((Float)obj[7]);
			airlineBean1.setPrice4((Float)obj[8]);
			airlineBean1.setPrice5((Float)obj[9]);
			airlineBean1.setPickFee((Float)obj[10]);
			airlineBean1.setDeliveryFee((Float)obj[11]);
			airlineBean1.setPicture((String)obj[12]);
			airlineBean1.setRemarks((String)obj[13]);
			airlineBean1.setCarrierId((String)obj[14]);
			airlineBean1.setRelDate((Date)obj[15]);
			airlineList.add(airlineBean1);
		}
		for(int i=0;i<airlineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(airlineList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * where sql
	 * @param airlineBean
	 * @param params
	 * @return
	 */
	private String whereSql(AirLineSearchBean airlineBean,Map<String,Object> params){
		
		String wheresql=" where 1=1 ";
		if (airlineBean.getStartCity() != null
				&& !airlineBean.getStartCity().trim().equals("中文或拼音")
				&& !airlineBean.getStartCity().equals("")&& !airlineBean.getStartCity().equals("全国")) {
			wheresql+=" and t1.startCity=:startCity ";
			params.put("startCity", airlineBean.getStartCity());
		}
		if (airlineBean.getEndCity() != null
				&& !airlineBean.getEndCity().trim().equals("中文或拼音")
				&& !airlineBean.getEndCity().equals("")&& !airlineBean.getEndCity().equals("全国")) {
			wheresql+=" and t1.endCity=:endCity ";
			params.put("endCity", airlineBean.getEndCity());
		}
		if (airlineBean.getOnwayTime() != null && !airlineBean.getOnwayTime().trim().equals("All")
				&& !airlineBean.getOnwayTime().equals("")) {
			String  onwayTime = airlineBean.getOnwayTime();
			if (onwayTime.equals("12小时抵运")) {
				wheresql+=" and t1.onwayTime=:time";
				params.put("time", "12小时");
			}
			if (onwayTime.equals("24小时抵运")) {
				wheresql+=" and t1.onwayTime=:time";
				params.put("time", "24小时");
			}
			if (onwayTime.equals("48小时抵运")) {
				wheresql+=" and t1.onwayTime=:time";
				params.put("time", "48小时");
			}
		}
		return wheresql;
	}

	@Override
	public AirLine getAirLineInfo(String airrlineId) {
		
		return airlineDao.get(AirLine.class, airrlineId);
	}

	@Override
	public JSONArray getAirLineResource(HttpSession session, PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		String hql="from AirLine  where carrierId=:carrierId order by relDate desc";
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<AirLine> list=airlineDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<list.size();i++){
			AirLine airline=new AirLine();
			BeanUtils.copyProperties(list.get(i), airline);
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(airline);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	@Override
	public boolean insertNewAirLine(AirLine airline, HttpServletRequest request, MultipartFile file) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "airline");
		
		airline.setRelDate(new Date());
		airline.setCarrierId(carrierId);
		airline.setId(IdCreator.createAirLineId());
		
		//设置文件位置 
		airline.setPicture(fileLocation);
		airlineDao.save(airline);// 保存实体
		return true;
	}

	@Override
	public boolean updateAirLine(AirLine airline, HttpServletRequest request, MultipartFile file) {
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//保存文件
		String fileLocation=UploadFile.uploadFile(file, carrierId, "airline");

		AirLine airlineInstance = airlineDao.get(AirLine.class,airline.getId());
		airlineInstance.setStartCity(airline.getStartCity());
		airlineInstance.setEndCity(airline.getEndCity());
		airlineInstance.setOnwayTime(airline.getOnwayTime());
		airlineInstance.setPrice1(airline.getPrice1());
		airlineInstance.setPrice2(airline.getPrice2());
		airlineInstance.setPrice3(airline.getPrice3());
		airlineInstance.setPrice4(airline.getPrice4());
		airlineInstance.setPrice5(airline.getPrice5());
		airlineInstance.setPickFee(airline.getPickFee());
		airlineInstance.setDeliveryFee(airline.getDeliveryFee());
		airlineInstance.setExtraService(airline.getExtraService());
		airlineInstance.setRemarks(airline.getRemarks());
		
		
		//设置文件位置 
		airlineInstance.setPicture(fileLocation);

		//更新
		airlineDao.update(airlineInstance);
		return true;
	}
}

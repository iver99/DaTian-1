package cn.edu.bjtu.service.impl;

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
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.service.CitylineService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Cityline;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Transactional
@Repository
/**
 * �������ͷ����ʵ��
 * @author RussWest0
 *
 */
public class CitylineServiceImpl implements CitylineService {

	@Resource
	CitylineDao citylineDao;
	@Autowired 
	FocusService focusService;
	/**
	 * ��Դ����ȡɸѡ��������
	 */
	@Override
	public JSONArray getSelectedLineNew(CityLineSearchBean cityLineBean,
			PageUtil pageUtil, HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.cityName,"
				+ "t1.name,"
				+ "t1.refPrice,"
				+ "t1.relDate,"
				+ "t1.VIPService,"
				+ "t1.creditRate,"
				+ "t1.companyName,"
				+ "t1.standPrice1,"
				+ "t1.standPrice2,"
				+ "t1.pickFee,"
				+ "t1.deliveryFee,"
				+ "t3.status "
				+ " from city_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//�����ǰ���û���¼�������м����û���Ϣ
			sql+=" where t2.focusType='cityline' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='cityline' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(cityLineBean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=citylineDao.findBySql(sql, params,page,display);
		
		List<CityLineSearchBean> citylineList=new ArrayList<CityLineSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CityLineSearchBean citylinebean=new CityLineSearchBean();
			Object[] obj=it.next();
			citylinebean.setId((String)obj[0]);
			citylinebean.setCarrierId((String)obj[1]);
			citylinebean.setCityName((String)obj[2]);
			citylinebean.setName((String)obj[3]);;
			citylinebean.setRefPrice((Float)obj[4]+"");
			citylinebean.setRelDate((Date)obj[5]);
			citylinebean.setVIPService((String)obj[6]);
			citylinebean.setCreditRate((Integer)obj[7]);
			citylinebean.setCompanyName((String)obj[8]);
			citylinebean.setStandPrice1((Float)obj[9]);
			citylinebean.setStandPrice2((Float)obj[10]);
			citylinebean.setPickFee((Float)obj[11]);
			citylinebean.setDeliveryFee((Float)obj[12]);
			citylinebean.setStatus((String)obj[13]);
			citylineList.add(citylinebean);
		}
		
		for(int i=0;i<citylineList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(citylineList.get(i));
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
	private String whereSql(CityLineSearchBean citylineBean,Map<String,Object> params){
		
		String wheresql=" where 1=1 ";
		if (citylineBean.getCityName() != null
				&& !citylineBean.getCityName().trim().equals("���Ļ�ƴ��")
				&& !citylineBean.getCityName().equals("")&& !citylineBean.getCityName().equals("ȫ��")) {
			wheresql+=" and t1.cityName like '%"+citylineBean.getCityName()+"%' ";
			//params.put("cityName", citylineBean.getCityName());
		}
		if(citylineBean.getRefPrice()!=null && !citylineBean.getRefPrice().trim().equals("") && !citylineBean.getRefPrice().trim().equals("All")){
			String refPrice=citylineBean.getRefPrice().trim();
			if(refPrice.equals("����2Ԫ/kg")){
				wheresql+=" and t1.refPrice >= 2 ";
			}
			if(refPrice.equals("1��2Ԫ/kg")){
				wheresql+=" and t1.refPrice >= 1 and t1.refPrice <= 2 ";
			}
			if(refPrice.equals("С��1Ԫ/kg")){
				wheresql+=" and t1.refPrice <=1 ";
			}
		}
		if(citylineBean.getVIPService()!=null && !citylineBean.getVIPService().trim().equals("") && !citylineBean.getVIPService().equals("All")){
			String VIPService=citylineBean.getVIPService().trim();
			if(VIPService.equals("����ֵ����")){
				wheresql+=" and t1.VIPService='��' ";
			}
			if(VIPService.equals("����ֵ����")){
				wheresql+=" and t1.VIPService='��' ";
			}
		}
		return wheresql;
	}

	@Override
	/**
	 * ��ȡ����������Ϣ
	 */
	public Cityline getCitylineInfo(String citylineid) {
		return citylineDao.get(Cityline.class, citylineid);
	}


	@Override
	/**
	 * ������������
	 */
	public boolean insertNewCityline(Cityline cityline,
			HttpServletRequest request, MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "cityline");

		cityline.setCarrierId(carrierId);
		cityline.setRelDate(new Date());
		cityline.setId(IdCreator.createCityLineId());
		
		//�����ļ�λ�� 
		cityline.setDetailPrice(fileLocation);
		citylineDao.save(cityline);// ����ʵ��
		return true;
	}

	
	@Override
	public boolean updateNewCityline(Cityline cityline,
			HttpServletRequest request,MultipartFile file) {
		
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "cityline");

		Cityline citylineInstance = citylineDao.get(Cityline.class,cityline.getId());
		citylineInstance.setName(cityline.getName());
		citylineInstance.setCityName(cityline.getCityName());
		citylineInstance.setVIPService(cityline.getVIPService());
		citylineInstance.setVIPDetail(cityline.getVIPDetail());
		citylineInstance.setRefPrice(cityline.getRefPrice());
		citylineInstance.setRemarks(cityline.getRemarks());
		citylineInstance.setStandPrice1(cityline.getStandPrice1());
		citylineInstance.setStandPrice2(cityline.getStandPrice2());
		citylineInstance.setPickFee(cityline.getPickFee());
		citylineInstance.setDeliveryFee(cityline.getDeliveryFee());
		//citylineInstance.setRelDate(new Date());
		
		//�����ļ�λ�� 
		citylineInstance.setDetailPrice(fileLocation);

		//����
		citylineDao.update(citylineInstance);
		return true;
		
		
	}
	
	
	/**
	 * ɾ����������
	 */
	@Override
	public boolean deleteCityline(String id) {
		Cityline cityline = getCitylineInfo(id);// ����id���ҵ�����������Ϣ
		citylineDao.delete(cityline);
		
		//�Ѵ˹�ע���еĴ˸�����Ϣ����ΪʧЧ
		focusService.setInvalid(id);
		
		return true;
	}

	
	/***
	 * ���س�������ɸѡ��¼������
	 */
	@Override
	public Integer getSelectedCityLineTotalRows(CityLineSearchBean citylineBean) {
		
				Map<String,Object> params=new HashMap<String,Object>();
				String hql="select count(*) from CityCarrierView t1"+whereSql(citylineBean, params);
				Long count=citylineDao.count(hql, params);
				
				return count.intValue();
	}
	
	/**
	 * �ҵ���Ϣ-��������-�ܼ�¼��
	 */
	@Override
	public Integer getUserCitylineResourceTotalRows(HttpSession session) {
		String carrierId=(String) session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Cityline t where t.carrierId=:carrierId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		Long count=citylineDao.count(hql, params);
		return count.intValue();
	}

	/**
	 * �ҵ���Ϣ-��������
	 */
	@Override
	public JSONArray getUserCitylineResource(HttpSession session,PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Cityline t where t.carrierId=:carrierId order by t.relDate desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Cityline> cityLineList=citylineDao.find(hql, params,page,display);
		JSONArray jsonArray=new JSONArray();
		for(Cityline cityLine:cityLineList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(cityLine);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}

	/**
	 * ��ȡ��˾����������Դ
	 */
	@Override
	public String getCompanyCitylineResource(String carrierId) {
		String hql = "from Cityline t where t.carrierId=:carrierId order by t.relDate desc";

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("carrierId", carrierId);

		List<Cityline> cityLineList = citylineDao.find(hql, params);

		JSONArray jsonArray = new JSONArray();

		for (Cityline cityLine : cityLineList) {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(cityLine);
			jsonArray.add(jsonObject);
		}

		return jsonArray.toString();
	}
	
	
}

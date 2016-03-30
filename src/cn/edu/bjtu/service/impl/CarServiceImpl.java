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

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Transactional
@Service("carServiceImpl")
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;

	@Autowired
	CarTeamDao carTeamDao;
	@Resource
	LinetransportService linetransportService;
	
	@Autowired
	FocusService focusService;
	
	
	/**
	 * ������Դ��ɸѡcar
	 */
	@Override
	public JSONArray getSelectedCarNew(CarSearchBean carbean,
			PageUtil pageUtil, HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
			String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.carNum,"
				+ "t1.companyName,"
				+ "t1.carBase,"
				+ "t1.carState,"
				+ "t1.carLength,"
				+ "t1.carWeight,"
				+ "t1.carLocation,"
				+ "t1.relDate,"
				+ "t1.linetransportId,"
				+ "t3.status "
				+ " from car_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//�����ǰ���û���¼�������м����û���Ϣ
			sql+=" where t2.focusType='car' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='car' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(carbean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=carDao.findBySql(sql, params,page,display);
		
		List<CarSearchBean> carList=new ArrayList<CarSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			CarSearchBean carBean=new CarSearchBean();
			Object[] obj=it.next();
			carBean.setId((String)obj[0]);
			carBean.setCarrierId((String)obj[1]);
			carBean.setCarNum((String)obj[2]);
			carBean.setCompanyName((String)obj[3]);;
			carBean.setCarBase((String)obj[4]);
			carBean.setCarState((String)obj[5]);
			carBean.setCarLength((Double)obj[6]+"");
			carBean.setCarWeight((Double)obj[7]+"");;
			carBean.setCarLocation((String)obj[8]);
			carBean.setRelDate((Date)obj[9]);
			carBean.setLinetransportId((String)obj[10]);;
			carBean.setStatus((String)obj[11]);
			carList.add(carBean);
		}
		
		for(int i=0;i<carList.size();i++){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carList.get(i));
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}

	/**
	 * where sql
	 * @param carBean
	 * @param params
	 * @return
	 */
	private String whereSql(CarSearchBean carBean,Map<String,Object> params){
		String wheresql=" where 1=1 ";
		if(carBean.getStartPlace()!=null && !carBean.getStartPlace().trim().equals("���Ļ�ƴ��")&&!carBean.getStartPlace().trim().equals("")&&!carBean.getStartPlace().trim().equals("ȫ��")){
			wheresql+=" and t1.startPlace=:startPlace ";
			params.put("startPlace", carBean.getStartPlace());
		}
		if(carBean.getEndPlace()!=null && !carBean.getEndPlace().trim().equals("���Ļ�ƴ��")&&!carBean.getStartPlace().trim().equals("")&&!carBean.getStartPlace().trim().equals("ȫ��")){
			wheresql+=" and t1.endPlace=:endPlace ";
			params.put("endPlace", carBean.getEndPlace());
		}
		if(carBean.getCarBase()!=null && !carBean.getCarBase().equals("") && !carBean.getCarBase().equals("All")){
			wheresql+=" and t1.carBase=:carBase ";
			params.put("carBase", carBean.getCarBase());
		}
		if(carBean.getCarLength()!=null && !carBean.getCarLength().trim().equals("All") && !carBean.getCarLength().trim().equals("")){
			String carLength=carBean.getCarLength();
			if (carLength.equals("10��")) {
				wheresql+=" and t1.carLength=10";
			}
			if (carLength.equals("12��")) {
				wheresql+=" and t1.carLength=12";
			}
			if (carLength.equals("14��")) {
				wheresql+=" and t1.carLength=14";
			}
		}
		if(carBean.getCarWeight()!=null && !carBean.getCarWeight().trim().equals("All")&& !carBean.getCarWeight().trim().equals("")){
			
			String carWeight=carBean.getCarWeight();
			if (carWeight.equals("8��")) {
				wheresql+=" and t1.carWeight=8";
			}
			if (carWeight.equals("12��")) {
				wheresql+=" and t1.carWeight=12";
			}
			if (carWeight.equals("16��")) {
				wheresql+=" and t1.carWeight=16";
			}
			if (carWeight.equals("20��")) {
				wheresql+=" and t1.carWeight=20";
			}
		}
		
		return wheresql;
	}
	@Override
	/**
	 * �����ض�������Ϣ
	 */
	public Carinfo getCarInfo(String carid) {
		

		return carDao.get(Carinfo.class, carid);
	}

	@Override
	/**
	 * ���ӳ���
	 */
	public boolean insertNewCar(Carinfo car,HttpServletRequest request){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);//�����ļ�

		car.setId(IdCreator.createlineTransportId());
		car.setRelDate(new Date());
		car.setCarrierId(carrierId);
		car.setCarState("ͣЪ");
		carDao.save(car);
		return true;
	}

	
	@Override
	public boolean updateNewCar(Carinfo car,HttpServletRequest request){

		Carinfo carInstance = carDao.get(Carinfo.class,car.getId());
		carInstance.setCarTeam(car.getCarTeam());
		carInstance.setCarType(car.getCarType());
		carInstance.setCarBase(car.getCarBase());
		carInstance.setCarBrand(car.getCarBrand());
		carInstance.setCarUse(car.getCarUse());
		carInstance.setCarLength(car.getCarLength());
		carInstance.setCarWidth(car.getCarWidth());
		carInstance.setCarHeight(car.getCarHeight());
		carInstance.setCarWeight(car.getCarWeight());
		carInstance.setPurchaseTime(car.getPurchaseTime());
		carInstance.setStorage(car.getStorage());
		//����
		carDao.update(carInstance);
		return true;
	}
	
	
	/**
	 * �ַ���תΪ��������
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
	
	

	@Override
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	public boolean deleteCar(String id) {
		Carinfo carinfo = getCarInfo(id);// ����id���ҵ�������Ϣ

		carDao.delete(carinfo);
		
		//���ù�ע���еĴ���ԴΪʧЧ
		focusService.setInvalid(id);
		return true;
	}

	/**
	 * ������Դ��-����ɸѡ��¼������
	 */
	@Override
	public Integer getSelectedCarTotalRows(CarSearchBean carBean) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from CarCarrierView t1"+whereSql(carBean, params);
		Long count=carDao.count(hql, params);
		
		return count.intValue();
	}
	
	/**
	 * ��ȡ��˾������Ϣ�б�
	 */
	@Override
	public List<Carteam> getCompanyCarteamList(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Carteam t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		
		return carTeamDao.find(hql, params);
	}
	
	/**
	 * �ҵ���Ϣ-������Ϣ-�ܼ�¼����
	 */
	@Override
	public Integer getUserCarResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Carinfo t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		Long count=carDao.count(hql, params);
		
		return count.intValue();
		
	}

	/**
	 * �ҵ���Ϣ-������Ϣ
	 */
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

	/*
	 * ��ȡ��˾���� ��Դ
	 * @see cn.edu.bjtu.service.CarService#getCompanyCarAjax(java.lang.String)
	 */
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
	}

	@Override
	public List<Carinfo> getAllcarNum(String carrierId) {
		return carDao.find("from Carinfo where carrierId='"+carrierId+"'");
	}

	@Override
	public boolean setcarState(String carNum,String carState) {
		String hql = "from Carinfo where carNum='"+carNum+"'";
		List<Carinfo> car = carDao.find(hql);
		Carinfo carinfo = car.get(0);
		carinfo.setCarState(carState);
		
		carDao.update(carinfo);
		return true;
	}
	
	
	
}

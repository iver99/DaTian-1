package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarService;
import cn.edu.bjtu.service.FocusService;
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
	@Autowired
	FocusService focusService;

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

		car.setId(IdCreator.createCarId());
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
		return true;
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

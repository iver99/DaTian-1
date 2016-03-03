package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.CarTeamDao;
import cn.edu.bjtu.service.CarTeamService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carteam;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class CarTeamServiceImpl implements CarTeamService{
	
	@Autowired
	CarTeamDao carTeamDao;

	@Override
	public List<Carteam> getCarteam(String carrierId) {
		
		String hql="from Carteam t where t.carrierId=:carrierId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		return carTeamDao.find(hql, params);
	}

	@Override
	public Carteam getCarteamInfo(String id) {
		
		return carTeamDao.get(Carteam.class,id);
	}

	@Override
	public boolean insertCarteam(String teamName, String carCount,
			String chief, String phone, String explaination, String carrierId) {
		Carteam carteam=new Carteam();
		carteam.setId(IdCreator.createCarteamId());
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setCarrierId(carrierId);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		carteam.setRelDate(new Date());
		// return true;
		carTeamDao.save(carteam);// ����ʵ��
		return true;
	}

	@Override
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	public boolean deleteCarteam(String id) {
		Carteam carteam=new Carteam();
		carteam = getCarteamInfo(id);// ����id���ҵ�������Ϣ
		carTeamDao.delete(carteam);
		return true;
	}

	@Override
	public boolean updateCarteam(String id, String teamName, String carCount,
			String chief, String phone, String explaination) {
		Carteam carteam=new Carteam();
		carteam = getCarteamInfo(id);// ����id���ҵ�������Ϣ
		carteam.setTeamName(teamName);
		carteam.setCarCount(carCount);
		carteam.setChief(chief);
		carteam.setPhone(phone);
		carteam.setExplaination(explaination);
		// return true;
		carTeamDao.update(carteam);// ����ʵ��
		return true;
	}
	
	/**
	 * �ҵ���Ϣ-�ҵ���Դ-������Ϣ-������Ϣ
	 */
	@Override
	public String getUserCarTeamResource(HttpSession session, PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Carteam t where t.carrierId=:carrierId order by t.relDate desc";
		params.put("carrierId", carrierId);
		
		List<Carteam> carTeamList=carTeamDao.find(hql, params);
		JSONArray jsonArray=new JSONArray();
		for(Carteam carteam:carTeamList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(carteam);
			jsonArray.add(carteam);
		}
		
		return jsonArray.toString();
	}

	/**
	 * �ҵ���Ϣ-�ҵ���Դ-������Ϣ=������Ϣ=�ܼ�¼��
	 */
	@Override
	public Integer getUserCarTeamResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Carteam t where t.carrierId=:carrierId ";
		params.put("carrierId", carrierId);
		
		Long count=carTeamDao.count(hql, params);
		
		return count.intValue();
	}
}

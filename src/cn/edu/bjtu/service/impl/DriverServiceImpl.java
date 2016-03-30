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
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Driverinfo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class DriverServiceImpl implements DriverService{

	@Autowired
	DriverDao driverDao;
	@Autowired
	CarDao carDao;
	
	@Override
	/**
	 * ͨ��driverid�ҵ�˾����Ϣ
	 */
	public Driverinfo getDriverInfo(String driverId) {
		
		return driverDao.get(Driverinfo.class,driverId);
	}
	
	@Override
	public Driverinfo getDriverByName(String driverName) {
		String hql="from Driverinfo where driverName=:driverName";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("driverName", driverName);
		
		return driverDao.get(hql, params);
	}
	
	@Override
	public Driverinfo getDriverByPhone(String phone) {
				String hql="from Driverinfo where phone=:phone";
				Map<String,Object> params=new HashMap<String,Object>();
				params.put("phone", phone);
				
				return driverDao.get(hql, params);
	}
	@Override
	/**
	 * ��ȡ���е�˾�����������³���ҳ��ʹ��
	 */
	public List getAllDriverName(String carrierId) {
		
		return driverDao.find("select driverName from Driverinfo where carrierId='"+carrierId+"'");
	}

	@Override
	public List getAllDriver(String carrierId) {
		
		return driverDao.find("from Driverinfo where carrierId='"+carrierId+"'");
	}
	
	

	@Override
	/**
	 * ����˾��
	 */
	public boolean insertNewDriver(Driverinfo driver,HttpServletRequest request,MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "driver");
		driver.setId(IdCreator.createDriverId());
		driver.setCarrierId(carrierId);
		driver.setRelDate(new Date());
		//�����ļ�λ�� 
		driver.setIdscans(fileLocation);
		driverDao.save(driver);// ����ʵ��
		return true;
	}

	@Override
	public boolean updateNewDriver(Driverinfo driver,HttpServletRequest request,MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "driver");

		Driverinfo driverInstance = driverDao.get(Driverinfo.class,driver.getId());
		driverInstance.setDriverName(driver.getDriverName());
		driverInstance.setSex(driver.getSex());
		driverInstance.setIDCard(driver.getIDCard());
		driverInstance.setLicenceNum(driver.getLicenceNum());
		driverInstance.setLicenceRate(driver.getLicenceRate());
		driverInstance.setLicenceTime(driver.getLicenceTime());
		driverInstance.setPhone(driver.getPhone());
		
		//�����ļ�λ�� 
		driverInstance.setIdscans(fileLocation);

		//����
		driverDao.update(driverInstance);
		return true;
	}
	
	
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
	 * ɾ��˾��
	 * @param id
	 * @return
	 */
	public boolean deleteDriver(String id) {
		Driverinfo driverinfo = getDriverInfo(id);// ����id���ҵ�������Ϣ
		driverDao.delete(driverinfo);
		return true;
	}
	/**
	 * �ҵ���Ϣ-˾����Ϣ
	 */
	@Override
	public JSONArray getUserDriverResource(HttpSession session,PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Driverinfo t where t.carrierId=:carrierId order by t.relDate desc ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Driverinfo> driverList=driverDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		for(Driverinfo driver:driverList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(driver);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}

	/**
	 * �ҵ���Ϣ-˾����Ϣ-�ܼ�¼����
	 */
	@Override
	public Integer getUserDriverResourceTotalRows(HttpSession session) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from Driverinfo t where t.carrierId=:carrierId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		
		Long count=driverDao.count(hql, params);
		return count.intValue();
		
	}
}

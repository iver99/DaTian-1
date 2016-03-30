package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Driverinfo;
import com.alibaba.fastjson.JSONArray;

public interface DriverService {
	public Driverinfo getDriverInfo(String driverId);
	//add by solitudeycq at 2015-12-19 14:48
	public Driverinfo getDriverByPhone(String phone);
	public Driverinfo getDriverByName(String driverName);

	public List getAllDriverName(String carrierId);
	public List getAllDriver(String carrierId);
	
	public boolean insertNewDriver(Driverinfo driver,HttpServletRequest request,MultipartFile file);
	public boolean updateNewDriver(Driverinfo driver,HttpServletRequest request,MultipartFile file);
	
	public boolean deleteDriver(String id);
	
	/**
	 * �ҵ���Ϣ-˾����Ϣ
	 * @Title: getUserDriverResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:13:11
	 */
	public JSONArray getUserDriverResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * �ҵ���Ϣ-˾����Ϣ-�ܼ�¼����
	 * @Title: getUserDriverResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:16:24
	 */
	public Integer getUserDriverResourceTotalRows(HttpSession session);

}

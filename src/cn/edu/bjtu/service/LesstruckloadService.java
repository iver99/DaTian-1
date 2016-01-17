package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Truck;

public interface LesstruckloadService {
	/**
	 * 获取资源栏筛选零担
	 * @param truckbean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedLesstruckloadNew(TruckBean truckBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 获取资源栏-零担筛选记录总条数（前台）
	 * @param truckBean
	 * @return
	 */
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean);
	
/*	*//**
	 * 我的信息-车辆信息-总记录条数(后台)
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:12:59
	 *//*
	public Integer getLesstruckloadResourceTotalRows(HttpSession session);
*/
	
	public Truck getLesstruckloadInfo(String truckId);
	
	/**
	 * 我的信息-我的资源-零担
	 * @param session
	 * @param pageUtil
	 * @return
	 *//*
	public JSONArray getUserLesstruckloadResource(HttpSession session,PageUtil pageUtil);
	
	public boolean insertNewLesstruckload(Truck truck,HttpServletRequest request, MultipartFile file);
	
	public boolean deleteLesstruckload(String id);
	
	public boolean updateLesstruckload(Truck truck,HttpServletRequest request,MultipartFile file);*/
}

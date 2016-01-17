/**
 * 
 */
package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.AirLine;

/**
 * @author solitudeycq
 *
 */
public interface AirLineService {

	public JSONArray getSelectedAirLineNew(AirLineSearchBean airlineBean, PageUtil pageUtil, HttpSession session);
    
	public AirLine getAirLineInfo(String airrlineId);
	
	/**
	 * 我的信息-我的国内空运资源
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getAirLineResource(HttpSession session,PageUtil pageUtil);
	
	public boolean insertNewAirLine(AirLine airline,HttpServletRequest request, MultipartFile file);
	
	public boolean updateAirLine(AirLine airline,HttpServletRequest request,MultipartFile file);
}

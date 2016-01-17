/**
 * 
 */
package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.util.PageUtil;

/**
 * @author solitudeycq
 *
 */
public interface AirLineService {

	public JSONArray getSelectedAirLineNew(AirLineSearchBean airlineBean, PageUtil pageUtil, HttpSession session);

}

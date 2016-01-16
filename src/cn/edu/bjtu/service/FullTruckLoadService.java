/**
 * 
 */
package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Truck;

/**
 * @author solitudeycq
 *
 */
public interface FullTruckLoadService {
	
	/**
	 * 资源栏获取筛选整车资源
	 * @param truckBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedFullTruckLoadNew(TruckBean truckBean,PageUtil pageUtil,HttpSession session);
	
	public Truck getfulltruckloadInfo(String truckId);
	
	/**
	 * 我的信息-我的整车资源
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getUserFullTruckLoadResource(HttpSession session,PageUtil pageUtil);

}

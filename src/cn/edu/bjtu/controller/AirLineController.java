/**
 * 
 */
package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author solitudeycq
 *
 */
@Controller
public class AirLineController {
	
	/**
     * 资源栏所有整车信息
     * @return
     */
	@RequestMapping(value="/airline",params="flag=0")
	public String getallAirLine(){
		return "resource_list7";
		
	}

}

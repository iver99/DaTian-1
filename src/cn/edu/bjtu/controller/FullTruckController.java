/**
 * 
 */
package cn.edu.bjtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author solitudeycq
 * 整车相关
 *
 */
@Controller
public class FullTruckController {
	
	
    /**
     * 资源栏所有整车信息
     * @return
     */
	@RequestMapping(value="/fulltruckload",params="flag=0")
	public String getallFullTruckLoad(){
		
		return "resource_list";
		
	}

}

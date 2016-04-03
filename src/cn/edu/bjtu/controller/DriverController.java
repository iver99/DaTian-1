package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.DriverService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.vo.Driverinfo;

/**
 * 司机相关的控制器
 * @author russwest
 * @date   2015年8月28日 下午2:05:14
 */
@Controller
public class DriverController {
	@Autowired
	DriverService driverService;
	
	ModelAndView mv = new ModelAndView();
	/**
	 * 获取司机列表
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/driver")
	public String getAllDriver(){
		return "mgmt_r_driver";
		
	}
	/**
	 * 司机信息详情
	 * @param driverId
	 * @param flag
	 * @return
	 */
	@RequestMapping("driverdetail")
	public ModelAndView getDriverInfo(@RequestParam String driverId,HttpServletRequest request,
			@RequestParam int flag) {
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		Driverinfo driver = driverService.getDriverInfo(driverId);
		if (flag == 1) {// 对应司机详情
			mv.addObject("driver", driver);
			mv.setViewName("mgmt_r_driver4");
		} else if (flag == 2)// 对应司机更新
		{
			String temp = clientId + "_";
			if(driver.getIdscans()!=null){
			    if(driver.getIdscans().indexOf(temp)!=-1){
			    	String[] s = driver.getIdscans().split(temp);
			    	driver.setIdscans(s[1]);
			    	}else{
			    		driver.setIdscans("请上传文件...");
				}
			}
			mv.addObject("driver", driver);
			mv.setViewName("mgmt_r_driver3");
		}

		return mv;
	}
	
	/**
	 * 删除
	 */
	@RequestMapping(value = "driverdelete", method = RequestMethod.GET)
	public String deleteDriver(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		boolean flag = driverService.deleteDriver(id);
		return "redirect:driver?flag=1";

	}
	
	
	@RequestMapping(value = "/updateDriver", method = RequestMethod.POST)
	public String updateNewDriver(Driverinfo driver,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=driverService.updateNewDriver(driver,request,file);
		return "redirect:driver?flag=1";
	}
}

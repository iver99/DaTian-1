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
import cn.edu.bjtu.vo.Driverinfo;

/**
 * ˾����صĿ�����
 * @author russwest
 * @date   2015��8��28�� ����2:05:14
 */
@Controller
public class DriverController {
	@Autowired
	DriverService driverService;
	
	ModelAndView mv = new ModelAndView();
	/**
	 * ��ȡ˾���б�
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/driver")
	public String getAllDriver(){
		return "mgmt_r_driver";
		
	}
	/**
	 * ˾����Ϣ����
	 * @param driverId
	 * @param flag
	 * @return
	 */
	@RequestMapping("driverdetail")
	public ModelAndView getDriverInfo(@RequestParam String driverId,
			@RequestParam int flag) {
		Driverinfo driver = driverService.getDriverInfo(driverId);
		mv.addObject("driver", driver);
		if (flag == 1) {// ��Ӧ˾������
			mv.setViewName("mgmt_r_driver4");
		} else if (flag == 2)// ��Ӧ˾������
		{
			mv.setViewName("mgmt_r_driver3");
		}

		return mv;
	}
	
	/**
	 * ɾ��
	 */
	@RequestMapping(value = "driverdelete", method = RequestMethod.GET)
	public String deleteDriver(@RequestParam String id,// GET��ʽ���룬��action��
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

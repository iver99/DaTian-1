package cn.edu.bjtu.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.service.DriverLoginService;
import cn.edu.bjtu.vo.Driverinfo;

@Controller
public class DriverLoginController {
	
	@Autowired
	DriverLoginService driverloginService;
	
	@RequestMapping("/driverlogin")
	@ResponseBody
	public String driverlogin(@RequestParam(value="phone",required=false) String phone,@RequestParam(value="passwd",required=false) String passwd) throws JSONException{
		
		//目前使用司机手机号直接登录，密码随意.
		//String passwd = driver.getString("passwd");---司机登录密码---手机端---目前暂不使用
		Driverinfo driverinfo = driverloginService.checkLogin(phone);
		if(driverinfo!=null){
			String successJson = "{\"logBean\":\"success\"}";
			JSONObject success = new JSONObject(successJson);
			return success.toString();
		}else{
			String failJson = "{\"logBean\":\"fail\"}";
			JSONObject fail = new JSONObject(failJson);
			return fail.toString();
		}
	}
	
	

}

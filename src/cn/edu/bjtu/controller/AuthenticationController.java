package cn.edu.bjtu.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.AuthenticationService;
import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.service.CompanycertificateService;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;

@Controller
/**
 * ��֤��ؿ�����
 * @author RussWest0
 *
 */
public class AuthenticationController {

	@Resource(name = "authenticationServiceImpl")
	AuthenticationService authenticationService;
	@Resource
	ClientSecurityService clientSecurityService;
	@Resource
	CompanycertificateService companycertificateService;
	@Autowired
	UserinfoDao userinfoDao;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("/authentic")
	/**
	 * ��ȡ���д���֤��Ϣ
	 * @param request
	 * @return
	 */
	public ModelAndView getAllAuthentication(HttpServletRequest request) {
		List<Userinfo> validateList = authenticationService.getAllAuthentication();
		mv.addObject("validateList", validateList);
		mv.setViewName("mgmt_m_register");
		return mv;

	}

	@RequestMapping("authenticdetail")
	/**
	 * ������֤��Ϣ����
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getAuthenticationInfo(@RequestParam String clientId,
			@RequestParam(required=false) String feedback,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		// String carrierId=(String)request.getSession().getAttribute(Constant.USER_ID);
		// String carrierId = "C-0002";
		Clientinfo clientinfo = authenticationService
				.getAuthenticationInfo(clientId);
		mv.addObject("clientinfo", clientinfo);
		Userinfo userinfo = clientSecurityService.getUserById(clientId);
		mv.addObject("userinfo", userinfo);
		
		if (flag == 1)// ����
		{
			// mv.setViewName("mgmt_m_register2");
		} else if (flag == 22)// ��˸���ҳ����ת
		{
			mv.setViewName("mgmt_m_register2");
		} else if (flag == 23)// ��˹�˾ҳ����ת
		{
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(clientId);
			mv.addObject("detailCompanyCertificate", companycertificate);
			mv.setViewName("mgmt_m_register3");
		} else if (flag == 32) {//��˸���
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "�����");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		} else if (flag == 42) {//��˸���
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "δͨ��");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		
		else if (flag == 33) {//��˹�˾
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "�����");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		} else if (flag == 43) {//��˹�˾
			boolean judge = authenticationService.updateAuthenticStatus(feedback,
					clientId, "δͨ��");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}

		return mv;
	}
	
	/**
	 * ��ȡ��˸����û�ҳ��
	 * @param userid
	 * @return
	 */
	@RequestMapping("authenticdetailuserpage")
	public ModelAndView getAuthenticUserpage(String userid){
		Clientinfo clientinfo = authenticationService
				.getAuthenticationInfo(userid);
		mv.addObject("clientinfo", clientinfo);
		Userinfo userinfo = clientSecurityService.getUserById(userid);
		mv.addObject("userinfo", userinfo);
		mv.setViewName("mgmt_m_register2");//��˸���ҳ��
		return mv;
	}
	
	/*
	 * 
	 * ��ȡ��˹�˾�û�ҳ��
	 */
	@RequestMapping("authenticdetailcompanypage")
	public ModelAndView getAuthenticCompanyPage(String userid){
		
		Userinfo userinfo = clientSecurityService.getUserById(userid);
		mv.addObject("userinfo", userinfo);
		Companycertificate companycertificate = companycertificateService.getCompanycertificate(userid);
		mv.addObject("detailCompanyCertificate", companycertificate);
		mv.setViewName("mgmt_m_register3");//��˹�˾ҳ�� 
		
		return mv;
	}
	/**
	 * ��˸����û�ͨ��,��Ҫ�޸�״̬Ϊ����֤
	 * @return
	 */
	@RequestMapping("authenUserPass")
	public ModelAndView authenUserPass(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag = authenticationService.authenUserPass(feedback, user_id);
		if (flag == true) {
			// mv.setViewName("");
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}

		}
		mv.setViewName("mgmt_m_register");

		return mv;
		
	}
	
	/**
	 * ��˸����û��ܾ�����Ҫ�޸�״̬Ϊδ��֤
	 * @return
	 */
	@RequestMapping("authenUserDeny")
	public ModelAndView authenUserDeny(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag = authenticationService.authenUserDeny(feedback, user_id);
		if (flag == true) {
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		mv.setViewName("mgmt_m_register");
		return mv;

	}
	
	/**
	 * ��˹�˾�û�ͨ��
	 * @return
	 */
	@RequestMapping("authenCompanyPass")
	public ModelAndView authenCompanyPass(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag=authenticationService.authenCompanyPass(feedback,user_id);
		
		if(flag==true){
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		
		mv.setViewName("mgmt_m_register");
		
		return mv;
	}
	
	/**
	 * ��˹�˾�û��ܾ�
	 * @return
	 */
	@RequestMapping("authenCompanyDeny")
	public ModelAndView authenCompanyDeny(String feedback,String user_id,HttpServletResponse response){
		
		boolean flag=authenticationService.authenCompanyDeny(feedback,user_id);
		
		if(flag==true){
			try {
				response.sendRedirect("authentic");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		mv.setViewName("mgmt_m_register");
		
		return mv;
	}
	
	

	@RequestMapping("authenticview")
	/**
	 * 
	 * @param clientId
	 * @param flag
	 * @return
	 */
	public ModelAndView getAuthenticationCheck(@RequestParam String clientId,
			@RequestParam int flag, HttpServletRequest request,
			HttpServletResponse response) {
		if(flag == 2){//�鿴������Ϣ
			Clientinfo clientinfo = authenticationService
					.getAuthenticationInfo(clientId);
			mv.addObject("clientinfo", clientinfo);
			Userinfo userinfo = clientSecurityService.getUserById(clientId);
			mv.addObject("userinfo", userinfo);
			mv.setViewName("mgmt_m_register2a");
		}
		else if(flag == 3){//�鿴��˾��Ϣ
			Companycertificate companycertificate = companycertificateService.getCompanycertificate(clientId);
			mv.addObject("detailCompanyCertificate", companycertificate);
			Userinfo userinfo = clientSecurityService.getUserById(clientId);
			mv.addObject("userinfo", userinfo);
			mv.setViewName("mgmt_m_register3a");
		}
		return mv;
	}

	@RequestMapping("/findbyusername")
	/**
	 * ��ȡ���д���֤��Ϣ
	 * @param request
	 * @return
	 */
	public ModelAndView findByUsername(String username,
			HttpServletRequest request) {
		List validateList = authenticationService.getFindUser(username);
		mv.addObject("validateList", validateList);
		mv.setViewName("mgmt_m_register");

		return mv;

	}
}

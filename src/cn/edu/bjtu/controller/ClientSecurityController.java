package cn.edu.bjtu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.ClientSecurityService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.Encrypt;
import cn.edu.bjtu.vo.Userinfo;

@Controller
public class ClientSecurityController {

	@Autowired
	ClientSecurityService clientSecurityService;

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/mysecurity")
	/**
	 * ��ȡ�ҵİ�ȫ����ҳ��
	 * @param session
	 * @return
	 */
	public ModelAndView getMySercurityPage(HttpSession session) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		Userinfo userinfo = clientSecurityService.getUserById(userId);
		mv.addObject("userinfo", userinfo);
		mv.setViewName("mgmt_a_security");
		return mv;

	}

	/**
	 * ��ȡ�޸������
	 * @return
	 */
	@RequestMapping("getchangepasswordpage")
	public ModelAndView gotoChangePasswordPage() {

		mv.setViewName("mgmt_a_security2");
		return mv;
	}

	/*
	 * �޸�����
	 */
	@RequestMapping("changepassword")
	public ModelAndView changePassword(HttpSession session, String oldPassword,
			String newPassword, String repeatPassword) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		boolean flag = false;
		String psw_old = Encrypt.MD5(oldPassword);//add by RussWest0 at 2015��6��7��,����11:21:01 
		flag = clientSecurityService.checkOldPassword(psw_old, userId);
		if (flag == true)// ��������ȷ �����
		{
			if (newPassword.equals(repeatPassword))// ����������һ��
			{
				//add by RussWest0 at 2015��6��7��,����11:19:49 
//				�������
				String psw = Encrypt.MD5(newPassword);
				clientSecurityService.changePassword(psw, userId);// �޸�����
				String msg = "�޸�����ɹ�";
				mv.addObject("msg", msg);
				mv.setViewName("mgmt_a_security");
				return mv;
			} else// ���������벻һ��
			{
				String msg = "�����������벻һ�£�����������������!";
				mv.addObject("msg", msg);
				mv.setViewName("mgmt_a_security2");
				return mv;
			}

		} else// ���������
		{
			String msg = "ԭʼ�������!����������";
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security2");
			return mv;
		}
	}
	
	/**
	 * ��ת�޸İ��ֻ�ҳ��
	 * @return
	 */
	@RequestMapping("removephone")
	public ModelAndView removePhonePage(HttpSession session) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		Userinfo userinfo = clientSecurityService.getUserById(userId);
		String phone=userinfo.getPhone();
		String phonehide = phone.substring(0,phone.length()-(phone.substring(3)).length())+"****"+phone.substring(7);
		mv.addObject("phonehide", phonehide);
		mv.addObject("phone", phone);
		mv.setViewName("mgmt_a_security3");
		return mv;
	}
	/**
	 * ��ת�����ֻ���ҳ��
	 * @return
	 */
	@RequestMapping("gotochangephone")
	public ModelAndView gotoChangePhonePage(HttpSession session) {
		mv.setViewName("mgmt_a_security3a");
		return mv;
	}
	
	/**
	 * �󶨳ɹ������ذ�ȫ���ý���
	 * @return
	 */
	@RequestMapping("changephone")
	public String changePhone(HttpSession session, String phone,
			HttpServletRequest request, HttpServletResponse response) {
		clientSecurityService.changePhone(phone, session);
		return "redirect:mysecurity";

	}

	/**
	 * ������ҳ��
	 * @param session
	 * @return
	 */
	@RequestMapping("getbindemailpage")
	public ModelAndView gotoBindEmailPage() {
		mv.setViewName("mgmt_a_security4");
		return mv;
	}

	@RequestMapping("bindemail")
	public String bindEmail(HttpSession session, String email,
			HttpServletRequest request, HttpServletResponse response) {
		//String userId = (String) session.getAttribute(Constant.USER_ID);
		clientSecurityService.bindEmail(email, session);
		
		return "redirect:mysecurity";
		
	}

	/**			     
	 * ��ȡ���������ҳ��
	 * @param session
	 * @return
	 */
	@RequestMapping("getchangebindemailpage")
	public ModelAndView gotoChangeEmailPage(HttpSession session) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		Userinfo userinfo = clientSecurityService.getUserById(userId);
		String email = userinfo.getEmail();
		mv.addObject("email", email);
		mv.setViewName("mgmt_a_security4b");
		return mv;
	}

	@RequestMapping("changebindemail")
	public String changeBindEmail(HttpSession session, String newEmail,
			HttpServletRequest request, HttpServletResponse response) {
		clientSecurityService.changeBindEmail(newEmail, session);
		return "redirect:mysecurity";

	}
	@RequestMapping("getsetquestionpage")
	public ModelAndView gotoSetSecurityQuestionPage()
	{
		mv.setViewName("mgmt_a_security5");//����
		return mv;
	}
	
	@RequestMapping("getchangequestionpage")
	public ModelAndView gotoChangeSecurityQuestionPage(HttpSession session)
	{
		String userId=(String )session.getAttribute(Constant.USER_ID);
		Userinfo userinfo=clientSecurityService.getUserById(userId);
		
		mv.addObject("userinfo", userinfo);
		mv.setViewName("mgmt_a_security5a");//�޸�
		return mv;
	}
	@RequestMapping("setquestion")
	public ModelAndView setSecurityQuestion(String question1,String question2,String question3,
			String answer1,String answer2,String answer3,HttpSession session)
	{
		String userId=(String )session.getAttribute(Constant.USER_ID);
		boolean flag=clientSecurityService.setSecurityQuestion(question1,question2,question3,answer1,answer2,answer3,userId);
		if(flag== true)
		{
			String msg="�޸��ܱ�����ɹ�!";
			Userinfo userinfo=clientSecurityService.getUserById(userId);
			mv.addObject("userinfo", userinfo);//����ҳ���ϵ�bean
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security");
			return mv;
		}
		else
		{
			String msg="�޸��ܱ�����ʧ�ܣ�����������!";
			mv.addObject("msg", msg);
			mv.setViewName("mgmt_a_security5");
			return mv;
		}
	}
	@RequestMapping("checkanswer")
	public ModelAndView checkSecurityQuestion(String answer1,String answer2,String answer3,HttpSession session)
	{
		String userId=(String )session.getAttribute(Constant.USER_ID);
		boolean flag=clientSecurityService.checkAnswer(answer1,answer2,answer3,userId);
		if(flag==true)
		{
			String msg="����ȷ��";
			mv.addObject("msg",msg);
			mv.setViewName("mgmt_a_security5b");//��֤�ɹ�������ҳ��
			return mv;
		}
		else 
		{
			String msg="�𰸲���ȷ�����������룡";
			mv.addObject("msg",msg);
			
			mv.setViewName("mgmt_a_security5a");//��֤ʧ�ܣ�������֤ҳ��
			return mv;
		}
	}
	
}

package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.ClientService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;

@Controller
/**
 * �ͻ�������
 * @author RussWest0
 *
 */
public class ClientController {
	@Resource
	ClientService clientService;
	
	ModelAndView mv = new ModelAndView();

	@RequestMapping("accountinfo")
	/**
	 * �г���ǰ�û�����֤��Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getAccountInfo(HttpServletRequest request,
			HttpServletResponse response) {
		// �˷����ڿ�����Ҫ�ж��û�����,��Ϊ��ҵ�û��͸����û�����֤ҳ�治һ��
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		if(userId==null)//δ��¼
		{
			mv.setViewName("login");
			return mv;
		}
		//int userKind=(Integer)request.getSession().getAttribute("userKind");
		boolean flag = clientService.checkHeadIconStatus(userId);
		String status = clientService.getStatus(userId);
		mv.addObject("status", status);
		mv.addObject("headCheck", flag);
		mv.setViewName("mgmt_a_info");
		return mv;
	}

	/**
	 * ������Ϣ
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("basicuserinfo")
	public ModelAndView getBasicUserInfo(HttpSession session) {
//		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);

		Userinfo userinfo = clientService.getBasicUserInfo(session);
		mv.addObject("userInfo", userinfo);
		mv.setViewName("mgmt_a_info2");
		return mv;
	}
	/**
	 * �鿴�û�ͷ��
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getuserpicture")
	public ModelAndView getUserPicture(HttpSession session) {
		Clientinfo clientinfo = clientService.getUserPicture(session);
		mv.addObject("clientinfo", clientinfo);
		String userPicture=clientinfo.getIDPicture();
		/*System.out.println(userPicture);*/
		mv.addObject("userpicture",userPicture);
		mv.setViewName("mgmt_a_info5a");
		return mv;
	}
	/**
	 * ��ȡ�����û���֤��
	 */
	@RequestMapping("getvalidateform")
	/**
	 * ��֤�˻���
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView getValidateForm() {
		mv.setViewName("mgmt_a_info3");
		return mv;
	}

	@RequestMapping("validateuser")
	public ModelAndView validateUser(@RequestParam(required = false) MultipartFile file,
			String realName, String phone,
			String IDCard, String sex, HttpServletRequest request,
			HttpServletResponse response) {
		String userId=(String)request.getSession().getAttribute(Constant.USER_ID);
		
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// ���ϴ��ļ������
		{
			path = UploadPath.getClientPath();// ��ͬ�ĵط�ȡ��ͬ���ϴ�·��
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// �ļ���
			File targetFile = new File(path, fileName);
			try { // ���� �ļ�
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// û���ϴ��ļ������path �� filenNameĬ��Ϊnull

		// ////////////////////////////////////////////
		
		boolean flag=clientService.validateUser(userId,realName,phone,IDCard,sex,path,fileName);
		if(flag==true){
			try {
				response.sendRedirect("accountinfo");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}else{//��֤�˻�����
			mv.setViewName("mgmt_a_info");
			mv.addObject("msg", "��֤�˻������Ժ�������");
		}
			
		return mv;
	}
	/**
	 * ��ȡ�����û���֤��Ϣ��
	 * @return
	 */
	@RequestMapping("getupdateUserinfoForm")
	public ModelAndView getUpdateUserInfoForm(HttpSession session){
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Clientinfo clientinfo=clientService.getClientInfo(userId);//����id��ȡclientinfo
		mv.addObject("clientinfo", clientinfo);
		mv.setViewName("mgmt_a_info3a");
		return mv;
	}
	
	@RequestMapping("updateclientinfo")
	/**
	 * �����û���Ϣ 
	 * @param session
	 * @param clientinfo
	 * @return
	 */
	public ModelAndView updateClientInfo(HttpServletResponse response,HttpSession session,Clientinfo clientinfo,MultipartFile file){
		String userId=(String) session.getAttribute(Constant.USER_ID);
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// ���ϴ��ļ������
		{
			path = UploadPath.getClientPath();// ��ͬ�ĵط�ȡ��ͬ���ϴ�·��
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// �ļ���
			File targetFile = new File(path, fileName);
			try { // ���� �ļ�
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		boolean flag=clientService.updateClientinfo(clientinfo,path, fileName,userId);
		if(flag){
			mv.addObject("msg", "���¸�����Ϣ�ɹ�!");
			try {
				response.sendRedirect("accountinfo");//�����ҵ���Ϣҳ��
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
			
		}else{
			mv.addObject("msg", "���¸�����Ϣʧ�ܣ�");
			try {
				response.sendRedirect("accountinfo");//�����ҵ���Ϣҳ�� 
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}
		return mv;
	}
	
	@RequestMapping("viewClientInfoDetail")
	/**
	 * �鿴�û���Ϣ����
	 * @return
	 */
	public ModelAndView viewClientInfoDetail(HttpSession session){
		String userId=(String )session.getAttribute(Constant.USER_ID);
		Clientinfo clientinfo=clientService.getClientInfo(userId);
		
		mv.addObject("clientinfo", clientinfo);
		mv.setViewName("mgmt_a_info3b");
		return mv;
	}
	/**
	 * ���idpicture
	 */
	@RequestMapping(value = "insertuseridpicture", method = RequestMethod.POST)
	public ModelAndView insertUserIDPicture(Clientinfo clientinfo,HttpServletRequest request,MultipartFile file) {
		clientService.insertUserIdPicture(clientinfo,request,file);
		mv.setViewName("mgmt_a_info");
		return mv;
		
	}

	/**
	 * ����idpicture
	 */
	@RequestMapping(value = "downloaduseridpicture", method = RequestMethod.GET)
	public ModelAndView downloadUserIDPicture(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
			Clientinfo clientinfo = clientService.getClientInfo(id);
			String file = clientinfo.getIDPicture();
			DownloadFile.downloadFile(file,request,response);
		return mv;

	}

	
	/**
	 * �����ҵ���Ϣ-��ҳ�·�������Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserTransactionInfoAjax")
	public String getUserTransactionInfo(HttpSession session){
		//������δʵ��
		String data=clientService.getTransactionInfo(session);
		return data;
		
	}
	
}

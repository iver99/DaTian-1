package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.FocusBean;
import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Focus;

import com.alibaba.fastjson.JSONArray;

public interface FocusService extends BaseDao<Focus>{
	public boolean insertFocus(String clientId, String foucsType, String foucsId);
	public List getFocusJudgement(String clientId, String foucsType, String foucsId);
	public boolean deleteFocus(String id);
	public List getFocusList(String clientId,String focusType);

	
	/**
	 * ������ע
	 * @Title: searchFocus 
	 *  
	 * @param: @param search_content
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��6�� ����12:20:37
	 */
	public JSONArray searchFocus(FocusBean focusBean,HttpSession session,PageUtil pageUtil);
	
	/**
	 * ��ע�ܼ�¼�� 
	 * @param focusBean
	 * @param session
	 * @return
	 */
	public Integer getUserFocusTotalRowsAjax(FocusBean focusBean,HttpSession session);
	
	/**
	 * ���ù�עΪʧЧ״̬
	 * @param id
	 * @return
	 */
	public boolean setInvalid(String id);

}

package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carteam;

public interface CarTeamService {
	public List<Carteam> getCarteam(String carrierId);
	public Carteam getCarteamInfo(String id);
	public boolean insertCarteam(String teamName,String carCount,String chief,String phone,String explaination,String carrierId);
	public boolean deleteCarteam(String id);
	public boolean updateCarteam(String id,String teamName,String carCount,String chief,String phone,String explaination);
	
	/**
	 * �ҵ���Ϣ-�ҵ���Դ-������Ϣ-������Ϣ
	 * @Title: getUserCarTeamResource 
	 *  
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��15�� ����11:21:10
	 */
	public String getUserCarTeamResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * �ҵ���Ϣ-�ҵ���Դ-������Ϣ=������Ϣ=�ܼ�¼��
	 * @Title: getUserCarTeamResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��15�� ����11:21:45
	 */
	public Integer getUserCarTeamResourceTotalRows(HttpSession session);


}

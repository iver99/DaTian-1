package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Settlement;

import com.alibaba.fastjson.JSONArray;

/**
 * ���ڼ�¼���ɶ��˵���Ϣ
 * @author RussWest0
 * @date   2015��6��20�� ����7:11:59
 */
public interface SettlementRecordService {
	/**
	 * �޸Ķ���״̬Ϊ�ѽ��㣬����¼������
	 * @param orderNum
	 * @param session
	 * @return
	 */
	public boolean finishSettlement(String orderNum,HttpSession session);
	
	/**
	 * ���ݶ����Ż�ȡ�������ɼ�¼
	 * @param orderNum
	 * @return
	 */
	public List<Settlement> getSettlementRecordByOrderNum(String orderNum);
	
	/**
	 * �ҵĽ���
	 * @param session
	 * @return
	 */
	public JSONArray getUserSettlement(HttpSession session,String name,PageUtil pageUtil);
	
	/**
	 * �ҵĽ���-�ܼ�¼���� 
	 * @param session
	 * @return
	 */
	public Integer getUserSettlementTotalRows(HttpSession session);

}

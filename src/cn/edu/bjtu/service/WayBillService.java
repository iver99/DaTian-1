/**
 * 
 */
package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.WayBill;
import java.util.List;
/**
 * @author solitudeycq
 *
 */
public interface WayBillService {
	
	public List<WayBill> getWayBillByDriverName(String driver);
	public WayBill getWayBillBywaybillNum(String waybillNum);
	public boolean setConfirm(String waybillId);
	public boolean startTask(String waybillId);
	public boolean finishTask(String waybillNum,String price,String picture);
	public List<WayBill> getAllWayBillNumsPictureByOrderId(String orderId);
}

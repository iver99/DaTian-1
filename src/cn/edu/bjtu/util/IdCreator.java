package cn.edu.bjtu.util;

/**
 * id������
 * @author RussWest0
 *
 */
public class IdCreator {
	
	/**
	 * ����WayBillID
	 * @return
	 */
	public static String createWayBillId(){
		return "WB" + (int)(Math.random() * 100000000);
	}
	
	/**
	 * ����AirLineID
	 * @return
	 */
	public static String createAirLineId(){
		return "AI" + (int)(Math.random() * 100000000);
	}
	
	/**
	 * �������������㵣ID
	 * @return
	 */
	public static String createTruckId(){
		return "TR" + (int)(Math.random() * 100000000);
	}

	/**
	 * 
	 * @return �����������id
	 */
	public static String createClientId() {
		return "CL" + (int)(Math.random() * 100000000);
	}
	/**
	 * ������ҵ�ͻ���id
	 * @return
	 */
	public static String createBusinessClientId()
	{
		return "BU"+(int)(Math.random() * 100000000);
	}
	/**
	 * ���س��˷�id
	 * @return
	 */
	public static String createCarrierId() {
		return "CA" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���ظ���id
	 * @return
	 */
	public static String createlineTransportId() {
		return "LI" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���ػ���id
	 * @return
	 */
	public static String createGoodsId() {
		return "GO" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���س�������id
	 * @return
	 */
	public static String createCityLineId() {
		return "CI" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���س���id�����ǳ��ƣ�
	 * @return
	 */
	public static String createCarId() {
		return "CAR" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���زֿ�id
	 * @return
	 */
	public static String createRepositoryId() {
		return "RE" + (int)(Math.random() * 100000000);
	}
	/**
	 * ����˾��id
	 * @return
	 */
	public static String createDriverId() {
		return "DR" + (int)(Math.random() * 100000000);
	}
	/**
	 * ���ض���id-ʱ������
	 * @return
	 */
	public static String createOrderId() {
		return "OR"+(int)(Math.random() * 100000000);
	}
	
	/**
	 * ����Ͷ��id-ʱ������
	 * @return
	 */
	public static String createComplaintId() {
		return "CO"+(int)(Math.random() * 100000000);
	}
	/**
	 * ��������id-ʱ������
	 * @return
	 */
	public static String createAssessId() {
		return "AS"+(int)(Math.random() * 100000000);
	}
	/**
	 * ���غ�ͬid
	 * @return
	 */
	public static String createContractId(){
		return "CO"+(int)(Math.random()*100000000);
	}
	
	public static String createOrderNum()
	{
		return "Y"+(int)(Math.random()*100000000);
	}
	
	/**
	 * �������˻�id
	 * @return
	 */
	public static String createSubAccountId(){
		return "SA"+(int)(Math.random()*100000000);
	}
	
	/**
	 * ���س��õ�ַid
	 * @return
	 */
	public static String createAddressId(){
		return "Add"+(int)(Math.random()*100000000);
	}
	
	/**
	 * ���س�����Ϣ��id
	 * @return
	 */
	public static String createCarteamId(){
		return "CT"+(int)(Math.random()*100000000);
	}
	
	/**
	 * ���ع�עid
	 * @return
	 */
	public static String createFocusId(){
		return "F"+(int)(Math.random()*100000000);
	}
	
	/**
	 * ��������id
	 * @return
	 */
	public static String createMessageId(){
		return "M"+(int)(Math.random()*100000000);
	}
	
	/**
	 * ���ط�����id
	 * @return
	 */
	public static String createResponseId(){
		return "RE"+(int )(Math.random()*100000000);
	}
	
	/**
	 * ���ؽ����id
	 * @return
	 */
	public static String createSettlementId(){
		return "SE"+(int )(Math.random()*100000000);
	}
	
	/**
	 * ����track��id
	 * @return
	 */
	public static String createTrackId(){
		return "T"+(int )(Math.random()*100000000);
	}

}

/**
 * 
 */
package cn.edu.bjtu.bean.page;

/**
 * @author solitude
 * ��Bean����ҪĿ������������Ϣ���������ʾ˾�����˵��ŵ���Ϣ�����������track���¼��ֶο��ܻ�Ӱ�쵽�ƶ��ˣ����ǲ����������ַ�����
 *
 */
public class TrackBean {
	
	private String id;
	private String orderId;
	private String carNum;
	private Double locLongitude;//����
	private Double locLatitude;//γ��
	private String time;
	private String address;
	private String orderNum;
	private String event;      //�¼����ѽ�������/��ȡ��/������/��ǩ�գ�
	private String waybillNum; //�˵���
	
	private String driver;//˾��

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id Ҫ���õ� id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return orderId
	 */
	public String getOrderId() {
		return orderId;
	}

	/**
	 * @param orderId Ҫ���õ� orderId
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return carNum
	 */
	public String getCarNum() {
		return carNum;
	}

	/**
	 * @param carNum Ҫ���õ� carNum
	 */
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	/**
	 * @return locLongitude
	 */
	public Double getLocLongitude() {
		return locLongitude;
	}

	/**
	 * @param locLongitude Ҫ���õ� locLongitude
	 */
	public void setLocLongitude(Double locLongitude) {
		this.locLongitude = locLongitude;
	}

	/**
	 * @return locLatitude
	 */
	public Double getLocLatitude() {
		return locLatitude;
	}

	/**
	 * @param locLatitude Ҫ���õ� locLatitude
	 */
	public void setLocLatitude(Double locLatitude) {
		this.locLatitude = locLatitude;
	}

	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time Ҫ���õ� time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address Ҫ���õ� address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum Ҫ���õ� orderNum
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return event
	 */
	public String getEvent() {
		return event;
	}

	/**
	 * @param event Ҫ���õ� event
	 */
	public void setEvent(String event) {
		this.event = event;
	}

	/**
	 * @return waybillNum
	 */
	public String getWaybillNum() {
		return waybillNum;
	}

	/**
	 * @param waybillNum Ҫ���õ� waybillNum
	 */
	public void setWaybillNum(String waybillNum) {
		this.waybillNum = waybillNum;
	}

	/**
	 * @return driver
	 */
	public String getDriver() {
		return driver;
	}

	/**
	 * @param driver Ҫ���õ� driver
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
}

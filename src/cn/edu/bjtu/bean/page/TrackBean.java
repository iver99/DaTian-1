/**
 * 
 */
package cn.edu.bjtu.bean.page;

/**
 * @author solitude
 * 该Bean的主要目的是在物流信息输出界面显示司机和运单号的信息，但是如果在track中新加字段可能会影响到移动端，于是采用这种这种方案。
 *
 */
public class TrackBean {
	
	private String id;
	private String orderId;
	private String carNum;
	private Double locLongitude;//经度
	private Double locLatitude;//纬度
	private String time;
	private String address;
	private String orderNum;
	private String event;      //事件（已接受任务/已取件/运输中/已签收）
	private String waybillNum; //运单号
	
	private String driver;//司机

	/**
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 要设置的 id
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
	 * @param orderId 要设置的 orderId
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
	 * @param carNum 要设置的 carNum
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
	 * @param locLongitude 要设置的 locLongitude
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
	 * @param locLatitude 要设置的 locLatitude
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
	 * @param time 要设置的 time
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
	 * @param address 要设置的 address
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
	 * @param orderNum 要设置的 orderNum
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
	 * @param event 要设置的 event
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
	 * @param waybillNum 要设置的 waybillNum
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
	 * @param driver 要设置的 driver
	 */
	public void setDriver(String driver) {
		this.driver = driver;
	}
}

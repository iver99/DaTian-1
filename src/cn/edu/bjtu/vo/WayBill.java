package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="waybill")
public class WayBill implements java.io.Serializable{
	
	@Id
	private String id;
	private String orderId;
	private String waybillNum;
	
	private String deliveryAddr;
	private String deliveryName;
	private String deliveryPhone;
	
	private String recieverAddr;
	private String recieverName;
	private String recieverPhone;
	
	private String goodsName;
	private Float goodsWeight;
	private Float goodsVolume;
	
	private String carNum;
	private String driver;
	private String confirm;
	
	private Date waybillSubTime;
	private Date waybillFinishTime;
	
	private String waybillState;

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
	 * @return deliveryAddr
	 */
	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	/**
	 * @param deliveryAddr 要设置的 deliveryAddr
	 */
	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}

	/**
	 * @return deliveryName
	 */
	public String getDeliveryName() {
		return deliveryName;
	}

	/**
	 * @param deliveryName 要设置的 deliveryName
	 */
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	/**
	 * @return deliveryPhone
	 */
	public String getDeliveryPhone() {
		return deliveryPhone;
	}

	/**
	 * @param deliveryPhone 要设置的 deliveryPhone
	 */
	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	/**
	 * @return recieverAddr
	 */
	public String getRecieverAddr() {
		return recieverAddr;
	}

	/**
	 * @param recieverAddr 要设置的 recieverAddr
	 */
	public void setRecieverAddr(String recieverAddr) {
		this.recieverAddr = recieverAddr;
	}

	/**
	 * @return recieverName
	 */
	public String getRecieverName() {
		return recieverName;
	}

	/**
	 * @param recieverName 要设置的 recieverName
	 */
	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	/**
	 * @return recieverPhone
	 */
	public String getRecieverPhone() {
		return recieverPhone;
	}

	/**
	 * @param recieverPhone 要设置的 recieverPhone
	 */
	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}

	/**
	 * @return goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}

	/**
	 * @param goodsName 要设置的 goodsName
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	/**
	 * @return goodsWeight
	 */
	public Float getGoodsWeight() {
		return goodsWeight;
	}

	/**
	 * @param goodsWeight 要设置的 goodsWeight
	 */
	public void setGoodsWeight(Float goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	/**
	 * @return goodsVolume
	 */
	public Float getGoodsVolume() {
		return goodsVolume;
	}

	/**
	 * @param goodsVolume 要设置的 goodsVolume
	 */
	public void setGoodsVolume(Float goodsVolume) {
		this.goodsVolume = goodsVolume;
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

	/**
	 * @return confirm
	 */
	public String getConfirm() {
		return confirm;
	}

	/**
	 * @param confirm 要设置的 confirm
	 */
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	/**
	 * @return waybillSubTime
	 */
	public Date getWaybillSubTime() {
		return waybillSubTime;
	}

	/**
	 * @param waybillSubTime 要设置的 waybillSubTime
	 */
	public void setWaybillSubTime(Date waybillSubTime) {
		this.waybillSubTime = waybillSubTime;
	}

	/**
	 * @return waybillFinishTime
	 */
	public Date getWaybillFinishTime() {
		return waybillFinishTime;
	}

	/**
	 * @param waybillFinishTime 要设置的 waybillFinishTime
	 */
	public void setWaybillFinishTime(Date waybillFinishTime) {
		this.waybillFinishTime = waybillFinishTime;
	}

	/**
	 * @return waybillState
	 */
	public String getWaybillState() {
		return waybillState;
	}

	/**
	 * @param waybillState 要设置的 waybillState
	 */
	public void setWaybillState(String waybillState) {
		this.waybillState = waybillState;
	}
	
	
	

}

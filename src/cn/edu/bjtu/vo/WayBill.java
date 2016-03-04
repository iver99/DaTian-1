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
	private String orderNum;
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
	private String resourceName;
	
	private Float price;
	private String picture;
	
    
	/**
	 * @return picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * @param picture Ҫ���õ� picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * @return price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price Ҫ���õ� price
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}

	/**
	 * @param resourceName Ҫ���õ� resourceName
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
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
	 * @return deliveryAddr
	 */
	public String getDeliveryAddr() {
		return deliveryAddr;
	}

	/**
	 * @param deliveryAddr Ҫ���õ� deliveryAddr
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
	 * @param deliveryName Ҫ���õ� deliveryName
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
	 * @param deliveryPhone Ҫ���õ� deliveryPhone
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
	 * @param recieverAddr Ҫ���õ� recieverAddr
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
	 * @param recieverName Ҫ���õ� recieverName
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
	 * @param recieverPhone Ҫ���õ� recieverPhone
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
	 * @param goodsName Ҫ���õ� goodsName
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
	 * @param goodsWeight Ҫ���õ� goodsWeight
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
	 * @param goodsVolume Ҫ���õ� goodsVolume
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
	 * @param carNum Ҫ���õ� carNum
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
	 * @param driver Ҫ���õ� driver
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
	 * @param confirm Ҫ���õ� confirm
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
	 * @param waybillSubTime Ҫ���õ� waybillSubTime
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
	 * @param waybillFinishTime Ҫ���õ� waybillFinishTime
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
	 * @param waybillState Ҫ���õ� waybillState
	 */
	public void setWaybillState(String waybillState) {
		this.waybillState = waybillState;
	}
	
	
	

}

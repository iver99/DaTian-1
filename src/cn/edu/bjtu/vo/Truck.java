/**
 * 
 */
package cn.edu.bjtu.vo;

import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author solitudeycq
 *
 */
@Component
public class Truck implements java.io.Serializable {
	
	private String id;
	private String startCity;
	private String endCity;
	private int onwayTime;
	private String carType;
	private Float carLength;
	private Float stanPrice1;
	private Float stanPrice2;
	private Float pickFee;
	private Float deliveryFee;
	private String offerReturn;
	private String extraService;
	private Date relDate;
	private String carrierId;
	private String remarks;
	private String picture;
	private String resourceType;
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
	 * @return startCity
	 */
	public String getStartCity() {
		return startCity;
	}
	/**
	 * @param startCity 要设置的 startCity
	 */
	public void setStartCity(String startCity) {
		this.startCity = startCity;
	}
	/**
	 * @return endCity
	 */
	public String getEndCity() {
		return endCity;
	}
	/**
	 * @param endCity 要设置的 endCity
	 */
	public void setEndCity(String endCity) {
		this.endCity = endCity;
	}
	/**
	 * @return onwayTime
	 */
	public int getOnwayTime() {
		return onwayTime;
	}
	/**
	 * @param onwayTime 要设置的 onwayTime
	 */
	public void setOnwayTime(int onwayTime) {
		this.onwayTime = onwayTime;
	}
	/**
	 * @return carType
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * @param carType 要设置的 carType
	 */
	public void setCarType(String carType) {
		this.carType = carType;
	}
	/**
	 * @return carLength
	 */
	public Float getCarLength() {
		return carLength;
	}
	/**
	 * @param carLength 要设置的 carLength
	 */
	public void setCarLength(Float carLength) {
		this.carLength = carLength;
	}
	/**
	 * @return stanPrice1
	 */
	public Float getStanPrice1() {
		return stanPrice1;
	}
	/**
	 * @param stanPrice1 要设置的 stanPrice1
	 */
	public void setStanPrice1(Float stanPrice1) {
		this.stanPrice1 = stanPrice1;
	}
	/**
	 * @return stanPrice2
	 */
	public Float getStanPrice2() {
		return stanPrice2;
	}
	/**
	 * @param stanPrice2 要设置的 stanPrice2
	 */
	public void setStanPrice2(Float stanPrice2) {
		this.stanPrice2 = stanPrice2;
	}
	/**
	 * @return pickFee
	 */
	public Float getPickFee() {
		return pickFee;
	}
	/**
	 * @param pickFee 要设置的 pickFee
	 */
	public void setPickFee(Float pickFee) {
		this.pickFee = pickFee;
	}
	/**
	 * @return deliveryFee
	 */
	public Float getDeliveryFee() {
		return deliveryFee;
	}
	/**
	 * @param deliveryFee 要设置的 deliveryFee
	 */
	public void setDeliveryFee(Float deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	/**
	 * @return offerReturn
	 */
	public String getOfferReturn() {
		return offerReturn;
	}
	/**
	 * @param offerReturn 要设置的 offerReturn
	 */
	public void setOfferReturn(String offerReturn) {
		this.offerReturn = offerReturn;
	}
	/**
	 * @return extraService
	 */
	public String getExtraService() {
		return extraService;
	}
	/**
	 * @param extraService 要设置的 extraService
	 */
	public void setExtraService(String extraService) {
		this.extraService = extraService;
	}
	/**
	 * @return relDate
	 */
	public Date getRelDate() {
		return relDate;
	}
	/**
	 * @param relDate 要设置的 relDate
	 */
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	/**
	 * @return carrierId
	 */
	public String getCarrierId() {
		return carrierId;
	}
	/**
	 * @param carrierId 要设置的 carrierId
	 */
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	/**
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}
	/**
	 * @param remarks 要设置的 remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	/**
	 * @return picture
	 */
	public String getPicture() {
		return picture;
	}
	/**
	 * @param picture 要设置的 picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}
	/**
	 * @return resourceType
	 */
	public String getResourceType() {
		return resourceType;
	}
	/**
	 * @param resourceType 要设置的 resourceType
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	/**
	 * 
	 */
	public Truck() {
	}
	/**
	 * @param id
	 */
	public Truck(String id) {
		this.id = id;
	}
	/**
	 * @param id
	 * @param startCity
	 * @param endCity
	 * @param onwayTime
	 * @param carType
	 * @param carLength
	 * @param stanPrice1
	 * @param stanPrice2
	 * @param pickFee
	 * @param deliveryFee
	 * @param offerReturn
	 * @param extraService
	 * @param relDate
	 * @param carrierId
	 * @param remarks
	 * @param picture
	 * @param resourceType
	 */
	public Truck(String id, String startCity, String endCity, int onwayTime, String carType, Float carLength,
			Float stanPrice1, Float stanPrice2, Float pickFee, Float deliveryFee, String offerReturn,
			String extraService, Date relDate, String carrierId, String remarks, String picture, String resourceType) {
		super();
		this.id = id;
		this.startCity = startCity;
		this.endCity = endCity;
		this.onwayTime = onwayTime;
		this.carType = carType;
		this.carLength = carLength;
		this.stanPrice1 = stanPrice1;
		this.stanPrice2 = stanPrice2;
		this.pickFee = pickFee;
		this.deliveryFee = deliveryFee;
		this.offerReturn = offerReturn;
		this.extraService = extraService;
		this.relDate = relDate;
		this.carrierId = carrierId;
		this.remarks = remarks;
		this.picture = picture;
		this.resourceType = resourceType;
	}
}

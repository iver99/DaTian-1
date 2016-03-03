package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="city_carrier_view")
public class CityCarrierView {
	private String companyName;
	private String creditRate;
	@Id
	private String id;
	private String cityName;
	private Float refPrice;
	private Float standPrice1;
	private Float standPrice2;
	private Float pickFee;
	private Float deliveryFee;
	private Date relDate;
	private String carrierId;
	private String VIPService;
	private String detailPrice;
	private String remarks;
	private String name;
	
	/**
	 * @return standPrice1
	 */
	public Float getStandPrice1() {
		return standPrice1;
	}
	/**
	 * @param standPrice1 要设置的 standPrice1
	 */
	public void setStandPrice1(Float standPrice1) {
		this.standPrice1 = standPrice1;
	}
	/**
	 * @return standPrice2
	 */
	public Float getStandPrice2() {
		return standPrice2;
	}
	/**
	 * @param standPrice2 要设置的 standPrice2
	 */
	public void setStandPrice2(Float standPrice2) {
		this.standPrice2 = standPrice2;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetailPrice() {
		return detailPrice;
	}
	public void setDetailPrice(String detailPrice) {
		this.detailPrice = detailPrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCreditRate() {
		return creditRate;
	}
	public void setCreditRate(String creditRate) {
		this.creditRate = creditRate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public Float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(Float refPrice) {
		this.refPrice = refPrice;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getVIPService() {
		return VIPService;
	}
	public void setVIPService(String vIPService) {
		VIPService = vIPService;
	}
}

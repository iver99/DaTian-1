package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * 资源栏城市配送筛选pagebean
 * @author RussWest0
 * @date   2015年6月13日 下午1:34:38
 */
public class CityLineSearchBean {

	private String id;
	private String cityName;//城市名称
	private String refPrice;
	private String companyName;
	private String VIPService;//增值服务
	private Integer creditRate;//信用等级
	private Date relDate;
	private String status;//关注状态
	private String name;//资源名称
	private String carrierId;//承运方id
	private Float standPrice1;
	private Float standPrice2;
	private Float pickFee;
	private Float deliveryFee;
	
	
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
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public String getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getVIPService() {
		return VIPService;
	}
	public void setVIPService(String vIPService) {
		VIPService = vIPService;
	}
	
	public Integer getCreditRate() {
		return creditRate;
	}
	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}

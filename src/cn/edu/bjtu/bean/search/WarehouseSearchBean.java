package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 *  �ֿ�ɸѡpagebean
 *  
 * @author RussWest0
 * @date   2015��6��13�� ����4:13:23
 */
public class WarehouseSearchBean {
	
	private String id;
	private String carrierId;
	private String city;
	private String type;//�ֿ�����
//	private String kind;
	private String storageForm;//������̬
	private String houseArea;//�ֿ���� 
	private String status;//��ע״̬  
	private String remainArea;
	private String standPrice;
	
	private String name;
	private String companyName;
	private String fireRate;
	private Date relDate;


	/**
	 * @return remainArea
	 */
	public String getRemainArea() {
		return remainArea;
	}


	/**
	 * @param remainArea Ҫ���õ� remainArea
	 */
	public void setRemainArea(String remainArea) {
		this.remainArea = remainArea;
	}


	/**
	 * @return standPrice
	 */
	public String getStandPrice() {
		return standPrice;
	}


	/**
	 * @param standPrice Ҫ���õ� standPrice
	 */
	public void setStandPrice(String standPrice) {
		this.standPrice = standPrice;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getFireRate() {
		return fireRate;
	}


	public void setFireRate(String fireRate) {
		this.fireRate = fireRate;
	}


	public Date getRelDate() {
		return relDate;
	}


	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getCarrierId() {
		return carrierId;
	}


	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStorageForm() {
		return storageForm;
	}


	public void setStorageForm(String storageForm) {
		this.storageForm = storageForm;
	}
	public String getHouseArea() {
		return houseArea;
	}


	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}

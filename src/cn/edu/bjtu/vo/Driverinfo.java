package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="driverinfo")
public class Driverinfo implements java.io.Serializable {
	@Id
	private String id;
	private String driverName;
	private String sex;
	private Integer age;
	private String licenceRate;
	private String phone;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date relDate;
	private String IDCard;
	private String licenceNum;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date licenceTime;
	private String carrierId;
	private String remarks;
	private String carId;
	private String idscans;
	private String passwd;
	private String state;//司机状态-已分配，空闲。

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state 要设置的 state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return passwd
	 */
	public String getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd 要设置的 passwd
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getIdscans() {
		return idscans;
	}

	public void setIdscans(String idscans) {
		this.idscans = idscans;
	}
	
	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDriverName() {
		return this.driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getLicenceRate() {
		return this.licenceRate;
	}

	public void setLicenceRate(String licenceRate) {
		this.licenceRate = licenceRate;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}


	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public String getLicenceNum() {
		return this.licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public Date getLicenceTime() {
		return this.licenceTime;
	}

	public void setLicenceTime(Date licenceTime) {
		this.licenceTime = licenceTime;
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

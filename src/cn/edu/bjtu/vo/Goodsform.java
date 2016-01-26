package cn.edu.bjtu.vo;

// Generated 2015-2-14 15:14:57 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="goodsform")
public class Goodsform implements java.io.Serializable {
	@Id
	private String id;
	private String name;
	private String type;
	private String transportType;
	private Float weight;
	//private Float volume;
	private String startPlace;
	private String endPlace;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date relDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date limitDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date updateDate;
	//private String declaredValue;
	private String transportReq;
	private String damageReq;
	private String vipservice;
	private String vipServiceDetail;//add by RussWest0 at 2015年6月9日,下午8:51:25 
	private String oriented;
	private int feedbackQuantity;
	private String invoice;
	private String relatedMaterial;//图片展示
	private String clientId;
	private String remarks;  //补充信息
	private String state;
	private String goodsDes;//货物描述
	private String feeReq;//费用要求
	
	/*private String carrierId;

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}*/

	public String getState() {
		return state;
	}

	/**
	 * @return updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate 要设置的 updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return goodsDes
	 */
	public String getGoodsDes() {
		return goodsDes;
	}

	/**
	 * @param goodsDes 要设置的 goodsDes
	 */
	public void setGoodsDes(String goodsDes) {
		this.goodsDes = goodsDes;
	}

	/**
	 * @return feeReq
	 */
	public String getFeeReq() {
		return feeReq;
	}

	/**
	 * @param feeReq 要设置的 feeReq
	 */
	public void setFeeReq(String feeReq) {
		this.feeReq = feeReq;
	}

	public String getVipServiceDetail() {
		return vipServiceDetail;
	}

	public void setVipServiceDetail(String vipServiceDetail) {
		this.vipServiceDetail = vipServiceDetail;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Goodsform() {
	}

	public Goodsform(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransportType() {
		return this.transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	/*public Float getVolume() {
		return this.volume;
	}

	public void setVolume(Float volume) {
		this.volume = volume;
	}
*/
	public String getStartPlace() {
		return this.startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return this.endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public Date getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	/*public String getDeclaredValue() {
		return this.declaredValue;
	}

	public void setDeclaredValue(String declaredValue) {
		this.declaredValue = declaredValue;
	}*/

	public String getTransportReq() {
		return this.transportReq;
	}

	public void setTransportReq(String transportReq) {
		this.transportReq = transportReq;
	}

	public String getDamageReq() {
		return this.damageReq;
	}

	public void setDamageReq(String damageReq) {
		this.damageReq = damageReq;
	}

	public String getVipservice() {
		return this.vipservice;
	}

	public void setVipservice(String vipservice) {
		this.vipservice = vipservice;
	}

	public String getOriented() {
		return this.oriented;
	}

	public void setOriented(String oriented) {
		this.oriented = oriented;
	}

	public int getFeedbackQuantity() {
		return this.feedbackQuantity;
	}

	public void setFeedbackQuantity(int feedbackQuantity) {
		this.feedbackQuantity = feedbackQuantity;
	}
	
	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getRelatedMaterial() {
		return this.relatedMaterial;
	}

	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}

	
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}

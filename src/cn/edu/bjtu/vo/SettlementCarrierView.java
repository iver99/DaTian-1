package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
/**
 * ���㹦����ͼvo
 * @author RussWest0
 *
 */
@Entity
@Table(name="settlement_carrier_view")
public class SettlementCarrierView {
	@Id
	private String id;//����id
	private String orderNum;
	private String clientName;
	private String contractId;
	private Date submitTime;
	private String settlementState;
	private String settlementStateCompany;
	private Float actualPrice;
	private Float expectedPrice;
	private String carrierId;
	
	private String carrierId2;
	private String companyName;
	//add by RussWest0 at 2015��6��20��,����12:16:01 
	private String clientId;
	private String state;
	
	
	/**
	 * @return settlementStateCompany
	 */
	public String getSettlementStateCompany() {
		return settlementStateCompany;
	}
	/**
	 * @param settlementStateCompany Ҫ���õ� settlementStateCompany
	 */
	public void setSettlementStateCompany(String settlementStateCompany) {
		this.settlementStateCompany = settlementStateCompany;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCarrierId2() {
		return carrierId2;
	}
	public void setCarrierId2(String carrierId2) {
		this.carrierId2 = carrierId2;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getContractId() {
		return contractId;
	}
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
	public Date getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	public String getSettlementState() {
		return settlementState;
	}
	public void setSettlementState(String settlementState) {
		this.settlementState = settlementState;
	}
	public Float getActualPrice() {
		return actualPrice;
	}
	public void setActualPrice(Float actualPrice) {
		this.actualPrice = actualPrice;
	}
	public Float getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(Float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
}

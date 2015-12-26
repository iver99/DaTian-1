package cn.edu.bjtu.bean.page;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 财务分析-运营指标-pagebean
 * @author iver
 * @date   2015年12月26日 下午6:13:08
 */
public class OperationBean {
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date startDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date endDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date date;
	private String transportAccuracy;//运输准确率
	private Integer accurateIntention;//准确意向数
	private Integer totalIntention;//总意向数
	private String clientConsentRate;//客户满意度
	
	/**
	 * @return the clientConsentRate
	 */
	public String getClientConsentRate() {
		return clientConsentRate;
	}
	/**
	 * @param clientConsentRate the clientConsentRate to set
	 */
	public void setClientConsentRate(String clientConsentRate) {
		this.clientConsentRate = clientConsentRate;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the transportAccuracy
	 */
	public String getTransportAccuracy() {
		return transportAccuracy;
	}
	/**
	 * @param transportAccuracy the transportAccuracy to set
	 */
	public void setTransportAccuracy(String transportAccuracy) {
		this.transportAccuracy = transportAccuracy;
	}
	/**
	 * @return the accurateIntention
	 */
	public Integer getAccurateIntention() {
		return accurateIntention;
	}
	/**
	 * @param accurateIntention the accurateIntention to set
	 */
	public void setAccurateIntention(Integer accurateIntention) {
		this.accurateIntention = accurateIntention;
	}
	/**
	 * @return the totalIntention
	 */
	public Integer getTotalIntention() {
		return totalIntention;
	}
	/**
	 * @param totalIntention the totalIntention to set
	 */
	public void setTotalIntention(Integer totalIntention) {
		this.totalIntention = totalIntention;
	}
	
	
}

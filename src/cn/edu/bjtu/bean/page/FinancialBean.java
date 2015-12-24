package cn.edu.bjtu.bean.page;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 财务分析pagebean
 * @author iver
 * @date   2015年12月23日 下午8:51:29
 */
public class FinancialBean {
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	Date date;//时间yyyy-mm-dd
	Double transportFee;//运费收入
	Double totalInsurance;//保险费收入
	Double totalFee;//合计
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	Date startDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	Date endDate;
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
	 * @return the transportFee
	 */
	public Double getTransportFee() {
		return transportFee;
	}
	/**
	 * @param transportFee the transportFee to set
	 */
	public void setTransportFee(Double transportFee) {
		this.transportFee = transportFee;
	}
	/**
	 * @return the totalInsurance
	 */
	public Double getTotalInsurance() {
		return totalInsurance;
	}
	/**
	 * @param totalInsurance the totalInsurance to set
	 */
	public void setTotalInsurance(Double totalInsurance) {
		this.totalInsurance = totalInsurance;
	}
	/**
	 * @return the totalFee
	 */
	public Double getTotalFee() {
		return totalFee;
	}
	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	
}

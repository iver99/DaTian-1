package cn.edu.bjtu.vo.sms;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 短信操作日志
 * @author iver
 * @date   2016年1月26日 下午10:42:08
 */
@Entity
@Table(name="sms_log")
public class SmsLog {

	@Id
	private int id;
	private String terminal;//终端类型，pc端发出的短信或者安卓端发出的短信
	private String type;//日志类型,详细类型请参见constant常量池
	private String phone;
	private String smsContent;
	private String comment;//备注
	private Date time;
	private int status;//状态，参见cosntant常量池
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the terminal
	 */
	public String getTerminal() {
		return terminal;
	}
	/**
	 * @param terminal the terminal to set
	 */
	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the smsContent
	 */
	public String getSmsContent() {
		return smsContent;
	}
	/**
	 * @param smsContent the smsContent to set
	 */
	public void setSmsContent(String smsContent) {
		this.smsContent = smsContent;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}

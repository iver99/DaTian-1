package cn.edu.bjtu.bean.page;

import java.util.Date;
/**
 * ��עpage bean
 * @ClassName: FocusBean 
 * @author chendonghao 
 * @date 2015��7��6�� ����12:36:42
 */
public class FocusBean {
	private String id;
	private String clientId;
	private String focusType;
	private String resourceId;//��Դ��id����Ӧvo���focusId
	private String status;//��ע��״̬
	private String startPlace;//����
	private String endPlace;//����
	private String lineName;//��������
	private String carrierId;
	private String companyName;//��˾����
	private Date relDate;
	private String name;//�������͵�name,���ֿ߲� name�����߻�����
	private String carNum;//����
	private Date time;
	
	
	
	
	
	/**
	 * @return time
	 */
	public Date getTime() {
		return time;
	}
	/**
	 * @param time Ҫ���õ� time
	 */
	public void setTime(Date time) {
		this.time = time;
	}
	private String search_content;//������ʹ�� 
	
	
	
	public String getSearch_content() {
		return search_content;
	}
	public void setSearch_content(String search_content) {
		this.search_content = search_content;
	}
	public String getLineName() {
		return lineName;
	}
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getFocusType() {
		return focusType;
	}
	public void setFocusType(String focusType) {
		this.focusType = focusType;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
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
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	
	
	
}

package cn.edu.bjtu.bean.page;

/**
 * Ͷ�߹��ܵ�ҳ��Bean
 * @author RussWest0
 * @date   2015��6��9�� ����11:01:47
 */
public class ComplaintBean {
	
	/**
	 * ˵����
	 * �˰��µ��඼��page Bean����ҳ������ʾ����ҳ�����̨������ʹ�ã�д�ڿ������ķ����������
	 * ��������Կ��Բ���һ�ű�����ݣ�ע���vo���µ������֣�vo���������ͱ�һһ��Ӧ��
	 */
	
	private String type;
	private String theme;
	private String content;
	private String orderNum;
	private String relativeMaterial;//��ز���
	
	/**
	 * @return the relativeMaterial
	 */
	public String getRelativeMaterial() {
		return relativeMaterial;
	}
	/**
	 * @param relativeMaterial the relativeMaterial to set
	 */
	public void setRelativeMaterial(String relativeMaterial) {
		this.relativeMaterial = relativeMaterial;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
}

package cn.edu.bjtu.util;
/**
 * ������
 * @author RussWest0
 * @date   2015��6��2�� ����8:37:51
 */
public class Constant {
	
	/*�û����*/
	public static final String USER_NAME="username";
	
	public static final String USER_KIND="userKind";
	
	public static final String USER_ID="userId";
	
	/**
	 * ===============����Դ��ʼ=====================================
	 */
	/*����Դ���*/
	public static final String DATA_SOURCE="dataSource";
	
	/*��֤����ȫ��ص�����Դ*/
	public static final String DATA_SOURCE_SECURITY="dataSource_security";
	/**
	 * ��������Դ
	 */
	public static final String DATA_SOURCE_SMS="dataSource_sms";
	/**
	 * ===============����Դ����=====================================
	 */
	//���ŷ���״̬
	public static final Integer SMS_SUCCESS=0;//���ŷ��ͳɹ� 
	public static final Integer SMS_FAIL=-1;//���ŷ���ʧ��
	//������Դ�ն�����
	public static final String SMS_PC_TERM="PC";
	public static final String SMS_ANDROID_TERM="ANDROID";
	//��������
	public static final String SMS_VCODE="VCODE";//��֤��
	public static final String SMS_WARNING="WARNING";//����
	public static final String SMS_INFO="INFO";//�������͵Ķ�����Ϣ
	
	//������֤�����ʱ�� ��λΪ��
	public static final Integer SMS_EXPIRE_TIME=60 * 5;

}

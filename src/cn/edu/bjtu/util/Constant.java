package cn.edu.bjtu.util;
/**
 * 常量类
 * @author RussWest0
 * @date   2015年6月2日 下午8:37:51
 */
public class Constant {
	
	/*用户相关*/
	public static final String USER_NAME="username";
	
	public static final String USER_KIND="userKind";
	
	public static final String USER_ID="userId";
	
	/**
	 * ===============数据源开始=====================================
	 */
	/*数据源相关*/
	public static final String DATA_SOURCE="dataSource";
	
	/*认证，安全相关的数据源*/
	public static final String DATA_SOURCE_SECURITY="dataSource_security";
	/**
	 * 短信数据源
	 */
	public static final String DATA_SOURCE_SMS="dataSource_sms";
	/**
	 * ===============数据源结束=====================================
	 */
	//短信发送状态
	public static final Integer SMS_SUCCESS=0;//短信发送成功 
	public static final Integer SMS_FAIL=-1;//短信发送失败
	//短信来源终端类型
	public static final String SMS_PC_TERM="PC";
	public static final String SMS_ANDROID_TERM="ANDROID";
	//短信类型
	public static final String SMS_VCODE="VCODE";//验证码
	public static final String SMS_WARNING="WARNING";//警告
	public static final String SMS_INFO="INFO";//其他类型的短信信息
	
	

}

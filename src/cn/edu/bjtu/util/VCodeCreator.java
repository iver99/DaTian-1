package cn.edu.bjtu.util;
/**
 * 验证码生成工具
 * @author iver
 * @date   2016年1月26日 上午11:56:09
 */
public class VCodeCreator {

	/**
	 * 随机生成一个4位数字验证码
	 * @return
	 */
	public static String getVCode(){
		int vcode=(int)(Math.random() * 10000);
		
		//保证返回四位随机数
		return vcode<1000?vcode+1000+"":vcode+"";
	}
	
}

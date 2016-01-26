package cn.edu.bjtu.util;
/**
 * 验证码生成工具
 * @author iver
 * @date   2016年1月26日 上午11:56:09
 */
public class VCodeCreator {

	/**
	 * 随机生成一个验证码
	 * @return
	 */
	public static String getVCode(){
		return (int)(Math.random() * 10000)+"";
	}
	
}

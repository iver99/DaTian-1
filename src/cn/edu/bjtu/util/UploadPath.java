package cn.edu.bjtu.util;

import java.io.File;

/**
 * ���ظ����ϴ���·��-ÿ��·������������windows��linux
 * 
 * @author RussWest0
 *
 */
public class UploadPath {

	
	public static File file = null;

	/**
	 * ���ظ����ļ��ϴ���·��
	 * 
	 * @return
	 */
	public static String getLinetransportPath() {
		// return sep+Base_Directory+sep+"linetransport";
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//linetransport";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/linetransport";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	/**
	 * ���������ļ��ϴ���·��
	 * 
	 * @return
	 */
	public static String getFullTruckLoadPath() {
		// return sep+Base_Directory+sep+"linetransport";
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//fulltruckload";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/fulltruckload";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	/**
	 * �����㵣�ļ��ϴ���·��
	 * 
	 * @return
	 */
	public static String getLessTruckLoadPath() {
		// return sep+Base_Directory+sep+"linetransport";
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//lesstruckload";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/lesstruckload";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	/**
	 * ���ع��ڿ����ļ��ϴ���·��
	 * 
	 * @return
	 */
	public static String getAirLinePath() {
		// return sep+Base_Directory+sep+"linetransport";
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//airline";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/airline";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	public static String getCitylinePath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//cityline";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/cityline";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	public static String getGoodsPath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//goods";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/goods";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	public static String getWarehousePath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//warehouse";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/warehouse";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	/*public static String getUserpicturePath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//userpicture";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/userpicture";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}*/
	public static String getUserpicturePath() {
		if (isWindows()) {//windowsϵͳ
			String path = "G://tomcat7//webapps//Datian//views//userpicture";//�ϴ�����Ŀ�е�userpicture�ļ�����
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/tomcat7_v2/webapps/Datian/views/userpicture";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	public static String getClientPath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//client";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/client";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	public static String getContractPath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//client";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/client";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	public static String getDriverPath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//driver";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/driver";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	

	public static String getCompanyCertificatePath() {
		
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//companyCertificate";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/companyCertificate";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	//ǩ���ϴ�ͼ��1
	public static String getSignBillPath() {
		if (isWindows()) {//windowsϵͳ
			String path = "D://eclipse_project//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//DaTian//file//signBill";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/tomcat7_v2/webapps/DaTian/file/signBill";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	//ǩ���ϴ�ͼ��2
		public static String anothergetSignBillPath() {
			if (isWindows()) {//windowsϵͳ
				String path = "D://eclipse_project//.metadata//.plugins//org.eclipse.wst.server.core//tmp0//wtpwebapps//DaTian//file//signBill//";//�ϴ���D��
				file = new File(path);
				file.mkdirs();//�Է��ļ��в�����
				return path;
			}
			else//linuxϵͳ (δ����)
			{
				//����ļ��в��������û�д���
				String path= "/usr/local/tomcat7_v2/webapps/DaTian/file/signBill/";
				file=new File(path);
				file.mkdirs();//��ֹ�ļ��в�����
				return path;
			}
		}
	/**
	 * �ύ����ʱ�ύ���ļ�
	 * @return
	 */
	public static String getResponsePath(){
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//response";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/response";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	/**
	 * �ύͶ��ʱ�ύ���ļ�
	 * @return
	 */
	public static String getComplaintPath(){
		if (isWindows()) {//windowsϵͳ
			String path = "D://uploadFile//complaint";//�ϴ���D��
			file = new File(path);
			file.mkdirs();//�Է��ļ��в�����
			return path;
		}
		else//linuxϵͳ (δ����)
		{
			//����ļ��в��������û�д���
			String path= "/usr/local/uploadFile/complaint";
			file=new File(path);
			file.mkdirs();//��ֹ�ļ��в�����
			return path;
		}
	}
	
	
	// �жϵ�ǰϵͳ
	public static boolean isWindows() {
		boolean flag = false;
		if (System.getProperties().getProperty("os.name").toUpperCase()
				.indexOf("WINDOWS") != -1) {
			flag = true;
		}
		return flag;
	}


}

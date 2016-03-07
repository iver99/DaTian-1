package cn.edu.bjtu.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.web.multipart.MultipartFile;

import Decoder.BASE64Decoder;

/**
 * �ļ��ϴ�
 * @author RussWest0
 * @date   2015��7��5�� ����2:51:20
 */
public class UploadFile {
	
	/**
	 * �����ļ��������ļ��ľ���·��
	 * @param file �ļ�
	 * @param userId �û�id
	 * @param fileType �ļ�����
	 * @return
	 */
	public static String uploadFile(MultipartFile file,String userId,String fileType){
		String path = "";
		String fileName = "";
		String fileLocation ="";
		
		if ("linetransport".equals(fileType)) {
			path = UploadPath.getLinetransportPath();
		} else if ("cityline".equals(fileType)) {
			path = UploadPath.getCitylinePath();
		} else if ("cargo".equals(fileType)) {
			path = UploadPath.getGoodsPath();
		} else if ("warehouse".equals(fileType)) {
			path = UploadPath.getWarehousePath();
		} else if ("businessClient".equals(fileType)) {
			path = UploadPath.getClientPath();
		} else if ("contract".equals(fileType)) {
			path = UploadPath.getContractPath();
		} else if ("driver".equals(fileType)) {
			path = UploadPath.getDriverPath();
		} else if ("companyCertificate".equals(fileType)) {
			path = UploadPath.getCompanyCertificatePath();
		} else if ("signBill".equals(fileType)) {
			path = UploadPath.getSignBillPath();
		} else if ("response".equals(fileType)) {
			path = UploadPath.getResponsePath();
		} else if ("complaint".equals(fileType)) {
			path = UploadPath.getComplaintPath();
		} else if("fulltruckload".equals(fileType)){
			path = UploadPath.getFullTruckLoadPath();
		} else if("lesstruckload".equals(fileType)){
			path = UploadPath.getLessTruckLoadPath();
		} else if("airline".equals(fileType)){
			path = UploadPath.getAirLinePath();
		}
		
		if (file.getSize() != 0)// ���ϴ��ļ������
		{
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// �ļ���
			File targetFile = new File(path, fileName);
			try { // ���� �ļ�
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			fileLocation = path + "//" + fileName;
			if ("signBill".equals(fileType)){
				return fileName;
			}else
				return fileLocation;
		
	}
	
	public static String mobileuploadFile(String strImageContent,String waybillNum){
		BASE64Decoder decoder = new BASE64Decoder();
		String imgFilePath = UploadPath.anothergetSignBillPath() + waybillNum + ".jpg";
		if(strImageContent == null){
			return "ͼ������Ϊ��";
		}
		try {
			byte[] bytes = decoder.decodeBuffer(strImageContent);
			for (int i = 0; i < bytes.length; ++i) {
				if (bytes[i] < 0) {// �����쳣����
					bytes[i] += 256;
				}
			}
			//����ͼƬ
			OutputStream out = new FileOutputStream(imgFilePath);		
			out.write(bytes);		
			out.flush();
			out.close();
			System.out.println("�洢�ɹ���");
			return imgFilePath;
		} catch (IOException e) {
			return "�洢ʧ�ܣ�";
		}	
	}
}

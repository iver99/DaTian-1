package cn.edu.bjtu.service;

import cn.edu.bjtu.vo.Companycertificate;

/**
 * 
 * @author RussWest0
 *
 */
public interface CompanycertificateService {
	
	public boolean validateCompany(String userId, String companyName,
			String divisionCode, String companyAddr, String companyType, 
			String companyScale,String businessKind,
			String companyContact, String phone,
			String path, String fileName);
	public Companycertificate getCompanycertificate(String companyId);
	public boolean companycertificateUpdate(String userId, String companyName,
			String divisionCode, 
			String companyAddr, String companyType, String companyScale,
			String businessKind,
			String companyContact, String phone, 
			String path, String fileName);
}

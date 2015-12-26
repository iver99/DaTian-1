package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Companycertificate;

/**
 * 
 * @author RussWest0
 *
 */
public interface CompanycertificateDao extends BaseDao<Companycertificate>{
	public Companycertificate getCompanycertificate(String companyId);
	public boolean companycertificateUpdate(String userId, String companyName,
			String divisionCode, 
			String companyAddr, String companyType, String companyScale,
			String businessKind,
			String companyContact, String phone, 
			String path, String fileName);

}

package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AddressDao;
import cn.edu.bjtu.service.AddressService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Transactional
@Service
/**
 * 子账户服务层实现 
 * 
 *
 */
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	AddressDao addressDao;
	@Resource 
	Address address;
	
	/**
	 * 获取地址列表
	 */
	@Override
	public List getAddress(String userId) {
		
		
		return addressDao.getAddress(userId);
	}
	
	
	@Override
	public Address getAddressDetail(String id){
		
		return addressDao.getAddressDetail(id);
	}
	
	
	@Override
	public boolean deleteAddress(String id){
		Address address=addressDao.get(Address.class, id);
		addressDao.delete(address);
		
		return true;
	}
	/**
	 * 新增常用地址
	 */
	@Override
	public boolean insertAddress(HttpSession session,Address address){
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		address.setId(IdCreator.createAddressId());
		address.setRelDate(new Date());
		address.setClientId(userId);
		 addressDao.save(address);
		 return true;
	}
	
	@Override
	public boolean updateAddress(HttpSession session,Address address){
	
		Address addr= addressDao.getAddressDetail(address.getId());// 根据id查找
		addr.setName(address.getName());
		addr.setPhone(address.getPhone());
		addr.setAddress(address.getAddress());
		addressDao.update(addr);
		return true;
	}
	


	/**
	 * 下订单时获取用于的发货地址列表
	 */
	@Override
	public JSONArray getUserAddress(HttpSession session,Integer kind) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId and t.kind=:kind";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", kind);
		List<Address> addressList=addressDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		for(Address address: addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(address);
			jsonArray.add(jsonObject);
		}
		return jsonArray;
	}
	
	/**
	 * 获取发货地址
	 */
	@Override
	public String getAddress(HttpSession session, PageUtil pageUtil,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Address t where t.clientId=:clientId and t.kind=:kind order by t.relDate desc ";//1为发货地址,2为收货地址
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Address> addressList=addressDao.find(hql, params, page, display);
		
		JSONArray jsonArray=new JSONArray();
		for(Address addr:addressList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(addr);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}

	/**
	 * 常用发货地址-总记录数
	 */
	@Override
	public Integer getAddressTotalRows(HttpSession session,Address address) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count (*) from Address t where t.clientId=:clientId and t.kind=:kind ";//1为发货地址,2为收货地址
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		params.put("kind", address.getKind());
		
		Long count =addressDao.count(hql, params);
		
		return count.intValue();
	}
	
}

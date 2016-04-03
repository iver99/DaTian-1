package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.FocusBean;
import cn.edu.bjtu.dao.AirLineDao;
import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.dao.TruckDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.AirLine;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Focus;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Truck;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class FocusServiceImpl extends BaseDaoImpl<Focus> implements FocusService {
	
	@Autowired
	FocusDao focous;
	@Autowired
	FocusDao focusDao;
	@Autowired
	LinetransportDao linetransportDao;
	@Autowired
	CitylineDao citylineDao;
	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	CarDao carDao;
	@Autowired
	GoodsInfoDao goodsinfoDao;
	@Autowired
	CompanyDao companyDao;
	@Autowired
	TruckDao truckDao;
	@Autowired
	AirLineDao airlineDao;
	@Autowired
	GoodsInfoDao goodsDao;
	

	@Override
	/**
	  * 添加关注
	  */
	public boolean insertFocus(String clientId, String foucsType, String foucsId){
		Focus focus=new Focus();
		focus.setId(IdCreator.createFocusId());
		focus.setClientId(clientId);
		focus.setFocusType(foucsType);
		focus.setFocusId(foucsId);
		focus.setStatus("有效");
		focusDao.save(focus);
		return true;
	}

	@Override
	/**
	  * 判断某条信息是否已被关注 
	  */
	public List getFocusJudgement(String clientId, String focusType,
			String focusId) {
		
		return focusDao.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
	}

	@Override
	/**
	  * 删除关注 
	  */
	public boolean deleteFocus(String id){
		Focus focus = this.get(Focus.class, id);
		 this.delete(focus);
		 return true;
	}
	@Override
	/**
	 * 关注列表获取
	 */
	public List getFocusList(String clientId,String focusType) {
		
		if(focusType != "")
			return this.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"'");
		else
			return this.find("from Focus where clientId='"+clientId+"'");
	}
	
	
	/**
	 * 搜索关注
	 */
	@Override
	public JSONArray searchFocus(FocusBean bean, HttpSession session,PageUtil pageUtil) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Focus t where t.clientId=:clientId order by t.focusType asc ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Focus> focusList=focusDao.find(hql, params,page,display);
		List<FocusBean> focusBeanList=new ArrayList<FocusBean>();
		String search_content=bean.getSearch_content();
			for(Focus focus:focusList){
				FocusBean focusBean=new FocusBean();
				if("fulltruckload".equals(focus.getFocusType())){
					Truck truck=truckDao.get(Truck.class, focus.getFocusId());
					Carrierinfo company = companyDao.get(Carrierinfo.class, truck.getCarrierId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setStartPlace(truck.getStartCity());
						focusBean.setEndPlace(truck.getEndCity());
						focusBean.setRelDate(truck.getRelDate());
						focusBean.setResourceId(truck.getId());
						focusBean.setCarrierId(truck.getCarrierId());
						focusBean.setCompanyName(company.getCompanyName());
						//若有筛选条件
						if("".equals(search_content) || (!"".equals(search_content) && 
								focusBean.getStartPlace().contains(search_content) ||
								focusBean.getEndPlace().contains(search_content))){
							    focusBeanList.add(focusBean);
					}	
				} else if("lesstruckload".equals(focus.getFocusType())){
					Truck truck=truckDao.get(Truck.class, focus.getFocusId());
					Carrierinfo company = companyDao.get(Carrierinfo.class, truck.getCarrierId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setStartPlace(truck.getStartCity());
						focusBean.setEndPlace(truck.getEndCity());
						focusBean.setRelDate(truck.getRelDate());
						focusBean.setResourceId(truck.getId());
						focusBean.setCarrierId(truck.getCarrierId());
						focusBean.setCompanyName(company.getCompanyName());
						//若有筛选条件
						if("".equals(search_content) || (!"".equals(search_content) && 
								focusBean.getStartPlace().contains(search_content) ||
								focusBean.getEndPlace().contains(search_content))){
							    focusBeanList.add(focusBean);
					}	
				} else if("cityline".equals(focus.getFocusType())){
					Cityline cityline=citylineDao.get(Cityline.class, focus.getFocusId());
					Carrierinfo company = companyDao.get(Carrierinfo.class, cityline.getCarrierId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setName(cityline.getName());
						focusBean.setRelDate(cityline.getRelDate());
						focusBean.setResourceId(cityline.getId());
						focusBean.setCarrierId(cityline.getCarrierId());
						focusBean.setCompanyName(company.getCompanyName());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}
				}else if("warehouse".equals(focus.getFocusType())){
					Warehouse warehouse=warehouseDao.get(Warehouse.class, focus.getFocusId());
					Carrierinfo company = companyDao.get(Carrierinfo.class, warehouse.getCarrierId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(warehouse.getRelDate());
						focusBean.setName(warehouse.getName());
						focusBean.setResourceId(warehouse.getId());
						focusBean.setCarrierId(warehouse.getCarrierId());
						focusBean.setCompanyName(company.getCompanyName());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}					
				}else if("goods".equals(focus.getFocusType())){
					Goodsform goods = goodsDao.get(Goodsform.class, focus.getFocusId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(goods.getRelDate());
						focusBean.setName(goods.getName());
						focusBean.setResourceId(goods.getId());
						//focusBean.setCarrierId(warehouse.getCarrierId());
						//focusBean.setCompanyName(company.getCompanyName());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}					
				}else if("airline".equals(focus.getFocusType())){
					AirLine airline = airlineDao.get(AirLine.class,focus.getFocusId());
					Carrierinfo company = companyDao.get(Carrierinfo.class, airline.getCarrierId());
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(airline.getRelDate());
						focusBean.setStartPlace(airline.getStartCity());
						focusBean.setEndPlace(airline.getEndCity());
						focusBean.setCompanyName(company.getCompanyName());
						focusBean.setResourceId(airline.getId());
						focusBean.setCarrierId(airline.getCarrierId());
						if("".equals(search_content) || (!"".equals(search_content) && 
								focusBean.getStartPlace().contains(search_content) ||
								focusBean.getEndPlace().contains(search_content))){
							    focusBeanList.add(focusBean);
					}	
				}
		}
		
		//转成jsonarray
		JSONArray jsonArray=new JSONArray();
		for(FocusBean fBean: focusBeanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(fBean);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}

	/**
	 * 我的关注总记录数
	 */
	@Override
	public Integer getUserFocusTotalRowsAjax(FocusBean bean,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Focus t where t.clientId=:clientId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Focus> focusList=focusDao.find(hql, params);
		String search_content=bean.getSearch_content();
		
		int count=0;
		
			for(Focus focus:focusList){
				FocusBean focusBean=new FocusBean();
				if("airline".equals(focus.getFocusType())){
					AirLine airline = airlineDao.get(AirLine.class,focus.getFocusId());
						//若有筛选条件
						if("".equals(search_content) || (!"".equals(search_content) && 
								airline.getId().contains(search_content))){
							count++;
					}
				}else if("cityline".equals(focus.getFocusType())){
					Cityline cityline=citylineDao.get(Cityline.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && cityline.getName().contains(search_content))){
							count++;
						}
				}else if("fulltruckload".equals(focus.getFocusType())){
					Truck truck=truckDao.get(Truck.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && truck.getId().contains(search_content))){
							
							count++;
						}
				}else if("lesstruckload".equals(focus.getFocusType())){
					Truck truck=truckDao.get(Truck.class, focus.getFocusId());
					if("".equals(search_content) || (!"".equals(search_content) && truck.getId().contains(search_content))){
						
						count++;
						}
				}else if("warehouse".equals(focus.getFocusType())){
					Warehouse warehouse=warehouseDao.get(Warehouse.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && warehouse.getName().contains(search_content))){
							count++;
						}
					
				}else if("goods".equals(focus.getFocusType())){
					Goodsform cargo=goodsinfoDao.get(Goodsform.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && cargo.getName().contains(search_content))){
							count++;
						}
				}
		}
		
	return count;
	}

	/**
	 * 设置关注信息为失效状态，id为资源id
	 */
	@Override
	public boolean setInvalid(String id) {
		String hql="from Focus t where t.focusId=:focusId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("focusId", id);
		List<Focus> focusList=focusDao.find(hql, params);
		if(focusList !=null){
			for(Focus focus:focusList){
				/*focus.setStatus("失效");
				focusDao.update(focus);*/
				/**
				 * 目前解决方案：
				 * 当资源删除后直接将关注表中的对应的记录也删除
				 */
				focusDao.delete(focus);
			}

		}
				
		return true;
	}
	
	
	
	
	
}

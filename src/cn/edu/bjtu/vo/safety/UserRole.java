package cn.edu.bjtu.vo.safety;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.edu.bjtu.vo.Userinfo;
/**
 * 用户权限表
 * @author iver
 * @date   2016年1月22日 下午4:56:40
 */
@Entity
@Table(name="t_user_role")
public class UserRole {
	@Id
	private Integer id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", unique = true)
	Userinfo userInfo;
	@ManyToOne
	@JoinColumn(name = "roleId", unique = true)
	Role role;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the userInfo
	 */
	public Userinfo getUserInfo() {
		return userInfo;
	}
	/**
	 * @param userInfo the userInfo to set
	 */
	public void setUserInfo(Userinfo userInfo) {
		this.userInfo = userInfo;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

}

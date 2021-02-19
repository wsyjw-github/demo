package pers.yjw.platform.demo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.model
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-20 17:51
 */
@Getter
@Setter
public class AdminUserDetails implements UserDetails {
	private String username;
	private String realName;
	private String password;
	private Integer status;
	private Map<String, Serializable> data;
	private String partnerCode;
	private String partnerKey;
	private List<SimpleGrantedAuthority> authorities;
	
	@Override
	public List<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public Map<String, Serializable> getData() {
		return data;
	}
	
	public void setData(Map<String, Serializable> data) {
		this.data = data;
	}
	
	public String getPartnerCode() {
		return partnerCode;
	}
	
	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AdminUserDetails that = (AdminUserDetails) o;
		return Objects.equals(username, that.username);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(username, partnerCode);
	}
}

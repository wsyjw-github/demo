//package pers.yjw.platform.demo.conf;
//
//import com.alibaba.fastjson.JSONObject;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Sets;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import pers.yjw.platform.demo.client.dto.RespDto;
//import pers.yjw.platform.demo.client.dto.UserInfo;
//import pers.yjw.platform.demo.client.service.UserService;
//import pers.yjw.platform.demo.model.AdminUserDetails;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Set;
//
///**
// * @projectName demo
// * @version: 1.0
// * @packageName pers.yjw.platform.demo.conf
// * @description:
// * @author: YaoJianwei
// * @create: 2019-09-20 16:10
// */
//@Slf4j
//@Component
//public class SecurityAuthenticationProvider implements AuthenticationProvider {
//	@Resource
//	private SecurityUserDetailsService securityUserDetailsService;
//
//	@Override
//	public Authentication authenticate(Authentication authentication)
//			throws AuthenticationException {
//		String username = authentication.getName();
//		String password = (String) authentication.getCredentials();
//		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
//			throw new BadCredentialsException("Wrong password.");
//		}
//
//		AdminUserDetails adminUserDetail = (AdminUserDetails) securityUserDetailsService.loadUserByUsername(username);
//		adminUserDetail.setRealName(adminUserDetail.getUsername());
//		Collection<? extends GrantedAuthority> authorities = adminUserDetail.getAuthorities();
//		return new UsernamePasswordAuthenticationToken(adminUserDetail, password, authorities);
//	}
//
//	@Override
//	public boolean supports(Class<?> authentication) {
//		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
//	}
//
//
////	@Override
////	public AdminUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
////		RespDto<UserInfo> userInfoRespDto = userService.selectByAccountName(s);
////		AdminUserDetails adminUserDetails = new AdminUserDetails();
////		if (userInfoRespDto.getCode() != 0) {
////			throw new UsernameNotFoundException(s + " not found");
////		}
////
////		Set<SimpleGrantedAuthority> grantedAuthorities = Sets.newHashSet();
////		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userInfoRespDto.getData().getRole());
////		grantedAuthorities.add(grantedAuthority);
////
////		adminUserDetails.setAuthorities(grantedAuthorities);
////		adminUserDetails.setUsername(userInfoRespDto.getData().getAccountName());
////		String password = "admin";
////		adminUserDetails.setPassword(password);
////
////
////
////		return adminUserDetails;
////	}
//}

//package pers.yjw.platform.demo.web;
//
//import com.google.common.collect.Sets;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import pers.yjw.platform.demo.model.AdminUserDetails;
//
//import java.util.Set;
//
///**
// * @projectName demo
// * @version: 1.0
// * @packageName pers.yjw.platform.demo.web
// * @description:
// * @author: YaoJianwei
// * @create: 2019-09-20 15:41
// */
//@Slf4j
//@RestController
//public class IndexController {
	
//	@RequestMapping("/login")
//	public String login(String username, String password) {
//		log.info("userName:{}, password:{}", username, password);
//		AdminUserDetails adminUserDetails = new AdminUserDetails();
//		adminUserDetails.setUsername(username);
//		adminUserDetails.setPassword(password);
//		Set<SimpleGrantedAuthority> authorities = Sets.newHashSet();
//		authorities.add(new SimpleGrantedAuthority("CAN_SEARCH"));
//		adminUserDetails.setAuthorities(authorities);
//		Authentication authentication = new UsernamePasswordAuthenticationToken(adminUserDetails, "",
//				adminUserDetails.getAuthorities());
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		return "User login success!";
//	}
//
//
//	@RequestMapping("/logout")
//	public String logout() {
//		return "logout success";
//	}
//
//	@RequestMapping("/message")
//	public String message() {
//		return "welcome!";
//	}
//}

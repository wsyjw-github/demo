//package pers.yjw.platform.demo.web;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
///**
// * ProductController
// *
// * @author yjw
// * @date 2019-11-19
// * @time 09:48
// * @desc
// */
//@Controller
//@RequestMapping("/product")
//public class ProductController {
//
//	@RequestMapping("/info")
//	@ResponseBody
//	public String productInfo() {
//		String currentUser = "";
//		SecurityContext securityContext = SecurityContextHolder.getContext();
//		Authentication authentication = securityContext.getAuthentication();
//		Object principl = authentication.getPrincipal();
//		if (principl instanceof UserDetails) {
//			currentUser = ((UserDetails) principl).getUsername();
//		} else {
//			currentUser = principl.toString();
//		}
//		return " some product info, currentUser is: " + currentUser;
//	}
//}

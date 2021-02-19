package pers.yjw.platform.demo.web;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo.web
 * @description:
 * @author: YaoJianwei
 * @create: 2019-07-01 16:18
 */

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Value("${a.version}")
	private String aVersion;

//	@Value("${b.version}")
//	private String bVersion;

//	@Value("${c.version}")
//	private String cVersion;
	
	@RequestMapping("/yjwtest")
	public String test(HttpServletRequest request) {
		System.out.println("进入TestController");
		HttpSession session = request.getSession();
		System.out.println("sessionId:" + session.getId());
		System.out.println("aVersion:" + aVersion);
//		System.out.println("bVersion:" + bVersion);
//		System.out.println("cVersion:" + cVersion);
		return "ok";
	}
	
	@RequestMapping("/yjwtest2")
	public String test2(HttpServletRequest request) {
		System.out.println("进入TestController2");
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			System.out.println(c.getName() + ": " + c.getValue());
		}
		return "ok2";
	}
	
	@PreAuthorize("hasAnyAuthority('testAuthority')")
	@RequestMapping("/yjwtest3")
	public String test3(HttpServletRequest request) {
		System.out.println("进入TestController3");
		HttpSession session = request.getSession(Boolean.TRUE);
		System.out.println("sessionId:" + session.getId());
		return "ok3";
	}
}

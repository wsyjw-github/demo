package pers.yjw.platform.demo.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

/**
 * LoginController
 *
 * @author yjw
 * @date 2019-11-18
 * @time 17:51
 * @desc springboot默认  static中放静态页面，而templates中放动态页面
 */
@Controller
public class LoginController {
	/**
	 * 访问static中放静态页面方法1:直接访问http://localhost:8099/hello.html
	 */
	/**
	 * 访问static中静态页面方法2。当在pom.xml中引入了thymeleaf组件，动态跳转会覆盖默认的静态跳转，默认就会跳转到/templates/hello.html
	 * @return
	 */
	@RequestMapping("/hello2")
	public String sayHello2() {
		return "hello.html";
	}
	
	/**
	 * 访问static中静态页面方法3。当在pom.xml中引入了thymeleaf组件，动态跳转会覆盖默认的静态跳转，默认就会跳转到/templates/hello.html
	 * @return
	 */
	@RequestMapping(value = "/hello3")
	public ModelAndView sayHello3(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("key", "你好呀");
		modelAndView.setViewName("/hello.html");
		return modelAndView;
	}
	
	/**
	 * 访问而templates中动态页面
	 * @return
	 */
	@RequestMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping({"/", "/index", "/home"})
	public String root(){
		return "index";
	}
	
	@PreAuthorize("hasAnyAuthority('USER')")
	@GetMapping("/user")
	public String user(@AuthenticationPrincipal Principal principal, Model model){
		model.addAttribute("username", principal.getName());
		return "user/user";
	}
}

//package pers.yjw.platform.demo.conf;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.logout.LogoutHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//import pers.yjw.platform.demo.handler.CustomLogoutHandler;
//import pers.yjw.platform.demo.handler.LoginSuccessHandler;
//import pers.yjw.platform.demo.po.UserEntity;
//
//import javax.annotation.Resource;
//
///**
// * @projectName demo
// * @version: 1.0
// * @packageName pers.yjw.platform.demo.conf
// * @description:
// * @author: YaoJianwei
// * @create: 2019-09-20 13:56
// */
//@Slf4j
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
//	@Resource
//	SecurityAuthenticationProvider securityAuthenticationProvider;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//				.antMatchers("/index", "/login", "/test/yjwtest", "/login1.html")
//				.permitAll()
//				.antMatchers(HttpMethod.OPTIONS)
//				.permitAll()
//				.anyRequest()
//				.authenticated()
//		;
//		http.formLogin()
//				.loginPage("/login1.html")
//				.loginProcessingUrl("/login")
//				.failureForwardUrl("/login")
//		;
//
////		http.addFilterAt(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//		http.csrf().disable();
//	}
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		super.configure(web);
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		auth.authenticationProvider(daoAuthenticationProvider());
////	}
//
//	@Autowired
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//			throws Exception {
//		//采用自定义验证
//		auth.authenticationProvider(securityAuthenticationProvider);
//		//需要采用加密
//		auth.userDetailsService(securityAuthenticationProvider).passwordEncoder(passwordEncoder());
//	}
//
////	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
////		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter =
////				new UsernamePasswordAuthenticationFilter();
////		usernamePasswordAuthenticationFilter.setPostOnly(false);
////		usernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
////		usernamePasswordAuthenticationFilter.setUsernameParameter("userName");
////		usernamePasswordAuthenticationFilter.setPasswordParameter("password");
////		usernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login"
////		));
////		usernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler
////				("/logout"));
////
////		return usernamePasswordAuthenticationFilter;
////	}
//
////
////	@Autowired
////	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(securityAuthenticationProvider).passwordEncoder(passwordEncoder());
////	}
//
////	@Bean
////	DaoAuthenticationProvider daoAuthenticationProvider() {
////		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
////		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
////		daoAuthenticationProvider.setUserDetailsService(securityAuthenticationProvider);
////		return daoAuthenticationProvider;
////	}
//
//	@Bean
//	public LoginSuccessHandler loginSuccessHandler() {
//		return new LoginSuccessHandler();
//	}
//
//	@Bean
//	public LogoutHandler logoutHandler() {
//		return new CustomLogoutHandler("");
//	}
//
//	@Bean
//	public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
//		return (httpServletRequest, httpServletResponse, authentication) -> {
//			try {
//				UserEntity user = (UserEntity) authentication.getPrincipal();
//				log.info("USER : " + user.getAccountName() + " LOGOUT SUCCESS !  ");
//			} catch (Exception e) {
//				log.info("LOGOUT EXCEPTION , e : " + e.getMessage());
//			}
//		};
//	}
//
//
//}

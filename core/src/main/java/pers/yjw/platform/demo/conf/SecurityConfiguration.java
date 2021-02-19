//package pers.yjw.platform.demo.conf;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//import javax.annotation.Resource;
//
///**
// * SecurityConfiguration
// *
// * @author yjw
// * @date 2019-11-19
// * @time 09:47
// * @desc 加了@EnableGlobalMethodSecurity(prePostEnabled=true) @PreAuthorize(“hasAuthority(‘admin’)”)才会生效
// */
//@Slf4j
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//	@Resource
//	private SecurityUserDetailsService securityUserDetailsService;
//
//	@Resource
//	private SecurityAuthenticationProvider securityAuthenticationProvider;
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests()
////				.antMatchers("/product/**").hasRole("USER")
////				.antMatchers("/admin/**").hasRole("ADMIN")
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//				;
//
//		http.addFilterAt(usernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//	}
//
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		//采用自定义验证
//		auth.authenticationProvider(securityAuthenticationProvider);
//		//采用加密
//		auth.userDetailsService(securityUserDetailsService).passwordEncoder(passwordEncoder());;
////				.inMemoryAuthentication()
////				.withUser("admin1") // 管理员，同事具有 ADMIN,USER权限，可以访问所有资源
////				.password("admin1")
////				.roles("ADMIN", "USER")
////				.and()
////				.withUser("user1").password("user1") // 普通用户，只能访问 /product/**
////				.roles("USER");
//	}
//
//	private UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter() throws Exception {
//		UsernamePasswordAuthenticationFilter usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilter();
//		usernamePasswordAuthenticationFilter.setPostOnly(false);
//		usernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
//		usernamePasswordAuthenticationFilter.setUsernameParameter("username");
//		usernamePasswordAuthenticationFilter.setPasswordParameter("password");
//		usernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login"));
//		usernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler("/logout"));
//
//		usernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(new SimpleUrlAuthenticationSuccessHandler("/"));
//		return usernamePasswordAuthenticationFilter;
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//}

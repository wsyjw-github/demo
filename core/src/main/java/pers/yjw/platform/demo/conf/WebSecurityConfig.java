package pers.yjw.platform.demo.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.annotation.Resource;

/**
 * WebSecurityConfig
 *
 * @author yjw
 * @date 2019-12-03
 * @time 14:34
 * @desc
 */
@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Resource
	private SecurityUserDetailsService securityUserDetailsService;
	
	/**
	 * 匹配 "/" 路径，不需要权限即可访问
	 * 匹配 "/user" 及其以下所有路径，都需要 "USER" 权限
	 * 登录地址为 "/login"，登录成功默认跳转到页面 "/user"
	 * 退出登录的地址为 "/logout"，退出成功后跳转到页面 "/login"
	 * 默认启用 CSRF
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
//				.antMatchers("/user/**").hasRole("USER")
				.and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/user")
				.and()
				.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//创建存放于内存的用户和角色
//		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication()
//				.withUser("admin1")
//				.password(encoder.encode("admin1"))
//				.roles("ADMIN")
//				.and()
//				.withUser("user1")
//				.password(encoder.encode("user1"))
//				.roles("USER");
		auth.userDetailsService(securityUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
//	/**
//	 * 在内存中创建一个名为 "user" 的用户，密码为 "pwd"，拥有 "USER" 权限
//	 */
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		User.UserBuilder users = User.withDefaultPasswordEncoder();
//		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//		manager.createUser(users.username("anoyi").password("anoyi").roles("USER").build());
//		return manager;
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

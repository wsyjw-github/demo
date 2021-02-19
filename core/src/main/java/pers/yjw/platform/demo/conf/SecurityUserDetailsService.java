package pers.yjw.platform.demo.conf;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pers.yjw.platform.demo.client.dto.RespDto;
import pers.yjw.platform.demo.client.dto.UserInfo;
import pers.yjw.platform.demo.client.service.UserService;
import pers.yjw.platform.demo.model.AdminUserDetails;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * SecurityUserDetailsService
 *
 * @author yjw
 * @date 2019-11-19
 * @time 14:32
 * @desc
 */
@Slf4j
@Component
public class SecurityUserDetailsService implements UserDetailsService {

	@Resource
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		RespDto<UserInfo> userInfoRespDto = userService.selectByAccountName(s);
		UserInfo userInfo = userInfoRespDto.getData();
		AdminUserDetails adminUserDetails = new AdminUserDetails();
		if (userInfoRespDto.getCode() != 0) {
			throw new UsernameNotFoundException(s + " not found");
		}
		
		List<SimpleGrantedAuthority> simpleGrantedAuthorities = Lists.newArrayList();
		simpleGrantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));

		adminUserDetails.setAuthorities(simpleGrantedAuthorities);
		adminUserDetails.setUsername(userInfoRespDto.getData().getAccountName());
		String password = new BCryptPasswordEncoder().encode("yjw123");
		adminUserDetails.setPassword(password);

		return new org.springframework.security.core.userdetails.User(userInfoRespDto.getData().getAccountName(), password, simpleGrantedAuthorities);
//		return adminUserDetails;
	}
}

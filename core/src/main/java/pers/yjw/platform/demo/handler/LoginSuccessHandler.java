package pers.yjw.platform.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import pers.yjw.platform.demo.po.UserEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * LoginSuccessHandler
 *
 * @author yjw
 * @date 2019-11-18
 * @time 16:06
 * @desc
 */
@Slf4j
public class LoginSuccessHandler extends
		SavedRequestAwareAuthenticationSuccessHandler {
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
										HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// 获得授权后可得到用户信息 可使用SUserService进行数据库操作
		UserEntity userEntity = (UserEntity) authentication.getPrincipal();
		
		// 输出登录提示信息
		logger.info("User" + userEntity.getAccountName() + " 登录");
		
		logger.info(("IP :" + getIpAddress(request)));
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
	
	public String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	
}

package pers.yjw.platform.demo.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * CustomLogoutHandler
 *
 * @author yjw
 * @date 2019-11-18
 * @time 16:18
 * @desc
 */
@Slf4j
public class CustomLogoutHandler implements LogoutHandler {
	private String targetUrl;
	
	public CustomLogoutHandler(String targetUrl) {
		this.targetUrl = targetUrl;
		
	}
	
	@Override
	public void logout(HttpServletRequest request,
					   HttpServletResponse response, Authentication authentication) {
		try {
			log.info("CustomLogoutSuccessHandler.logout() is called!");
			response.sendRedirect(targetUrl);
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
	
}

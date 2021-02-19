package pers.yjw.platform.demo.aspect;

import cn.tongdun.hunter.exception.AbstractException;
import cn.tongdun.hunter.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import pers.yjw.platform.demo.vo.RespVo;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.web
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-20 15:41
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerValidatorAdvice {
	@ExceptionHandler(value = Exception.class)
	public RespVo exceptionHandle(Exception e) {
		log.error("enter into ControllerValidatorAdvice exceptionHandle......");
		e.printStackTrace();
		RespVo respVo = new RespVo().fail();
		if (e instanceof AbstractException || e instanceof AccessDeniedException || e instanceof CommonException
				|| e instanceof MissingServletRequestPartException || e instanceof UsernameNotFoundException) {
			respVo.setMsg(e.getMessage());
		} else if (e instanceof MultipartException) {
			respVo.setMsg("文件无效！");
		} else {
			respVo.setMsg("未知异常，请联系管理员");
		}
		log.error("调用接口发生异常：", e);
		return respVo;
	}
}

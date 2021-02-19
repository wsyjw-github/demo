package pers.yjw.platform.demo.client.exception;

import cn.tongdun.hunter.code.JordanErrorCodeEnum;
import cn.tongdun.hunter.exception.AbstractException;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.exception
 * @description:统一异常
 * @author: YaoJianwei
 * @create: 2019-09-10 16:39
 */
public class DemoException extends AbstractException {
	public DemoException() {
		super();
	}
	
	public DemoException(String message) {
		super(message);
	}
	
	public DemoException(String message, Throwable e) {
		super(message, e);
	}
	
	public DemoException(String message, int code) {
		super(message);
		this.code = code;
	}
	
	public DemoException(String message, int code, Throwable e) {
		super(message, e);
		this.code = code;
	}
	
	public DemoException(JordanErrorCodeEnum errorCode) {
		super(errorCode.getMessage(), errorCode.getCode());
	}
	
	public DemoException(JordanErrorCodeEnum errorCode, Throwable e) {
		super(errorCode.getMessage(), errorCode.getCode(), e);
	}
}

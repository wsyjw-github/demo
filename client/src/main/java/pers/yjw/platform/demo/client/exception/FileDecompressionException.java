package pers.yjw.platform.demo.client.exception;

import cn.tongdun.hunter.code.JordanErrorCodeEnum;
import cn.tongdun.hunter.exception.AbstractException;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.exception
 * @description:文件解压异常类
 * @author: YaoJianwei
 * @create: 2019-09-10 16:39
 */
public class FileDecompressionException extends AbstractException {
	private static final long serialVersionUID = -7666629322978454538L;
	
	public FileDecompressionException(JordanErrorCodeEnum errorCode) {
		super(errorCode.getMessage(), errorCode.getCode());
	}
}

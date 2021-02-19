package pers.yjw.platform.demo.client.context;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.context
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 16:39
 */
@Data
public class DemoContext implements Serializable {
	/**
	 * ip地址
	 */
	private String ip;
	/**
	 * 操作者
	 */
	private String operator;
	/**
	 * 合作方CODE
	 */
	private String partnerCode;
	/**
	 * 操作时间
	 */
	private Date date = new Date();
}

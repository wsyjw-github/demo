package pers.yjw.platform.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.dto
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 17:36
 */
@Data
public class BaseInfo implements Serializable {
	private Long id;
	/**
	 * 逻辑删除标记：0-正常，1-删除
	 */
	private Integer isDelete;
	/**
	 * 删除时间戳
	 */
	private Long delTimestamp;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtCreate;
	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date gmtModify;
	
}

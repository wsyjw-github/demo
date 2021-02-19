package pers.yjw.platform.demo.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.dto
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 16:21
 */
@Data
@NoArgsConstructor
public class UserInfo extends Model {
	private Long id;
	
	/**
	 * 创建者
	 */
	private String createBy;
	
	/**
	 * 修改者
	 */
	private String updateBy;
	
	/**
	 * 账户
	 */
	private String accountName;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 角色
	 */
	private String role;
	
	/**
	 * 用户状态 UserStatusEnum
	 */
	private Integer status;
	
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

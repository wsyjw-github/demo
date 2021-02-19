package pers.yjw.platform.demo.client.enumeration;


import lombok.Getter;

import java.util.Objects;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.enumeration
 * @description:用户状态枚举
 * @author: YaoJianwei
 * @create: 2019-09-10 16:55
 */
@Getter
public enum UserStatusEnum {
	INACTIVE(0, "禁用"),
	ACTIVE(1, "正常");
	
	private Integer code;
	private String name;
	
	UserStatusEnum(Integer code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static String getNameByCode(Integer code) {
		if (code == null) return null;
		String name = null;
		for (UserStatusEnum statusEnum : UserStatusEnum.values()) {
			if (Objects.equals(statusEnum.getCode(), code)) {
				name = statusEnum.getName();
				break;
			}
		}
		return name;
	}
	
}

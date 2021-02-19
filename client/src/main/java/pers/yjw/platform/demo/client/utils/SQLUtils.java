package pers.yjw.platform.demo.client.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.utils
 * @description:防止sql注入
 * @author: YaoJianwei
 * @create: 2019-09-10 16:39
 */
public class SQLUtils {
	/**
	 * SQL注入拦截
	 *
	 * @param str 待验证的字符串
	 * @return
	 */
	public static String sqlInject(String str) {
		if (StringUtils.isBlank(str)) {
			return null;
		}
		//去掉'|"|;|\字符
		str = StringUtils.replace(str, "'", "");
		str = StringUtils.replace(str, "\"", "");
		str = StringUtils.replace(str, ";", "");
		str = StringUtils.replace(str, "\\", "");
		
		//转换成小写
		str = str.toLowerCase();
		
		//非法字符
		String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alert", "drop"};
		//判断是否包含非法字符
		for (String keyword : keywords) {
			if (StringUtils.indexOf(str, keyword) != -1) {
				throw new RuntimeException("包含非法字符");
			}
		}
		return str;
	}
}

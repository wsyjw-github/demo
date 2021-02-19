package pers.yjw.platform.demo;


import pers.yjw.platform.demo.util.PropertyUtil;

import java.util.Properties;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName com.example.demo
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-09 14:34
 */
public class PropertyTest {
	public static void main(String... args) {
		String path = "/application-test.properties";
		Properties properties = PropertyUtil.getConfig(path);
		System.out.println(properties.getProperty("c.version"));
	}
	
}


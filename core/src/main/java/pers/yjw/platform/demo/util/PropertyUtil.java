package pers.yjw.platform.demo.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.util
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:11
 */
public class PropertyUtil {
	public static Properties getConfig(String path) {
		Properties props = null;
		try {
			props = new Properties();
			InputStream in = PropertyUtil.class.getResourceAsStream(path);
			BufferedReader bf = new BufferedReader(new InputStreamReader(in));
			props.load(bf);
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return props;
	}
}

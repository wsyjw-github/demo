package pers.yjw.platform.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pers.yjw.platform.demo.util.PropertyUtil;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.conf
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:10
 */
@Configuration
public class PropertyConfig {
	private String path = "/application-test.properties";
	
	@Bean
	public Properties properties() {
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

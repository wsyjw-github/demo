package pers.yjw.platform.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo
 * @description:
 * @author: YaoJianwei
 * @create: 2019-09-10 15:08
 */
@MapperScan(basePackages = {"pers.yjw.platform.demo.dao"})
@SpringBootApplication(exclude = {TransactionAutoConfiguration.class})
@ImportResource(locations = {"classpath:spring/spring-context.xml"})
//@PropertySource(value = "classpath:application-dev.properties", ignoreResourceNotFound = true)
public class AppMain extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AppMain.class);
	}
}

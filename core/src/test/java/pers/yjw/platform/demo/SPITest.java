package pers.yjw.platform.demo;

import pers.yjw.platform.demo.client.service.SPIService;
import sun.misc.Service;

import java.io.IOException;
import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * SPITest
 *
 * @author yjw
 * @date 2020-03-20
 * @time 15:48
 * @desc SPI ，全称为 Service Provider Interface，是一种服务发现机制
 */
public class SPITest {
	private static final String PREFIX = "META-INF/services/";
	public static void main(String[] args) throws IOException {
		Iterator<SPIService> providers = Service.providers(SPIService.class);
		ServiceLoader<SPIService> load = ServiceLoader.load(SPIService.class);
		
		while(providers.hasNext()) {
			SPIService ser = providers.next();
			ser.execute();
		}
		System.out.println("--------------------------------");
		Iterator<SPIService> iterator = load.iterator();
		while(iterator.hasNext()) {
			SPIService ser = iterator.next();
			ser.execute();
		}
	}
}

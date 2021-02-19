package pers.yjw.platform.demo.service;

import pers.yjw.platform.demo.client.service.SPIService;

/**
 * SpiImpl1
 *
 * @author yjw
 * @date 2020-03-20
 * @time 15:46
 * @desc
 */
public class SpiImpl1 implements SPIService {
	public void execute() {
		System.out.println("SpiImpl1.execute()");
	}
}

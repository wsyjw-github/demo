package pers.yjw.platform.demo;

import java.math.BigDecimal;
import java.util.Objects;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * BigDecimalTest
 *
 * @author yjw
 * @date 2019-10-17
 * @time 16:02
 * @desc
 */
public class BigDecimalTest {
	public static void main (String... args) {
		BigDecimal percent = new BigDecimal(100);
		BigDecimal b0 = new BigDecimal("150");
		BigDecimal b1 = new BigDecimal("140");
		BigDecimal b2 = new BigDecimal("2200");
		BigDecimal b3 = percent.multiply(b0.divide(b2, 4, BigDecimal.ROUND_HALF_UP));
		BigDecimal b4 = percent.multiply(b1).divide(b2, 2, BigDecimal.ROUND_HALF_UP);
		System.out.println(b3);
		System.out.println(b4);
		
		BigDecimal bdTest = new BigDecimal(1.745);
		BigDecimal bdTest1 = new BigDecimal(0.745);
		bdTest = bdTest.setScale(2, BigDecimal.ROUND_HALF_UP);
		bdTest1 = bdTest1.setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println("bdTest:" + bdTest); // 1.75
		System.out.println("bdTest1:" + bdTest1); // 0.74
		
		BigDecimal c1 = new BigDecimal(100.25);
		BigDecimal c2 = new BigDecimal(100.25);
		System.out.println(c1.compareTo(c2));
		
		BigDecimal ewn = new BigDecimal(2);
		BigDecimal wn = new BigDecimal(0);
		BigDecimal cer = null;
		if (!Objects.equals(new BigDecimal(0), wn)) {
			cer = percent.multiply(ewn).divide(wn, 2, ROUND_HALF_UP);
		}
		System.out.println("cer:" + cer);
	}
}

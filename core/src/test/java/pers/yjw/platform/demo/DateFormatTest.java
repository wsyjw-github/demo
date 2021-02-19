package pers.yjw.platform.demo;

import pers.yjw.platform.demo.util.DateUtil;

/**
 * DateFormatTest
 *
 * @author yjw
 * @date 2019-11-12
 * @time 14:29
 * @desc
 */
public class DateFormatTest {
	public static void main (String... args) {
		String audioPreProcessJobLastRunDateStr = "2019-09-04";
		audioPreProcessJobLastRunDateStr = DateUtil.getSpecifiedDayOffset(audioPreProcessJobLastRunDateStr, 1);
		System.out.println(audioPreProcessJobLastRunDateStr);
	}
}

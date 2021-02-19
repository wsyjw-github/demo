package pers.yjw.platform.demo;

import pers.yjw.platform.demo.util.DateUtil;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * DateTimeFormatterTest
 *
 * @author yjw
 * @date 2019-11-08
 * @time 16:49
 * @desc
 */
public class DateTimeFormatterTest {
	private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_FORMAT);
	private static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(DateUtil.DATE_FORMAT);
	
	public static void main(String... args) {
		Date date = new Date();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		Instant instant = date.toInstant();
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		System.out.println(localDateTime.format(dtf));
		System.out.println("****************************");
		
		String startTime = "2019-11-01";
		String endTIme = "2020-10-31";
		LocalDate beginDateTime = LocalDate.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		LocalDate endDateTime = LocalDate.parse(endTIme, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Integer dateBetween = Period.between(beginDateTime, endDateTime).getDays();
		Long span = ChronoUnit.DAYS.between(beginDateTime, endDateTime);
		System.out.println(dateBetween);//1
		System.out.println(span);//367
		System.out.println("****************************");
//
//		System.out.println(DateUtil.getCurrentDayMinTimeToStr());
//		System.out.println(DateUtil.getCurrentDayMaxTimeToStr());
//		System.out.println(DateUtil.getCurrentDateTimeToStr());
//		System.out.println(DateUtil.getCurrentDayToStr());
//		System.out.println(DateUtil.getCurrentDayAddDayToStr(1));
//		System.out.println(DateUtil.getSpecifiedDayAddDayToStr("2019-11-25", 2));
//		System.out.println("****************************");
//
//		LocalDate ldt = LocalDate.parse("2019-11-22", dtf2);
//		System.out.println(ldt);
//
//
//		System.out.println(DateUtil.getSpecifiedDayMinTimeToStr("2019-10-31"));
//		System.out.println(DateUtil.getSpecifiedDayMaxTimeToStr("2019-10-31"));
//
//
//		System.out.println(DateUtil.getSpecifiedDayToStr(new Date()));
//
//
		System.out.println(DateUtil.getSpecifiedDateToStr(new Date(), DateUtil.DATE_TIME_FORMAT));
	}
}

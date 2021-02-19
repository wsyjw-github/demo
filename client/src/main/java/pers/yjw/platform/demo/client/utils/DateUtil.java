package pers.yjw.platform.demo.client.utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @projectName demo
 * @version: 1.0
 * @packageName pers.yjw.platform.demo.client.utils
 * @description:日期工具
 * @author: YaoJianwei
 * @create: 2019-09-10 16:39
 */
public class DateUtil {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final Integer DATE_TO_TIME_TYPE_START = 1;      // 日期字符串转时间字符串类型，开始日期
	public static final Integer DATE_TO_TIME_TYPE_END = 2;      // 日期字符串转时间字符串类型，结束日期
	
	
	/**
	 * 获取当前日期
	 *
	 * @return
	 */
	public static String getCurrentDateStr() {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		dateStr = sdf.format(new Date());
		return dateStr;
	}
	
	/**
	 * 获取当前日期时间
	 *
	 * @return
	 */
	public static String getCurrentDateTimeStr() {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
		dateStr = sdf.format(new Date());
		return dateStr;
	}
	
	
	/**
	 * 日期转换成字符串
	 *
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String dateToStr(Date date, String dateFormat) {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		dateStr = sdf.format(date);
		return dateStr;
	}
	
	/**
	 * 字符串转换成日期
	 *
	 * @param dateStr
	 * @param dateFormat
	 * @return
	 */
	public static Date strToDate(String dateStr, String dateFormat) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * 日期字符串转时间字符串
	 *
	 * @param dateStr 日期字符串
	 * @param type    类型，1：开始日期，2：结束日期
	 * @return 时间字符串
	 */
	public static String dateStrToTimeStr(String dateStr, Integer type) {
		String timeStr = null;
		if (null != type && type.equals(DATE_TO_TIME_TYPE_END)) {
			// 结束日期
			if (StringUtils.isNotBlank(dateStr) && !dateStr.contains(" ")) {
				timeStr = dateStr + " 23:59:59";
			}
		} else {
			// 开始日期
			if (StringUtils.isNotBlank(dateStr) && !dateStr.contains(" ")) {
				timeStr = dateStr + " 00:00:00";
			}
		}
		return timeStr;
	}
	
	/**
	 * 获取当前日期相对天数的日期，比如7天后的日期，
	 *
	 * @param amount 相对天数
	 * @return 最后的日期
	 */
	public static Date getRelativeDaysDate(int amount) {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, amount);
		return c.getTime();
	}
	
	/**
	 * 日期转换成字符串
	 *
	 * @param date
	 * @param dateFormat
	 * @return
	 */
	public static String timestampToStr(Timestamp date, String dateFormat) {
		String dateStr = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		dateStr = sdf.format(date);
		return dateStr;
	}
}

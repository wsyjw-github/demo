package pers.yjw.platform.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 * @program: AI数据标注
 * @description: 日期工具类
 * @author: Jianjun.Ding
 * @create: 2018/12/13
 **/
@Slf4j
public class DateUtil {

    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_TWO = "yyyyMMdd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final Integer DATE_TO_TIME_TYPE_START = 1;      // 日期字符串转时间字符串类型，开始日期
    public static final Integer DATE_TO_TIME_TYPE_END = 2;      // 日期字符串转时间字符串类型，结束日期
    
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(DATE_FORMAT);


    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取当前日期时间
     *
     * @return
     */
    public static String getCurrentDateTimeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(new Date());
    }

    /**
     * 获取指定时间字符串
     * @param date 时间
     * @return 时间字符串
     */
    public static String getDateTimeStr(Date date){
        return new SimpleDateFormat(DATE_TIME_FORMAT).format(date);
    }


    /**
     * 日期转换成字符串
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String dateToStr(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
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
     * @param type    类型，1(DATE_TO_TIME_TYPE_START)：开始日期，2(DATE_TO_TIME_TYPE_END)：结束日期
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
     * 一天的开始或结束日期
     * @param date 日期
     * @param type 类型，1(DATE_TO_TIME_TYPE_START)：开始日期，2(DATE_TO_TIME_TYPE_END)：结束日期
     * @return 开始或结束日期
     */
    public static Date startOrEndDateOfOneDay(Date date, Integer type) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (null != type && type.equals(DATE_TO_TIME_TYPE_END)) {
            // 结束日期
            calendar.set(Calendar.HOUR_OF_DAY, 23);
            calendar.set(Calendar.MINUTE, 59);
            calendar.set(Calendar.SECOND, 59);
        } else {
            // 开始日期
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
        }

        return calendar.getTime();
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
     * 处理截止日期
     * 如当天3.12号为deadline，入库时间应该为3.13号0点或者3月12号23:59:59
     *
     * @param deadLine 截止日期
     * @return 时间
     */
    public static Date handleDeadLine(Date deadLine) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(deadLine);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    /**
     * 获取日期年份
     *
     * @param date 日期
     * @return 返回年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 功能描述：返回月
     *
     * @param date Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日期
     *
     * @param date Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }

    /**
     * 获得指定日期的相隔指定天数的日期
     *
     * @param specifiedDay 指定日期，形如：2019-02-23
     * @param offset       相隔指定的天数，大于0则为之后日期，小于0则为之前日期
     * @return 指定日期的相隔指定天数的日期
     */
    public static String getSpecifiedDayOffset(String specifiedDay, int offset) {
        Calendar c = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat(DATE_FORMAT).parse(specifiedDay);
            c.setTime(date);
            int day = c.get(Calendar.DATE);
            c.set(Calendar.DATE, day + offset);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new SimpleDateFormat(DATE_FORMAT).format(c.getTime());
    }
    
    /**
     * 当天的开始时间转成字符串（格式：2019-11-10 00:00:00）
     * @return
     */
    public static String getCurrentDayMinTimeToStr() {
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        //设置零点
        LocalDateTime beginTime = LocalDateTime.of(nowDate, LocalTime.MIN);
        return beginTime.format(dtf);
    }
    
    /**
     * 当天的截止时间转成字符串（格式：2019-11-10 23:59:59）
     * @return
     */
    public static String getCurrentDayMaxTimeToStr() {
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        //设置当天的结束时间
        LocalDateTime endTime = LocalDateTime.of(nowDate, LocalTime.MAX);
        //将时间进行格式化
        return dtf.format(endTime);
    }
    
    /**
     * 当前时间格式化成字符串 (格式：2019-11-10 10:00:00)
     * @return
     */
    public static String getCurrentDateTimeToStr() {
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
    
    /**
     * 当天的开始时间转成字符串（格式：2019-11-10）
     * @return
     */
    public static String getCurrentDayToStr() {
        LocalDate nowDate = LocalDate.now();
        return nowDate.format(dtf2);
    }
    
    
    /**
     * 当天日期向前或向后推移指定天数，日期转成字符串
     * @param daysToAdd 相隔指定的天数，大于0则为之后日期，小于0则为之前日期
     * @return 字符串（格式：2019-11-10）
     */
    public static String getCurrentDayAddDayToStr(int daysToAdd) {
        //获取当前日期
        LocalDate nowDate = LocalDate.now();
        LocalDate ld = nowDate.plusDays(daysToAdd);
        return ld.format(dtf2);
    }
    
    /**
     * 将指定日期相隔指定天数的日期转成字符串
     * @param dtStr 指定日期字符串
     * @param daysToAdd 相隔指定的天数，大于0则为之后日期，小于0则为之前日期
     * @return 字符串（格式：2019-11-10）
     */
    public static String getSpecifiedDayAddDayToStr(String dtStr,int daysToAdd) {
        String result = null;
        try {
            LocalDate ldt = LocalDate.parse(dtStr, dtf2);
            LocalDate ldt2 = ldt.plusDays(daysToAdd);
            result = ldt2.format(dtf2);
        } catch (DateTimeParseException ex) {
            log.error("method->getSpecifiedDayAddDayToStr {} could not be parsed with {}", dtStr, DATE_FORMAT);
        }
        
        return result;
    }
    
    /**
     * 指定时间转成字符串
     * @param date 指定时间
     * @return
     */
    public static String getSpecifiedDayToStr(Date date) {
        LocalDate localDate = toLocalDate(date);
        //将时间进行格式化
        return dtf2.format(localDate);
    }
    
    private static LocalDate toLocalDate(Date date){
        LocalDate localDate;
        if (null == date){
            localDate = LocalDate.now();
        } else {
            Instant instant = date.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            localDate = localDateTime.toLocalDate();
        }
        return localDate;
    }
    
    
    /**
     * 指定时间转成字符串
     *
     * @param date 指定时间
     * @param pattern 指定时间格式
     * @return
     */
    public static String getSpecifiedDateToStr(Date date, String pattern) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return DateTimeFormatter.ofPattern(pattern).format(localDateTime);
    }
    
    /**
     * 指定时间转成字符串（格式：2019-11-10 00:00:00）
     *
     * @param dtStr 指定时间字符串
     * @return
     */
    public static String getSpecifiedDayMinTimeToStr(String dtStr) {
        LocalDate nowDate = LocalDate.parse(dtStr, dtf2);
        LocalDateTime beginTime = LocalDateTime.of(nowDate, LocalTime.MIN);
        return dtf.format(beginTime);
    }
    
    /**
     * 指定时间转成字符串（格式：2019-11-10 23:59:59）
     *
     * @param dtStr 指定时间字符串
     * @return
     */
    public static String getSpecifiedDayMaxTimeToStr(String dtStr) {
        LocalDate nowDate = LocalDate.parse(dtStr, dtf2);
        LocalDateTime endTime = LocalDateTime.of(nowDate, LocalTime.MAX);
        return dtf.format(endTime);
    }
    
    public static void main(String... args) {
    
    }
}

package com.dsy.dadui.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期工具类
 *
 * @author <a href="mailto:taojiagui@loonxi.com">云启</a>
 * @version 1.0 2016年12月19日
 * @since 1.0
 */
public class DateUtil {

	// The sdf cache
	private static Map<String, SimpleDateFormat> sdfCache = new Hashtable<String, SimpleDateFormat>();

	// The Constant ONE_DAY
	public static final long ONE_DAY = 24 * 60 * 60 * 1000;

	// The Constant LOG
	private static Logger logger = LoggerFactory.getLogger(DateUtil.class);

	private static DateUtil instance = new DateUtil();

	public final static int WEEK_FIRST_DAY_TYPE_MONDAY = Calendar.MONDAY;
	public final static int WEEK_FIRST_DAY_TYPE_SUNDAY = Calendar.SUNDAY;

	private int weekFirstDayType = WEEK_FIRST_DAY_TYPE_MONDAY;

	/**
	 * 设置每周头一天为周几
	 * 
	 * @param weekFirstDayType
	 * @return DateUtil 对象
	 */
	public DateUtil setWeekFirstDayType(int weekFirstDayType) {
		this.weekFirstDayType = weekFirstDayType;
		return this;
	}

	/**
	 * 实例化DateUtil
	 * 
	 * @return DateUtil对象
	 */
	public static DateUtil getInstance() {
		synchronized (DateUtil.class) {
			if (null == instance) {
				instance = new DateUtil();
			}
		}

		return instance;
	}

	/**
	 * 
	 * @param year
	 *            年
	 * @param month(1-12)
	 *            月
	 * @param week
	 *            第几周
	 * @return 某年某月某周的所有日期
	 */
	public Date[] getDaysOfWeek(final int year, final int month, final int week) {
		Date[] dates = null;

		if (week >= 1 && week <= getMonthWeeks(year, month)) {
			final Date firstDayOfMonth = parse(year + "/" + (month) + "/01", "yyyy/MM/dd");

			final Date lastDayOfMonth = parse(year + "/" + (month) + "/" + getMonthDays(year)[month - 1], "yyyy/MM/dd");

			final Date fistDay = add(getFirstDayOfWeek(firstDayOfMonth), Calendar.DATE, 7 * (week - 1));

			List<Date> weekDayList = new ArrayList<Date>();
			for (int i = 0; i < 7; i++) {
				final Date day = add(fistDay, Calendar.DATE, i);
				if (!(day.before(firstDayOfMonth) || day.after(lastDayOfMonth))) {
					weekDayList.add(day);
				}
			}
			dates = weekDayList.toArray(new Date[weekDayList.size()]);
		}

		return dates;
	}

	/**
	 * 返回某一个月中的周数
	 * 
	 * @param year
	 *            月
	 * @param month
	 *            (1-12) 月
	 * @return 某月有多周
	 */
	public int getMonthWeeks(final int year, final int month) {
		int cnt = 0;
		final Calendar lstc = Calendar.getInstance();
		lstc.setTime(parse(year + "/" + (month) + "/" + getMonthDays(year)[month - 1], "yyyy/MM/dd"));
		lstc.setFirstDayOfWeek(weekFirstDayType);
		cnt = lstc.get(Calendar.WEEK_OF_MONTH);

		return cnt;
	}

	/**
	 * 获得某一周头一天的日期
	 * 
	 * @param date
	 *            日期
	 * @return 某周的第一天
	 */
	public Date getFirstDayOfWeek(final Date date) {
		final GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.setFirstDayOfWeek(weekFirstDayType);
		gc.set(Calendar.DAY_OF_WEEK, weekFirstDayType);
		return gc.getTime();
	}

	/**
	 * 根据年份获取该年二月份天数
	 * 
	 * @param year
	 *            年
	 * @return 某年二月的天数
	 */
	private static int[] getMonthDays(final int year) {
		int[] daye = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
			daye[1] = 29;
		} else {
			daye[1] = 28;
		}
		return daye;
	}

	/**
	 * Constructs a SimpleDateFormat using the given pattern and the default
	 * date format symbols for the given locale
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            the pattern describing the date and time format
	 * @param locale
	 *            the locale whose date format symbols should be used
	 * @return
	 */
	public static String format(final Date date, final String pattern, final Locale locale) {
		String resultDate = null;
		if (null != date && null != pattern && null != locale) {
			final SimpleDateFormat sdf = new SimpleDateFormat(pattern, locale);
			synchronized (sdf) {
				resultDate = sdf.format(date);
			}
		}
		return resultDate;
	}

	/**
	 * 将string转化为date类型
	 * 
	 * @param date
	 *            Input String to convert
	 * @param pattern
	 *            pattern
	 * @return Date
	 */
	public static Date parse(final String date, final String pattern) {
		Date resultDate = null;
		if (null != date && null != pattern) {
			try {
				final SimpleDateFormat sdf = getSimpleDateFormat(pattern);
				synchronized (sdf) {
					resultDate = sdf.parse(date);
				}
			} catch (ParseException e) {
				logger.error(e.toString());
			}
		}
		return resultDate;
	}

	/**
	 * 检验date类型是否正确
	 * 
	 * @param date
	 *            Input String to check
	 * @param pattern
	 *            pattern
	 * @return If check correct, return true; otherwise, return false flag:
	 *         false-not right date format true-right date format
	 */
	public static boolean checkIsDate(final String date, final String pattern) {
		boolean flag = false;
		if (null == date || "".equals(date) || null == pattern || "".equals(pattern)) {
			flag = false;
		} else {
			final SimpleDateFormat sdf = getSimpleDateFormat(pattern);
			try {
				synchronized (sdf) {
					final Date tempDate = sdf.parse(date);
					final String tempStr = sdf.format(tempDate);
					if (tempStr.equalsIgnoreCase(date)) {
						flag = true;
					}
				}
			} catch (ParseException e) {
				logger.error("Error parsing '" + date + "' using pattern '" + pattern + "'");
			}
		}
		return flag;
	}

	/**
	 * 将Date类型转化为string
	 * 
	 * @param date
	 *            Input date to convert
	 * @param pattern
	 *            pattern
	 * @return String
	 */
	public static String format(final Date date, final String pattern) {
		return null == date || null == pattern ? "" : getSimpleDateFormat(pattern).format(date);
	}

	/**
	 * Convert date to String.
	 * 
	 * @param date
	 *            Input date to convert
	 * @return String
	 */
	public static String formatDOB(final Date date) {
		return format(date, "dd/MM/yyyy");
	}

	/**
	 * Convert date to String.
	 *
	 * @param date
	 *            Input date to convert
	 * @return String
	 */
	public static String formatDOB2(final Date date) {
		return format(date, "yyyy-MM-dd");
	}

	/**
	 * 获得当前日期
	 * 
	 * @return Returns the today
	 */
	public static Date getToday() {
		final Date date = new Date();
		final String s = format(date, "dd/MM/yyyy");
		return parse(s, "dd/MM/yyyy");
	}

	/**
	 * Constructs a SimpleDateFormat using the given pattern and the default
	 * date format symbols for the default locale.
	 * 
	 * @param pattern
	 *            pattern
	 * @return SimpleDateFormat
	 */
	private static SimpleDateFormat getSimpleDateFormat(final String pattern) {
		SimpleDateFormat sdf = (SimpleDateFormat) sdfCache.get(pattern);
		if (null == sdf) {
			sdf = new SimpleDateFormat();
			sdf.applyPattern(pattern);
			sdf.setLenient(false);
			sdfCache.put(pattern, sdf);
		}
		return sdf;
	}

	/**
	 * Start Modification For BCP By Angelo on 21 Nov 2007 Date Comparasion
	 * Method.
	 * 
	 * @param aDate
	 *            the a date
	 * @param curDate
	 *            the cur date
	 * @param bDate
	 *            the b date
	 * @return If the method is correct, return true; otherwise, return false
	 */
	public static boolean compareDate(final Date aDate, final Date curDate, final Date bDate) {
		boolean result = false;
		if (null == aDate || null == curDate || null == bDate) {
			result = false;
		} else {
			result = (curDate.after(aDate) || curDate.equals(aDate)) && curDate.before(bDate);
		}
		return result;
	}

	/**
	 * 比较日期方法
	 * 
	 * @param aDateStr
	 *            the a date str
	 * @param bDateStr
	 *            the b date str
	 * @param pattern
	 *            the pattern
	 * @return boolean If the method is correct, return true; otherwise, return
	 *         false
	 */
	public static boolean compareDate(final String aDateStr, final String bDateStr, final String pattern) {
		final Date aDate = parse(aDateStr, pattern);
		final Date bDate = parse(bDateStr, pattern);
		boolean result = false;
		if ((null != aDate && null != bDate) && (aDate.before(bDate) || aDate.equals(bDate))) {
			result = true;
		}
		return result;
	}

	/**
	 * 计算日期
	 * 
	 * @param inputDate
	 *            the input date
	 * @param field
	 *            the field
	 * @param amount
	 *            the amount
	 * @return Date
	 */
	public static Date add(final Date inputDate, final int field, final int amount) {
		Date resultDate = null;
		if (null != inputDate) {
			final Calendar cal = Calendar.getInstance();
			cal.setTime(inputDate);
			cal.add(field, amount);
			resultDate = cal.getTime();
		}
		return resultDate;
	}

	/**
	 * Adds the day of year.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param amount
	 *            the amount
	 * @return the date
	 */
	public static Date addDayOfYear(final Date inputDate, final int amount) {
		return add(inputDate, Calendar.DAY_OF_YEAR, amount);
	}

	/**
	 * Adds the date.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param amount
	 *            the amount
	 * @return the date
	 */
	public static Date addDate(final Date inputDate, final int amount) {
		return add(inputDate, Calendar.DATE, amount);
	}

	/**
	 * Adds the month.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param amount
	 *            the amount
	 * @return the date
	 */
	public static Date addMonth(final Date inputDate, final int amount) {
		return add(inputDate, Calendar.MONTH, amount);
	}

	/**
	 * Adds the year.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param amount
	 *            the amount
	 * @return the date
	 */
	public static Date addYear(final Date inputDate, final int amount) {
		return add(inputDate, Calendar.YEAR, amount);
	}

	/**
	 * Convert to sql date.
	 * 
	 * @param date
	 *            the date
	 * @return the java.sql. date
	 */
	public static java.sql.Date convertToSQLDate(final Date date) {
		return null == date ? null : new java.sql.Date(date.getTime());
	}

	/**
	 * Convert to sql timestamp.
	 * 
	 * @param date
	 *            the date
	 * @return the timestamp
	 */
	public static Timestamp convertToSQLTimestamp(final Date date) {
		return null == date ? null : new Timestamp(date.getTime());
	}

	/**
	 * Method to truncte the input date's time to 00:00:00.
	 * 
	 * @param inputDate
	 *            the input date
	 * @return the date
	 */
	public static Date truncateTime(final Date inputDate) {
		return truncateTime(inputDate, Calendar.getInstance());
	}

	/**
	 * Method to truncte the input date's time to 00:00:00.
	 * 
	 * @param inputDate
	 *            the input date
	 * @param calendar
	 *            the calendar
	 * @return the date
	 */
	public static Date truncateTime(final Date inputDate, final Calendar calendar) {
		Date date = null;

		if (null != inputDate && null != calendar) {
			calendar.setTime(inputDate);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			date = calendar.getTime();
		}
		return date;

	}

	/**
	 * 获得某年的头一天日期
	 * 
	 * @param date
	 *            the date
	 * @return Date
	 */
	public static Date getFirstDayOfYear(final Date date) {
		Date firstDayOfYear = null;
		if (null != date) {
			final GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
			gc.setTime(date);
			gc.set(Calendar.DAY_OF_MONTH, 1);
			gc.set(Calendar.MONTH, 0);
			firstDayOfYear = truncateTime(gc.getTime());
		}
		return firstDayOfYear;
	}

	/**
	 * 获得某月头一天的日期
	 * 
	 * @param date
	 *            the date
	 * @return Date
	 */
	public static Date getFirstDayOfMonth(final Date date) {
		final GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return gc.getTime();
	}

	/**
	 * 获得某月最后一天的日期
	 * 
	 * @param date
	 *            the date
	 * @return Date
	 */
	public static Date getLastDayOfMonth(final Date date) {
		Date resultDate = null;
		if (null != date) {
			Date day = getFirstDayOfMonth(date);
			day = addMonth(day, 1);
			day = addDate(day, -1);
			resultDate = day;
		}
		return resultDate;
	}

	/**
	 * 获得当前日期
	 * 
	 * @return the now date
	 * @returnDate
	 */
	public static Date getNowDate() {
		return new Date();
	}

	/**
	 * 获得当前日期
	 * 
	 * @return
	 */
	public static Timestamp getNowTimestamp() {
		return new Timestamp(getNowDate().getTime());
	}

	/**
	 * Compare date.
	 * 
	 * @param firstDate
	 *            the first date
	 * @param secondDate
	 *            the second date
	 * @return true, if successful
	 */
	public static boolean compareDate(final Date firstDate, final Date secondDate) {
		boolean result = false;
		if (null == firstDate || null == secondDate) {
			result = false;
		} else {
			final Calendar firstCalendar = Calendar.getInstance();
			firstCalendar.setTime(firstDate);
			firstCalendar.set(Calendar.DAY_OF_MONTH, firstCalendar.get(Calendar.DAY_OF_MONTH) - 1);
			final Calendar secondCalendar = Calendar.getInstance();
			secondCalendar.setTime(secondDate);
			result = firstCalendar.after(secondCalendar);
		}
		return result;
	}

	/**
	 * Compare sql date.
	 * 
	 * @param firstDate
	 *            the first date
	 * @param secondDate
	 *            the second date
	 * @return the int
	 */
	public static int compareSQLDate(final Date firstDate, final Date secondDate) {
		int result = 0;
		if (null == firstDate) {
			if (null == secondDate) {
				result = 0;
			} else {
				result = 1;
			}
		} else {
			if (null == secondDate) {
				result = -1;
			} else {
				result = firstDate.compareTo(secondDate);
			}
		}
		return result;
	}

	/**
	 * 计算距今 yearFromNow 的年份
	 * 
	 * @param yearFromNow
	 *            时间（天）
	 * @return
	 */
	public static String getCalendarYear(final int yearFromNow) {
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, yearFromNow);
		return String.valueOf(calendar.get(Calendar.YEAR));
	}

	/**
	 * 计算两个日期之前的的时间差（秒）
	 * 
	 * @param fromDate
	 *            the from date
	 * @param toDate
	 *            the to date
	 * @return the int
	 */
	public static int dateDiff(final Date fromDate, final Date toDate) {
		int result = 0;
		if (null != fromDate && null != toDate) {
			result = (int) ((toDate.getTime() - fromDate.getTime()) / (24 * 60 * 60 * 1000));
		}
		return result;
	}

	/**
	 * 计算两个日期之前的时间差（天数）
	 * 
	 * @param fromDate
	 *            起始日期
	 * @param toDate
	 *            结束日期
	 * @return 天数
	 */
	public static int msDiff(final Date fromDate, final Date toDate) {
		int result = 0;
		if (null != fromDate && null != toDate) {
			result = (int) (toDate.getTime() - fromDate.getTime());
		}
		return result;
	}

	/**
	 * 计算两个字符串日期相差的天数
	 * 
	 * @param smdate
	 * @param bdate
	 * @return
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate, String bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

}

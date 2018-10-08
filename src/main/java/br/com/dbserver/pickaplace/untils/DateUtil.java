package br.com.dbserver.pickaplace.untils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static final String BRAZILIAN_FORMAT_DATE = "dd/MM/yyyy";
	public static final String BRAZILIAN_FORMAT_COMPLETE = "dd/MM/yyyy hh:mm:ss";
	public static final String HOURS_SHORT_FORMAT = "hh:mm";
	public static final String USA_FORMAT = "yyyy-MM-dd hh:mm:ss";
	public static final String TIME_OF_PROCESSING_OF_VOTES = "11:30";

	public static Integer getWeekOfMonth(Date date) {
		Integer weekOfMonthReturn = null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		weekOfMonthReturn = calendar.get(Calendar.WEEK_OF_MONTH);

		return weekOfMonthReturn;
	}

	public static Integer getMonth(Date date) {
		Integer weekMonthReturn = null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		weekMonthReturn = calendar.get(Calendar.MONTH) + 1;

		return weekMonthReturn;
	}

	public static Integer getYear(Date date) {
		Integer weekMonthReturn = null;

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		weekMonthReturn = calendar.get(Calendar.YEAR);

		return weekMonthReturn;
	}

	public static String brazilianFormatDate(Date date) {
		String formatedDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(BRAZILIAN_FORMAT_DATE);

		formatedDate = simpleDateFormat.format(date);

		return formatedDate;
	}

	public static String hoursFormatDate(Date date) {
		String formatedDate = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(HOURS_SHORT_FORMAT);

		formatedDate = simpleDateFormat.format(date);

		return formatedDate;
	}

	public static Boolean isAfterHours(Date date) {
		Boolean isAfterHours = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH':'mm':'ss");
		String hourCheck = simpleDateFormat.format(date);
		
		String hourStart = "08:00:00";
		String hourEnd = "11:25:00";
		
		if ((hourCheck.compareTo(hourStart) >= 0) && (hourCheck.compareTo(hourEnd) <= 0)) {
			isAfterHours = true;
		}
		return isAfterHours;
	}
}

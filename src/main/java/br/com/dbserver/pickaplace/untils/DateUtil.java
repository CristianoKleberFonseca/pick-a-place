package br.com.dbserver.pickaplace.untils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
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
		weekMonthReturn = calendar.get(Calendar.MONTH)+1;
				
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
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		formatedDate = simpleDateFormat.format(date);
		
		return formatedDate;
	}
	
	public static void main(String[] args) {
		System.out.println(String.format("Processing of day %s no realized so far.", DateUtil.brazilianFormatDate(new Date())));
	}

}

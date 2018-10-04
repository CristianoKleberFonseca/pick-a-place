package br.com.dbserver.pickaplace.untils;

import java.util.Calendar;

public class DataBaseUntil {
	
	public static Long generateID() {
		Calendar calendar = null;
		try {
			Thread.sleep(5);
			calendar = Calendar.getInstance();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return calendar.getTimeInMillis();
	}

}

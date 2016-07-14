package org.elsys;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Holidays {
	private String holidayStart;
	private String holidayEnd;
	
	
	public Holidays(String holidayStart, String holidayEnd) {
		this.holidayEnd = holidayEnd;
		this.holidayStart = holidayStart;
	}
	
	public String getHolidayStart() {
		return holidayStart;
	}

	public String getHolidayEnd() {
		return holidayEnd;
	}
	
	public int getDays() {
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		DateTime endDate = DateTime.parse(holidayEnd, dtf); 
		DateTime startDate = DateTime.parse(holidayStart, dtf);
		
		return Days.daysBetween(startDate, endDate).getDays();
	}
	
	
	
}

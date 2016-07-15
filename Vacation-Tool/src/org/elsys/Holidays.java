package org.elsys;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Holidays {
	private Date holidayStart;
	private Date holidayEnd;
	
	public String getDuration() {
		return holidayStart.toString() + " " + holidayEnd.toString();
	}
	
	public Holidays(Date holidayStart, Date holidayEnd) {
		this.holidayEnd = holidayEnd;
		this.holidayStart = holidayStart;
	}
	
	public Date getHolidayStart() {
		return holidayStart;
	}

	public Date getHolidayEnd() {
		return holidayEnd;
	}
	
	public int getDays() {	
		DateTime startDate = new DateTime(holidayStart);
		DateTime endDate = new DateTime(holidayEnd);
		
		return Days.daysBetween(startDate, endDate).getDays() + 1;
	}
	
	
	
}

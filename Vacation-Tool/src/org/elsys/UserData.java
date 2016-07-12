package org.elsys;

import java.util.Random;

public class UserData {
	private Integer remainingHolidays = new Random().nextInt(40 - 10 + 1) + 10;
	
	private String username;
	
	
	public String getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String holidayDate) {
		this.holidayDate = holidayDate;
	}

	public Integer getRemainingHolidays() {
		return remainingHolidays;
	}
	private String holidayDate;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}

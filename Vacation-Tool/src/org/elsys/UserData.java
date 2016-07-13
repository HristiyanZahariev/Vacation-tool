package org.elsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserData {
	private Integer remainingHolidays = new Random().nextInt(40 - 10 + 1) + 10;
	
	private String username;
	
	private List<Holidays> managedHolidays = new ArrayList<Holidays>();
	

	public List<Holidays> getManagedHolidays() {
		return managedHolidays;
	}

	public void setManagedHolidays(List<Holidays> managedHolidays) {
		this.managedHolidays = managedHolidays;
	}

	public Integer getRemainingHolidays() {
		return remainingHolidays;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void addHoliday(Holidays holiday) {
		managedHolidays.add(holiday);
	}

}

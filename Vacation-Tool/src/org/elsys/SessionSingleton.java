package org.elsys;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="holidays")
@RequestScoped
public class SessionSingleton {
	
	private static SessionSingleton instance = null;
	
	private List<String> holidayDate = new ArrayList<String>();
	
	Random holidayPicker = new Random();
	private Integer remainingHolidays = holidayPicker.nextInt(40 - 10 + 1) + 10;
	
	private String username;
	
	private SessionSingleton() {
		
	}
	
	public List<String> getHolidayDate() {
		return holidayDate;
	}

	public void setHolidayDate(String date) {
		if(!holidayDate.contains(date)) {
			holidayDate.add(0, date);
		}
	}
	
	public Integer getRemainingHolidays() {
		return remainingHolidays;
	}

	
	public static SessionSingleton getInstance() {
		if(instance == null) {
			instance = new SessionSingleton();
		}
		return instance;		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}

package org.elsys;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="holidays")
@RequestScoped
public class SessionSingleton {
	
	private static SessionSingleton instance = null;
	
	private String holidayDate;
	
	Random holidayPicker = new Random();
	private Integer remainingHolidays = holidayPicker.nextInt(40 - 10 + 1) + 10;
	
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

	private SessionSingleton() {
		
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

package org.elsys;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;
=======
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
>>>>>>> 40a36b2706ad189fd94aa8e66f7df40e85ea099a


public class SessionSingleton {
	
	private static SessionSingleton instance = null;
	private Map<String,UserData> dataList = new HashMap<String,UserData>();
	
<<<<<<< HEAD
	private SessionSingleton() {
		
	}
=======
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

>>>>>>> 40a36b2706ad189fd94aa8e66f7df40e85ea099a
	
	public UserData getUserData(String username) {
		return  dataList.get(username);
		
	}
	
	public static SessionSingleton getInstance() {
		if(instance == null) {
			instance = new SessionSingleton();
		}
		return instance;		
	}

	
	
	
}

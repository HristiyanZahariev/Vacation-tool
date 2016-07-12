package org.elsys;

import java.util.HashMap;
import java.util.Map;


public class SessionSingleton {
	
	private static SessionSingleton instance = null;
	private Map<String,UserData> dataList = new HashMap<String,UserData>();
	
	private SessionSingleton() {
		
	}
	
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

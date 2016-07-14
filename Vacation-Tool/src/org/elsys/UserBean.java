package org.elsys;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	private String username;
	private String password;
	private String name;
	private String email;
	private UserData userData = null;
	
	public void changeText() {
		System.out.println("Submitted username: " + username);
		System.out.println("Submitted password: " + password);
		System.out.println("Submitted email: " + email);
		
		userData = SessionSingleton.getInstance().getUserData(username);
		if(userData == null) {
			userData = new UserData();
			userData.setUsername(username);
			SessionSingleton.getInstance().addUserData(userData);
		}
	}
	
	public void registerUser() {
		if(SessionSingleton.getInstance().getUserData(username) == null) {
			userData = new UserData();
			userData.setUsername(username);
			SessionSingleton.getInstance().addUserData(userData);			
		} else {
			System.out.println("User with that name already exists");
			
		}
		
	}
	
	public void addHoliday(String start, String end) {
		Holidays tmp = new Holidays();
		tmp.addHoliday(start, end);
		
		UserData data = SessionSingleton.getInstance().getUserData(username);
		data.addHoliday(tmp);
	}

	public String getUsername() {
		return username;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}
	
	public List<Holidays> getManagedHolidays() {
		return userData.getManagedHolidays();
	}
	
	public int getRemainingHolidays() {
		return userData.getRemainingHolidays();
	}
	
	public String getUserDataUsername() {
		return userData.getUsername();
	}
	

}
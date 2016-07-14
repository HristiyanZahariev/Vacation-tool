package org.elsys;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

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
		
		boolean loggedIn = false;
		RequestContext context = RequestContext.getCurrentInstance();
		
		userData = SessionSingleton.getInstance().getUserData(username);
		if(userData == null) {
			System.out.println("No user with that name. Please register.");	
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "No user with that name is registered.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} else {
			loggedIn = true;
		}
		
		context.addCallbackParam("registered", loggedIn);
	}
	
	public void registerUser(ActionEvent event) {
		boolean registered = false;
		RequestContext context = RequestContext.getCurrentInstance();
		
		if(SessionSingleton.getInstance().getUserData(username) == null) {
			UserData tmpData = new UserData();
			tmpData.setUsername(username);
			SessionSingleton.getInstance().addUserData(tmpData);
			registered = true;
		} else {
			System.out.println("User with that name already exists");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Register Error", "User with that name already exists.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		context.addCallbackParam("registered", registered);
		
	}
	
	public void addHoliday(String start, String end) {
		Holidays tmp = new Holidays(start, end);
		
		userData.addHoliday(tmp);
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
	
	

}
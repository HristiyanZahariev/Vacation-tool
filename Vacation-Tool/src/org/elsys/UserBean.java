package org.elsys;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	private String username;
	private String password;
	private String name;
	private String email;
	
	public void changeText() {
		System.out.println("Submitted username: " + username);
		System.out.println("Submitted password: " + password);
		System.out.println("WTF: " + email);
		UserData userData = SessionSingleton.getInstance().getUserData(username);
		if(userData == null) {
			userData = new UserData();
			//TODO set username
			//SessionSingleton.getInstance().addUserData(userData);
		}
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
	
	public List<Holidays> getManagedHolidays {
		
		
	}

}
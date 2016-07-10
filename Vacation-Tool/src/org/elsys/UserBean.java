package org.elsys;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="userBean")
@RequestScoped
public class UserBean {

	private String username;
	private String password;
	
	public void changeText() {
		System.out.println("Submitted username: " + username);
		System.out.println("Submitted password: " + password);
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String pass) {
		this.password = pass;
	}

}
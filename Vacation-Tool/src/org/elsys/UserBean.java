package org.elsys;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.joda.time.DateTime;
import org.primefaces.context.RequestContext;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean {

	private String username;
	private String password;
	private String name;
	private String email;
	private UserData userData = null;
	private Date start;
	private Date end;
	
	public Date getStart() {
		return start;
	}
	
	public void logout() throws IOException {
	    ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
	    ec.invalidateSession();
	    ec.redirect(ec.getRequestContextPath() + "/login.xhtml");
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public void loginUser() {
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
			System.out.println("User " + userData.getUsername() + " logged in");
		}
		
		context.addCallbackParam("registered", loggedIn);
	}
	
	public Object renderIndex() {
	    loginUser();
	    return "/index.xhtml";
	}
	
	public Object renderLogin() {
	    registerUser();
	    return "/login.xhtml";
	}
	

	public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "PrimeFaces Rocks."));
    }
	
	public void registerUser() {
		boolean registered = false;
		RequestContext context = RequestContext.getCurrentInstance();
		
		if(SessionSingleton.getInstance().getUserData(username) == null) {
			UserData tmpData = new UserData();
			tmpData.setUsername(username);
			SessionSingleton.getInstance().addUserData(tmpData);
			registered = true;
			System.out.println("registered user: " + username);
		} else {
			System.out.println("User with that name already exists");
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Register Error", "User with that name already exists.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		context.addCallbackParam("registered", registered);
		
	}
	
	public void addHoliday() {
		Holidays tmp = new Holidays(start, end);
		
		System.out.println(tmp.getDays());
		if(tmp.getDays() <= userData.getRemainingHolidays() && start.before(end)) {
			userData.addHoliday(tmp);
			userData.deductRemainingHolidays(tmp.getDays());
		} else if(tmp.getDays() > userData.getRemainingHolidays() || start.after(end)) {
			System.out.println("shit");
		}
	}

	public List<Holidays> getManagedHolidays() {
		return userData.getManagedHolidays();
	}
	
	public String getRemainingHolidays() {
		return userData.getRemainingHolidays().toString();
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

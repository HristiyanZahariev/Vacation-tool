package org.elsys;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class Controller {

	private String testValue;
	
	public void changeText() {
		System.out.println("Submitted value: " + testValue);
	}

	public String getTestValue() {
		return testValue;
	}

	public void setTestValue(String testValue) {
		this.testValue = testValue;
	}

}

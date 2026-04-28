package com.springmvc.dto;

public class pwChange {
	private String currentPw;
	private String newPw;
	private String newPwCheck;
	public String getCurrentPw() {
		return currentPw;
	}
	public void setCurrentPw(String currentPw) {
		this.currentPw = currentPw;
	}
	public String getNewPw() {
		return newPw;
	}
	public void setNewPw(String newPw) {
		this.newPw = newPw;
	}
	public String getNewPwCheck() {
		return newPwCheck;
	}
	public void setNewPwCheck(String newPwCheck) {
		this.newPwCheck = newPwCheck;
	}
	public pwChange(String currentPw, String newPw, String newPwCheck) {
		super();
		this.currentPw = currentPw;
		this.newPw = newPw;
		this.newPwCheck = newPwCheck;
	}
	
}

package com.springmvc.dto;

public class LoginDTO {
	private String Id;
	private String pw;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public LoginDTO(String id, String pw) {
		super();
		Id = id;
		this.pw = pw;
	}
	
}

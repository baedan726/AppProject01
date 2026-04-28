package com.springmvc.dto;

public class findPwDTO {
	private String Id;
	private String email;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public findPwDTO(String id, String email) {
		super();
		Id = id;
		this.email = email;
	}
	
}

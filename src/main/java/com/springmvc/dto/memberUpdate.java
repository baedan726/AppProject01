package com.springmvc.dto;

public class memberUpdate {
	private String nickname;
    private String email;
    private String phone;
    private String profileImage;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public memberUpdate(String nickname, String email, String phone, String profileImage) {
		super();
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.profileImage = profileImage;
	}
    
}

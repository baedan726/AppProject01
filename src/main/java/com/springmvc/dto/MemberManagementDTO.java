package com.springmvc.dto;

public class MemberManagementDTO {
	private Long memberId;
    private String loginId;
    private String name;
    private String nickname;
    private String email;
    private String phone;
    private String role;
    private String status;
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public MemberManagementDTO(Long memberId, String loginId, String name, String nickname, String email, String phone,
			String role, String status) {
		super();
		this.memberId = memberId;
		this.loginId = loginId;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.status = status;
	}
	public MemberManagementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}

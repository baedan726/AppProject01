package com.springmvc.dto;

public class InquiryDTO {
	private Long inquiryId;
    private Long memberId;
    private String title;
    private String content;
    private String answer;
    private String status;
	public Long getInquiryId() {
		return inquiryId;
	}
	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public InquiryDTO(Long inquiryId, Long memberId, String title, String content, String answer, String status) {
		super();
		this.inquiryId = inquiryId;
		this.memberId = memberId;
		this.title = title;
		this.content = content;
		this.answer = answer;
		this.status = status;
	}
    
}

package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 문의 작성/수정 폼 (사용자)
 * ※ INQUIRY 테이블에 첨부 컬럼이 없으므로 첨부 기능은 제외됨
 */
public class InquiryForm {

    private Long inquiryId;

    @NotBlank(message = "제목을 입력해 주세요.")
    @Size(max = 100, message = "제목은 100자 이하로 입력해 주세요.")
    private String title;

    @NotBlank(message = "문의 내용을 입력해 주세요.")
    @Size(min = 5, max = 2000, message = "5자 이상 2000자 이하로 입력해 주세요.")
    private String content;

    public InquiryForm() {}

    public Long getInquiryId() { return inquiryId; }
    public void setInquiryId(Long inquiryId) { this.inquiryId = inquiryId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
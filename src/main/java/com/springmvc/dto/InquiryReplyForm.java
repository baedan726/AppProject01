package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * 관리자 답변 폼 (inquiryManagement에서 사용)
 *  - INSERT INTO INQUIRY_REPLY + UPDATE INQUIRY SET status='ANSWERED' (트랜잭션)
 */
public class InquiryReplyForm {

    @NotNull(message = "답변할 문의를 선택해 주세요.")
    private Long inquiryId;

    @NotBlank(message = "답변 내용을 입력해 주세요.")
    private String content;

    public InquiryReplyForm() {}

    public Long getInquiryId() { return inquiryId; }
    public void setInquiryId(Long inquiryId) { this.inquiryId = inquiryId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * INQUIRY 테이블 매핑
 * [컬럼] inquiry_id, member_id, title, content,
 *        status('WAITING'|'ANSWERED'), created_at
 */
public class Inquiry {

    private Long inquiryId;
    private Long memberId;
    private String title;
    private String content;
    private String status;
    private LocalDateTime createdAt;

    /* JOIN 표시용 */
    private String memberName;

    /* 답변 (있을 경우 1개) */
    private InquiryReply reply;

    public Inquiry() {}

    public Long getInquiryId() { return inquiryId; }
    public void setInquiryId(Long inquiryId) { this.inquiryId = inquiryId; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public InquiryReply getReply() { return reply; }
    public void setReply(InquiryReply reply) { this.reply = reply; }
}
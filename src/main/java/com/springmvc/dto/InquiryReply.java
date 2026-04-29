package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * INQUIRY_REPLY 테이블 매핑
 * [컬럼] reply_id, inquiry_id, admin_id, content, created_at
 */
public class InquiryReply {

    private Long replyId;
    private Long inquiryId;
    private Long adminId;
    private String content;
    private LocalDateTime createdAt;

    /* JOIN 표시용 */
    private String adminName;

    public InquiryReply() {}

    public Long getReplyId() { return replyId; }
    public void setReplyId(Long replyId) { this.replyId = replyId; }

    public Long getInquiryId() { return inquiryId; }
    public void setInquiryId(Long inquiryId) { this.inquiryId = inquiryId; }

    public Long getAdminId() { return adminId; }
    public void setAdminId(Long adminId) { this.adminId = adminId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
}
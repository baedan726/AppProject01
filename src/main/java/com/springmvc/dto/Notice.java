package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * NOTICE 테이블 매핑
 * [컬럼] notice_id, admin_id, title, content, created_at
 */
public class Notice {

    private Long noticeId;
    private Long adminId;
    private String title;
    private String content;
    private LocalDateTime createdAt;

    /* JOIN 표시용 */
    private String adminName;

    public Notice() {}

    public Long getNoticeId() { return noticeId; }
    public void setNoticeId(Long noticeId) { this.noticeId = noticeId; }

    public Long getAdminId() { return adminId; }
    public void setAdminId(Long adminId) { this.adminId = adminId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getAdminName() { return adminName; }
    public void setAdminName(String adminName) { this.adminName = adminName; }
}
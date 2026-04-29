package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * COMPLAINT 테이블 매핑 (리뷰 신고)
 * [컬럼] complaint_id, review_id, reporter_id, reason,
 *        status('WAITING'|'ACCEPTED'|'REJECTED'), created_at
 */
public class Complaint {

    private Long complaintId;
    private Long reviewId;
    private Long reporterId;
    private String reason;
    private String status;
    private LocalDateTime createdAt;

    /* JOIN 표시용 */
    private String reporterName;
    private String reviewContent;
    private String reviewWriterName;

    public Complaint() {}

    public Long getComplaintId() { return complaintId; }
    public void setComplaintId(Long complaintId) { this.complaintId = complaintId; }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getReporterId() { return reporterId; }
    public void setReporterId(Long reporterId) { this.reporterId = reporterId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public String getReporterName() { return reporterName; }
    public void setReporterName(String reporterName) { this.reporterName = reporterName; }

    public String getReviewContent() { return reviewContent; }
    public void setReviewContent(String reviewContent) { this.reviewContent = reviewContent; }

    public String getReviewWriterName() { return reviewWriterName; }
    public void setReviewWriterName(String reviewWriterName) { this.reviewWriterName = reviewWriterName; }
}
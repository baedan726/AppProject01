package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/**
 * 신고 처리 폼 (관리자용 - 화면 30)
 *  - UPDATE COMPLAINT SET status=? WHERE complaint_id=?
 *  - 승인(ACCEPTED) + blindReview=true → UPDATE REVIEW SET status='HIDDEN'
 */
public class ComplaintForm {

    @NotNull
    private Long complaintId;

    @NotBlank
    @Pattern(regexp = "WAITING|ACCEPTED|REJECTED",
             message = "처리 상태는 WAITING/ACCEPTED/REJECTED 중 하나여야 합니다.")
    private String status;

    /** 승인 시 해당 리뷰를 HIDDEN으로 함께 변경 (체크박스) */
    private boolean blindReview;

    public ComplaintForm() {}

    public Long getComplaintId() { return complaintId; }
    public void setComplaintId(Long complaintId) { this.complaintId = complaintId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isBlindReview() { return blindReview; }
    public void setBlindReview(boolean blindReview) { this.blindReview = blindReview; }
}
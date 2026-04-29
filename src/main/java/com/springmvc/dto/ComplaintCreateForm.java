package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 사용자가 리뷰 신고할 때 사용하는 폼
 *  - 화면 9 (리뷰 상세)에서 신고 버튼 클릭 시
 *  - INSERT INTO COMPLAINT (review_id, reporter_id, reason, status='WAITING')
 */
public class ComplaintCreateForm {

    @NotNull(message = "신고할 리뷰가 지정되지 않았습니다.")
    private Long reviewId;

    @NotBlank(message = "신고 사유를 입력해 주세요.")
    @Size(min = 5, max = 500, message = "5자 이상 500자 이하로 입력해 주세요.")
    private String reason;

    public ComplaintCreateForm() {}

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }
}
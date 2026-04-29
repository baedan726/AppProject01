package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * REVIEW_LIKE 테이블 매핑 — UNIQUE(review_id, member_id)
 */
public class ReviewLike {

    private Long reviewLikeId;
    private Long reviewId;
    private Long memberId;
    private LocalDateTime createdAt;

    public ReviewLike() {}

    public Long getReviewLikeId() { return reviewLikeId; }
    public void setReviewLikeId(Long reviewLikeId) { this.reviewLikeId = reviewLikeId; }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
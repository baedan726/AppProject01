package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * REVIEW_IMAGE 테이블 매핑
 * [컬럼] image_id, review_id, image_url, created_at
 */
public class ReviewImage {

    private Long imageId;
    private Long reviewId;
    private String imageUrl;
    private LocalDateTime createdAt;

    public ReviewImage() {}

    public Long getImageId() { return imageId; }
    public void setImageId(Long imageId) { this.imageId = imageId; }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
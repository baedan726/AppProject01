package com.springmvc.dto;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REVIEW 테이블 매핑 + 화면 표시용 JOIN/집계 필드
 *
 * [REVIEW 테이블 컬럼]
 *   review_id      BIGINT PK
 *   member_id      BIGINT FK → MEMBER
 *   restaurant_id  BIGINT FK → RESTAURANT
 *   rating         INT
 *   content        TEXT
 *   image          VARCHAR(255)
 *   status         ENUM('VISIBLE','HIDDEN')
 *   created_at     DATETIME
 *   updated_at     DATETIME
 */
public class Review {

    /* ===== REVIEW 테이블 컬럼 1:1 ===== */
    private Long reviewId;
    private Long memberId;
    private Long restaurantId;
    private Integer rating;
    private String content;
    private String image;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* ===== JOIN 표시용 (DB 컬럼 아님) ===== */
    private String memberName;
    private String restaurantName;

    /* ===== 집계 (LEFT JOIN + COUNT) ===== */
    private Long likeCount;
    private Long commentCount;

    /* ===== 연관 (별도 SELECT) ===== */
    private List<ReviewImage> imageList;
    private List<ReviewComment> commentList;

    public Review() {}

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }

    public String getRestaurantName() { return restaurantName; }
    public void setRestaurantName(String restaurantName) { this.restaurantName = restaurantName; }

    public Long getLikeCount() { return likeCount; }
    public void setLikeCount(Long likeCount) { this.likeCount = likeCount; }

    public Long getCommentCount() { return commentCount; }
    public void setCommentCount(Long commentCount) { this.commentCount = commentCount; }

    public List<ReviewImage> getImageList() { return imageList; }
    public void setImageList(List<ReviewImage> imageList) { this.imageList = imageList; }

    public List<ReviewComment> getCommentList() { return commentList; }
    public void setCommentList(List<ReviewComment> commentList) { this.commentList = commentList; }
}
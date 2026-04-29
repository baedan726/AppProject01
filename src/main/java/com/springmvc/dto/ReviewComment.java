package com.springmvc.dto;

import java.time.LocalDateTime;

/**
 * REVIEW_COMMENT 테이블 매핑
 * [컬럼] comment_id, review_id, member_id, content,
 *        status('ACTIVE'|'DELETED'), created_at, updated_at
 */
public class ReviewComment {

    private Long commentId;
    private Long reviewId;
    private Long memberId;
    private String content;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    /* JOIN 표시용 */
    private String memberName;

    public ReviewComment() {}

    public Long getCommentId() { return commentId; }
    public void setCommentId(Long commentId) { this.commentId = commentId; }

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public String getMemberName() { return memberName; }
    public void setMemberName(String memberName) { this.memberName = memberName; }
}
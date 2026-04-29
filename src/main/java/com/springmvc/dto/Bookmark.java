package com.springmvc.dto;

import java.time.LocalDateTime;

public class Bookmark {
    private Long bookmarkId;
    private Long memberId;
    private Long restaurantId;
    private LocalDateTime createdAt;
	public Bookmark() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bookmark(Long bookmarkId, Long memberId, Long restaurantId, LocalDateTime createdAt) {
		super();
		this.bookmarkId = bookmarkId;
		this.memberId = memberId;
		this.restaurantId = restaurantId;
		this.createdAt = createdAt;
	}
	public Long getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(Long bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}


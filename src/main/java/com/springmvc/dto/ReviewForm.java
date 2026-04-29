package com.springmvc.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * 리뷰 작성/수정 폼
 *  - reviewId == null → 등록 (INSERT INTO REVIEW)
 *  - reviewId != null → 수정 (UPDATE REVIEW)
 */
public class ReviewForm {

    private Long reviewId;

    @NotNull(message = "맛집을 선택해 주세요.")
    private Long restaurantId;

    @NotNull(message = "별점을 선택해 주세요.")
    @Min(value = 1, message = "별점은 1점 이상이어야 합니다.")
    @Max(value = 5, message = "별점은 5점 이하여야 합니다.")
    private Integer rating;

    @NotBlank(message = "리뷰 내용을 입력해 주세요.")
    @Size(min = 10, max = 2000, message = "리뷰는 10자 이상 2000자 이하로 작성해 주세요.")
    private String content;

    private List<MultipartFile> images;
    private List<Long> deleteImageIds;

    public ReviewForm() {}

    public Long getReviewId() { return reviewId; }
    public void setReviewId(Long reviewId) { this.reviewId = reviewId; }

    public Long getRestaurantId() { return restaurantId; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public List<MultipartFile> getImages() { return images; }
    public void setImages(List<MultipartFile> images) { this.images = images; }

    public List<Long> getDeleteImageIds() { return deleteImageIds; }
    public void setDeleteImageIds(List<Long> deleteImageIds) { this.deleteImageIds = deleteImageIds; }
}
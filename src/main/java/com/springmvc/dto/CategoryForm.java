package com.springmvc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * 카테고리 등록/수정 폼 (CATEGORY 테이블)
 * SQL 스키마: category_id, category_name 두 컬럼만 존재
 */
public class CategoryForm {

    private Long categoryId;

    @NotBlank(message = "카테고리 이름을 입력해 주세요.")
    @Size(max = 50, message = "카테고리 이름은 50자 이하로 입력해 주세요.")
    private String categoryName;

    public CategoryForm() {}

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
}
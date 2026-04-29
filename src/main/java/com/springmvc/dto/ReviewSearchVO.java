package com.springmvc.dto;

/**
 * 리뷰 목록 검색/필터/정렬/페이징 VO
 *  - URL: /review/list?keyword=&sort=&category=&rating=&page=
 *  - 컨트롤러에서 @ModelAttribute ReviewSearchVO search
 */
public class ReviewSearchVO {

    private String keyword;
    private String sort = "latest";   // latest | rating | popular
    private Long category;
    private Integer rating;            // 3, 4, 5
    private Boolean hasPhoto;
    private Boolean hasComment;
    private Long memberId;             // 내 리뷰 관리에서 사용

    private int page = 1;
    private int size = 12;

    public ReviewSearchVO() {}

    /** SQL LIMIT 시작 위치 */
    public int getOffset() {
        return (page - 1) * size;
    }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public String getSort() { return sort; }
    public void setSort(String sort) { this.sort = sort; }

    public Long getCategory() { return category; }
    public void setCategory(Long category) { this.category = category; }

    public Integer getRating() { return rating; }
    public void setRating(Integer rating) { this.rating = rating; }

    public Boolean getHasPhoto() { return hasPhoto; }
    public void setHasPhoto(Boolean hasPhoto) { this.hasPhoto = hasPhoto; }

    public Boolean getHasComment() { return hasComment; }
    public void setHasComment(Boolean hasComment) { this.hasComment = hasComment; }

    public Long getMemberId() { return memberId; }
    public void setMemberId(Long memberId) { this.memberId = memberId; }

    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }

    public int getSize() { return size; }
    public void setSize(int size) { this.size = size; }
}
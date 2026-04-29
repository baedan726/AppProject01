package com.springmvc.dto;

import java.util.List;
import java.util.Map;

/**
 * 관리자 대시보드 KPI/차트 통합 DTO (화면 28)
 * 단일 테이블 매핑이 아니라 여러 SELECT COUNT/GROUP BY 결과를 묶어서 전달
 */
public class DashboardStatsDTO {

    /* ===== KPI 카드 ===== */
    private long totalMembers;
    private long todayNewMembers;
    private long totalReviews;
    private long totalRestaurants;
    private long pendingComplaints;
    private long pendingInquiries;

    /* ===== 차트 데이터 ===== */
    private List<Map<String, Object>> memberSignupChart;
    private List<Map<String, Object>> reviewChart;
    private List<Map<String, Object>> categoryDistribution;
    private List<Map<String, Object>> ratingDistribution;

    public DashboardStatsDTO() {}

    public long getTotalMembers() { return totalMembers; }
    public void setTotalMembers(long totalMembers) { this.totalMembers = totalMembers; }

    public long getTodayNewMembers() { return todayNewMembers; }
    public void setTodayNewMembers(long todayNewMembers) { this.todayNewMembers = todayNewMembers; }

    public long getTotalReviews() { return totalReviews; }
    public void setTotalReviews(long totalReviews) { this.totalReviews = totalReviews; }

    public long getTotalRestaurants() { return totalRestaurants; }
    public void setTotalRestaurants(long totalRestaurants) { this.totalRestaurants = totalRestaurants; }

    public long getPendingComplaints() { return pendingComplaints; }
    public void setPendingComplaints(long pendingComplaints) { this.pendingComplaints = pendingComplaints; }

    public long getPendingInquiries() { return pendingInquiries; }
    public void setPendingInquiries(long pendingInquiries) { this.pendingInquiries = pendingInquiries; }

    public List<Map<String, Object>> getMemberSignupChart() { return memberSignupChart; }
    public void setMemberSignupChart(List<Map<String, Object>> memberSignupChart) { this.memberSignupChart = memberSignupChart; }

    public List<Map<String, Object>> getReviewChart() { return reviewChart; }
    public void setReviewChart(List<Map<String, Object>> reviewChart) { this.reviewChart = reviewChart; }

    public List<Map<String, Object>> getCategoryDistribution() { return categoryDistribution; }
    public void setCategoryDistribution(List<Map<String, Object>> categoryDistribution) { this.categoryDistribution = categoryDistribution; }

    public List<Map<String, Object>> getRatingDistribution() { return ratingDistribution; }
    public void setRatingDistribution(List<Map<String, Object>> ratingDistribution) { this.ratingDistribution = ratingDistribution; }
}
package com.springmvc.dto;

public class RestaurantDTO {
    private Long restaurantId;
    private String name;
    private String categoryName;
    private Double rating;
    private String imageUrl;
    private Double distance;
	public RestaurantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDTO(Long restaurantId, String name, String categoryName, Double rating, String imageUrl,
			Double distance) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.categoryName = categoryName;
		this.rating = rating;
		this.imageUrl = imageUrl;
		this.distance = distance;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Double getDistance() {
		return distance;
	}
	public void setDistance(Double distance) {
		this.distance = distance;
	}
    
}

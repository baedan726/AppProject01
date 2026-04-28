package com.springmvc.dto;

public class preferenceDTO {
	private Long preferenceId;
    private Long memberId;
    private String favoriteCategory;
    private String spicyLevel;
    private String pricePreference;
    private String situationPreference;
    private String moodPreference;
	public Long getPreferenceId() {
		return preferenceId;
	}
	public void setPreferenceId(Long preferenceId) {
		this.preferenceId = preferenceId;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getFavoriteCategory() {
		return favoriteCategory;
	}
	public void setFavoriteCategory(String favoriteCategory) {
		this.favoriteCategory = favoriteCategory;
	}
	public String getSpicyLevel() {
		return spicyLevel;
	}
	public void setSpicyLevel(String spicyLevel) {
		this.spicyLevel = spicyLevel;
	}
	public String getPricePreference() {
		return pricePreference;
	}
	public void setPricePreference(String pricePreference) {
		this.pricePreference = pricePreference;
	}
	public String getSituationPreference() {
		return situationPreference;
	}
	public void setSituationPreference(String situationPreference) {
		this.situationPreference = situationPreference;
	}
	public String getMoodPreference() {
		return moodPreference;
	}
	public void setMoodPreference(String moodPreference) {
		this.moodPreference = moodPreference;
	}
	public preferenceDTO(Long preferenceId, Long memberId, String favoriteCategory, String spicyLevel,
			String pricePreference, String situationPreference, String moodPreference) {
		super();
		this.preferenceId = preferenceId;
		this.memberId = memberId;
		this.favoriteCategory = favoriteCategory;
		this.spicyLevel = spicyLevel;
		this.pricePreference = pricePreference;
		this.situationPreference = situationPreference;
		this.moodPreference = moodPreference;
	}
    
}

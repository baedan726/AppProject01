package com.springmvc.repository;

import java.util.List;

import com.springmvc.dto.RestaurantMapDTO;
import com.springmvc.dto.Restaurant;
import com.springmvc.dto.RestaurantDTO;

public interface RestaurantRepository {

    // 맛집 리스트 페이지
    List<RestaurantDTO> getRestaurantList();

    // 맛집 상세 페이지
    Restaurant getRestaurantById(Long restaurantId);

    // 지도 전체보기 페이지
    List<RestaurantMapDTO> getRestaurantMapList();

    // 맛집 관리 - 등록
    void insertRestaurant(Restaurant restaurant);

    // 맛집 관리 - 수정
    void updateRestaurant(Restaurant restaurant);

    // 맛집 관리 - 삭제
    void deleteRestaurant(Long restaurantId);
}
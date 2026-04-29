package com.springmvc.service;

import java.util.List;

import com.springmvc.dto.Restaurant;
import com.springmvc.dto.RestaurantDTO;
import com.springmvc.dto.RestaurantMapDTO;

public interface RestaurantService {

    List<RestaurantDTO> getRestaurantList();

    Restaurant getRestaurantById(Long restaurantId);

    List<RestaurantMapDTO> getRestaurantMapList();

    void insertRestaurant(Restaurant restaurant);

    void updateRestaurant(Restaurant restaurant);

    void deleteRestaurant(Long restaurantId);
}
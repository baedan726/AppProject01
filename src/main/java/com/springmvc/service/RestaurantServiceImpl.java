package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dto.Restaurant;
import com.springmvc.dto.RestaurantDTO;
import com.springmvc.dto.RestaurantMapDTO;
import com.springmvc.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDTO> getRestaurantList() {
        return restaurantRepository.getRestaurantList();
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.getRestaurantById(restaurantId);
    }

    @Override
    public List<RestaurantMapDTO> getRestaurantMapList() {
        return restaurantRepository.getRestaurantMapList();
    }

    @Override
    public void insertRestaurant(Restaurant restaurant) {
        restaurantRepository.insertRestaurant(restaurant);
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
        restaurantRepository.updateRestaurant(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.deleteRestaurant(restaurantId);
    }
}
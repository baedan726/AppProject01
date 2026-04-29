package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springmvc.dto.Restaurant;
import com.springmvc.dto.RestaurantDTO;
import com.springmvc.dto.RestaurantMapDTO;
import com.springmvc.service.RestaurantService;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // 맛집 리스트 페이지
    @GetMapping("/restaurants")
    public String restaurantList(Model model) {
        List<RestaurantDTO> restaurantList = restaurantService.getRestaurantList();

        model.addAttribute("restaurantList", restaurantList);

        return "restaurant/list";
    }

    // 맛집 상세 페이지
    @GetMapping("/restaurants/{restaurantId}")
    public String restaurantDetail(@PathVariable("restaurantId") Long restaurantId, Model model) {
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);

        model.addAttribute("restaurant", restaurant);

        return "restaurant/detail";
    }

    // 지도 전체보기 페이지
    @GetMapping("/restaurants/map")
    public String restaurantMap(Model model) {
        List<RestaurantMapDTO> mapList = restaurantService.getRestaurantMapList();

        model.addAttribute("mapList", mapList);

        return "restaurant/map";
    }
}
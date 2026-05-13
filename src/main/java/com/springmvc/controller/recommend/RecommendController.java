package com.springmvc.controller.recommend;

import java.util.ArrayList;
import java.util.List;

// import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dto.recommend.RecommendHistory;
import com.springmvc.dto.restaurant.RestaurantDTO;
import com.springmvc.service.kakao.KakaoLocalService;
import com.springmvc.service.recommend.RecommendService;
import com.springmvc.service.restaurant.RestaurantService;

@Controller
public class RecommendController {

	@Autowired
	private RecommendService recommendService;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private KakaoLocalService kakaoLocalService;

	// 추천 페이지
	@GetMapping("/recommend")
	public String recommend() {
		return "recommend/recommend";
	}

	// 추천 결과 페이지
	@GetMapping("/recommend/result")
	public String recommendResult(@RequestParam("selectedFood") String selectedFood,
			@RequestParam(value = "lat", required = false) Double lat,
			@RequestParam(value = "lng", required = false) Double lng, Model model) {

		List<RestaurantDTO> nearRestaurantList;

		if (lat != null && lng != null) {

			nearRestaurantList = restaurantService.getNearRestaurants(selectedFood, lat, lng, 3);

			if (nearRestaurantList == null || nearRestaurantList.isEmpty()) {
				kakaoLocalService.importRestaurants(selectedFood);

				nearRestaurantList = restaurantService.getNearRestaurants(selectedFood, lat, lng, 3);
			}

		} else {

			nearRestaurantList = restaurantService.searchRestaurantList(null, selectedFood, 0, 3);

			if (nearRestaurantList == null || nearRestaurantList.isEmpty()) {
				kakaoLocalService.importRestaurants(selectedFood);

				nearRestaurantList = restaurantService.searchRestaurantList(null, selectedFood, 0, 3);
			}
		}

		if (nearRestaurantList == null) {
			nearRestaurantList = new ArrayList<>();
		}

		// 추천 기록 저장
		if (!nearRestaurantList.isEmpty()) {
			Long memberId = 1L; // 일단 테스트용

			RestaurantDTO recommendRestaurant = nearRestaurantList.get(0);

			RecommendHistory history = new RecommendHistory();
			history.setMemberId(memberId);
			history.setSelectedFood(selectedFood);
			history.setResultRestaurantId(recommendRestaurant.getRestaurantId());

			recommendService.insertRecommendHistory(history);
		}

		model.addAttribute("selectedFood", selectedFood);
		System.out.println(nearRestaurantList);
		model.addAttribute("nearRestaurantList", nearRestaurantList);

		return "recommend/result";
	}

	// 추천 기록 페이지
	@GetMapping("/recommend/history")
	public String recommendHistory(Model model) {

		Long memberId = 1L; // 일단 테스트용 (나중에 로그인으로 변경)

		List<RecommendHistory> list = recommendService.getRecommendHistoryList(memberId);

		model.addAttribute("historyList", list);

		return "recommend/history";
	}
	
	@PostMapping("/recommend/history/delete")
	public String deleteRecommendHistory(@RequestParam("recommendId") Long recommendId) {
		
		Long memberId = 1L;
		
		recommendService.deleteRecommendHistory(recommendId, memberId);
		
		return "redirect:/recommend/history";
	}

// // 추천 기록 페이지
//    @GetMapping("/recommend/history")
//    public String recommendHistory(Model model, HttpSession session) {
//
//        Long memberId = (Long) session.getAttribute("memberId");
//
//        if (memberId == null) {
//            return "redirect:/login";
//        }
//
//        List<RecommendHistory> list = recommendService.getRecommendHistoryList(memberId);
//
//        model.addAttribute("historyList", list);
//
//        return "recommend/history";
//    }
	

}
package com.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.dto.restaurant.RestaurantDTO;
import com.springmvc.service.restaurant.RestaurantService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    // http://localhost:8080/AppProject01/  접속 시
	// 추가: 최근 본 맛집 서비스
    @Autowired
    private RestaurantService restaurantService;

    // http://localhost:8080/AppProject01/ 접속 시
    @RequestMapping("/")
    public String home(HttpSession session, Model model) {

        // 수정:
        // 지금은 member 파트 제외하고 테스트용 memberId 사용
        Long memberId = 1L;

        // 추가: 최근 본 맛집 조회
        List<RestaurantDTO> recentList =
                restaurantService.getRecentlyRestaurantList(memberId);

        // 추가: JSP로 전달
        model.addAttribute("recentList", recentList);

        return "index"; // → /WEB-INF/views/index.jsp
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login";   // → /WEB-INF/views/login.jsp
    }
    
    @RequestMapping("/setup")
    public String setup() {
        return "setup-summary";   // → /WEB-INF/views/setup-summary.jsp
    }
}
package com.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    // http://localhost:8080/AppProject01/  접속 시
    @RequestMapping("/")
    public String home() {
        return "index";   // → /WEB-INF/views/index.jsp 로 forward
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
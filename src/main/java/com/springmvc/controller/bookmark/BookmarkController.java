package com.springmvc.controller.bookmark;

import java.util.List;
// import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.dto.bookmark.Bookmark;
import com.springmvc.service.BookmarkService.BookmarkService;

@Controller
public class BookmarkController {

	@Autowired
	private BookmarkService bookmarkService;
	
	// 즐겨찾기 목록 조회
	@GetMapping("/bookmark/list")
	public String bookmarkList(Model model) {
		
		Long memberId = 1L; // 테스트용, 나중에 로그인 사용자 ID로 변경

        List<Bookmark> bookmarkList = bookmarkService.getBookmarkList(memberId);

        model.addAttribute("bookmarkList", bookmarkList);

        return "bookmark/list";
	}
	
//	// 즐겨찾기 목록 조회
//    @GetMapping("/bookmark/list")
//    public String bookmarkList(Model model, HttpSession session) {
//
//        Long memberId = (Long) session.getAttribute("memberId");
//
//        if (memberId == null) {
//            return "redirect:/login";
//        }
//
//        List<Bookmark> bookmarkList = bookmarkService.getBookmarkList(memberId);
//
//        model.addAttribute("bookmarkList", bookmarkList);
//
//        return "bookmark/list";
//    } 
	
	// 즐겨찾기 추가
    @PostMapping("/bookmark/add")
    public String addBookmark(@RequestParam("restaurantId") Long restaurantId) {

        Long memberId = 1L; // 테스트용

        bookmarkService.insertBookmark(memberId, restaurantId);

        return "redirect:/restaurants/" + restaurantId;
    }
    
//    // 즐겨찾기 추가
//    @PostMapping("/bookmark/add")
//    public String addBookmark(@RequestParam("restaurantId") Long restaurantId,
//                              HttpSession session) {
//
//        Long memberId = (Long) session.getAttribute("memberId");
//
//        if (memberId == null) {
//            return "redirect:/login";
//        }
//
//        bookmarkService.insertBookmark(memberId, restaurantId);
//
//        return "redirect:/restaurants/" + restaurantId;
//    }

    // 즐겨찾기 삭제
    @PostMapping("/bookmark/delete")
    public String deleteBookmark(@RequestParam("bookmarkId") Long bookmarkId) {

        Long memberId = 1L; // 테스트용 

        bookmarkService.deleteBookmark(bookmarkId, memberId);

        return "redirect:/bookmark/list";
    }
    
// // 즐겨찾기 삭제
//    @PostMapping("/bookmark/delete")
//    public String deleteBookmark(@RequestParam("bookmarkId") Long bookmarkId,
//                                 HttpSession session) {
//
//        Long memberId = (Long) session.getAttribute("memberId");
//
//        if (memberId == null) {
//            return "redirect:/login";
//        }
//
//        bookmarkService.deleteBookmark(bookmarkId, memberId);
//
//        return "redirect:/bookmark/list";
//    }
}

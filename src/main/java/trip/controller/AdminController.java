package trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import trip.favorite.service.FavoriteService;

@Controller
public class AdminController {
	
	@Autowired
	private FavoriteService f_service;
	
	public AdminController() {
		
	}
	
	@RequestMapping("/adminFavorite.do")
	public String adminFavoritePage(Model model) {
		List list = f_service.favoriteList();
		model.addAttribute("list", list);
		return "admin/adminFavorite";
	}
	@RequestMapping(value = "/adminFavoriteAdd.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String adminFavoriteAdd(String v_name) {
		String msg = f_service.adminFavoriteAdd(v_name)>0? "등록에 성공했습니다":"등록에 실패했습니다";
		return msg;
	}
	@RequestMapping(value = "/adminFavoriteDelete.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String adminFavoriteDelete(int v_idx) {
		String msg = f_service.adminFavoriteDelete(v_idx)>0? "삭제에 성공했습니다":"삭제에 실패했습니다";
		return msg;
	}
	
}

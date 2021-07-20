package trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.favorite.model.PlaceFavoriteDTO;
import trip.member.model.MemberDTO;
import trip.place.service.PlaceService;
import trip.total.model.AgeDTO;
import trip.total.model.CityTotalDTO;
import trip.total.model.GenderDTO;
import trip.total.model.TotalDTO;
import trip.total.model.TotalVO;
import trip.total.service.TotalService;

@Controller
public class TotalController {
	
	@Autowired
	private TotalService t_service;
	@Autowired
	private PlaceService p_service;
	
	public TotalController() {
		
	}
	
	@RequestMapping("/placeTotalPage.do")
	public String placeTotalPage(Model model, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		List places = p_service.getPlaceWithIdx(idx);
		model.addAttribute("places", places);
		return "placeTotal/placeTotal";
	}
	
	@RequestMapping("/totalUpdate.do")
	@ResponseBody
	public ModelAndView totalUpdate(int pl_idx) {
		List favorite = t_service.favoriteTotalRnumSelect(pl_idx);
		List city = t_service.cityTotalRnumSelect(pl_idx);
		TotalVO total = t_service.totalRnumSelect(pl_idx);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("favorite", favorite);
		mav.addObject("city", city);
		mav.addObject("total", total);
		mav.setViewName("placeTotal/totalBody");
		return mav;
	}
	
}

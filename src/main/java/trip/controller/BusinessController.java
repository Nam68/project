package trip.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import trip.business.service.BusinessService;
import trip.favorite.model.FavoriteDTO;
import trip.favorite.service.FavoriteService;
import trip.img.service.ImgService;
import trip.member.model.MemberDTO;
import trip.place.service.PlaceService;
import trip.review.service.ReviewService;
import trip.view.FileUpload;

@Controller
public class BusinessController {
	
	@Autowired
	private BusinessService b_service;
	@Autowired
	private FavoriteService f_service;
	@Autowired
	private PlaceService p_service;
	@Autowired
	private ImgService i_service;
	@Autowired
	private ReviewService r_service;
	
	@RequestMapping(value = "/businessPage.do")
	public String businessPage(Model model, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		List list = b_service.businessPlaceList(idx);
		model.addAttribute("list", list);
		return "business/businessPlaceList";
	}
	
	@RequestMapping(value = "/businessPlaceAddPage.do")
	public String businessPlaceAdd(Model model) {
		model.addAttribute("favorite", f_service.favoriteList());
		return "business/businessPlaceAdd";
	}
	@RequestMapping(value = "/businessPlaceAdd.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")	
	@ResponseBody
	public String businessPlaceAdd(@RequestBody Map<String, Object> param, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		String msg = b_service.businessPlaceInsert(param, idx)>0? "등록에 성공했습니다":"등록에 실패했습니다";
		i_service.deleteAllTempFile(idx);
		return msg;
	}
	
	@RequestMapping(value = "/businessPlaceUpdatePage.do", method = RequestMethod.POST)
	public String businessPlaceUpdate(Model model, HttpSession session, int pl_idx) {
		model.addAttribute("placeList", p_service.placeWithImg(pl_idx, session));
		model.addAttribute("favorite", f_service.placeInforFavoriteSelect(pl_idx));
		model.addAttribute("reviewList", r_service.reviewList(pl_idx));
		return "business/businessPlaceUpdate";
	}
	@RequestMapping(value = "/businessPlaceUpdate.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")	
	@ResponseBody
	public String businessPlaceUpdate(@RequestBody Map<String, Object> param, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		String msg = b_service.businessPlaceUpdate(param, idx)>0? "등록에 성공했습니다":"등록에 실패했습니다";
		i_service.deleteAllTempFile(idx);
		return msg;
	}
	
	@RequestMapping(value = "/businessPlaceDelete.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String businessPlaceDelete(int pl_idx) {
		String msg = b_service.businessPlaceDelete(pl_idx)>0? "삭제했습니다":"삭제에 실패했습니다";
		return msg;
	}
	
	@RequestMapping("/jusoPopup.do")
	public String jusoPopup() {
		return "business/popup/jusoPopup";
	}
	
}

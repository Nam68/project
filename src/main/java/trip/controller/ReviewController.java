package trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.member.model.MemberDTO;
import trip.review.service.ReviewService;

@Controller
public class ReviewController {
	
	@Autowired
	private ReviewService service;
	
	public ReviewController() {
		
	}
	
	@RequestMapping(value = "/reviewWrite.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String reviewWrite(int pl_idx, double star, String review, HttpSession session) {
		MemberDTO dto = ((MemberDTO) session.getAttribute("memberDTO"));
		if(dto==null) return "로그인 후 이용 가능합니다";
		int idx = dto.getIdx();
		String msg = service.reviewWrite(pl_idx, star, review, idx)>0? "등록에 성공했습니다":"등록에 실패했습니다";
		return msg;
	}
	
	@RequestMapping(value = "/reviewList.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView reviewList(int pl_idx, HttpSession session) {
		List list = service.reviewList(pl_idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("review/reviewBody");
		return mav;
	}
	
	@RequestMapping(value = "/reviewDeleteReq.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String reviewDeleteReq(int r_idx) {
		String msg = service.reviewDeleteReq(r_idx)>0? "신청했습니다":"신청에 실패했습니다";
		return msg;
	}
	
	@RequestMapping("/reviewManagerList.do")
	public ModelAndView reviewManager() {
		List list = service.reviewManagerList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", list);
		mav.setViewName("customer/review/reviewList");
		return mav;
	}
	
	@RequestMapping(value = "/reqCancel.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String reqCancel(int r_idx) {
		String msg = service.reviewDeleteReqCancel(r_idx)>0? "반려했습니다":"서버와 연결되지 않았습니다";
		return msg;
	}
	
	@RequestMapping(value = "/reviewDelete.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String reviewDelete(int r_idx) {
		String msg = service.reviewDelete(r_idx)>0? "삭제했습니다":"서버와 연결되지 않았습니다";
		return msg;
	}
	
}

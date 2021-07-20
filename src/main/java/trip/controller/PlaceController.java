package trip.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.map.model.CartDTO;
import trip.map.model.PlanDTO;
import trip.map.model.PlanVO;
import trip.member.model.MemberDTO;
import trip.place.model.PlaceCartVO;
import trip.place.service.PlaceService;

@Controller
public class PlaceController {

	@Autowired
	private PlaceService placeService;

	@RequestMapping(value = "/planSaveForm.do", method = RequestMethod.GET)
	public String planSave(HttpSession session) {
		return "main";
	}

	@RequestMapping(value = "/planSavemsg.do", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String planSaveSubmit(String p_name, String p_content, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		PlanDTO dto = new PlanDTO(0, p_name, p_content, idx);
		
		int result = placeService.planSave(dto, session);
		String msg = result > 0 ? "플랜저장완료" : "플랜저장실패";
		
		return msg;
	}
	
	@RequestMapping("/planList.do")
	public String planList(Model model, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		List planList = placeService.planList(idx);
		model.addAttribute("planLists", planList);
		return "cart/planList";
	}
	
	@RequestMapping(value = "/placeDuplicationCheck.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String placeDuplicationCheck(int pl_idx, HttpSession session) {
		HashMap<Integer, Object> day = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		if(day == null) day = new HashMap<Integer, Object>();
		
		Iterator it = day.keySet().iterator();
		while(it.hasNext()) {
			int key = (Integer) it.next();
			ArrayList<CartDTO> list = (ArrayList<CartDTO>) day.get(key);
			for(CartDTO temp : list) {
				if(temp.getPl_idx() == pl_idx) {
					return "장소를 중복해서 선택할 수 없습니다";
				}
			}
		}
		return "";
	}

	@RequestMapping(value = "/placeCart.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public ModelAndView intoCart(@RequestBody Map<String, Object> params,
			HttpSession session, Map<String,Object> map) {
		
		// 날짜 map
		HashMap<Integer, Object> day = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		if(day == null) day = new HashMap<Integer, Object>();
		
		
		int resultdate = (Integer) params.get("resultdate");
		int pl_idx = (Integer) params.get("pl_idx");
		String pl_name = (String) params.get("pl_name");
		String pl_img = (String) params.get("pl_img");
		double pl_lat = (Double) params.get("pl_lat");
		double pl_lng = (Double) params.get("pl_lng");
		CartDTO cart = new CartDTO(resultdate, pl_idx, pl_name, pl_img, pl_lat, pl_lng);
		
		ArrayList<CartDTO> dayList = (ArrayList<CartDTO>) day.get(resultdate);
		if(dayList == null) dayList = new ArrayList<CartDTO>();
		dayList.add(cart);
		
		day.put(resultdate, dayList);
		
		session.setAttribute("placeCart", day);

		ModelAndView mav = new ModelAndView();
		mav.addObject("placeCart", dayList);
		
		mav.setViewName("cart/cartItems");
		return mav;
	}
	
	@RequestMapping("/dayChange.do")
	public ModelAndView dayChange(int day, HttpSession session) {
		HashMap<Integer, Object> cart = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		if(cart == null) cart = new HashMap<Integer, Object>();
		
		ArrayList<CartDTO> dayList = (ArrayList<CartDTO>) cart.get(day);
		if(dayList == null) dayList = new ArrayList<CartDTO>(); cart.put(day, dayList);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("placeCart", dayList);
		mav.setViewName("cart/cartItems");
		return mav;
	}
	
	@RequestMapping("/deletePlace.do")
	public ModelAndView deletePlace(int pl_idx, int resultdate, HttpSession session) {
		HashMap<Integer, Object> day = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		ArrayList<CartDTO> dayList = (ArrayList<CartDTO>) day.get(resultdate);
		for(int i = 0; i < dayList.size(); i++) {
			CartDTO temp = dayList.get(i);
			if(temp.getPl_idx() == pl_idx) {
				dayList.remove(i);
			}
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("placeCart", dayList);
		mav.setViewName("cart/cartItems");
		return mav;
	}
	
	@RequestMapping(value = "/planDelete.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String planDelete(int p_idx) {
		String msg = placeService.planDelete(p_idx)>0? "삭제에 성공했습니다":"삭제에 실패했습니다";
		return msg;
	}
	 

}

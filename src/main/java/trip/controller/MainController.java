package trip.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap.KeySetView;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trip.favorite.model.UserFavoriteDTO;
import trip.favorite.service.FavoriteService;
import trip.member.model.MemberDTO;
import trip.member.model.UserDTO;
import trip.member.service.MemberService;
import trip.place.model.PlaceInfoDTO;
import trip.place.model.PlaceVO;
import trip.place.service.PlaceService;
import trip.planInfo.model.PlanInfoVO;
import trip.total.service.TotalVistitService;

@Controller
public class MainController {
	
	@Autowired
	private PlaceService placeService;
	@Autowired
	private FavoriteService favoriteService;
	@Autowired
	private TotalVistitService ser;
	
	public MainController() {
		
	}
	
	@RequestMapping("/mainPage.do")
	public String mainPage(Model data, HttpSession session) {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			String ipx=String.valueOf(ip);
			String id[]=ipx.split("/");
			int count=ser.ipSelect(id[1]);
			if(count==0) {
				if(id[1] != null) {
					int xo=ser.insertTotal(id[1]);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		favoriteService.makeTempUserFavorite(session);
		List list = placeService.placeList(session);
		System.out.println("list="+list.size());
		data.addAttribute("placeList", list);
		return "temp/main";
	}
	
	@RequestMapping(value = "/openPlaceInfo.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView placeInfoPage(int pl_idx, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		List imgList = placeService.placeWithImg(pl_idx, session);
		
		//장소를 클릭할 때 취향 정보를 조작
		favoriteService.favoriteUpdateWhenClicked(pl_idx, session);
		
		mav.addObject("imgList", imgList);
		mav.setViewName("tripJson");
		return mav;
	}
	
	
	
	//장소 좋아요 관련
	@RequestMapping("/likeAdd.do")
	@ResponseBody
	public String likeAdd(int pl_idx, int idx) {
		return placeService.likeAdd(pl_idx, idx);
	}
	@RequestMapping("/likeDelete.do")
	@ResponseBody
	public String likeDelete(int pl_idx, int idx) {
		return placeService.likeDelete(pl_idx, idx);
	}
	
	
	
	//검색 관련
	@RequestMapping(value = "/placeFastSeach.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String placeSearchKeyDown(String keyValue) {
		List list = placeService.placeFastSeach(keyValue);
		ObjectMapper mapper = new ObjectMapper();
		String data = "";
		try {
			data = mapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	@RequestMapping(value = "/placeSearchText.do")
	public ModelAndView placeSearchText(String keyValue) {
		ModelAndView mav = new ModelAndView();		
		List list = placeService.placeSearchText(keyValue);
		mav.addObject("placeList", list);
		mav.setViewName("temp/main");
		return mav;
	}
	
	@RequestMapping(value = "/placeSearchIdx.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView placeSearchIdx(int pl_idx) {
		ModelAndView mav = new ModelAndView();
		List list = placeService.placeSearchIdx(pl_idx);
		mav.addObject("placeList", list);
		mav.setViewName("temp/searchBody");
		return mav;
	}
	
	
	
	//userFavorite 저장
	@RequestMapping("/saveFavorite.do")
	public void saveFavorite(HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("memberDTO");
		if(dto != null) {
			int idx = dto.getIdx();
			List<UserFavoriteDTO> list = (List<UserFavoriteDTO>) session.getAttribute("userFavorite");
			favoriteService.saveFavorite(list, idx);
		}
		
		HashMap<Integer, Object> cart = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		if(cart != null) session.setAttribute("placeCart", new HashMap<Integer, Object>());
	}
	
	
	
	
	//카트 관련
	@RequestMapping(value = "/intoCart.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	public ModelAndView intoCart(@RequestBody Map<String, Object> param, HttpSession session) {	
		String pl_name = (String) param.get("pl_name");
		int pl_idx = (Integer) param.get("pl_idx");
		int day = (Integer) param.get("day");
		String pl_img = (String) param.get("pl_img");
		double lat = (Double) param.get("lat");
		double lng = (Double) param.get("lng");
		
		HashMap<Integer, ArrayList<PlanInfoVO>> cartMap = (HashMap<Integer, ArrayList<PlanInfoVO>>) session.getAttribute("cartMap");
		if(cartMap == null) cartMap = new HashMap<Integer, ArrayList<PlanInfoVO>>();
		
		ArrayList<PlanInfoVO> cart = cartMap.get(day);
		if(cart == null) cart = new ArrayList<PlanInfoVO>();
		
//		for(PlanInfoVO temp : cart) {
//			if(temp.getPl_idx() == pl_idx) {
//				return "같은 장소는 추가할 수 없습니다";
//			}
//		}
		
		PlanInfoVO dto = new PlanInfoVO(pl_name, pl_idx, day, pl_img, lat, lng);
		cart.add(dto);
		cartMap.put(day, cart);
		
		session.setAttribute("cartMap", cartMap);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("todayCart", cart);
		mav.setViewName("planCart/cartBody");
		return mav;
	}
	
	@RequestMapping("/deleteCart.do")
	public ModelAndView deleteCart(int pl_idx, int day, HttpSession session) {
		HashMap<Integer, ArrayList<PlanInfoVO>> cartMap = (HashMap<Integer, ArrayList<PlanInfoVO>>) session.getAttribute("cartMap");
		ArrayList<PlanInfoVO> cart = cartMap.get(day);
		for(int i = 0; i < cart.size(); i++) {
			PlanInfoVO temp = cart.get(i);
			if(temp.getPl_idx() == pl_idx) cart.remove(i);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("todayCart", cart);
		mav.setViewName("planCart/cartBody");
		return mav;
	}
	
	@RequestMapping("/cartDateUpdate.do")
	public ModelAndView cartDateUpdate(int day, int totalDate, HttpSession session) {
		HashMap<Integer, ArrayList<PlanInfoVO>> cartMap = (HashMap<Integer, ArrayList<PlanInfoVO>>) session.getAttribute("cartMap");
		if(cartMap == null) cartMap = new HashMap<Integer, ArrayList<PlanInfoVO>>();
		
		Object[] keys = cartMap.keySet().toArray();

		for(int i = 0; i < keys.length; i++) {
			int target = (Integer) keys[i];

			if(target > totalDate) {

				cartMap.remove(i);
			}
		}
		
		ArrayList<PlanInfoVO> cart = cartMap.get(day);
		if(cart == null) cart = new ArrayList<PlanInfoVO>(); cartMap.put(day, cart);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("todayCart", cart);
		mav.setViewName("planCart/cartBody");
		
		return mav;
	}
	
	@RequestMapping("/cartUpdate.do")
	public ModelAndView cartUpdate(int day, HttpSession session) {
		HashMap<Integer, ArrayList<PlanInfoVO>> cartMap = (HashMap<Integer, ArrayList<PlanInfoVO>>) session.getAttribute("cartMap");
		if(cartMap == null) cartMap = new HashMap<Integer, ArrayList<PlanInfoVO>>();
		
		ArrayList<PlanInfoVO> cart = cartMap.get(day);
		if(cart == null) cart = new ArrayList<PlanInfoVO>(); cartMap.put(day, cart);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("todayCart", cart);
		mav.setViewName("planCart/cartBody");
		
		return mav;
	}
	
}

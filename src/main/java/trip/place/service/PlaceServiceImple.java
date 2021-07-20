package trip.place.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import trip.favorite.model.UserFavoriteDTO;
import trip.map.model.CartDTO;
import trip.map.model.PlanDTO;
import trip.map.model.PlanVO;
import trip.member.model.MemberDTO;
import trip.place.model.PlaceCartVO;
import trip.place.model.PlaceDAO;
import trip.place.model.PlaceDTO;
import trip.place.model.PlaceInfoDTO;
import trip.place.model.PlaceVO;

public class PlaceServiceImple implements PlaceService {
	
	@Autowired
	PlaceDAO dao;
	
	public PlaceServiceImple() {
		
	} 
	
	
	public List placeList(HttpSession session) {
		List<UserFavoriteDTO> ulist = (List<UserFavoriteDTO>) session.getAttribute("userFavorite");
		
		int[] vidx = placeRecommandIdx(ulist);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("favorite1", vidx[0]);
		map.put("favorite2", vidx[1]);
		
		return deduplicateList(dao.placeList(map));
	}
	//취향 정보에 따른 추천 취향 배치 메서드
	private int[] placeRecommandIdx(List<UserFavoriteDTO> ulist) {
		int x = (int) (Math.random()*(ulist.size()-1)+0);
		UserFavoriteDTO dto1 = ulist.get(x);
		UserFavoriteDTO dto2 = ulist.get(x+1);
		for(int i = 2; i < ulist.size(); i++) {
			if(ulist.get(i).getCount() > dto1.getCount()) {
				dto1 = ulist.get(i); continue;
			} else if(ulist.get(i).getCount() > dto2.getCount()) {
				dto2 = ulist.get(i);
			}
		}
		int[] result = {dto1.getV_idx(), dto2.getV_idx()}; 
		return result;
	}
	
	public List placeWithImg(int pl_idx, HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("memberDTO");
		int idx = dto==null? 0:dto.getIdx();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", pl_idx);
		map.put("idx", idx);
		return starNumberFormat(dao.placeWithImg(map));
	}
	
	public String likeAdd(int pl_idx, int idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", pl_idx);
		map.put("idx", idx);
		dao.likeAdd(map);
		return Integer.toString(dao.likeSelect(pl_idx));
	}
	
	public String likeDelete(int pl_idx, int idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", pl_idx);
		map.put("idx", idx);
		dao.likeDelete(map);
		return Integer.toString(dao.likeSelect(pl_idx));
	}
	
	public List placeFastSeach(String keyValue) {
		return dao.placeFastSeach(keyValue);
	}
	
	public List placeSearchText(String keyValue) {
		return deduplicateList(dao.placeSearchText(keyValue)); 
	}
	
	public List placeSearchIdx(int pl_idx) {
		return deduplicateList(dao.placeSearchIdx(pl_idx));
	}
	
	
	public List starNumberFormat(List<PlaceVO> list) {
		for(PlaceVO temp : list) {
			DecimalFormat df = new DecimalFormat("#.##");
			temp.setPl_star(Double.parseDouble(df.format(temp.getPl_star())));
		}
		return list;
	}	
	
	public List getPlaceWithIdx(int idx) {
		return dao.getPlaceWithIdx(idx);
	}
	
	public List placePlainList() {
		return dao.placePlainList();
	}
	
	
	
	
	
	/** 리스트 중복 제거 메서드 */
	public List deduplicateList(List<PlaceVO> list) {
		ArrayList<PlaceVO> result = new ArrayList<PlaceVO>();
		HashMap<Integer, PlaceVO> map = new HashMap<Integer, PlaceVO>();
		for(PlaceVO temp : list) {
			if(map.get(temp.getPl_idx()) == null) {
				map.put(temp.getPl_idx(), temp);
				result.add(temp);
			}
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	//카트
	public int planSave(PlanDTO dto, HttpSession session) {
		ArrayList<PlaceInfoDTO> infoList = new ArrayList<PlaceInfoDTO>();
		HashMap<Integer, Object> cart = (HashMap<Integer, Object>) session.getAttribute("placeCart");
		Iterator it = cart.keySet().iterator();
		while(it.hasNext()) {
			int key = (Integer) it.next();
			ArrayList<CartDTO> list = (ArrayList<CartDTO>) cart.get(key);
			for(int i = 0; i < list.size(); i++) {
				CartDTO temp = list.get(i);
				int pl_idx = temp.getPl_idx();
				int day = temp.getResultdate();
				String img = temp.getPl_img();
				int sunbun = i+1;
				infoList.add(new PlaceInfoDTO(0, pl_idx, day, img, sunbun));
			}
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dto", dto);
		map.put("infoList", infoList);
		
		int count = dao.planSave(map);
		
		return count;
	}
	
	public int planDelete(int p_idx) {
		int count=dao.planDelete(p_idx);
		return count;
	}

	public List<PlanVO> planList() {
		Map map = new HashedMap();
		List<PlanVO> planList = dao.planList(map);
		return planList;
	}
	
	public List<PlanVO> planList(int idx) {
		List<PlanVO> planList = dao.planList(idx);
		HashMap<Integer, Object> map = new HashMap<Integer, Object>();
		ArrayList<PlanVO> list = new ArrayList<PlanVO>();
		for(PlanVO temp : planList) {
			if(map.get(temp.getP_idx()) == null) {
				map.put(temp.getP_idx(), temp);
				list.add(temp);
			}
		}
		return list;
	}
	
	public List<PlaceCartVO> placeList() {
		Map map = new HashedMap();
		List<PlaceCartVO> placeList = dao.placeList(map);
		return placeList;
	}

	public List<PlaceCartVO> selectOneplace() {
		Map map = new HashedMap();
		List<PlaceCartVO> pvo = dao.selectOneplace(map);
		return pvo;
	}
}

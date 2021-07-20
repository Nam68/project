package trip.place.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import trip.map.model.PlanDTO;
import trip.map.model.PlanVO;
import trip.place.model.PlaceCartVO;
import trip.place.model.PlaceDTO;
import trip.place.model.PlaceVO;

public interface PlaceService {
	
	public List placeList(HttpSession session);
	public List placeWithImg(int pl_idx, HttpSession session);
	
	public String likeAdd(int pl_idx, int idx);
	public String likeDelete(int pl_idx, int idx);
	
	//검색을 통한 서치기능
	public List placeFastSeach(String keyValue);
	public List placeSearchText(String keyValue);
	public List placeSearchIdx(int pl_idx);
	
	public List getPlaceWithIdx(int idx);
	public List placePlainList();
	
	
	
	
	//리스트 중복제거
	public List deduplicateList(List<PlaceVO> list);
	
	
	
	
	
	
	//카트
	public int planSave(PlanDTO dto, HttpSession session);
	public List<PlanVO> planList();
	public List<PlanVO> planList(int idx);
	public List<PlaceCartVO> placeList();
	public List<PlaceCartVO> selectOneplace();
	public int planDelete(int p_idx);
}

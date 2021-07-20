package trip.place.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trip.map.model.PlanVO;

public interface PlaceDAO {
	
	public List placeList(HashMap<String, Integer> map);
	public List placeWithImg(HashMap<String, Integer> map);
	
	public int likeAdd(HashMap<String, Integer> map);
	public int likeDelete(HashMap<String, Integer> map);	
	public int likeSelect(int pl_idx);
	
	//검색 관련된 서치기능
	public List placeFastSeach(String keyValue);
	public List placeSearchText(String keyValue);
	public List placeSearchIdx(int pl_idx);
	
	
	public List getPlaceWithIdx(int idx);
	public List placePlainList();
	
	
	//카트
	public int planSave(HashMap<String, Object> map);//플랜저장
	public List<PlanVO> planList(Map map);
	public List<PlanVO> planList(int idx);
	public List<PlaceCartVO> placeList(Map lmap);
	public List<PlaceCartVO> selectOneplace(Map lmap);
	public int planDelete(int idx);
	
}

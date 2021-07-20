package trip.place.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import trip.map.model.PlanVO;

public class PlaceDAOImple implements PlaceDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap; 
	
	public PlaceDAOImple() {
		
	}
	
	public List placeList(HashMap<String, Integer> map) {
		return sqlMap.selectList("placeList", map);
	}
	
	public List placeWithImg(HashMap<String, Integer> map) {
		return sqlMap.selectList("placeWithImg", map);
	}
	
	public int likeAdd(HashMap<String, Integer> map) {
		return sqlMap.insert("likeAdd", map);
	}
	
	public int likeDelete(HashMap<String, Integer> map) {
		return sqlMap.delete("likeDelete", map);
	}
	
	public int likeSelect(int pl_idx) {
		return sqlMap.selectOne("likeSelect", pl_idx);
	}
	
	public List placeFastSeach(String keyValue) {
		return sqlMap.selectList("placeFastSeach", keyValue);
	}
	
	public List placeSearchText(String keyValue) {
		return sqlMap.selectList("placeSeachText", keyValue);
	}
	
	public List placeSearchIdx(int pl_idx) {
		return sqlMap.selectList("placeSeachIdx", pl_idx);
	}
	
	public List getPlaceWithIdx(int idx) {
		return sqlMap.selectList("getPlaceWithIdx", idx);
	}
	
	public List placePlainList() {
		return sqlMap.selectList("placePlainList");
	}
	
	
	
	
	//카트
	public int planSave(HashMap<String, Object> map) {
		int count=sqlMap.insert("planAdd", map);
		return count;
	}
	
	public List<PlanVO> planList(Map map) {
		List<PlanVO> planList=sqlMap.selectList("planAllList", map);
		return planList;
	}
	
	public List<PlanVO> planList(int idx) {
		List<PlanVO> planList=sqlMap.selectList("planAllList", idx);
		return planList;
	}
	
	public List<PlaceCartVO> placeList(Map map) {
		List<PlaceCartVO> placeList=sqlMap.selectList("placeAllList", map);
		return placeList;
	}
	
	public List<PlaceCartVO> selectOneplace(Map lmap) {
		List<PlaceCartVO> placeList=sqlMap.selectList("selectOneplace", lmap);
		return placeList;
	}
	
	public int planDelete(int p_idx) {
		int count=sqlMap.delete("planDelete", p_idx);
		return count;
	}

}

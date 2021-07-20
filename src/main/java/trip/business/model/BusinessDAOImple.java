package trip.business.model;

import java.util.Map;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class BusinessDAOImple implements BusinessDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public BusinessDAOImple() {
		
	}
	
	public List businessPlaceList(int idx) {
		return sqlMap.selectList("businessPlaceList", idx);
	}
	
	public int businessPlaceDelete(int pl_idx) {
		return sqlMap.delete("businessPlaceDelete", pl_idx);
	}
	
	public int businessPlaceInsert(Map<String, Object> map) {
		return sqlMap.insert("businessPlaceInsert", map);
	}
	
	public int businessPlaceUpdate(Map<String, Object> map) {
		return sqlMap.update("businessPlaceUpdate", map);
	}
	
	public int placeAllImgDelete(int pl_idx) {
		return sqlMap.delete("placeAllImgDelete", pl_idx);
	}

}

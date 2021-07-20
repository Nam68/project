package trip.review.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewDAOImple implements ReviewDAO {

	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public ReviewDAOImple() {
		
	}
	
	public int reviewWrite(Map<String, Object> map) {
		return sqlMap.insert("reviewWrite", map); 
	}

	public List reviewList(int pl_idx) {
		return sqlMap.selectList("reviewList", pl_idx);
	}
	
	public int reviewDeleteReq(int r_idx) {
		return sqlMap.update("reviewDeleteReq", r_idx);
	}
	
	public int reviewDeleteReqCancel(int r_idx) {
		return sqlMap.update("reviewDeleteReqCancel", r_idx);
	}
	
	public int reviewDelete(int r_idx) {
		return sqlMap.delete("reviewDelete", r_idx);
	}
	
	public List reviewManagerList() {
		return sqlMap.selectList("reviewManagerList");
	}

}

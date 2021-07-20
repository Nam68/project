package trip.total.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import trip.favorite.model.PlaceFavoriteDTO;
import trip.member.service.MemberService;

public class TotalDAOImple implements TotalDAO {

	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public TotalDAOImple() {
		
	}
	
	public TotalDTO totalSelect(int pl_idx) {
		return sqlMap.selectOne("totalSelect", pl_idx); 
	}

	public int totalUpdate(HashMap<String, Integer> map) {
		return sqlMap.update("totalUpdate", map);
	}
	
	public int cityTotalUPdate(HashMap<String, Integer> map) {
		return sqlMap.update("cityTotalUpdate", map);
	}
	
	public List getAllcity() {
		return sqlMap.selectList("getAllCity");
	}
	
	public List favoriteTotalRnumSelect(int pl_idx) {
		return sqlMap.selectList("favoriteTotalRnumSelect", pl_idx);
	}
	
	public List cityTotalRnumSelect(int pl_idx) {
		return sqlMap.selectList("cityTotalRnumSelect", pl_idx);
	}
	
	public TotalVO totalRnumSelect(int pl_idx) {
		return sqlMap.selectOne("totalRnumSelect", pl_idx);
	}
}

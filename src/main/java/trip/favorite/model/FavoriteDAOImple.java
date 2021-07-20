package trip.favorite.model;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class FavoriteDAOImple implements FavoriteDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap; 
	
	public FavoriteDAOImple() {
		
	}
	
	public List favoriteList() {
		return sqlMap.selectList("favoriteList");
	}
	
	public List userFavoriteList(int idx) {
		return sqlMap.selectList("userFavoriteList", idx);
	}
	
	public int userFavoriteAdd(HashMap<String, Integer> map) {
		return sqlMap.insert("userFavoriteListInsert", map);
	}
	
	public int userFavoriteUpdate(HashMap<String, Integer> map) {
		return sqlMap.update("userFavoriteUpdate", map);
	}
	
	public List placeFavoriteList(int pl_idx) {
		return sqlMap.selectList("placeFavoriteList", pl_idx);
	}
	
	public int placeFavoriteInsert(HashMap<String, Integer> map) {
		return sqlMap.insert("placeFavoriteInsert", map);
	}
	
	public int placeFavoriteUpdate(HashMap<String, Integer> map) {
		return sqlMap.update("placeFavoriteUpdate", map);
	}
	
	public List placeInfoFavoriteList(int pl_idx) {
		return sqlMap.selectList("placeInfoFavoriteList", pl_idx);
	}
	
	public List placeInforFavoriteSelect(int pl_idx) {
		return sqlMap.selectList("placeInfoFavoriteSelect", pl_idx);
	}
	
	public int userFavoriteListInsert(HashMap<String, Object> map) {
		return sqlMap.insert("userFavoriteListInsert", map);
	}
	
	public int adminFavoriteAdd(HashMap<String, Object> map) {
		return sqlMap.insert("adminFavoriteAdd", map);
	}
	
	public int adminFavoriteDelete(int v_idx) {
		return sqlMap.delete("adminFavoriteDelete", v_idx);
	}
	
}

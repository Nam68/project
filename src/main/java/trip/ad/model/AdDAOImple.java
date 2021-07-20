package trip.ad.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class AdDAOImple implements AdDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public AdDAOImple() {
		
	}
	
	public List adList(int idx) {
		return sqlMap.selectList("adList", idx);
	}
	
	public int adSubmit(Map<String, Object> map) {
		return sqlMap.insert("adInsert", map);
	}
	
	public AdDTO adSelect(int a_idx) {
		return sqlMap.selectOne("adSelect", a_idx);
	}
	
	public List adImgList(int bbs_idx) {
		return sqlMap.selectList("adImgList", bbs_idx);
	}
	
	public int adAllImgDelete(int bbs_idx) {
		return sqlMap.delete("adAllImgDelete", bbs_idx);
	}
	
	public int adUPdate(Map<String, Object> map) {
		return sqlMap.update("adUpdate", map);
	}
	
	public int adDelete(int a_idx) {
		return sqlMap.delete("adDelete", a_idx);
	}
	
	public AdDTO adListForSns() {
		return sqlMap.selectOne("adListForSns");
	}
	
	public int adCountUpdate(int bbs_idx) {
		return sqlMap.update("adCountUpdate", bbs_idx);
	}
	
	
	//추가
		public List adManagerList(int cp) {
			return sqlMap.selectList("adManagerList",cp);
		}

		public int adCount() {
			return sqlMap.selectOne("adCount");
		}

		public int permitUpdate(Map<String, Integer> map) {
			return sqlMap.update("permitUpdate",map);
		}

		public int permitDelete(Map<String, Integer> map) {
			return sqlMap.delete("permitDelete", map);
		}
	
	
	
	
	public int adsPay() {
		int count=sqlMap.selectOne("adspay");
		return count;
	}

	public int adsCount(Map map) {
		int count=sqlMap.insert("adscount", map);
		return count;
	}

	public int adsTotal(Map map) {
		int list=sqlMap.selectOne("adstotal", map);
		return list;
	}

}

package trip.sns.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class SnsDAOImple implements SnsDAO {

	@Autowired
	private SqlSessionTemplate sqlMap;

	public SnsDAOImple() {

	}

	public int snsWrite(Map<String, Object> map) {
		int count = sqlMap.insert("snsWrite", map);
		return count;
	}

	public int snsDelete(SnsDTO dto) {
		int count = sqlMap.delete("snsDelete", dto);
		return count;
	}

	public int snsGood(GoodDTO gdto) {
		int count = sqlMap.insert("snsGood", gdto);
		return count;
	}

	public List<SnsDTO> snsList(Map map) {
		List<SnsDTO> list = sqlMap.selectList("snsList", map);
		return list;
	}

	public List<SnsDTO> mySnsList(Map map) {
		List<SnsDTO> list = sqlMap.selectList("mySnsList", map);
		return list;
	}

	public int getTotalCount() {
		int count = sqlMap.selectOne("snsTotalCount");
		return count;
	}

	public SnsDTO snsContent(int bbs_idx) {
		SnsDTO dto = sqlMap.selectOne("snsSelectContent", bbs_idx);
		return dto;
	}

	public List bbsAllImgList() {
		return sqlMap.selectList("bbsAllImgList");
	}

	public int addGood(HashMap<String, Integer> map) {
		return sqlMap.insert("addGood", map);
	}

	public int deleteGood(HashMap<String, Integer> map) {
		return sqlMap.delete("deleteGood", map);
	}

	public int goodSelect(int idx) {
		return sqlMap.selectOne("goodSelect", idx);
	}

	public int goodInsert(HashMap<String, Integer> map) {
		return sqlMap.insert("goodInsert", map);
	}

	public int goodDelete(HashMap<String, Integer> map) {
		return sqlMap.selectOne("goodDelete", map);
	}

	public int goodCount(int bbs_idx) {
		return sqlMap.selectOne("goodCount",bbs_idx);
	}

	public List goodCheck(int idx) {
		return sqlMap.selectList("goodlist", idx);
	}
	
}

package trip.qna.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import trip.member.model.MemberDTO;


public class QnADAOImple implements QnADAO {

	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public int QnAWrite(QnADTO dto) {
		int count = sqlMap.insert("QnAInsert", dto);
		return count;
	}

	public int getQnATotalCnt() {
		int count = sqlMap.selectOne("QnATotalCnt");
		return count;
	}
	
	public List<QnADTO> QnAAllList(Map map) {
		List<QnADTO> list = sqlMap.selectList("QnAList", map);
		return list;
	}
	
	public QnADTO QnAContent(int bbs_idx) {
		QnADTO dto = sqlMap.selectOne("QnASelectContent",bbs_idx);
		return dto;
	}
	
	
	public int QnAUpdate(QnADTO dto) {
		int count = sqlMap.update("QnAUpdate", dto);
		return count;
	}
	

	public int QnADelete(int bbs_idx) {
		int count = sqlMap.delete("QnADelete",bbs_idx);
		return count;
	}
	
}

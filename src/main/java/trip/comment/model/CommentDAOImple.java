package trip.comment.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class CommentDAOImple implements CommentDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;

	public CommentDAOImple() {
		
	}
	
	//글 작성
	public int addComment(CommentVO vo) {
		int count = sqlMap.insert("addComment", vo);
		return count;
	}
	//글 목록
	public List<CommentVO> commentList(int bbs_idx) {
		List<CommentVO> list = sqlMap.selectList("commentList", bbs_idx);
		return list;
	}
	//글 총 갯수
	public int getTotalCCnt() {
		int count = sqlMap.selectOne("commentTotalCnt");
		return count;
	}
	//글 삭제
	public int commentDelete(int c_idx) {
		int count = sqlMap.delete("commentDelete",c_idx);
		return count;
	}
	//글 수정
	public int commentUpdate(CommentVO vo) {
		int count = sqlMap.update("commentUpdate",vo);
		return count;
	}
	
	public List<CommentVO> comment(int bbs_idx) {
		List<CommentVO> list = sqlMap.selectList("commentList", bbs_idx);
		return list;
	}
}

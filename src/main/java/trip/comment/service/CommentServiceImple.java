package trip.comment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import trip.comment.model.CommentDAO;
import trip.comment.model.CommentVO;

public class CommentServiceImple implements CommentService {

	@Autowired
	private CommentDAO Dao; 
	
	//글 작성
	public int addComment(CommentVO vo) {
		int count = Dao.addComment(vo);
		return count;
	}
	
	//글 목록
	public List<CommentVO> commentList(int bbs_idx) {
		return Dao.commentList(bbs_idx);
	}
	//글 총 갯수
	public int getTotalCCnt() {
	int count=Dao.getTotalCCnt();
		return count;
	}
	
	//글 삭제
	public int commentDelete(int c_idx) {
		int count = Dao.commentDelete(c_idx);
		return count;
	}
	//글 수정
	public int commentUpdate(CommentVO vo) {
		int count = Dao.commentUpdate(vo);
		return count;
	}
	
	public List<CommentVO> comment(Integer bbs_idx) {
		return Dao.comment(bbs_idx);
	}
	
} 
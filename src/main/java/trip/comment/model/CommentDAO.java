package trip.comment.model;

import java.util.List;

import trip.comment.model.CommentVO;

	public interface CommentDAO {
		
		//글 작성
		public int addComment(CommentVO vo);
		//글 목록
		public List<CommentVO> commentList(int bbs_idx);
		//글 총 갯수
		public int getTotalCCnt();
		//글 삭제
		public int commentDelete(int c_idx);
		//글 수정
		public int commentUpdate(CommentVO vo);
		
		public List<CommentVO> comment(int bbs_idx);
	}

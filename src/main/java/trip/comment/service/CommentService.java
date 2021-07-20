package trip.comment.service;

import java.util.List;

import org.springframework.stereotype.Service;

import trip.comment.model.CommentVO;

@Service
public interface CommentService {
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
	
	public List<CommentVO> comment(Integer bbs_idx);
}
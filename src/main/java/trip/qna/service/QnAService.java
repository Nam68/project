package trip.qna.service;

import java.util.List;

import trip.qna.model.QnADTO;

public interface QnAService {

		//QnA 글쓰기
		public int QnAWrite(QnADTO dto);
		//QnA 글 리스트
		public List<QnADTO> QnAAllList(int cp, int ls);
		//QnA 총 카운트
		public int getQnATotalCnt();
		//QnA 글 컨텐츠
		public QnADTO QnAContent(int bbs_idx);
		//QnA 글 수정
		public int QnAUpdate(QnADTO dto);
		//QnA 글 삭제
		public int QnADelete(int bbs_idx);
	
}

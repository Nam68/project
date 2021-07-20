package trip.qna.model;

import java.util.List;
import java.util.Map;


import trip.qna.*;

public interface QnADAO {
		
		//QnA 글쓰기
		public int QnAWrite(QnADTO dto);
		//QnA 글 리스트
		public List<QnADTO> QnAAllList(Map map);
		//QnA 총 카운트
		public int getQnATotalCnt();
		//QnA 글 컨텐츠
		public QnADTO QnAContent(int bbs_idx);
		//QnA 글 수정
		public int QnAUpdate(QnADTO dto);
		//QnA 글 삭제
		public int QnADelete(int bbs_idx);
	
}

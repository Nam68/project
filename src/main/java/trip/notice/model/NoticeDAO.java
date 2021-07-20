package trip.notice.model;

import java.util.List;
import java.util.Map;


import trip.qna.model.QnADTO;

public interface NoticeDAO {
	
	//글 작성
	public int noticeWrite(NoticeDTO dto);
	//글 리스트
	public List<NoticeDTO> noticeAllList(Map map);
	//총 카운트
	public int getNoticeTotalCnt();
	//글 컨텐츠
	public NoticeDTO noticeContent(int n_idx);
	//조회수
	public int noticeReadnum(int n_idx);
	//공지사항 팝업
	public List<NoticeDTO> noticePop();
	//글 수정
	public int noticeUpdate(NoticeDTO dto);
	//QnA 글 삭제
	public int noticeDelete(int n_idx);

  
}

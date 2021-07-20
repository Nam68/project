package trip.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.notice.model.NoticeDAO;
import trip.notice.model.NoticeDTO;


public class NoticeServiceImple implements NoticeService {

	@Autowired
	private NoticeDAO dao;
	
	public int noticeWrite(NoticeDTO dto) {
		int count = dao.noticeWrite(dto);
		return count;
	}
	public int getNoticeTotalCnt() {
		int count = dao.getNoticeTotalCnt();
		return count;
	}
	public List<NoticeDTO> noticeAllList(int cp, int ls) {
		Map map = new HashMap();
		int start=((cp-1)*ls)+1;
		int end=cp*ls;
		map.put("start", start);
		map.put("end", end);
		List<NoticeDTO> list = dao.noticeAllList(map);
		return list;
	
	}
	public NoticeDTO noticeContent(int n_idx) {
		NoticeDTO dto = dao.noticeContent(n_idx);
		return dto;
	}
	
	public int noticeReadnum(int n_idx) {
		return dao.noticeReadnum(n_idx);
	}
	
	public List<NoticeDTO> noticePop() {
		List<NoticeDTO> list = dao.noticePop();
		return list;
	}
	
	public int noticeUpdate(NoticeDTO dto) {
		int count = dao.noticeUpdate(dto);
		return count;
	}
	public int noticeDelete(int n_idx) {
		int count = dao.noticeDelete(n_idx);
		return count;
	}

}

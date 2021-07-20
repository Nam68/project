package trip.qna.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;


import trip.qna.model.QnADAO;
import trip.qna.model.QnADTO;

public class QnAServiceImple implements QnAService {

	@Autowired
	private QnADAO dao;
	
	public int QnAWrite(QnADTO dto) {
		int count=dao.QnAWrite(dto);
		return count;
	}
	
	public int getQnATotalCnt() {
		int count = dao.getQnATotalCnt();
		return count;
	}
	
	public List<QnADTO> QnAAllList(int cp, int ls) {
		Map map = new HashMap();
		int start=((cp-1)*ls)+1;
		int end=cp*ls;
		map.put("start", start);
		map.put("end", end);
		List<QnADTO> list = dao.QnAAllList(map);
		return list;
	
	}

	public QnADTO QnAContent(int bbs_idx) {
		QnADTO dto = dao.QnAContent(bbs_idx);
		return dto;
	}
	
	public int QnAUpdate(QnADTO dto) {
		int count = dao.QnAUpdate(dto);
		return count;
	}
	
	public int QnADelete(int bbs_idx) {
		int count = dao.QnADelete(bbs_idx);
		return count;
	}
	
}
	


package trip.notice.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class NoticeDAOImple implements NoticeDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public int noticeWrite(NoticeDTO dto) {
        return sqlMap.insert("noticeInsert",dto);
    }
	
	public int getNoticeTotalCnt() {
		int count = sqlMap.selectOne("noticeTotalCnt");
		return count;
	}
	
	public List<NoticeDTO> noticeAllList(Map map) {
		List<NoticeDTO> list = sqlMap.selectList("noticeAllList", map);
		return list;
	}
	
	public NoticeDTO noticeContent(int n_idx) {
		NoticeDTO dto = sqlMap.selectOne("noticeContent", n_idx);
		return dto;
	}

	public int noticeReadnum(int n_idx) {
		return sqlMap.update("noticeReadnum", n_idx);
	}

	public List<NoticeDTO> noticePop() {
		List<NoticeDTO> list = sqlMap.selectList("noticePop");
		return list;
	}
	
	public int noticeUpdate(NoticeDTO dto) {
		int count = sqlMap.update("noticeUpdate", dto);
		return count;
	}
	
	public int noticeDelete(int n_idx) {
		int count = sqlMap.delete("noticeDelete",n_idx);
		return count;
	}

}

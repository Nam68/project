package trip.review.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.review.model.ReviewDAO;

public class ReviewServiceImple implements ReviewService {

	@Autowired
	private ReviewDAO dao;
	
	public int reviewWrite(int pl_idx, double star, String review, int idx) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pl_idx", pl_idx);
		map.put("star", star);
		map.put("review", review);
		map.put("idx", idx);
		return dao.reviewWrite(map);
	}

	public List reviewList(int pl_idx) {
		return dao.reviewList(pl_idx);
	}
	
	public int reviewDeleteReq(int r_idx) {
		return dao.reviewDeleteReq(r_idx);
	}
	
	public int reviewDeleteReqCancel(int r_idx) {
		return dao.reviewDeleteReqCancel(r_idx);
	}
	
	public int reviewDelete(int r_idx) {
		return dao.reviewDelete(r_idx);
	}
	
	public List reviewManagerList() {
		return dao.reviewManagerList();
	}

}

package trip.review.service;

import java.util.List;
import java.util.Map;

public interface ReviewService {

	public int reviewWrite(int pl_idx, double star, String review, int idx);
	public List reviewList(int pl_idx);
	public int reviewDeleteReq(int r_idx);
	public int reviewDeleteReqCancel(int r_idx);
	public int reviewDelete(int r_idx);
	public List reviewManagerList();
	
}

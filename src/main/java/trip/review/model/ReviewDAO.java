package trip.review.model;

import java.util.List;
import java.util.Map;

public interface ReviewDAO {
	
	public int reviewWrite(Map<String, Object> map);
	public List reviewList(int pl_idx);
	public int reviewDeleteReq(int r_idx);
	public int reviewDeleteReqCancel(int r_idx);
	public int reviewDelete(int r_idx);
	public List reviewManagerList();
	
	
}

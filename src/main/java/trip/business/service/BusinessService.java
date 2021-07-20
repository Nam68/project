package trip.business.service;

import java.util.List;
import java.util.Map;

public interface BusinessService {
	
	public List businessPlaceList(int idx);
	public int businessPlaceDelete(int pl_idx);
	
	public int businessPlaceInsert(Map<String, Object> param, int idx);
	public int businessPlaceUpdate(Map<String, Object> param, int idx);
	
}

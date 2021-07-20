package trip.business.model;

import java.util.Map;
import java.util.List;

public interface BusinessDAO {
	
	public List businessPlaceList(int idx);
	public int businessPlaceDelete(int pl_idx);
	
	public int businessPlaceInsert(Map<String, Object> map);
	public int businessPlaceUpdate(Map<String, Object> map);
	
	public int placeAllImgDelete(int pl_idx);
}

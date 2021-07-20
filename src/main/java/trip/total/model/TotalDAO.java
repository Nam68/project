package trip.total.model;

import java.util.HashMap;
import java.util.List;

import trip.favorite.model.PlaceFavoriteDTO;

public interface TotalDAO {
	
	public TotalDTO totalSelect(int pl_idx);
	public int totalUpdate(HashMap<String, Integer> map);
	public int cityTotalUPdate(HashMap<String, Integer> map);
	
	//City값 가져오기
	public List getAllcity();
	
	//대표적인 1개 통계값만 가져오기
	public List favoriteTotalRnumSelect(int idx);
	public List cityTotalRnumSelect(int idx);
	public TotalVO totalRnumSelect(int idx);
	
}

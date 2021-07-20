package trip.total.service;

import java.util.HashMap;
import java.util.List;

import trip.favorite.model.PlaceFavoriteDTO;
import trip.total.model.CityTotalDTO;
import trip.total.model.TotalDTO;
import trip.total.model.TotalVO;

public interface TotalService {
	
	public TotalDTO totalSelect(int pl_idx);
	public int updateAllTotal(int pl_idx, int c_idx, int gender, int age);
	
	public List getAllCity();
	
	//대표적인 1개 통계값만 가져오기
	public List favoriteTotalRnumSelect(int idx);
	public List cityTotalRnumSelect(int idx);
	public TotalVO totalRnumSelect(int idx);
		
}

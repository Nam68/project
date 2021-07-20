package trip.total.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import trip.favorite.model.PlaceFavoriteDTO;
import trip.member.service.MemberService;
import trip.total.model.CityTotalDTO;
import trip.total.model.TotalDAO;
import trip.total.model.TotalDTO;
import trip.total.model.TotalVO;

public class TotalServiceImple implements TotalService {

	@Autowired
	private TotalDAO dao;
	
	public TotalServiceImple() {
			
	}
	
	public TotalDTO totalSelect(int pl_idx) {
		return dao.totalSelect(pl_idx);
	}
	
	public int updateAllTotal(int pl_idx, int c_idx, int gender, int age) {
		int result = 0;
		result += totalUpdate(pl_idx, gender, age);
		result += cityTotalUPdate(pl_idx, c_idx);
		return result;
	}
	
	public int cityTotalUPdate(int pl_idx, int c_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", pl_idx);
		map.put("c_idx", c_idx);
		return dao.cityTotalUPdate(map);
	}
	
	public List getAllCity() {
		return dao.getAllcity();
	}

	public int totalUpdate(int pl_idx, int gender, int age) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		TotalDTO tdto = totalSelect(pl_idx);
		map.put("pl_idx", pl_idx);
		if(gender == MemberService.MALE) {
			map.put("male", tdto.getMale()+1);
			map.put("female", tdto.getFemale());
		} else {
			map.put("male", tdto.getMale());
			map.put("female", tdto.getFemale()+1);
		}
		
		map.put("under20", tdto.getUnder20());
		map.put("in30", tdto.getIn30());
		map.put("in40", tdto.getIn40());
		map.put("in50", tdto.getIn50());
		map.put("over60", tdto.getOver60());
		
		switch(age/10) {
		case 0:
		case 1: 
		case 2: map.put("under20", tdto.getUnder20()+1); break;
		case 3: map.put("in30", tdto.getIn30()+1); break;
		case 4: map.put("in40", tdto.getIn40()+1); break;
		case 5: map.put("in50", tdto.getIn50()+1); break;
		case 6: map.put("over60", tdto.getOver60()+1);
		}
		
		return dao.totalUpdate(map);
	}
	
	public List favoriteTotalRnumSelect(int pl_idx) {
		return dao.favoriteTotalRnumSelect(pl_idx);
	}
	
	public List cityTotalRnumSelect(int pl_idx) {
		return dao.cityTotalRnumSelect(pl_idx);
	}
	
	public TotalVO totalRnumSelect(int pl_idx) {
		return dao.totalRnumSelect(pl_idx);
	}

}

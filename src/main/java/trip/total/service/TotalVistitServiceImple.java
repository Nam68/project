package trip.total.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.total.model.TotalVistitDAO;

public class TotalVistitServiceImple implements TotalVistitService {
	
	@Autowired
	TotalVistitDAO dao;

	public int toDay() {
		int count=dao.toDay();
		return count;
	}

	public int totalDay() {
		int count=dao.totalDay();
		return count;
	}

	public int ipSelect(String ip) {
		int idx=dao.ipSelect(ip);
		return idx;
	}

	public int insertTotal(String ip) {
		int count=dao.insertTotal(ip);
		return count;
	}

	public int groupTotal(int type, int idx) {
		Map map=new HashMap();
		map.put("type", type);
		map.put("idx", idx);
		int count=dao.groupTotal(map);
		return count;
	}

	public int groupToday(int type) {
		int count=dao.groupToday(type);
		return count;
	}

	public int groupTotalDay(int type) {
		int count=dao.groupTotalDay(type);
		return count;
	}

	public int typeJointoday(int type) {
		int count=dao.typeJointoday(type);
		return count;
	}

	public int typeAllJoinday(int type) {
		int count=dao.typeAllJoinday(type);
		return count;
	}
	


}

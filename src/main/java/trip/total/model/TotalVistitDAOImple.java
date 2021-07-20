package trip.total.model;

import java.sql.Date;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class TotalVistitDAOImple implements TotalVistitDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int toDay() {
		int count=sql.selectOne("today");
		return count;
	}

	public int totalDay() {
		int count=sql.selectOne("totalday");
		return count;
	}

	public int ipSelect(String ip) {
		System.out.println(ip);
		int idx=0;
		int count=sql.selectOne("ipcount", ip);
		if(count!=0) {
			idx=sql.selectOne("ipselect", ip);
		}
		
		return idx;
	}

	public int insertTotal(String ip) {
		int count=sql.selectOne("inserttotal",ip);
		return count;
	}

	public int groupTotal(Map map) {
		int count=sql.selectOne("grouptotal",map);
		return count;
	}

	public int groupToday(int type) {
		int count=sql.selectOne("typeday",type);
		return count;
	}

	public int groupTotalDay(int type) {
		int count=sql.selectOne("alltimetype",type);
		return count;
	}
	
	public int typeJointoday(int type) {
		int count=sql.selectOne("todayjoin",type);
		return count;
	}
	
	public int typeAllJoinday(int type) {
		int count=sql.selectOne("alldaytype", type);
		return count;
	}
	
	

}

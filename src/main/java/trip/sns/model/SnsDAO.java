package trip.sns.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SnsDAO {
	
	public int snsWrite(Map<String, Object> map);
	public int snsDelete(SnsDTO dto);
	public int snsGood(GoodDTO gdto);
	public List<SnsDTO> snsList(Map map);
	public List<SnsDTO> mySnsList(Map map);
	public int getTotalCount();
	public SnsDTO snsContent(int bbs_idx);
	
	public List bbsAllImgList();
	
	public int addGood(HashMap<String, Integer> map);
	public int deleteGood(HashMap<String, Integer> map);	
	public int goodSelect(int idx);
	//good insert
	public int goodInsert(HashMap<String, Integer> map);
	//good delete
	public int goodDelete(HashMap<String, Integer> map);
	public int goodCount(int bbs_idx);
	public List goodCheck(int idx);
	
}

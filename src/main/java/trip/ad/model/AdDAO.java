package trip.ad.model;

import java.util.List;
import java.util.Map;

public interface AdDAO {
	
	public List adList(int idx);
	public int adSubmit(Map<String, Object> map);
	public AdDTO adSelect(int a_idx);
	public List adImgList(int bbs_idx);
	public int adAllImgDelete(int bbs_idx);
	public int adUPdate(Map<String, Object> map);
	public int adDelete(int a_idx);
	
	public AdDTO adListForSns();
	public int adCountUpdate(int bbs_idx);
	
	
	
	//추가
		public List adManagerList(int cp);
		public int adCount();
		public int permitUpdate(Map<String, Integer> map);
		public int permitDelete(Map<String, Integer> map);
		
	
	
	
	//admin 광고값 받아오기
	public int adsPay();
	
	//ads_pay bbs_idx,pay 정보 ads_pay등록 등록
	public int adsCount(Map map);
	
	//선택 년도의 정보 출력
	public int adsTotal(Map map);
}

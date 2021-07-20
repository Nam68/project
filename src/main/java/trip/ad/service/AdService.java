package trip.ad.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import trip.ad.model.AdDTO;
import trip.ad.model.AdVO;
import trip.img.model.BbsImgDTO;

public interface AdService {
	
	public List adList(int idx);
	public int adSubmit(Map<String, Object> param, int idx);
	public AdDTO adSelect(int a_idx);
	public List adImgList(int bbs_idx);
	public int adAllImgDelete(int bbs_idx);
	public int adUpdate(Map<String, Object> param, int idx);
	public int adDelete(int a_idx);
	
	public ArrayList<String> getPaths(List<BbsImgDTO> list);
	public List<AdVO> removeDuplication(List<AdVO> list);
	
	
	public AdDTO adListForSns();
	public int adCountUpdate(int bbs_idx);
	
	
	public List adManagerList(int cp);
	public int adCount();
	public int permitUpdate(int a_idx);
	public int permitDelete(int a_idx);
	
	
	
	
	//admin 광고값 받아오기
	public int adsPay();
	
	//ads_pay bbs_idx,pay 정보 ads_pay등록 등록
	public int adsCount(int idx,int pay);
		
	//선택 년도의 정보 출력
	public List adsTotal(String year);
	
	//1월
	public int Jan(String year);
	//2월
	public int Feb(String year);
	//3월
	public int Mar(String year);
	//4월
	public int Apr(String year);
	//5월
	public int May(String year);
	//6월
	public int Jun(String year);
	//7월
	public int Jul(String year);
	//8월
	public int Aug(String year);
	//9월
	public int Sept(String year);
	//10월
	public int Oct(String year);
	//11월
	public int Nov(String year);
	//12월
	public int Dec(String year);
}	

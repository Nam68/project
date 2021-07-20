package trip.ad.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.ad.model.AdDAO;
import trip.ad.model.AdDTO;
import trip.ad.model.AdVO;
import trip.img.model.BbsImgDTO;
import trip.img.service.ImgService;

public class AdServiceImple implements AdService {
	
	@Autowired
	private AdDAO dao;
	@Autowired
	private ImgService i_service;
	
	public AdServiceImple() {
		
	}
	
	public List adList(int idx) {
		List<AdVO> list = dao.adList(idx);
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		for(AdVO temp : list) {
			long start = temp.getA_startdate().getTime();
			long end = temp.getA_enddate().getTime();
			long day = end - start;
			if(day < 0) {
				temp.setLeftdate("미정");
				continue;
			}
			temp.setLeftdate(sdf.format(day));
		}		
		return list;
	}

	public AdDTO adSelect(int a_idx) {
		return dao.adSelect(a_idx);
	}
	
	public List adImgList(int bbs_idx) {
		return dao.adImgList(bbs_idx);
	}
	
	public int adAllImgDelete(int bbs_idx) {
		return dao.adAllImgDelete(bbs_idx);
	}
	
	public int adUpdate(Map<String, Object> param, int idx) {
		int bbs_idx = (Integer) param.get("bbs_idx");
		dao.adAllImgDelete(bbs_idx); //DB 내 bbsImg 테이블에서 관련 로우 삭제
		
		ArrayList<String> bbs_img = (ArrayList<String>) param.get("bbs_img");
		i_service.removeAllFile(bbs_img); //서버 내 img폴더에 저장된 이미지를 전부 삭제
		
		ArrayList<String> imgList = i_service.adImgSubmit(idx);
		param.put("imgList", imgList); //임시 폴더에 있던 파일을 새롭게 img에 집어넣고 관련 경로를 당음
		
		return dao.adUPdate(param);
	}
	
	public int adDelete(int a_idx) {
		return dao.adDelete(a_idx);
	}
	
	
	public int adSubmit(Map<String, Object> param, int idx) {
		ArrayList<String> bbs_img = i_service.adImgSubmit(idx);
		param.put("imgList", bbs_img);
		param.put("a_wirter", idx);
		return dao.adSubmit(param);
	}
	
	/** img의 이미지 파일을 임시 폴더로 옮기기 위한 경로를 모아서 반환(이를 토대로 이미지서비스에서 실제 파일을 옮기도록 유도) */
	public ArrayList<String> getPaths(List<BbsImgDTO> list) {
		ArrayList<String> result = new ArrayList<String>();
		for(BbsImgDTO temp : list) result.add(temp.getBbs_img());
		return result;
	}
	
	/** 광고 리스트에서 중복되는 결과값 삭제 */
	public List<AdVO> removeDuplication(List<AdVO> list) {
		HashMap<Integer, AdVO> map = new HashMap<Integer, AdVO>();
		List<AdVO> result = new ArrayList<AdVO>();
		for(AdVO temp : list) {
			if(map.get(temp.getA_idx()) == null) {
				map.put(temp.getA_idx(), temp);
				result.add(temp);
			}
		}
		return result;
	}
	
	
	public AdDTO adListForSns() {
		return dao.adListForSns();
	}
	
	public int adCountUpdate(int bbs_idx) {
		return dao.adCountUpdate(bbs_idx);
	}
	
	
	
	/**추가**/
	   public List adManagerList(int cp) {
	      return dao.adManagerList(cp);
	   }

	   public int adCount() {
	      return dao.adCount();
	   }

	   public int permitUpdate(int a_idx) {
	      HashMap<String, Integer> map= new HashMap<String, Integer>();
	      map.put("a_idx", a_idx);
	      return dao.permitUpdate(map);
	   }

	   public int permitDelete(int a_idx) {
	      HashMap<String, Integer> map= new HashMap<String, Integer>();
	      map.put("a_idx", a_idx);
	      return dao.permitDelete(map);
	   }
	
	
	
	
	
	public int adsPay() {
		int count=dao.adsPay();
		return count;
	}

	public int adsCount(int idx,int pay) {
		Map map=new HashMap();
		map.put("bbs_idx", idx);
		map.put("pay", pay);
		int count=dao.adsCount(map);
		return count;
	}

	public List adsTotal(String year) {
		return null;
	}
	
	
	
	
	
	//1월
	public int Jan(String year) {
		Map map=new HashMap();
		map.put("start", year+"-01-01");
		map.put("end", year+"-01-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//2월
	public int Feb(String year) {
		Map map=new HashMap();
		map.put("start", year+"-02-01");
		map.put("end", year+"-02-28");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//3월
	public int Mar(String year) {
		Map map=new HashMap();
		map.put("start", year+"-03-01");
		map.put("end", year+"-03-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//4월
	public int Apr(String year) {
		Map map=new HashMap();
		map.put("start", year+"-04-01");
		map.put("end", year+"-04-30");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//5월
	public int May(String year) {
		Map map=new HashMap();
		map.put("start", year+"-05-01");
		map.put("end", year+"-05-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//6월
	public int Jun(String year) {
		Map map=new HashMap();
		map.put("start", year+"-06-01");
		map.put("end", year+"-06-30");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//7월
	public int Jul(String year) {
		Map map=new HashMap();
		map.put("start", year+"-07-01");
		map.put("end", year+"-07-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//8월
	public int Aug(String year) {
		Map map=new HashMap();
		map.put("start", year+"-08-01");
		map.put("end", year+"-08-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//9월
	public int Sept(String year) {
		Map map=new HashMap();
		map.put("start", year+"-09-01");
		map.put("end", year+"-09-30");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//10월
	public int Oct(String year) {
		Map map=new HashMap();
		map.put("start", year+"-10-01");
		map.put("end", year+"-10-31");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//11월
	public int Nov(String year) {
		Map map=new HashMap();
		map.put("start", year+"-11-01");
		map.put("end", year+"-11-30");
		
		int list=dao.adsTotal(map);
		return list;
	}
	//12월
	public int Dec(String year) {
		Map map=new HashMap();
		map.put("start", year+"-12-01");
		map.put("end", year+"-12-31");
		
		int list=dao.adsTotal(map);
		return list;
	}

}

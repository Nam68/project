package trip.planbbs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.planbbs.model.PlanBbsDAO;
import trip.planbbs.model.PlanBbsVO;

public class PlanBbsServiceImple implements PlanBbsService {
	
	@Autowired
	private PlanBbsDAO dao;
	
	public PlanBbsServiceImple() {
		
	}
	
	public List PlanListForm(int idx, int p_idx, int day, int cp) {
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		map.put("cp", cp);
		map.put("idx", idx);
		map.put("p_idx", p_idx);
		map.put("day", day);
		return dao.PlanListForm(map);
	}

	public int dayChange(int p_idx) {
		return dao.dayChange(p_idx);
	}

	public int getTotalCnt(int p_idx, int day) {
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		map.put("p_idx",p_idx);
		map.put("day", day);
		return dao.getTotalCnt(map);
	}

	public int imgChage(int p_idx, int pl_idx, String img) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List planModi1(int p_idx) {
		// TODO Auto-generated method stub
		return null;
	}

	public int planbbsInsert(PlanBbsVO vo) {
		return dao.planbbsInsert(vo);
	}

	public List myPlanListView(int p_idx, int idx, int day) {
		HashMap<String,Integer>map = new HashMap<String, Integer>();
		map.put("p_idx",p_idx);
		map.put("idx", idx);
		map.put("day", day);
		return dao.myPlanListView(map);
	}

	public int planBbsCount(String plan_writer) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List myPlanBbsListView(String plan_writer,int cp) {
			HashMap<String, Object>map=new HashMap<String, Object>();
			map.put("plan_writer", plan_writer);
			map.put("cp",cp);
			return dao.myPlanBbsListView(map);
		
	}

	public List myPlanBbsListContent(String plan_writer, int bbs_idx) {
		HashMap<String, Object>map= new HashMap<String, Object>();
		map.put("plan_writer", plan_writer);
		map.put("bbs_idx", bbs_idx);
		return dao.myPlanBbsListContent(map);
	}

	public int goodCount(int bbs_idx) {
		return dao.goodCount(bbs_idx);
	}

	public List planbbsContent2(int p_idx, int bbs_idx, int day) {
		HashMap<String, Integer>map= new HashMap<String,Integer>();
		map.put("p_idx", p_idx);
		map.put("bbs_idx", bbs_idx);
		map.put("day", day);
		return dao.planbbsContent2(map);
	}

	public int goodInsert(int idx, int bbs_idx) {
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx",bbs_idx);
		return dao.goodInsert(map);
	}

	public int goodDelete(int idx, int bbs_idx) {
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx",bbs_idx);
		return dao.goodDelete(map);
	}

	public PlanBbsVO goodSelect(int idx, int bbs_idx) {
		HashMap<String,Integer> map= new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx",bbs_idx);
		return dao.goodSelect(map);
	}

	public int planbbsDelete(int bbs_idx) {
		return dao.planbbsDelete(bbs_idx);
	}

	public List planbbsIdCheck(int bbs_idx) {
		HashMap<String,Integer>map=new HashMap<String, Integer>();
		map.put("bbs_idx", bbs_idx);
		return dao.allPlanList(bbs_idx);
	}

	public int planbbsModi(int bbs_idx, String plan_content) {
		HashMap<String, Object>map= new HashMap<String, Object>();
		map.put("bbs_idx", bbs_idx);
		map.put("plan_content", plan_content);
		return dao.planbbsModi(map);
	}

	public List planbbsModiImg(int bbs_idx, int cp, int day) {
		HashMap<String,Integer>map=new HashMap<String, Integer>();
		map.put("bbs_idx", bbs_idx);
		map.put("day", day);
		map.put("cp", cp);
		return dao.planbbsModiImg(map);
	}

	public int planbbsImgModiCount(int bbs_idx, int day) {
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("bbs_idx", bbs_idx);
		map.put("day", day);
		return dao.planbbsImgModiCount(map);
	}

	public int planbbsModiCount(int bbs_idx) {
		HashMap<String, Integer>map=new HashMap<String, Integer>();
		map.put("bbs_idx", bbs_idx);
		return dao.planbbsModiCount(map);
	}

	public PlanBbsVO planBbsContent(int bbs_idx) {
		PlanBbsVO vo = dao.planBbsContent(bbs_idx);
		return vo;
	}

	public List allPlanList(int cp) {
		List list=dao.allPlanList(cp);
		System.out.println(list);
		return list;
	}

	public int allPlanCount() {
		int count =dao.allPlanCount();
		return count;
	}
	
	
	public int planInfoImgUpdate(int p_idx, int pl_idx, int day, String img) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("p_idx", p_idx);
		map.put("pl_idx", pl_idx);
		map.put("day", day);
		map.put("img", img);
		return dao.planInfoImgUpdate(map);
	}

}

package trip.planbbs.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

public class PlanBbsDAOImple implements PlanBbsDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public PlanBbsDAOImple() {
		
	}

	
	//남은이 장바구니에서 넘겨받았을 때 처음 나오는페이지 플랜리스트 나열
		public List PlanListForm(Map<String, Integer> map) {
			List list= sqlMap.selectList("myplanList", map);
			return list;
		}

		//day처리
		public int dayChange(int p_idx) {
			int day=sqlMap.selectOne("dayChange",p_idx);
			return day;
		}


		public int getTotalCnt(Map<String, Integer> map) {
			int count=sqlMap.selectOne("getTotalCnt",map);
			return count;
		}


		public int imgChage(int p_idx, int pl_idx, String img) {
			
			HashMap<String,Object> map= new HashMap<String, Object>();
			map.put("p_idx", p_idx);
			map.put("pl_idx", pl_idx);
			map.put("img",img);
			
			int count=sqlMap.update("planImgChange", map);
			return count;
			
		}


		public List planModi1(int p_idx) {
			
			List planList= sqlMap.selectOne("planModi1",p_idx);
			return planList;
		}


		public int planbbsInsert(PlanBbsVO vo) {
			int count=sqlMap.insert("planbbsInsert", vo);
			return count;
		}


		public List myPlanListView(Map<String, Integer> map) {
			List myplanList=sqlMap.selectList("myplanListView",map);
			return myplanList;
		}


		//myplanbbs부분 총카운트
		public int planBbsCount(String plan_writer) {
			HashMap<String, String>map=new HashMap<String, String>();
			map.put("plan_writer", plan_writer);
			int count=sqlMap.selectOne("myplanBbsTotal",map);
			return count;
		
		}

		//myplanbbs리스트 
		public List myPlanBbsListView(Map<String, Object> map) {
			List myplanBbsList =sqlMap.selectList("myplanBbsListView", map);
			return myplanBbsList;
		}

		//플랜bbs컨텐츠자세히
		public List myPlanBbsListContent(Map<String, Object> map) {
			List myPlanbbsListContent= sqlMap.selectList("myPlanBbsContent", map);
			return myPlanbbsListContent;
		}

		//좋아요 갯수
		public int goodCount(int bbs_idx) {
			int count=sqlMap.selectOne("goodCount",bbs_idx);
			return count;
		}

		//plancontentbbs2
		public List planbbsContent2(Map<String, Integer> map) {
			List planbbsresult=sqlMap.selectList("myplanbbsContent2", map);
			return planbbsresult;
		}

		//좋아요 insert
		public int goodInsert(Map<String, Integer> map) {
			int count=sqlMap.insert("goodInsert",map);
			return count;
			
		}

		
		public int goodDelete(Map<String, Integer> map) {
			int count=sqlMap.insert("goodDelete",map);
			return count;
		}


		public PlanBbsVO goodSelect(Map<String, Integer> map) {
			PlanBbsVO goodList=sqlMap.selectOne("goodselect",map);
			return goodList;
			
		}

		//삭제
		public int planbbsDelete(int bbs_idx) {
			int count=sqlMap.delete("planbbsDelete", bbs_idx);
			return count;
		}

		//id확인
		public List planbbsIdCheck(int bbs_idx) {
			List vo=sqlMap.selectOne("planbbsIdCheck", bbs_idx);
			return vo;
		}

		//게시글 수정
		public int planbbsModi(Map<String, Object> map) {
			int count=sqlMap.update("planbbsModi", map);
			return count;
		}
		
		//추가
		public List planbbsModiImg(Map<String, Integer> map) {
			return sqlMap.selectList("planbbsModiImg", map);
		}


		public int planbbsImgModiCount(Map<String, Integer> map) {
			return sqlMap.selectOne("planbbsImgModiCount",map);
		}


		public int planbbsModiCount(Map<String, Integer> map) {
			return sqlMap.selectOne("planbbsModidayCount", map);
		}
		
		
	public PlanBbsVO planBbsContent(int bbs_idx) {
		PlanBbsVO vo = sqlMap.selectOne("planBbsContent", bbs_idx);
		return vo;
	}


	public List allPlanList(int cp) {
		List allplanList=sqlMap.selectList("allPlanList",cp);
		return allplanList;
	}


	public int allPlanCount() {
		int count=sqlMap.selectOne("allPlanCount");
		return count;
	}
	
	public int planInfoImgUpdate(Map<String, Object> map) {
		return sqlMap.update("planInfoImgUpdate", map);
	}

}

package trip.planbbs.model;

import java.util.*;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

public interface PlanBbsDAO {
	
	//아이디랑 플랜넘버랑 데이값 넘기기 planlistform으로 보내준다.
		public List PlanListForm(Map<String, Integer> map);
		//날짜조절
		public int dayChange(int p_idx);
		//총게시글 수 카운트
		public int getTotalCnt(Map<String, Integer> map);
		public int imgChage(int p_idx, int pl_idx, String img);
		//플랜 bbs전 내용물 가져오기위해..
		public List planModi1(int p_idx);
		//플랜bbs insert
		public int planbbsInsert(PlanBbsVO vo);
		//내 플랜리스트 나열
		public List myPlanListView(Map<String, Integer> map);
		//planBbs list 나열할때 페이징하기위한 카운트
		public int planBbsCount(String plan_writer);
		//planSnsList나열
		public List myPlanBbsListView(Map<String, Object> map);
		//planSnsContent자세히보기
		public List myPlanBbsListContent(Map<String, Object> map);
		//좋아요
		public int goodCount(int bbs_idx);
		//내컨텐츠 리스트출력
		public List planbbsContent2(Map<String, Integer> map);
		//좋아요 insert
		public int goodInsert(Map<String, Integer> map);
		//좋아요 delete
		public int goodDelete(Map<String, Integer> map);
		//좋아요 select
		public PlanBbsVO goodSelect(Map<String, Integer> map);
		//게시글삭제
		public int planbbsDelete(int bbs_idx);
		//게시글 작성자 확인
		public List planbbsIdCheck(int bbs_idx);
		//게시글 수정
		public int planbbsModi(Map<String, Object> map);
		
		//댓글
		public PlanBbsVO planBbsContent(int bbs_idx);
		
		//추가
		//페이징
		public List planbbsModiImg(Map<String, Integer> map);
		public int planbbsImgModiCount(Map<String,Integer>map);
		public int planbbsModiCount(Map<String,Integer>map);
		public List allPlanList(int cp);
		public int allPlanCount();
		
		
		public int planInfoImgUpdate(Map<String, Object> map);
}

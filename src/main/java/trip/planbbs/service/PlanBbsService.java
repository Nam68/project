package trip.planbbs.service;

import java.util.List;

import trip.planbbs.model.PlanBbsVO;

public interface PlanBbsService {
	
	//�븘�씠�뵒�옉 �뵆�옖�꽆踰꾨옉 �뜲�씠媛� �꽆湲곌린 planlistform�쑝濡� 蹂대궡以��떎.
	public List PlanListForm(int idx,int p_idx, int day,int cp);
	//�궇吏쒖“�젅
	public int dayChange(int p_idx);
	//珥앷쾶�떆湲� �닔 移댁슫�듃
	public int getTotalCnt(int p_idx, int day);
	public int imgChage(int p_idx, int pl_idx, String img);
	//�뵆�옖 bbs�쟾 �궡�슜臾� 媛��졇�삤湲곗쐞�빐..
	public List planModi1(int p_idx);
	//�뵆�옖bbs insert
	public int planbbsInsert(PlanBbsVO vo);
	//�궡 �뵆�옖由ъ뒪�듃 �굹�뿴
	public List myPlanListView(int p_idx , int idx, int day);
	//planBbs list �굹�뿴�븷�븣 �럹�씠吏뺥븯湲곗쐞�븳 移댁슫�듃
	public int planBbsCount(String plan_writer);
	//planSnsList�굹�뿴
	public List myPlanBbsListView(String plan_writer,int cp);
	//planSnsContent�옄�꽭�엳蹂닿린
	public List myPlanBbsListContent(String plan_writer,int bbs_idx);
	//醫뗭븘�슂
	public int goodCount(int bbs_idx);
	//�궡而⑦뀗痢� 由ъ뒪�듃異쒕젰
	public List planbbsContent2(int p_idx,int bbs_idx,int day);
	//醫뗭븘�슂 insert
	public int goodInsert(int idx, int bbs_idx);
	//醫뗭븘�슂 delete
	public int goodDelete(int idx, int bbs_idx);
	//醫뗭븘�슂 select
	public PlanBbsVO goodSelect(int idx, int bbs_idx);
	//planbbs delete 
	public int planbbsDelete(int bbs_idx);
	//planbbsIdCheck
	public List planbbsIdCheck(int bbs_idx);
	public int planbbsModi(int bbs_idx,String plan_content);
	
	//추가
	public List planbbsModiImg(int bbs_idx, int cp, int day);
	public int planbbsImgModiCount(int bbs_idx,int day);
	public int planbbsModiCount(int bbs_idx);

	public PlanBbsVO planBbsContent(int bbs_idx);
	public List allPlanList(int cp);
	public int allPlanCount();
	
	
	
	public int planInfoImgUpdate(int p_idx, int pl_idx, int day, String img);
}

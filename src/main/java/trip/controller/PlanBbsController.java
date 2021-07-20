package trip.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import min.page.PageModule;
import trip.comment.model.CommentVO;
import trip.comment.service.CommentService;
import trip.member.model.MemberDTO;
import trip.planbbs.model.PlanBbsDAO;
import trip.planbbs.model.PlanBbsVO;
import trip.planbbs.service.PlanBbsService;

import java.io.*;

@Controller
public class PlanBbsController {
	
	@Autowired
	private PlanBbsService pb_service;
	@Autowired
	private CommentService c_service;
	
	//내플랜보기로 이동
		@RequestMapping("/myPlanList.do")
		public String planList() {
			return "planbbs/planList";
		}
		
		//플랜 day별로 볼수 있는 폼으로
		@RequestMapping("/planListForm.do")
		public ModelAndView planListForm(String plan_title, int p_idx, @RequestParam(value = "day", defaultValue = "1") int day, @RequestParam(value="cp",defaultValue = "1")int cp, HttpSession session) {
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberDTO");
			
			int idx = memberDTO.getIdx();
			String plan_writer = memberDTO.getName();
			
			int days=pb_service.dayChange(p_idx);
			
			List planList=pb_service.PlanListForm(idx, p_idx, day,cp);
			
			ModelAndView mav= new ModelAndView();
			
			if(planList!=null) {
				mav.addObject("days", days);
				mav.addObject("planList",planList);
				mav.addObject("p_idx",p_idx);
				mav.setViewName("planbbs/planListForm");
			}
			return mav;
		}
		
		//플랜 데이별로 클릭시 보이는...
		@RequestMapping(value = "/day.do", produces = "text/pain;charset=utf-8")
		@ResponseBody
		public ModelAndView planListChange(int p_idx, int day, @RequestParam(value="cp",defaultValue = "1")int cp, HttpSession session) {
			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			
			List planList=pb_service.PlanListForm(idx, p_idx, day,cp);
			
			ModelAndView mav= new ModelAndView();
			int totalCnt=pb_service.getTotalCnt(p_idx, day);
			int listSize=1;
			int pageSize=1;

			String pageStr=min.page.PageModule
					.makePage(totalCnt, listSize, pageSize, cp, day, p_idx);
			if(planList!=null) {
				mav.addObject("pageStr",pageStr);
				mav.addObject("planList",planList);
				mav.setViewName("planbbs/planListResult");
				
			}else {
				mav.addObject("writer", false);
				mav.addObject("msg","삭제할수없습니다.");
				mav.setViewName("planbbs/planBbsOk");
			}
			return mav;
			
		}
		
		
		//플랜저장
		@RequestMapping("/planBbsInsert.do")
		public ModelAndView planbbsInsert(PlanBbsVO vo) {
			
			int count=pb_service.planbbsInsert(vo);
			ModelAndView mav= new ModelAndView();
			if(count>0) {
				mav.addObject("plan_title",vo.getPlan_title());
				mav.addObject("plan_content", vo.getPlan_content());
				mav.addObject("plan_writer", vo.getPlan_writer());
				mav.addObject("p_idx", vo.getP_idx());
				mav.addObject("msg", "게시글 등록 성공");
				mav.setViewName("planbbs/planBbsOk");
			}else {
				mav.addObject("msg", "게시글 등록실패");
				mav.setViewName("planbbs/planBbsOk");
			}
			
			return mav;
		}
		
		
		//내플랜리스트 보기
		@RequestMapping("/myPlanListView.do")
		public ModelAndView myPlanListView(int p_idx, @RequestParam(value = "day", defaultValue = "1") int day, HttpSession session) {
			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			List myplanList=pb_service.myPlanListView(p_idx, idx, day);
			int days=pb_service.dayChange(p_idx);
			ModelAndView mav= new ModelAndView();
			if(myplanList != null) {
				mav.addObject("days", days);
				mav.addObject("myplanList", myplanList);
				mav.setViewName("planbbs/myplanList");
			}
			
			return mav;
		
		}
		
		//ajax로 처리될 부분
		@RequestMapping(value="/myplanListViewResult.do" , produces = "text/pain;charset=utf-8")
		@ResponseBody
		public ModelAndView myplanListViewResult(int p_idx, int day, HttpSession session) {
			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			List myplanList=pb_service.myPlanListView(p_idx, idx, day);

			ModelAndView mav= new ModelAndView();
			if(myplanList != null) {
				
				mav.addObject("myplanList", myplanList);
				mav.setViewName("planbbs/myplanList2");
			}
			
			return mav;
		
		}

		@RequestMapping("/myPlanBbsSns.do")
		public ModelAndView myPlanBbsSns(@RequestParam("plan_writer")String plan_writer,@RequestParam(value = "day", defaultValue = "1")int cp) {
			
			ModelAndView mav= new ModelAndView();
			List myplanBbsList=pb_service.myPlanBbsListView(plan_writer,cp);
			int totalCnt=pb_service.allPlanCount();
			System.out.println(totalCnt);
			int listSize=3;
			int pageSize=1;
			String pageStr=min.page.PageModule5
					.makePaging(plan_writer, totalCnt, listSize, pageSize, cp, plan_writer);
			if(myplanBbsList!=null) {
				mav.addObject("pageStr", pageStr);
				mav.addObject("plan_writer",plan_writer);
				mav.addObject("myplanBbsList", myplanBbsList);
				mav.setViewName("planbbs/myPlanBbsSns");
				
			}
			
			return mav;
		}
		
		
		@RequestMapping("/myPlanBbsContent.do")
		public ModelAndView myplanbbsContent(String plan_writer, int bbs_idx, int p_idx, HttpSession session) {
			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			ModelAndView mav= new ModelAndView();
			List myplanContentList= pb_service.myPlanBbsListContent(plan_writer, bbs_idx);
			int count=pb_service.goodCount(bbs_idx);
			int days=pb_service.dayChange(p_idx);
			List vo= pb_service.planbbsIdCheck(bbs_idx);
			PlanBbsVO goodList=pb_service.goodSelect(idx, bbs_idx);
			
			if(myplanContentList!=null) {
				mav.addObject("days",days);
				mav.addObject("count",count);
				mav.addObject("plan_writer",plan_writer);
				mav.addObject("bbs_idx",bbs_idx);
				List myplanContentList2=pb_service.planbbsContent2(p_idx, bbs_idx, 1);
				mav.addObject("myplanContentList", myplanContentList2);
				mav.addObject("idCheck",vo);
				if(goodList !=null) {
					mav.addObject("goodselect", true);
				} else {
					mav.addObject("goodselect", false);
				}
				if(vo!=null) {
					mav.addObject("writer", true);
					mav.addObject("msg","삭제되었습니다.");
					mav.setViewName("planbbs/planBbsOk");
				}else {
					
				}
				mav.setViewName("planbbs/planbbsContent");
			}
			return mav;
			
		}
		
		@RequestMapping("/day2.do")
		public ModelAndView planbbsContent2(int bbs_idx, int p_idx, int day) {
			
			ModelAndView mav= new ModelAndView();
			List myplanContentList2=pb_service.planbbsContent2(p_idx, bbs_idx, day);
			
			if(myplanContentList2 !=null) {
				mav.addObject("myplanContentList2", myplanContentList2);
				mav.setViewName("planbbs/planbbsContent2");
			}
			
			return mav;
				
		}
		
		//좋아요 insert
		@RequestMapping("/goodInsert.do")
		public ModelAndView goodInsert(int bbs_idx, HttpSession session) {

			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			ModelAndView mav= new ModelAndView();
			int count = pb_service.goodInsert(idx, bbs_idx);
			if(count>0) {
				mav.addObject("msg", "좋아요성공");
				mav.setViewName("planbbs/planBbsOk");
			}else {
				mav.addObject("msg", "좋아요실패");
				mav.setViewName("planbbs/planBbsOk");
			}
			return mav;
		}
		
		//좋아요 delete
		@RequestMapping("/goodDelete.do")
		public ModelAndView goodDelete(int bbs_idx, HttpSession session) {
			int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			ModelAndView mav= new ModelAndView();
			int count=pb_service.goodDelete(idx, bbs_idx);
			if(count>0) {
				mav.addObject("msg", "좋아요취소성공");
				mav.setViewName("planbbs/planBbsOk");
			}else {
				mav.addObject("msg", "좋아요취소실패");
				mav.setViewName("planbbs/planBbsOk");
			}
			return mav;
		}
		
		//플랜삭제
		@RequestMapping("/planbbsDelete.do")
		public ModelAndView bbsContentDelete(int bbs_idx,HttpSession session) {
			int idxs=((MemberDTO) session.getAttribute("memberDTO")).getIdx();
			ModelAndView mav= new ModelAndView();
			int count=pb_service.planbbsDelete(bbs_idx);
			if(count>0) {
				 mav.addObject("msg", "삭제되었습니다.");
				 mav.setViewName("planbbs/planBbsOk");
			}else {
				mav.addObject("msg", "삭제할 수 없습니다.");
				 mav.setViewName("planbbs/planBbsOk");
			}
			return mav;
		}
		
		//플랜수정
		@RequestMapping("/planModi.do")
		public ModelAndView planbbsModi(String plan_title, int p_idx, @RequestParam(value = "day", defaultValue = "1") int day, @RequestParam(value="cp",defaultValue = "1")int cp, HttpSession session) {
			MemberDTO memberDTO = (MemberDTO) session.getAttribute("memberDTO");
			
			int idx = memberDTO.getIdx();
			String plan_writer = memberDTO.getName();
			
			int days=pb_service.dayChange(p_idx);
			
			List planList=pb_service.PlanListForm(idx, p_idx, day,cp);
			
			ModelAndView mav= new ModelAndView();
			
			if(planList!=null) {
				mav.addObject("days", days);
				mav.addObject("planList",planList);
				mav.addObject("p_idx",p_idx);
				mav.setViewName("planbbs/planBbsModi");
			}
			return mav;
		}
		@RequestMapping("/planBbsModi2.do")
		public ModelAndView planbbsModi2(String plan_content,int bbs_idx) {
			ModelAndView mav= new ModelAndView();
			int count=pb_service.planbbsModi(bbs_idx, plan_content);
			System.out.println(count);
			if(count>0) {
				mav.addObject("msg", "게시글이 수정되었습니다.");
				mav.setViewName("planbbs/modiMsg");
			}else {
				mav.addObject("msg", "게시글수정에 실패하였습니다.");
				mav.setViewName("planbbs/modiMsg");
			}
			return mav;
		}
		
		@RequestMapping("/allplanList.do")
		public ModelAndView allplanList(@RequestParam(value="cp",defaultValue = "1")int cp) {

			ModelAndView mav= new ModelAndView();
			List list=pb_service.allPlanList(cp);
			int totalCnt=pb_service.allPlanCount();
			System.out.println(totalCnt);
			int listSize=3;
			int pageSize=1;

			String pageStr=min.page.PageModule3
					.makePaging("allplanList.do", totalCnt, listSize, pageSize, cp);
					
			mav.addObject("allplanList", list);
			mav.setViewName("planbbs/allPlanList");
			mav.addObject("pageStr", pageStr);
			return mav;
		}
		
		
		@RequestMapping("/planBbsComment.do")
		   public ModelAndView planBbsContent(@RequestParam("bbs_idx") int bbs_idx) {
		      PlanBbsVO vo = pb_service.planBbsContent(bbs_idx);
		      List<CommentVO> list = c_service.comment(bbs_idx);

		      ModelAndView mav = new ModelAndView();
		      if (vo != null) {
		         mav.addObject("vo", vo);
		         mav.setViewName("planbbs/planBbsComment");
		         mav.addObject("clists", list);
		      } else {
		         mav.addObject("msg", "잘못된 접근또는 삭제된 게시글입니다.");
		         mav.setViewName("sns/snsMsg");
		      }
		      return mav;
		   }

}




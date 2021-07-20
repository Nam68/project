package trip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import trip.comment.model.CommentVO;
import trip.comment.service.CommentService;
import trip.member.model.MemberDTO;
import trip.sns.model.SnsDTO;
import trip.sns.service.SnsService;

@RestController
@RequestMapping("/*")
public class CommentController {

	@Autowired
	private CommentService commentService;
	@Autowired
	private SnsService snsService;
	
	@Autowired
	private trip.comment.service.CommentService c_Service;
	
	@RequestMapping(value = "/addComment.do", method = RequestMethod.GET)
	public ModelAndView commentForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;

	}

	@RequestMapping(value = "/addComment.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCommentSubmit(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			CommentVO vo, @RequestParam("bbs_idx") int bbs_idx) {
		String sns_writer = ((MemberDTO) session.getAttribute("memberDTO")).getId();
		int result = commentService.addComment(vo);
		String msg = result > 0 ? "작성 성공!" : "작성 실패!";
		SnsDTO dto = snsService.snsContent(bbs_idx);
		List<CommentVO> list = commentService.comment(bbs_idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("sns_writer", sns_writer);
		mav.addObject("msg", msg);
		mav.setViewName("sns/snsMsg");
		mav.addObject("dto", dto);
		mav.addObject("clists", list);
		mav.setViewName("sns/comment");
		return mav;
	}
	
	//댓글 작성
    @RequestMapping(value ="/addAdminComment.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addCommentSubmit(CommentVO vo, int bbs_idx) {
		int result = commentService.addComment(vo);
		int idx = vo.getBbs_idx();
		List<trip.comment.model.CommentVO> list = c_Service.commentList(bbs_idx);
		String msg = result > 0 ? "댓글 작성 성공!" : "댓글 작성 실패!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("bbs_idx", idx);
		mav.addObject("clist", list);
		mav.addObject("msg", msg);
		mav.setViewName("customer/user/userQnACommentMsg");
		return mav;
	}
    
	//댓글 삭제
	@RequestMapping("/commentDelete.do")
	public ModelAndView commentDelete(int c_idx) {
		int result=c_Service.commentDelete(c_idx);
		String msg=result>0?"댓글을 삭제하였습니다.!":"댓글을 삭제하지 못했습니다.!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("customer/user/userQnACommentMsg2");
		return mav;
	}
	
	//댓글 수정 폼
	@RequestMapping(value = "/commentUpdate.do", method = RequestMethod.GET)
	public String commentUpdateForm(@RequestParam("c_idx")int c_idx, Model mo) {
		List<trip.comment.model.CommentVO> dto = c_Service.commentList(c_idx);
		mo.addAttribute("dto",dto);
		return "customer/user/userCommentUpdate";
	}
	
	//댓글 수정
	@RequestMapping(value = "/commentUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView QnAUpdate(trip.comment.model.CommentVO vo) {
		int result = c_Service.commentUpdate(vo);
		int idx = vo.getC_idx();
		String msg = result>0?"게시글이 성공적으로 수정되었습니다.":"게시글 수정에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("c_idx", idx);
		mav.addObject("msg", msg);
		mav.setViewName("customer/user/userCommentMsg2");
		return mav;
	}
}

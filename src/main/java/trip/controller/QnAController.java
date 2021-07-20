package trip.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import trip.comment.model.CommentVO;
import trip.comment.service.CommentService;
import trip.qna.model.QnADTO;
import trip.qna.service.QnAService;

@Controller
public class QnAController {

	@Autowired
	QnAService qser;
	@Autowired
	CommentService cser;
	
	//글 목록
	@RequestMapping("/userQnAList.do")
	public ModelAndView userAllList(@RequestParam(value = "cp", defaultValue = "1")int cp) {
	
		int totalCnt = qser.getQnATotalCnt();
		int listSize=5;
		int pageSize=5;
		
		String pageStr=trip.page.PageModule.makePage("userQnAList.do", totalCnt, listSize, pageSize, cp);
		
		List<QnADTO> list = qser.QnAAllList(cp, pageSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("lists",list);
		mav.setViewName("customer/user/userQnAList");
		return mav;
	}
	
	//글 작성 폼
	@RequestMapping(value = "/userQnAWrite.do", method = RequestMethod.GET)
	public String QnAWriteForm() {
		return "customer/user/userQnAWrite";
	}
	
	//작성
	@RequestMapping(value = "/userQnAWrite.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView QnAWriteSubmit(QnADTO dto) {
	
		int result = qser.QnAWrite(dto);
		String msg = result>0?"게시글이 성공적으로 작성되었습니다.":"게시글 작성에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("customer/user/userQnAMsg");
		return mav;
	}
	
	//글 상세보기
	@RequestMapping("/userQnAContent.do")
	public ModelAndView QnAContent(@RequestParam("bbs_idx")int bbs_idx) {
		QnADTO dto = qser.QnAContent(bbs_idx);
		List<CommentVO> list = cser.commentList(bbs_idx);
		
		ModelAndView mav = new ModelAndView();
			mav.setViewName("customer/user/userQnAContent");
	        mav.addObject("clist", list);
		if(dto!=null) {
			mav.addObject("dto", dto);
			mav.setViewName("customer/user/userQnAContent");
		}else {
			mav.addObject("msg", "잘못된 접근 또는 삭제된 게시글입니다.");
			mav.setViewName("customer/user/userQnAMsg");
		}
		return mav;
	}
	
	//글 수정 폼
	@RequestMapping(value = "/userQnAUpdate.do", method = RequestMethod.GET)
	public String QnAUpdateForm(@RequestParam("bbs_idx")int bbs_idx, Model mo) {
		QnADTO dto = qser.QnAContent(bbs_idx);
		mo.addAttribute("dto",dto);
		
		return "customer/user/userQnAUpdate";
	}
	
	//글 수정 
	@RequestMapping(value = "/userQnAUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView QnAUpdate(QnADTO dto) {
		int result = qser.QnAUpdate(dto);
		int idx = dto.getBbs_idx();
		String msg = result>0?"게시글이 수정되었습니다.":"게시글 수정에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("bbs_idx", idx);
		mav.addObject("msg", msg);
		mav.setViewName("customer/user/userQnAUpdateMsg");
		return mav;
	}
	
	//글 삭제
	@RequestMapping("/userQnADelete.do")
	public ModelAndView userQnADelete(int bbs_idx) {
		int result=qser.QnADelete(bbs_idx);
		String msg=result>0?"게시글을 삭제하셨습니다.!":"게시글을 삭제하지 못했습니다.!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("customer/user/userQnAMsg");
		return mav;
	}
}
package trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.comment.model.CommentVO;
import trip.notice.model.NoticeDTO;
import trip.notice.service.NoticeService;

import trip.qna.model.QnADTO;



@Controller
public class NoticeController {

	@Autowired
	private NoticeService nser;

	//글 작성 폼
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.GET)
	public String noticeWriteForm() {
		return "customer/notice/noticeWrite";
	}
	
	//글 작성
	@RequestMapping(value = "/noticeWrite.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView noticeWriteSubmit(NoticeDTO dto) {
	
		int result = nser.noticeWrite(dto);
		String msg = result>0?"게시글이 성공적으로 작성되었습니다.":"게시글 작성에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("customer/notice/noticeMsg");
		return mav;
	}
	
	//글 목록
	@RequestMapping("/noticeAllList.do")
	public ModelAndView userAllList(@RequestParam(value = "cp", defaultValue = "1")int cp) {
	
		int totalCnt = nser.getNoticeTotalCnt();		
		int listSize=5;
		int pageSize=5;
		
		String pageStr=trip.page.PageModule.makePage("noticeAllList.do", totalCnt, listSize, pageSize, cp);
		
		List<NoticeDTO> list = nser.noticeAllList(cp, pageSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("lists",list);
		mav.setViewName("customer/notice/noticeList");
		return mav; 
	}
	
	//글 상세보기
	@RequestMapping("/noticeContent.do")
	public ModelAndView noticeContent(@RequestParam("n_idx")int n_idx) {
		NoticeDTO dto = nser.noticeContent(n_idx);
		ModelAndView mav = new ModelAndView();
		int readnum = 0; 
		nser.noticeReadnum(n_idx);
		mav.addObject("readnum",readnum);
		if(dto!=null) {
			mav.addObject("dto", dto);
			mav.setViewName("customer/notice/noticeContent");
		}else {
			mav.addObject("msg", "잘못된 접근 또는 삭제된 게시글입니다.");
			mav.setViewName("customer/notice/noticeMsg");
		}
		return mav;
	}
	
	//공지사항 팝업
	@RequestMapping("/noticePop.do")
	public ModelAndView noticePop() {
		List<NoticeDTO> list = nser.noticePop();
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists",list);
		mav.setViewName("customer/notice/noticePop");
		return mav;
	}
	
	
	//공지사항 수정 폼
	@RequestMapping(value = "/noticeUpdate.do", method = RequestMethod.GET)
	public String noticeUpdateForm(@RequestParam("n_idx")int n_idx, Model mo) {
		NoticeDTO dto = nser.noticeContent(n_idx);
		mo.addAttribute("dto",dto);
		
		return "customer/notice/noticeUpdate";
	}
	
	//공지사항 수정
	@RequestMapping(value = "/noticeUpdate.do", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView noticeUpdate(NoticeDTO dto) {
		int result = nser.noticeUpdate(dto);
		int idx = dto.getN_idx();
		String msg = result>0?"게시글이 성공적으로 수정되었습니다.":"게시글 수정에 실패하였습니다.";
		ModelAndView mav = new ModelAndView();
		mav.addObject("n_idx", idx);
		mav.addObject("msg", msg);
		mav.setViewName("customer/notice/noticeUpdateMsg");
		return mav;
	}
	
	//공지사항 삭제
	@RequestMapping("/noticeDelete.do")
	public ModelAndView noticeDelete(int n_idx) {
		
		int result=nser.noticeDelete(n_idx);
		String msg=result>0?"게시글을 삭제하였습니다.!":"게시글을 삭제하지 못했습니다.!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",msg);
		mav.setViewName("customer/notice/noticeMsg");
		return mav;
	}
	

}

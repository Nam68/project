package trip.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.ad.model.AdDTO;
import trip.ad.model.AdVO;
import trip.ad.model.SnsAdVO;
import trip.ad.service.AdService;
import trip.comment.model.CommentVO;
import trip.comment.service.CommentService;
import trip.img.model.BbsImgDTO;
import trip.img.service.ImgService;
import trip.member.model.MemberDTO;
import trip.sns.model.GoodDTO;
import trip.sns.model.SnsDTO;
import trip.sns.model.SnsVO;
import trip.sns.service.SnsService;

@Controller
public class SnsController {

	@Autowired
	private SnsService snsService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private AdService adService;

	@RequestMapping("/snsList.do")
	public ModelAndView snsList(HttpSession session, @RequestParam(value = "cp", defaultValue = "1") int cp) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		int totalCount = snsService.getTotalCount();
		int listSize = 2;
		int pageSize = 5;
		List goodChecklist = snsService.goodCheck(idx);
		String pageStr = trip.page.PageModule.makePage("snsList.do", totalCount, listSize, pageSize, cp);
		List<SnsVO> list = snsService.snsList(cp, listSize);
		
		//광고를 가져오는 코드
		AdDTO adDto = adService.adListForSns();
		int ad_idx = 0;
		if(adDto != null) {
			ad_idx = adDto.getBbs_idx();
		}
		ArrayList<BbsImgDTO> adImgs = (ArrayList<BbsImgDTO>) adService.adImgList(ad_idx);
		ArrayList<String> adImgTexts = new ArrayList<String>();
		for(BbsImgDTO temp : adImgs) {
			adImgTexts.add(temp.getBbs_img());
		}
		SnsAdVO ad = null;
		if(adDto != null) {
			System.out.println("hi");
			ad = new SnsAdVO(ad_idx, adDto.getA_idx(), adDto.getA_title(), adDto.getA_content(), adDto.getA_writer(), adDto.getA_limit(), adDto.getA_href(), adDto.getA_count(), adDto.getA_startdate(), adDto.getA_enddate(), adDto.getA_permit(), adImgTexts);
		}
		System.out.println(ad);

		ModelAndView mav = new ModelAndView();
		mav.addObject("goodChecklist", goodChecklist);
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", list);
		mav.addObject("ad", ad);
		mav.setViewName("sns/snsList");
		return mav;
	}
	
	@RequestMapping("/mySnsList.do")
	public ModelAndView mySnsList(HttpSession session, @RequestParam(value = "cp", defaultValue = "1") int cp) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		String sns_writer = ((MemberDTO) session.getAttribute("memberDTO")).getId();
		int totalCount = snsService.getTotalCount();
		int listSize = 2;
		int pageSize = 5;
		List goodChecklist = snsService.goodCheck(idx);
		String pageStr = trip.page.PageModule.makePage("mySnsList.do", totalCount, listSize, pageSize, cp);
		List<SnsVO> list = snsService.mySnsList(cp, listSize, sns_writer);
		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("goodChecklist", goodChecklist);
		mav.addObject("pageStr", pageStr);
		mav.addObject("lists", list);
		mav.addObject("ad", ad);
		mav.setViewName("sns/mySnsList");
		return mav;
	}

	@RequestMapping(value = "/snsWrite.do", method = RequestMethod.GET)
	public ModelAndView snsWriteForm(HttpSession session) {
		String sns_writer = ((MemberDTO) session.getAttribute("memberDTO")).getId();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sns_writer", sns_writer);
		mav.setViewName("sns/snsWrite");
		return mav;
	}
 
	@RequestMapping(value = "/snsWrite.do", method = RequestMethod.POST)
	@ResponseBody
	public String snsWriteSubmit(@RequestBody Map<String, Object> param, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		int result = snsService.snsWrite(param, idx);
		String msg = result > 0 ? "업로드 성공!" : "업로드 실패!";
		return msg;
	}
	
	@RequestMapping("/snsContent.do")
	public ModelAndView snsContent(HttpSession session, @RequestParam("bbs_idx") int bbs_idx ){
		String sns_writer = ((MemberDTO) session.getAttribute("memberDTO")).getId();
		SnsDTO dto = snsService.snsContent(bbs_idx);
		List<CommentVO> list = commentService.comment(bbs_idx);
		ModelAndView mav = new ModelAndView();
		mav.addObject("sns_writer", sns_writer);
		mav.addObject("dto", dto);
		mav.setViewName("sns/comment");
		mav.addObject("clists", list);
		return mav;
	}

	
	@RequestMapping("/snsHeader.do")
	public String snsHeader() {
		return "sns/snsHeader";
	}


	@RequestMapping(value = "/snsDelete.do")
	@ResponseBody
	public ModelAndView snsDeleteSubmit(HttpServletRequest request, HttpServletResponse response, SnsDTO dto) {
		int result = snsService.snsDelete(dto);
		String msg = result > 0 ? "삭제 성공!" : "삭제 실패!";
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("sns/mySnsMsg");
		return mav;
	}

	
	@RequestMapping("/addgood.do")
	@ResponseBody
	public String likeAdd(int idx, int bbs_idx) {
		return snsService.addGood(idx, bbs_idx);
	}

	@RequestMapping("/deleteAdd.do")
	@ResponseBody
	public String likeDelete(int idx, int bbs_idx) {
		return snsService.deleteGood(idx, bbs_idx);
	}
	
	@RequestMapping("/snsgoodUpdate.do")
	public ModelAndView goodInsert(HttpSession session, int bbs_idx) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		int count = snsService.goodInsert(idx, bbs_idx);
		ModelAndView mav = new ModelAndView();
		if (count > 0) {
			mav.setViewName("sns/snsList");
		}
		return mav;
	}
	

	@RequestMapping("/snsgoodDelete.do")
	public ModelAndView goodDelete(HttpSession session, int bbs_idx) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		int count = snsService.goodDelete(idx, bbs_idx);
		int result = snsService.goodCount(bbs_idx);
		ModelAndView mav = new ModelAndView();
		if (count > 0) {
			mav.addObject("count", result);
			mav.setViewName("sns/snsList");
		}
		return mav;
	}
	
	
	
	
	
	

}

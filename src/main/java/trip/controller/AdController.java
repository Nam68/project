package trip.controller;

import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import trip.ad.model.AdVO;
import trip.ad.service.AdService;
import trip.img.model.BbsImgDTO;
import trip.img.service.ImgService;
import trip.member.model.MemberDTO;

@Controller
public class AdController {
	
	@Autowired
	private AdService a_service;
	@Autowired
	private ImgService i_service;
	
	public AdController() {
		
	}
	
	@RequestMapping(value = "/myAdPage.do")
	public String myAdPage(Model model, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		List<AdVO> list = a_service.removeDuplication(a_service.adList(idx));
		model.addAttribute("adList", list);
		return "myAd/myAdList";
	}
	
	@RequestMapping("/myAdAdd.do")
	public String myAdAddPage() {
		return "myAd/myAdAdd";
	}
	
	@RequestMapping(value = "/myAdSubmit.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public String adSubmit(@RequestBody Map<String, Object> param, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		String msg = a_service.adSubmit(param, idx)>0? "등록신청했습니다":"등록신청에 실패했습니다";
		i_service.deleteAllTempFile(idx);
		return msg;
	}
	
	@RequestMapping(value = "/myAdUpdate.do", method = RequestMethod.POST)
	public ModelAndView myAdUpdatePage(int a_idx, int bbs_idx, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("adDTO", a_service.adSelect(a_idx));
		List<BbsImgDTO> imgList = a_service.adImgList(bbs_idx);
		mav.addObject("adImgList", imgList);
		mav.setViewName("myAd/myAdUpdate");
		
		//업데이트를 위해 기존의 파일을 임시폴더에 복사
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		i_service.imgFileSetting(a_service.getPaths(imgList), idx);
		return mav;
	}
	
	@RequestMapping(value = "/myAdUpdateSubmit.do", method = RequestMethod.POST, produces = "application/json;charset=utf8")
	@ResponseBody
	public String adUpdateSubmit(@RequestBody Map<String, Object> param, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		String msg = a_service.adUpdate(param, idx)>0? "수정했습니다":"수정에 실패했습니다";
		i_service.deleteAllTempFile(idx);
		return msg;
	}
	
	@RequestMapping(value = "/myAdDelete.do", produces = "text/plain;charset=utf8")
	@ResponseBody
	public String myAdDelete(int a_idx) {
		String msg = a_service.adDelete(a_idx)>0? "삭제했습니다":"삭제에 실패했습니다";
		return msg;
	}
	
	
	@RequestMapping("/adCountUp.do")
	public void adCountUp(int bbs_idx, int a_idx) {
		int money=a_service.adsPay();
		a_service.adsCount(a_idx, money);
		a_service.adCountUpdate(bbs_idx);
	}
	
	@RequestMapping("/toto.do")
	public String adstotal(Model model,int bbs_idx,String year) {
		int a=a_service.adsPay();
		System.out.println(a);
		System.out.println(bbs_idx);
		int aco=a_service.adsCount(bbs_idx, a);
		System.out.println(aco);
				
		model.addAttribute("aa", a);
		model.addAttribute("bb", aco);
		
		model.addAttribute("jan", a_service.Jan(year));
		model.addAttribute("feb", a_service.Feb(year));
		model.addAttribute("mar", a_service.Mar(year));
		model.addAttribute("apr", a_service.Apr(year));
		model.addAttribute("may", a_service.May(year));
		model.addAttribute("jun", a_service.Jun(year));
		model.addAttribute("jul", a_service.Jul(year));
		model.addAttribute("aug", a_service.Aug(year));
		model.addAttribute("sept", a_service.Sept(year));
		model.addAttribute("oct", a_service.Oct(year));
		model.addAttribute("nov", a_service.Nov(year));
		model.addAttribute("dec", a_service.Dec(year));
		
		return "total2";
	}
	
	@RequestMapping("/adManagerList.do")
	   public ModelAndView adManagerList(@RequestParam(value="cp",defaultValue = "1")int cp) {
	      
	      List adList=a_service.adManagerList(cp);
	      int totalCnt=a_service.adCount();
	      int listSize=5;
	      int pageSize=5;
	      
	      String pageStr=min.page.PageModule3
	            .makePaging("adManagerList.do", totalCnt, listSize, pageSize, cp);
	      
	      ModelAndView mav= new ModelAndView();
	      mav.addObject("adList",adList);
	      mav.addObject("pageStr",pageStr);
	      mav.setViewName("customer/ads/adManager");
	      return mav;
	   }
	   
	   @RequestMapping("/permitUpdate.do")
	   public ModelAndView permitUpdate(int a_idx) {
	      
	      int count=a_service.permitUpdate(a_idx);
	      System.out.println("update:"+count);
	      ModelAndView mav= new ModelAndView();
	      if(count>0) {
	         mav.setViewName("ad/adManager");
	      }
	      return mav;
	   }
	   
	   @RequestMapping("/permitDelete.do")
	   public ModelAndView permitDelete(int a_idx) {
	      int count=a_service.permitDelete(a_idx);
	      System.out.println("delete:"+count);
	      ModelAndView mav= new ModelAndView();
	      if(count>0) {
	         mav.setViewName("ad/adManager");
	      }   
	      return mav;
	      
	   }
}

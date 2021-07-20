package trip.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.member.model.*;
import trip.member.service.MemberService;
import trip.member.service.UserService;

import trip.qna.model.QnADTO;

@Controller
public class CustomerUserController {
	
	@Autowired
	MemberService mser;
	@Autowired
	UserService user;


	@RequestMapping("/customerForm.do")
	public String customerForm() {
		return "customer/customerForm";
				
	}
	
	//유저 리스트
	@RequestMapping("/customerUserList.do")
	@ResponseBody
	public ModelAndView userAllList(@RequestParam(value = "cp", defaultValue = "1")int cp) {
		
		int totalCnt = user.getUserTotalCnt();
		int listSize=5;
		int pageSize=5;
		
		String pageStr=trip.page.PageModule.makePage("customerUserList.do", totalCnt, listSize, pageSize, cp);
		
		List<MemberDTO> list = user.customerUserAllList(cp, listSize);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageStr",pageStr);
		mav.addObject("lists",list);
		mav.setViewName("customer/user/userList");
		return mav;
	}
	
	//유저 통계
	@RequestMapping("/userStats.do")
	@ResponseBody
	public ModelAndView userStats(UserDTO dto) {
		List<UserDTO> list = user.userStats(dto);
		ModelAndView mav = new ModelAndView();
		mav.addObject("lists", list);
		mav.setViewName("customer/stats/userStats");
		return mav;
	}
	
	 //유저 선택삭제
    @RequestMapping(value = "/customerUserDelete.do")
    @ResponseBody
    public String customerUserDelete(HttpServletRequest request) {
            
        String[] ajaxMsg = request.getParameterValues("valueArr");
        int size = ajaxMsg.length;
        for(int i=0; i<size; i++) {
        	user.customerUserDelete(ajaxMsg[i]);
        }
        return "redirect:/customer/user/userList";
    }
    
    //어드민 비밀번호 변경
    @RequestMapping(value="/pwd.do", method=RequestMethod.GET)
    public String pwdForm() {
    	return "customer/admin/pwd";
    }

    //어드민 비밀번호 변경
    @RequestMapping(value="/pwd.do", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView adminPwd(String pwd, HttpSession session, MemberDTO dto) {
 
         int result = user.adminPwd(dto);
    	 String msg = result>0?"비밀번호가 성공적으로 수정되었습니다.":"비밀번호 수정에 실패하였습니다.";
    	 ModelAndView mav = new ModelAndView();
    	 mav.addObject("msg", msg);
    	 mav.setViewName("customer/admin/pwdMsg");
         return mav;
    }


}

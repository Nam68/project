package trip.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.fasterxml.jackson.databind.ObjectMapper;

import trip.favorite.model.FavoriteDTO;
import trip.favorite.model.UserFavoriteDTO;
import trip.favorite.service.FavoriteService;
import trip.member.model.BusinessDTO;
import trip.member.model.MemberDTO;
import trip.member.model.UserDTO;
import trip.member.model.UserVO;
import trip.member.service.MemberService;
import trip.question.service.QuestionService;
import trip.total.service.TotalVistitService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private FavoriteService f_service;
	@Autowired
	private QuestionService q_service;
	@Autowired
	private TotalVistitService totalvistser;

	
	@RequestMapping(value = "/loginSubmit.do", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String loginSubmit(String id, String pwd, HttpSession session) {
		MemberDTO dto = service.memberLogin(id, pwd);

		if(dto == null) return "아이디 또는 비밀번호를 확인해주세요";
		
		Object info = service.getMemberInfo(dto.getGroupidx(), dto.getIdx());
		if(dto.getGroupidx() == service.USER) {
			List<UserFavoriteDTO> favorite = f_service.getUserFavoriteWhenLogin(dto.getIdx(), session);
			session.setAttribute("userFavorite", favorite);
		}
		
		String msg = dto!=null && info!=null? dto.getName()+"님 환영합니다!":"아이디 또는 비밀번호를 확인해주세요";
		
		 InetAddress ip;
	      try {
	         ip = InetAddress.getLocalHost();
	         String ipx=String.valueOf(ip);
	         String id2[]=ipx.split("/");
	         int count = totalvistser.ipSelect(id2[1]);
	         if(count==0) {
	            totalvistser.insertTotal(id2[1]);
	            totalvistser.groupTotal(dto.getIdx(), dto.getGroupidx());
	         }else if(count==1) {
	            totalvistser.groupTotal(dto.getIdx(), dto.getGroupidx());
	         }
	         
	      } catch (UnknownHostException e) {
	         e.printStackTrace();
	      }

		
		session.setAttribute("memberDTO", dto);
		session.setAttribute("memberInfo", info);
		return msg;
	}
	
	@RequestMapping(value = "/mainLoginSubmit.do", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public ModelAndView mainLoginSubmit(String id, String pwd, HttpSession session) {
		MemberDTO dto = service.memberLogin(id, pwd);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tripJson");
		
		String msg = "";
		if(dto == null) {
			msg = "아이디 또는 비밀번호를 확인해주세요";
			mav.addObject("msg", msg);
			return mav;
		}
		
		Object info = service.getMemberInfo(dto.getGroupidx(), dto.getIdx());
		if(dto.getGroupidx() == service.USER) {
			List<UserFavoriteDTO> favorite = f_service.getUserFavoriteWhenLogin(dto.getIdx(), session);
			session.setAttribute("userFavorite", favorite);
		}
		
		msg = dto!=null && info!=null? dto.getName()+"님 환영합니다!":"아이디 또는 비밀번호를 확인해주세요";
	
		session.setAttribute("memberDTO", dto);
		session.setAttribute("memberInfo", info);
		
		mav.addObject("msg", msg);
		mav.addObject("idx", dto.getIdx());
		mav.addObject("id", dto.getId());
		mav.addObject("groupidx", dto.getGroupidx());
		
		return mav;
	}
	
	@RequestMapping(value = "/userUpdate.do", method = RequestMethod.GET)
	public ModelAndView userUpdatePage() {
		ModelAndView mav = new ModelAndView();
		List list = q_service.questionList();
		mav.addObject("q_list", list);
		mav.setViewName("member/userUpdate");
		return mav;
	}
	
	@RequestMapping(value = "/logoutSubmit.do", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String logoutSubmit(HttpSession session) {
		session.invalidate();
		return "로그아웃되었습니다";
	}
	
	
	
	
	
	
	@RequestMapping("/memberType.do")
	public String memberType() {
		return"member/memberType";
	}
	
	@RequestMapping("/signup.do")
	public String memberForm(Model model, int type) {
		model.addAttribute("question", q_service.questionList());
		model.addAttribute("city", service.city());	
		if(type==2) {
			return "member/userMember";
		}else {
			return "member/businessMember";
		}
	}
	
	@RequestMapping(value = "/memberOk.do",method = RequestMethod.POST)
	public String memberOk(Model model, MemberDTO dto,String tel,@RequestParam(value = "gender",defaultValue = "1") int gender,Date age,String account,String addr,@RequestParam(value = "c_idx",defaultValue = "1") int c_idx) {
		
		if(dto.getGroupidx()==2) {
			int a=service.memberInsert(dto);
			UserVO vo=new UserVO(service.memberIdx(dto.getId()), gender, c_idx, tel, age);
			int b=service.userInsert(vo);
			
		}else {
			service.memberInsert(dto);
			BusinessDTO bdto=new BusinessDTO(service.memberIdx(dto.getId()), tel, account, addr);
			service.businessinsert(bdto);
		}
		service.joinday(service.memberIdx(dto.getId()), dto.getGroupidx());
		return "temp/main";
	}

}

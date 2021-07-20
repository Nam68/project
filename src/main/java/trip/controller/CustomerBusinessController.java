package trip.controller;

import java.net.InetAddress;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import trip.ad.service.AdService;
import trip.member.model.MemberDTO;
import trip.member.service.MemberService;
import trip.member.service.UserService;
import trip.total.service.TotalService;
import trip.total.service.TotalServiceImple;
import trip.total.service.TotalVistitService;

@Controller
public class CustomerBusinessController {

	@Autowired
	private MemberService mser;
	@Autowired
	private UserService user;
	@Autowired
	private TotalService tser;
	@Autowired
	private TotalVistitService ser;
	@Autowired
	private AdService aser;
	
	
	//사업자 리스트
		@RequestMapping("/customerBizList.do")
		public ModelAndView businessAllList(@RequestParam(value = "cp", defaultValue = "1")int cp) {
			
			int totalCnt = user.getBusinessTotalCnt();
			int listSize=5;
			int pageSize=5;
			
			String pageStr=trip.page.PageModule.makePage("customerBizList.do", totalCnt, listSize, pageSize, cp);
			
			List<MemberDTO> list = user.customerBusinessAllList(cp, listSize);
			
			ModelAndView mav = new ModelAndView();
			mav.addObject("pageStr",pageStr);
			mav.addObject("lists",list);
			mav.setViewName("customer/business/businessList");
			return mav;
		}


		//사업자 통계
		@RequestMapping("/customerBizStats.do")
		public String businessStats(Model model) {
			
			InetAddress ip;
			try {
				ip = InetAddress.getLocalHost();
				String ipx=String.valueOf(ip);
				String id[]=ipx.split("/");
				int count=ser.ipSelect(id[1]);
				model.addAttribute("todat",ser.toDay());
				model.addAttribute("total",ser.totalDay());
				model.addAttribute("us",ser.groupToday(2));
				model.addAttribute("bi",ser.groupToday(3));
				model.addAttribute("allus",ser.groupTotalDay(1));
				model.addAttribute("allbi",ser.groupTotalDay(2));
				model.addAttribute("todayJoin",ser.typeJointoday(2));
				model.addAttribute("totalJoin",ser.typeAllJoinday(2));
				
				String year="2021";
				int bbs_idx=1;
				int a=aser.adsPay();
				System.out.println(a);
				System.out.println(bbs_idx);
				int aco=aser.adsCount(bbs_idx, a);
				System.out.println(aco);
				
				
				
				
				model.addAttribute("aa", a);
				model.addAttribute("bb", aco);
				
				model.addAttribute("jan", aser.Jan(year));
				model.addAttribute("feb", aser.Feb(year));
				model.addAttribute("mar", aser.Mar(year));
				model.addAttribute("apr", aser.Apr(year));
				model.addAttribute("may", aser.May(year));
				model.addAttribute("jun", aser.Jun(year));
				model.addAttribute("jul", aser.Jul(year));
				model.addAttribute("aug", aser.Aug(year));
				model.addAttribute("sept", aser.Sept(year));
				model.addAttribute("oct", aser.Oct(year));
				model.addAttribute("nov", aser.Nov(year));
				model.addAttribute("dec", aser.Dec(year));
					
					
			}catch (Exception e) {
				// TODO: handle exception
			}
			
			
			return "customer/stats/businessStats";
		}

	
}

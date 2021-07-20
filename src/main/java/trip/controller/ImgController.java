package trip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import trip.img.service.ImgService;
import trip.member.model.MemberDTO;
import trip.planbbs.service.PlanBbsService;

@Controller
public class ImgController {
	
	@Autowired
	private ImgService service;
	@Autowired
	private PlanBbsService pb_service;
	
	public ImgController() {
		
	}
	
	@RequestMapping(value = "/tempImgUpdate.do", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String imgUpdate(MultipartFile file, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		return service.imgUpdate(file, idx);
	}
	
	@RequestMapping("/tempImgDelete.do")
	public void imgDelete(String path, HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		service.imgDelete(path, idx);
	}
	
	@RequestMapping("/allTempImgDelete.do")
	public void allImgDelete(HttpSession session) {
		int idx = ((MemberDTO) session.getAttribute("memberDTO")).getIdx();
		service.deleteAllTempFile(idx);
	}
	
	@RequestMapping(value = "/planBbsImgChange.do", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String planInfoImgUpdate(MultipartFile file, String path, int pl_idx, int p_idx, int day) {
		service.planInfoImgDelete(path);
		String newPath = service.planInfoImgUpdate(file);
		pb_service.planInfoImgUpdate(p_idx, pl_idx, day, newPath);
		return newPath;
	}
	
}

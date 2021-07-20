package trip.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.member.model.MemberDAO;
import trip.member.model.MemberDTO;
import trip.member.model.UserDAO;
import trip.member.model.UserDTO;



public class UserServiceImple implements UserService {

	@Autowired
	private UserDAO dao;
	@Autowired
	private MemberDAO mdao;
	
	//유저 회원가입
	public int userInsert(UserDTO dto,String id) {
		dto.setIdx(mdao.memberIdx(id));
		int count=dao.userInsert(dto);
		return count;
	}
	
	//고객센터 유저리스트
	public List<MemberDTO> customerUserAllList(int cp, int ls) {
		Map map = new HashMap();
		int start=((cp-1)*ls)+1;
		int end=cp*ls;
		map.put("start", start);
		map.put("end", end);
		List<MemberDTO> list = dao.customerUserAllList(map);
		return list;
	}
	
	//유저 총 카운트
	public int getUserTotalCnt() {
		int count = dao.getUserTotalCnt();
		return count;
	}
	
	//고객센터 사업자 리스트
	public List<MemberDTO> customerBusinessAllList(int cp, int ls) {
		Map map = new HashMap();
		int start=((cp-1)*ls)+1;
		int end=cp*ls;
		map.put("start", start-1);
		map.put("end", end);
		List<MemberDTO> list = dao.customerBusinessAllList(map);
		return list;
	}
	//사업자 총 카운트
	public int getBusinessTotalCnt() {
		int count = dao.getBusinessTotalCnt();
		return count;
	}
	
	public List<UserDTO> userStats(UserDTO dto) {
		List<UserDTO> list = dao.userSatas(dto);
		return list;
	}
	public int customerUserDelete(String idx) {
		int count = dao.customerUserDelete(idx);
		return count;
	}
	
	public int adminPwd(MemberDTO dto) {
		int count = dao.adminPwd(dto);
		return count;
	}
	
	
	
}

package trip.member.service;

import	java.util.*;

import trip.member.model.*;


public interface UserService {
	
	//유저 회원가입
	public int userInsert(UserDTO dto,String id);
	//고객센터 유저리스트
	public List<MemberDTO> customerUserAllList(int cp, int ls);
	//groupidx=1 총 카운트
	public int getUserTotalCnt();
	//고객센터 사업자리스트
	public List<MemberDTO> customerBusinessAllList(int cp, int ls);
	//groupidx=2 총 카운트
	public int getBusinessTotalCnt();
	//유저 연령, 성별 통계
	public List<UserDTO> userStats(UserDTO dto);
	//유저 선택 삭제
	public int customerUserDelete(String idx);
	//어드민 비밀번호 변경
	public int adminPwd(MemberDTO dto);
	

	 
}

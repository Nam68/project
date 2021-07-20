package trip.member.model;

import java.util.*;



public interface UserDAO {
	
	//유저 회원가입
	public int userInsert(UserDTO dto);
	//고객센터 유저리스트
	public List<MemberDTO> customerUserAllList(Map map);
	//유저 총 카운트
	public int getUserTotalCnt();
	//고객센터 사업자리스트
	public List<MemberDTO> customerBusinessAllList(Map map);
	//사업자 총 카운트
	public int getBusinessTotalCnt();
	//유저 성별,연령대 통계
	public List<UserDTO> userSatas(UserDTO dto);
	//유저 선택 삭제
	public int customerUserDelete(String idx);
	//어드민 비밀번호 변경
	public int adminPwd(MemberDTO dto);
	

}

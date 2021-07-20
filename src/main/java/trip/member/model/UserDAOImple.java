package trip.member.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import trip.member.model.MemberDTO;

public class UserDAOImple implements UserDAO {

	@Autowired
	private SqlSessionTemplate sqlMap;
	
	//유저 회원가입
	public int userInsert(UserDTO dto) {
		int count=sqlMap.insert("userinsert", dto);
		return count;
	}
	
	//고객센터 유저리스트
	public List<MemberDTO> customerUserAllList(Map map) {
		List<MemberDTO> list = sqlMap.selectList("customerUserAllList" , map);
		return list;
	}
	
	//유저 총 카운트
	public int getUserTotalCnt() {
		int count = sqlMap.selectOne("userTotalCnt");
		return count;
	}

	//고객센터 사업자리스트
	public List<MemberDTO> customerBusinessAllList(Map map) {
		List<MemberDTO> list = sqlMap.selectList("customerBusinessAllList" , map);
		return list;
	
	//사업자 총 카운트
	}public int getBusinessTotalCnt() {
		int count = sqlMap.selectOne("businessTotalCnt");
		return count;
	}
	
	//유저 통계 관련
	public List<UserDTO> userSatas(UserDTO dto) {
		List<UserDTO> list = sqlMap.selectList("userStats", dto);
		return list;
	}
	
	//유저 선택 삭제
	public int customerUserDelete(String idx) {
		int count = sqlMap.delete("customerUserDelete",idx);
		return count;
	}
	public int adminPwd(MemberDTO dto) {
		int count = sqlMap.update("adminPwd", dto);
		return count;
	}
	

	
}

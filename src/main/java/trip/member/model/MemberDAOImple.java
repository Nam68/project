package trip.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDAOImple implements MemberDAO {
	
	@Autowired
	private SqlSessionTemplate sqlMap;
	
	public MemberDAOImple() {
		
	}
	
	public MemberDTO memberLogin(HashMap<String, String> map) {
		MemberDTO dto = sqlMap.selectOne("memberLogin", map);
		return dto;
	}

	public AdminDTO adminSelect() {
		AdminDTO dto = sqlMap.selectOne("adminLogin");
		return dto;
	}
	
	public UserDTO userSelect(int idx) {
		UserDTO dto = sqlMap.selectOne("userLogin", idx);
		return dto;
	}
	
	public BusinessDTO businessSelect(int idx) {
		BusinessDTO dto = sqlMap.selectOne("businessLogin", idx);
		return dto;
	}
	
	public List memberList() {
		return sqlMap.selectList("memberList");
	}
	
	
	
	
	
	
	
	public int businessinsert(BusinessDTO dto) {
		int count=sqlMap.insert("bisinsert", dto);
		return count;
	}
	public int userInsert(UserVO dto) {
		int count=sqlMap.insert("userinsert", dto);
		return count;
	}
	
	
	
	
	
	
	
	
	public int memberInsert(MemberDTO dto) {
		int count=sqlMap.insert("memberinsert", dto);
		return count;
	}

	public int memberIdx(String id) {
		int idx=sqlMap.selectOne("memberidx",id);
		return idx;
	}

	
	public MemberDTO memberPwd(MemberDTO dto) {
		MemberDTO dto2=sqlMap.selectOne("pwdpass",dto);
		return dto2;
	}

	public int memberUpdate(MemberDTO dto) {
		int count=sqlMap.update("memberupdate", dto);
		return count;
	}

	public UserDTO user(int idx) {
		UserDTO dto=sqlMap.selectOne("userselect",idx);
		return dto;
	}

	public int userUpdate(UserDTO dto) {
		int count=sqlMap.update("userupdatetesttime",dto);
		return count;
	}

	public List Question() {
		List list=sqlMap.selectList("question");
		return list;
	}

	public List city() {
		List list=sqlMap.selectList("city");
		return list;
	}

	public BusinessDTO businessOne(int idx) {
		BusinessDTO dto=sqlMap.selectOne("businessselect", idx);
		return dto;
	}

	public int BusinessUpdate(BusinessDTO dto) {
		int count=sqlMap.update("businessupdatetest", dto);
		return count;
	}

	public AdminDTO adminOne(int idx) {
		AdminDTO dto=sqlMap.selectOne("adminselect",idx);
		return dto;
	}

	public int adminUpdate(AdminDTO dto) {
		int count=sqlMap.update("adminupdatetest", dto);
		return count;
	}

	public String lostId(Map map) {
		String dto=sqlMap.selectOne("idfind", map);
		return dto;
	}

	public int memberConfirm(Map map) {
		int idx=sqlMap.selectOne("confirm",map);
		return idx;
	}
	
	public int newPwd(Map map) {
		int count=sqlMap.update("newpwd", map);
		return count;
	}
	
	public MemberDTO idofall(String id) {
		MemberDTO dto=sqlMap.selectOne("idjoin", id);
		return dto;
	}
	
	public int joinday(Map map) {
		int count=sqlMap.insert("joinday", map);
		return count;
	}
}

package trip.member.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MemberDAO {
	
	public MemberDTO memberLogin(HashMap<String, String> map);
	public AdminDTO adminSelect();
	public UserDTO userSelect(int idx);
	public BusinessDTO businessSelect(int idx);
	
	public List memberList();
	

	public int memberIdx(String id);
	
	public int businessinsert(BusinessDTO dto);
	public int memberInsert(MemberDTO dto);
	public int userInsert(UserVO dto);


	
	
	//id 와 페스워드로 
	public MemberDTO memberPwd(MemberDTO dto);
	
	public int memberUpdate(MemberDTO dto);
	
	public UserDTO user(int idx);
	
	public int userUpdate(UserDTO dto);
	
	public List Question();
	
	public List city();
	
	public BusinessDTO businessOne(int idx);
	
	public int BusinessUpdate(BusinessDTO dto);
	
	public AdminDTO adminOne(int idx);
	
	public int adminUpdate(AdminDTO dto);

	public String lostId(Map map);
	
	public int memberConfirm(Map map);
	
	public int newPwd(Map map);
	
	
	//joindate
	public MemberDTO idofall(String id);
	public int joinday(Map map);
	
}

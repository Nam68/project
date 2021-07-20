package trip.member.service;

import java.util.List;

import trip.favorite.model.UserFavoriteDTO;
import trip.member.model.AdminDTO;
import trip.member.model.BusinessDTO;
import trip.member.model.MemberDTO;
import trip.member.model.UserDTO;
import trip.member.model.UserVO;

public interface MemberService {
	
	public static int ADMIN = 1;
	public static int USER = 2;
	public static int BUSINESS = 3;
	
	public static int MALE = 1;
	public static int FEMALE = 2;
	
	public MemberDTO memberLogin(String id, String pwd);
	
	/**groupidx를 통해서 알맞은 유저 정보 테이블을 가져오는 메서드*/
	public Object getMemberInfo(int groupidx, int idx);
	
	/** 유저가 로그인을 할 때 userFavorite에 필요한 데이터를 생성해주는 메서드 */
	public List<UserFavoriteDTO> setUserFavorite(int idx);
	
	
	public List memberList();
	
	
	
	
	public int businessinsert(BusinessDTO dto);
	public int userInsert(UserVO dto);
	public int memberInsert(MemberDTO dto);
	
	public int memberIdx(String id);

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
	
	public String lostId(String name,String tel);
	
	public int memberConfirm(MemberDTO dto,String tel);
	
	public int newPwd(int idx, String pwd);
	
	//joinday
	public MemberDTO idofall(String id);
	public int joinday(int type,int idx);
}

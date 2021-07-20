package trip.member.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import trip.favorite.model.FavoriteDAO;
import trip.favorite.model.FavoriteDTO;
import trip.favorite.model.UserFavoriteDTO;
import trip.favorite.service.FavoriteService;
import trip.member.model.AdminDTO;
import trip.member.model.BusinessDTO;
import trip.member.model.MemberDAO;
import trip.member.model.MemberDTO;
import trip.member.model.UserDTO;
import trip.member.model.UserVO;

public class MemberServiceImple implements MemberService {

	@Autowired
	MemberDAO dao;
	
	@Autowired
	FavoriteService fservice;
	
	public MemberDTO memberLogin(String id, String pwd) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pwd", pwd);
		MemberDTO dto = dao.memberLogin(map);
		return dto;
	}
	
	public Object getMemberInfo(int groupidx, int idx) {
		Object info = null;
		switch(groupidx) {
		case MemberService.ADMIN: info = dao.adminSelect(); break;
		case MemberService.USER: info = dao.userSelect(idx); break;
		case MemberService.BUSINESS: info = dao.businessSelect(idx);
		}
		return info;
	}
	
	public List<UserFavoriteDTO> setUserFavorite(int idx) {
		List<FavoriteDTO> flist = fservice.favoriteList();
		List<UserFavoriteDTO> udto = fservice.userFavoriteList(idx);
		
		HashMap<Integer, Boolean> userHas = new HashMap<Integer, Boolean>();
		for(UserFavoriteDTO temp : udto) userHas.put(temp.getV_idx(), true);
		
		for(FavoriteDTO temp : flist) {
			if(userHas.get(temp.getV_idx()) == null) {
				udto.add(new UserFavoriteDTO(idx, temp.getV_idx(), 0));
			}
		}
		return udto;
	}
	
	public List memberList() {
		return dao.memberList();
	}
	
	
	
	
	
	
	public int userInsert(UserVO dto) {
		int count=dao.userInsert(dto);
		return count;
	}

	public int businessinsert(BusinessDTO dto) {
		int count=dao.businessinsert(dto);
		return count;
	}
	
	
	
	
	
	
	
	public int memberInsert(MemberDTO dto) {
		dto.setIdx(111);
		int count=dao.memberInsert(dto);
		return count;
	}

	public int memberIdx(String id) {
		int idx=dao.memberIdx(id);
		return idx;
	}

	
	
	
	
	
	
	
	
	
	
	public MemberDTO memberPwd(MemberDTO dto) {
		MemberDTO dto2=dao.memberPwd(dto);
		return dto2;
	}

	public int memberUpdate(MemberDTO dto) {
		int count=dao.memberUpdate(dto);
		return count;
	}

	public UserDTO user(int idx) {
		UserDTO dto=dao.user(idx);
		return dto;
	}

	public int userUpdate(UserDTO dto) {
		int count=dao.userUpdate(dto);
		return count;
	}

	public List Question() {
		List list= dao.Question();
		return list;
	}

	public List city() {
		List list=dao.city();
		return list;
	}

	public BusinessDTO businessOne(int idx) {
		BusinessDTO dto=dao.businessOne(idx);
		return dto;
	}

	public int BusinessUpdate(BusinessDTO dto) {
		int count=dao.BusinessUpdate(dto);
		return count;
	}

	public AdminDTO adminOne(int idx) {
		AdminDTO dto=dao.adminOne(idx);
		return dto;
	}

	public int adminUpdate(AdminDTO dto) {
		int count=dao.adminUpdate(dto);
		return count;
	}

	public String lostId(String name, String tel) {
		Map map=new HashMap();
		map.put("name", name);
		map.put("tel", tel);
		String dto=dao.lostId(map);
		return dto;
	}

	public int memberConfirm(MemberDTO dto,String tel) {
		Map map=new HashMap();
		map.put("id", dto.getId());
		map.put("name", dto.getName());
		map.put("question", dto.getQuestion());
		map.put("answer", dto.getAnswer());
		map.put("tel", tel);
		int idx=dao.memberConfirm(map);
		return idx;
	}

	public int newPwd(int idx, String pwd) {
		Map map=new HashMap();
		map.put("idx", idx);
		map.put("pwd", pwd);
		int count=dao.newPwd(map);
		return count;
	}
	
	public MemberDTO idofall(String id) {
		MemberDTO dto=dao.idofall(id);
		return dto;
	}
	
	
	public int joinday(int type, int idx) {
		Map map=new HashMap();
		map.put("type", type);
		map.put("idx", idx);
		int count=dao.joinday(map);
		return count;
	}
}

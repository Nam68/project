package trip.favorite.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import trip.favorite.model.FavoriteDAO;
import trip.favorite.model.FavoriteDTO;
import trip.favorite.model.PlaceFavoriteDTO;
import trip.favorite.model.PlaceInfoFavoriteDTO;
import trip.favorite.model.UserFavoriteDTO;
import trip.member.model.MemberDTO;
import trip.member.model.UserDTO;
import trip.member.service.MemberService;
import trip.place.service.PlaceService;
import trip.total.service.TotalService;

public class FavoriteServiceImple implements FavoriteService {

	@Autowired
	FavoriteDAO dao;
	@Autowired
	TotalService t_service;
	@Autowired
	MemberService m_service;
	@Autowired
	PlaceService p_service;
	
	public List favoriteList() {
		return dao.favoriteList();
	}
	
	public List userFavoriteList(int idx) {
		return dao.userFavoriteList(idx);
	}
	
	public int userFavoriteAdd(int idx, int v_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("v_idx", v_idx);
		return dao.userFavoriteAdd(map);
	}
	
	public int userFavoriteUpdate(UserFavoriteDTO dto) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", dto.getIdx());
		map.put("v_idx", dto.getV_idx());
		map.put("count", dto.getCount());
		return dao.userFavoriteUpdate(map);
	}
	
	public List placeFavoriteList(int pl_idx) {
		return dao.placeFavoriteList(pl_idx);
	}
	
	public int placeFavoriteInsert(PlaceFavoriteDTO dto) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", dto.getPl_idx());
		map.put("v_idx", dto.getV_idx());
		map.put("count", dto.getCount());
		return dao.placeFavoriteInsert(map);
	}
	
	public int placeFavoriteUpdate(PlaceFavoriteDTO dto) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("pl_idx", dto.getPl_idx());
		map.put("v_idx", dto.getV_idx());
		map.put("count", dto.getCount());
		return dao.placeFavoriteUpdate(map);
	}
	
	public List placeInfoFavoriteList(int pl_idx) {
		return dao.placeInfoFavoriteList(pl_idx);
	}
	
	public List placeInforFavoriteSelect(int pl_idx) {
		return dao.placeInforFavoriteSelect(pl_idx);
	}
	
	
	
	
	
	
	/** ???????????? ???????????? ???????????? ?????? ?????? ?????????, ????????? ??? ??? ?????? ????????? ???????????? ????????????????????? ????????? */
	public List<UserFavoriteDTO> getUserFavoriteWhenLogin(int idx, HttpSession session) {
		List<UserFavoriteDTO> list = (List<UserFavoriteDTO>) session.getAttribute("userFavorite");
		List<UserFavoriteDTO> favorite = m_service.setUserFavorite(idx);
		if(list != null) {
			HashMap<Integer, UserFavoriteDTO> map = new HashMap<Integer, UserFavoriteDTO>();
			for(UserFavoriteDTO temp : favorite) map.put(temp.getV_idx(), temp);
			for(UserFavoriteDTO temp : list) {
				UserFavoriteDTO user = map.get(temp.getV_idx());
				user.setCount(user.getCount()+temp.getCount());
			}
		}
		return favorite;
	}
	
	/** ??????????????? ?????? ???????????? ????????? ????????? ???????????????, ??????????????? ?????? ???????????? ?????? ?????? ????????? ????????? ????????? */
	public void makeTempUserFavorite(HttpSession session) {
		if(session.getAttribute("userFavorite") != null) return;
		List<FavoriteDTO> flist = favoriteList();
		ArrayList<UserFavoriteDTO> favorite = new ArrayList<UserFavoriteDTO>();
		for(FavoriteDTO temp : flist) favorite.add(new UserFavoriteDTO(-1, temp.getV_idx(), 0));
		session.setAttribute("userFavorite", (List<UserFavoriteDTO>) favorite);
	}
	
	/** ???????????? ?????? ??? ???????????? userFavorite ???????????? */
	public int saveFavorite(List<UserFavoriteDTO> favorite, int idx) {
		List list = dao.userFavoriteList(idx);
		if(list.size() == 0) {
			List f_list = dao.favoriteList();
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("idx", idx);
			map.put("f_list", f_list);
			dao.userFavoriteListInsert(map);
		}
		int result = 0;
		for(UserFavoriteDTO temp : favorite) {
			temp.setIdx(idx);
			result += userFavoriteUpdate(temp);
		}
		return result;
	}
	
	/** ????????? ????????? ??? ?????? ??? ?????? ?????? */
	public void favoriteUpdateWhenClicked(int pl_idx, HttpSession session) {
		List ulist = (List) session.getAttribute("userFavorite");
		if(ulist == null) {
			makeTempUserFavorite(session);
			ulist = (List) session.getAttribute("userFavorite");
		}
		
		userFavoriteUpdate(pl_idx, ulist);
		placeFavoriteUpdate(pl_idx, ulist);
		placeTotalUpdate(pl_idx, session);
	}
	
	/** ????????? ????????? ??? userFavorite??? ?????????(?????? ??????) */
	private void userFavoriteUpdate(int pl_idx, List<UserFavoriteDTO> ulist) {
		List<PlaceInfoFavoriteDTO> plist = placeInfoFavoriteList(pl_idx);
		
		HashMap<Integer, UserFavoriteDTO> userMap = new HashMap<Integer, UserFavoriteDTO>();
		for(UserFavoriteDTO temp : ulist) userMap.put(temp.getV_idx(), temp);
		
		for(PlaceInfoFavoriteDTO temp : plist) {
			UserFavoriteDTO dto = userMap.get(temp.getV_idx());
			if(dto != null) {
				dto.setCount(dto.getCount() + temp.getCount());
			}
		}
	}
	
	/** ????????? ????????? ??? placeFavorite??? ?????????(?????? ??????) */
	private void placeFavoriteUpdate(int pl_idx, List<UserFavoriteDTO> ulist) {
		List<PlaceFavoriteDTO> plist = placeFavoriteList(pl_idx);
		
		HashMap<Integer, PlaceFavoriteDTO> placeMap = new HashMap<Integer, PlaceFavoriteDTO>();
		for(PlaceFavoriteDTO temp : plist) placeMap.put(temp.getV_idx(), temp);
		
		for(UserFavoriteDTO temp : ulist) {
			PlaceFavoriteDTO dto = placeMap.get(temp.getV_idx());
			if(dto == null) {
				placeFavoriteInsert(new PlaceFavoriteDTO(pl_idx, temp.getV_idx(), temp.getCount()));
			} else {
				dto.setCount(dto.getCount() + temp.getCount());
				placeFavoriteUpdate(dto);
			}
		}
	}
	
	/** ????????? ????????? ??? ?????? ?????? ???????????? ?????? */
	private void placeTotalUpdate(int pl_idx, HttpSession session) {
		MemberDTO dto = (MemberDTO) session.getAttribute("memberDTO");
		if(dto == null || dto.getGroupidx() != MemberService.USER) return;
		UserDTO user = (UserDTO) session.getAttribute("memberInfo");
		
		int c_idx = user.getC_idx();
		int gender = user.getGender();
		int age = calculateAge(user.getAge());
		
		t_service.updateAllTotal(pl_idx, c_idx, gender, age);
	}
	/** ?????? ?????? ????????? */
	private int calculateAge(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int today = Integer.parseInt(sdf.format(System.currentTimeMillis()));
		int age = today - Integer.parseInt(sdf.format(date)) +1;
		return age;
	}
	
	
	
	
	
	
	public int adminFavoriteAdd(String v_name) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("placeList", p_service.placePlainList());
		map.put("memberList", m_service.memberList());
		map.put("v_name", v_name);
		return dao.adminFavoriteAdd(map);
	}
	public int adminFavoriteDelete(int v_idx) {
		return dao.adminFavoriteDelete(v_idx);
	}

}

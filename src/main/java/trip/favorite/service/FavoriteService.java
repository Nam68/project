package trip.favorite.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import trip.favorite.model.PlaceFavoriteDTO;
import trip.favorite.model.PlaceInfoFavoriteDTO;
import trip.favorite.model.UserFavoriteDTO;

public interface FavoriteService {
	
	/** favorite에 대한 메서드들 */
	public List favoriteList();
	
	/** userFavorite에 대한 메서드들 */
	public List userFavoriteList(int idx);
	public int userFavoriteAdd(int idx, int v_idx);
	public int userFavoriteUpdate(UserFavoriteDTO dto);
	
	/** placeFavorite에 대한 메서드들 */
	public List placeFavoriteList(int pl_idx);
	public int placeFavoriteInsert(PlaceFavoriteDTO dto);
	public int placeFavoriteUpdate(PlaceFavoriteDTO dto);

	/** placeInfoFavorite에 대한 메서드들 */
	public List placeInfoFavoriteList(int pl_idx);
	public List placeInforFavoriteSelect(int pl_idx);
	
	/** 비로그인 상태에서 카운트된 유저 취향 정보를, 로그인 할 때 기존 정보에 추가해서 업데이트해주는 메서드 */
	public List<UserFavoriteDTO> getUserFavoriteWhenLogin(int idx, HttpSession session);
	/** 미로그인 상태에서도 취향 통계가 가능하도록 임시 유저 취향 세션을 생성 */
	public void makeTempUserFavorite(HttpSession session);
	/** 창을 닫을 때 자동으로 userFavorite 업데이트 */
	public int saveFavorite(List<UserFavoriteDTO> favorite, int idx);	
	/** 사용자가 장소를 클릭했을 때 추천수를 조정하는 메서드들 */
	public void favoriteUpdateWhenClicked(int pl_idx, HttpSession session);
	
	
	
	
	public int adminFavoriteAdd(String v_name);
	public int adminFavoriteDelete(int v_idx);
	
}

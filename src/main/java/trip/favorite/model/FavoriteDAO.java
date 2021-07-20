package trip.favorite.model;

import java.util.HashMap;
import java.util.List;

public interface FavoriteDAO {
	
	/** favorite에 대한 메서드들 */
	public List favoriteList();
	
	/** userFavorite에 대한 메서드들 */
	public List userFavoriteList(int idx);
	public int userFavoriteAdd(HashMap<String, Integer> map); //일단 보류(지금 안 쓰임)
	public int userFavoriteUpdate(HashMap<String, Integer> map);
	
	/** placeFavorite에 대한 메서드들 */
	public List placeFavoriteList(int pl_idx);
	public int placeFavoriteInsert(HashMap<String, Integer> map);
	public int placeFavoriteUpdate(HashMap<String, Integer> map);
	
	/** placeInfoFavorite에 대한 메서드들 */
	public List placeInfoFavoriteList(int pl_idx);
	public List placeInforFavoriteSelect(int pl_idx);
	
	
	
	public int adminFavoriteAdd(HashMap<String, Object> map);
	public int adminFavoriteDelete(int v_idx);
	public int userFavoriteListInsert(HashMap<String, Object> map);
}

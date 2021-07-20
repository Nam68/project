package trip.business.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import trip.business.model.BusinessDAO;
import trip.favorite.model.FavoriteDTO;
import trip.favorite.model.PlaceInfoFavoriteDTO;
import trip.img.service.ImgService;
import trip.place.service.PlaceService;
import trip.total.service.TotalService;
import trip.view.FileUpload;

public class BusinessServiceImple implements BusinessService {
	
	@Autowired
	private BusinessDAO dao;
	@Autowired
	private PlaceService p_service;
	@Autowired
	private ImgService i_service;
	@Autowired
	private TotalService t_service;
	
	public BusinessServiceImple() {
		
	}
	
	public List businessPlaceList(int idx) {
		return p_service.deduplicateList(dao.businessPlaceList(idx));
	}
	
	public int businessPlaceDelete(int pl_idx) {
		return dao.businessPlaceDelete(pl_idx);
	}
	
	
	public int businessPlaceInsert(Map<String, Object> param, int idx) {
		ArrayList<String> pl_img = i_service.adImgSubmit(idx);
		param.put("imgList", pl_img);
		param.put("favoriteList", favoriteInfoUpdate(param));
		param.put("cityList", t_service.getAllCity());
		return dao.businessPlaceInsert(param);
	}
	
	public int businessPlaceUpdate(Map<String, Object> param, int idx) {
		int pl_idx = (Integer) param.get("pl_idx");
		dao.placeAllImgDelete(pl_idx); //DB 내 bbsImg 테이블에서 관련 로우 삭제
		
		ArrayList<String> pl_img = (ArrayList<String>) param.get("pl_img");
		i_service.removeAllFile(pl_img); //서버 내 img폴더에 저장된 이미지를 전부 삭제
		
		ArrayList<String> imgList = i_service.adImgSubmit(idx);
		param.put("imgList", imgList); //임시 폴더에 있던 파일을 새롭게 img에 집어넣고 관련 경로를 당음
		
		param.put("favoriteList", favoriteInfoUpdate(param));
		return dao.businessPlaceUpdate(param);
	}
	
	
	//새 사업장 추가/갱신에 필요한 정보를 제이슨으로부터 추출
	public ArrayList<PlaceInfoFavoriteDTO> favoriteInfoUpdate(Map<String, Object> param) {
		List<String> vidxs = (List<String>) param.get("v_idx");
		HashMap<Integer, String> vidxMap = new HashMap<Integer, String>();
		for(String temp : vidxs) vidxMap.put(Integer.parseInt(temp), "checked");
		
		List<String> vListStr = (List<String>) param.get("vList");
		ArrayList<Integer> vList = new ArrayList<Integer>();
		for(String temp : vListStr) vList.add(Integer.parseInt(temp));
		
		ArrayList<PlaceInfoFavoriteDTO> favoriteList = new ArrayList<PlaceInfoFavoriteDTO>();
		for(int i = 0; i < vList.size(); i++) {
			int checked = 0;
			if(vidxMap.get(vList.get(i)) != null) checked = 1;
			favoriteList.add(new PlaceInfoFavoriteDTO(0, vList.get(i), checked));
		}
		return favoriteList;
	}

}

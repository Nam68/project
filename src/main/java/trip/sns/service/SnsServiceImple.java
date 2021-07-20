package trip.sns.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;

import trip.img.model.BbsImgDTO;
import trip.img.service.ImgService;
import trip.sns.model.*;

public class SnsServiceImple implements SnsService {

	@Autowired
	private SnsDAO snsDao;
	@Autowired
	private ImgService i_service;

	public int snsWrite(Map<String, Object> param, int idx) {
		ArrayList<String> bbs_img = i_service.adImgSubmit(idx);
		param.put("imgList", bbs_img);
		int count = snsDao.snsWrite(param);
		return count;
	}

	public List<SnsVO> snsList(int cp, int ls) {
		Map<String, Integer> map = new HashedMap();
		int start = (cp - 1) * ls;
		int end = cp * ls;
		map.put("start", start);
		map.put("end", end);
		List<SnsDTO> list = snsListSort(snsDao.snsList(map));
		List<BbsImgDTO> imgList = snsDao.bbsAllImgList();

		return getSnsVO(list, imgList);
	}

	public List<SnsVO> mySnsList(int cp, int ls, String sns_writer) {
		Map<String, Object> map = new HashedMap();
		int start = (cp - 1) * ls;
		int end = cp * ls;
		map.put("start", start);
		map.put("end", end);
		map.put("sns_writer", sns_writer);
		List<SnsDTO> list = snsListSort(snsDao.mySnsList(map));
		List<BbsImgDTO> imgList = snsDao.bbsAllImgList();

		return getSnsVO(list, imgList);
	}

	// 중복 컨텐츠 제거
	private List<SnsDTO> snsListSort(List<SnsDTO> list) {
		HashMap<Integer, SnsDTO> map = new HashMap<Integer, SnsDTO>();
		ArrayList<SnsDTO> result = new ArrayList<SnsDTO>();

		for (SnsDTO temp : list) {
			if (map.get(temp.getBbs_idx()) == null) {
				map.put(temp.getBbs_idx(), temp);
				result.add(temp);
			}
		}

		return result;
	}

	// 이미지를 여러장 가진 snsDTO로 업그레이드
	private List<SnsVO> getSnsVO(List<SnsDTO> list, List<BbsImgDTO> imgList) {
		ArrayList<SnsVO> vos = new ArrayList<SnsVO>();

		for (SnsDTO temp : list) {
			int bbs_idx = temp.getBbs_idx();

			ArrayList<String> imgs = new ArrayList<String>();
			for (BbsImgDTO imgTemp : imgList) {
				if (imgTemp.getBbs_idx() == bbs_idx) {
					imgs.add(imgTemp.getBbs_img());
				}
			}

			String sns_title = temp.getSns_title();
			String sns_content = temp.getSns_content();
			String sns_writer = temp.getSns_writer();
			Date sns_writedate = temp.getSns_writedate();

			vos.add(new SnsVO(bbs_idx, sns_title, sns_content, sns_writer, sns_writedate, imgs));
		}
		return vos;
	}

	public int getTotalCount() {
		int count = snsDao.getTotalCount();
		return count;
	}

	public SnsDTO snsContent(int bbs_idx) {
		SnsDTO dto = snsDao.snsContent(bbs_idx);
		return dto;
	}

	public int snsDelete(SnsDTO dto) {
		int count = snsDao.snsDelete(dto);
		return count;
	}

	public String addGood(int idx, int bbs_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx", bbs_idx);
		snsDao.addGood(map);
		return Integer.toString(snsDao.goodSelect(idx));
	}

	public String deleteGood(int idx, int bbs_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx", bbs_idx);
		snsDao.deleteGood(map);
		return Integer.toString(snsDao.goodSelect(idx));
	}

	public int goodInsert(int idx, int bbs_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx", bbs_idx);
		return snsDao.goodInsert(map);
	}

	public int goodDelete(int idx, int bbs_idx) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		map.put("bbs_idx", bbs_idx);
		return snsDao.goodDelete(map);

	}

	public int goodCount(int bbs_idx) {
		int count = snsDao.goodCount(bbs_idx);
		return count;
	}

	public List goodCheck(int idx) {
		List list = snsDao.goodCheck(idx);
		return list;
	}
	
}
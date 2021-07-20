package trip.sns.service;

import java.util.List;
import java.util.Map;

import trip.sns.model.GoodDTO;
import trip.sns.model.SnsDTO;
import trip.sns.model.SnsVO;

public interface SnsService {

	public int snsWrite(Map<String, Object> param, int idx);
	public int snsDelete(SnsDTO dto);
	public List<SnsVO> snsList(int cp, int ls);
	public List<SnsVO> mySnsList(int cp, int ls, String sns_writer);
	public int getTotalCount();
	public SnsDTO snsContent(int bbs_idx);
	
	public String addGood(int idx, int bbs_idx);
	public String deleteGood(int idx, int bbs_idx);
	public int goodInsert(int idx, int bbs_idx);
	public int goodDelete(int idx, int bbs_idx);
	public int goodCount(int bbs_idx);
	public List goodCheck(int idx);
	
  }

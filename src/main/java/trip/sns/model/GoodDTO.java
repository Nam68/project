package trip.sns.model;

public class GoodDTO {
	public int idx;
	public int good;
	public int bbs_idx;
	
	public int getBbs_idx() {
		return bbs_idx;
	}
	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getGood() {
		return good;
	}
	public GoodDTO(int idx, int good, int bbs_idx) {
		super();
		this.idx = idx;
		this.good = good;
		this.bbs_idx = bbs_idx;
	}
	public void setGood(int good) {
		this.good = good;
	}
	
	@Override
	public String toString() {
		return "GoodDTO [idx=" + idx + ", good=" + good + "]";
	}
	
	public GoodDTO(int idx, int good) {
		super();
		this.idx = idx;
		this.good = good;
	}
	
	public GoodDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
}

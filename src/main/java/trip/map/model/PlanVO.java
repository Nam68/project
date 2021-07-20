package trip.map.model;

import trip.place.model.PlaceCartVO;

public class PlanVO {
	private int p_idx;
	private String p_name;
	private String p_content;
	private int idx;
	private PlaceCartVO pl_idx;
	private int day;
	private String img;
	
	public PlanVO() {
		super();
	}
	public PlanVO(int p_idx, String p_name, String p_content,int idx, PlaceCartVO pl_idx, int day, String img) {
		super();
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.p_content = p_content;
		this.idx = idx;
		this.pl_idx = pl_idx;
		this.day = day;
		this.img = img;
	}
	public int getP_idx() {
		return p_idx;
	}
	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getP_content() {
		return p_content;
	}
	public void setP_content(String p_content) {
		this.p_content = p_content;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public PlaceCartVO getPl_idx() {
		return pl_idx;
	}
	public void setPl_idx(PlaceCartVO pl_idx) {
		this.pl_idx = pl_idx;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}

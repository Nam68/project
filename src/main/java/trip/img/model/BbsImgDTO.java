package trip.img.model;

public class BbsImgDTO {
	
	private String bbs_img;
	private int bbs_idx;
	
	public BbsImgDTO() {
		
	}

	public BbsImgDTO(String bbs_img, int bbs_idx) {
		super();
		this.bbs_img = bbs_img;
		this.bbs_idx = bbs_idx;
	}

	public String getBbs_img() {
		return bbs_img;
	}

	public void setBbs_img(String bbs_img) {
		this.bbs_img = bbs_img;
	}

	public int getBbs_idx() {
		return bbs_idx;
	}

	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}
	
}

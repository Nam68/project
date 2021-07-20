package trip.place.model;


public class PlaceInfoDTO {

	private int p_idx;
	private int pl_idx;
	private int day;
	private String img;
	private int sunbun;
	
	public PlaceInfoDTO() {
		
	}

	public PlaceInfoDTO(int p_idx, int pl_idx, int day, String img, int sunbun) {
		super();
		this.p_idx = p_idx;
		this.pl_idx = pl_idx;
		this.day = day;
		this.img = img;
		this.sunbun = sunbun;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
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

	public int getSunbun() {
		return sunbun;
	}

	public void setSunbun(int sunbun) {
		this.sunbun = sunbun;
	}
	
	
}

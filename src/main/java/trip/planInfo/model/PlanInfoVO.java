package trip.planInfo.model;

public class PlanInfoVO {
	
	private String pl_name;
	private int pl_idx;
	private int day;
	private String pl_img;
	private double lat;
	private double lng;
	
	public PlanInfoVO() {
		
	}

	public PlanInfoVO(String pl_name, int pl_idx, int day, String pl_img, double lat, double lng) {
		super();
		this.pl_name = pl_name;
		this.pl_idx = pl_idx;
		this.day = day;
		this.pl_img = pl_img;
		this.lat = lat;
		this.lng = lng;
	}
	
	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
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

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
}

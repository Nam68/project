package trip.map.model;

public class CartDTO {
	
	private int resultdate;
	private int pl_idx;
	private String pl_name;
	private String pl_img;
	private double pl_lat;
	private double pl_lng;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(int resultdate, int pl_idx, String pl_name, String pl_img, double pl_lat, double pl_lng) {
		super();
		this.resultdate = resultdate;
		this.pl_idx = pl_idx;
		this.pl_name = pl_name;
		this.pl_img = pl_img;
		this.pl_lat = pl_lat;
		this.pl_lng = pl_lng;
	}

	public int getResultdate() {
		return resultdate;
	}

	public void setResultdate(int resultdate) {
		this.resultdate = resultdate;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public double getPl_lat() {
		return pl_lat;
	}

	public void setPl_lat(double pl_lat) {
		this.pl_lat = pl_lat;
	}

	public double getPl_lng() {
		return pl_lng;
	}

	public void setPl_lng(double pl_lng) {
		this.pl_lng = pl_lng;
	}
	
}

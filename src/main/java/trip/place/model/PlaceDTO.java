package trip.place.model;

public class PlaceDTO {
	
	private int pl_idx;
	private String pl_name;
	private String pl_content;
	private double pl_lat;
	private double pl_lng;
	private int pl_like;
	private int pl_star;
	
	public PlaceDTO() {
		
	}

	public PlaceDTO(int pl_idx, String pl_name, String pl_content, double pl_lat, double pl_lng, int pl_like, int pl_star) {
		super();
		this.pl_idx = pl_idx;
		this.pl_name = pl_name;
		this.pl_content = pl_content;
		this.pl_lat = pl_lat;
		this.pl_lng = pl_lng;
		this.pl_like = pl_like;
		this.pl_star = pl_star;
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

	public String getPl_content() {
		return pl_content;
	}

	public void setPl_content(String pl_content) {
		this.pl_content = pl_content;
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

	public int getPl_like() {
		return pl_like;
	}

	public void setPl_like(int pl_like) {
		this.pl_like = pl_like;
	}

	public int getPl_star() {
		return pl_star;
	}

	public void setPl_star(int pl_star) {
		this.pl_star = pl_star;
	}
	
}

package trip.place.model;

public class PlaceVO {
	
	private int pl_idx;
	private String pl_name;
	private String pl_content;
	private double pl_lat;
	private double pl_lng;
	private int pl_like;
	private double pl_star;
	private String pl_img;
	private String review;
	private int user_like;
	private int owner;
	
	public PlaceVO() {
		
	}

	public PlaceVO(int pl_idx, String pl_name, String pl_content, double pl_lat, double pl_lng, int pl_like,
			double pl_star, String pl_img, String review, int user_like, int owner) {
		super();
		this.pl_idx = pl_idx;
		this.pl_name = pl_name;
		this.pl_content = pl_content;
		this.pl_lat = pl_lat;
		this.pl_lng = pl_lng;
		this.pl_like = pl_like;
		this.pl_star = pl_star;
		this.pl_img = pl_img;
		this.review = review;
		this.user_like = user_like;
		this.owner = owner;
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

	public double getPl_star() {
		return pl_star;
	}

	public void setPl_star(double pl_star) {
		this.pl_star = pl_star;
	}

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getUser_like() {
		return user_like;
	}

	public void setUser_like(int user_like) {
		this.user_like = user_like;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}
	
}

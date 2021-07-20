package trip.place.model;

import java.math.BigDecimal;

public class PlaceCartVO {
	
	private String pl_idx;
	private String pl_name;
	private String pl_content;
	private BigDecimal pl_lat;
	private BigDecimal pl_lng;
	private int pl_like;
	private int pl_star;
	private String pl_img;
	private int day;
	
	public PlaceCartVO() {
	
	}

	public PlaceCartVO(String pl_idx, String pl_name, String pl_content, BigDecimal pl_lat, BigDecimal pl_lng,
			int pl_like, int pl_star, String pl_img, int day) {
		super();
		this.pl_idx = pl_idx;
		this.pl_name = pl_name;
		this.pl_content = pl_content;
		this.pl_lat = pl_lat;
		this.pl_lng = pl_lng;
		this.pl_like = pl_like;
		this.pl_star = pl_star;
		this.pl_img = pl_img;
		this.day = day;
	}

	public String getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(String pl_idx) {
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

	public BigDecimal getPl_lat() {
		return pl_lat;
	}

	public void setPl_lat(BigDecimal pl_lat) {
		this.pl_lat = pl_lat;
	}

	public BigDecimal getPl_lng() {
		return pl_lng;
	}

	public void setPl_lng(BigDecimal pl_lng) {
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

	public String getPl_img() {
		return pl_img;
	}

	public void setPl_img(String pl_img) {
		this.pl_img = pl_img;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
}

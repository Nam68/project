package trip.review.model;

public class ReviewDTO {
	
	private int r_idx;
	private int pl_idx;
	private int idx;
	private double star;
	private String review;
	
	public ReviewDTO() {
		
	}

	public ReviewDTO(int r_idx, int pl_idx, int idx, double star, String review) {
		super();
		this.r_idx = r_idx;
		this.pl_idx = pl_idx;
		this.idx = idx;
		this.star = star;
		this.review = review;
	}

	public int getR_idx() {
		return r_idx;
	}

	public void setR_idx(int r_idx) {
		this.r_idx = r_idx;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
	
}

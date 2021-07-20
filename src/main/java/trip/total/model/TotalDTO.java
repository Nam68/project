package trip.total.model;

public class TotalDTO {
	
	private int pl_idx;
	private int under20;
	private int in30;
	private int in40;
	private int in50;
	private int over60;
	private int male;
	private int female;
	
	public TotalDTO() {
		
	}

	public TotalDTO(int pl_idx, int under20, int in30, int in40, int in50, int over60, int male, int female) {
		super();
		this.pl_idx = pl_idx;
		this.under20 = under20;
		this.in30 = in30;
		this.in40 = in40;
		this.in50 = in50;
		this.over60 = over60;
		this.male = male;
		this.female = female;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public int getUnder20() {
		return under20;
	}

	public void setUnder20(int under20) {
		this.under20 = under20;
	}

	public int getIn30() {
		return in30;
	}

	public void setIn30(int in30) {
		this.in30 = in30;
	}

	public int getIn40() {
		return in40;
	}

	public void setIn40(int in40) {
		this.in40 = in40;
	}

	public int getIn50() {
		return in50;
	}

	public void setIn50(int in50) {
		this.in50 = in50;
	}

	public int getOver60() {
		return over60;
	}

	public void setOver60(int over60) {
		this.over60 = over60;
	}

	public int getMale() {
		return male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public int getFemale() {
		return female;
	}

	public void setFemale(int female) {
		this.female = female;
	}	
	
}

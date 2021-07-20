package trip.total.model;

public class TotalVO {
	
	private int pl_idx;
	private double under20;
	private double in30;
	private double in40;
	private double in50;
	private double over60;
	private double male;
	private double female;
	
	public TotalVO() {
		
	}

	public TotalVO(int pl_idx, double under20, double in30, double in40, double in50, double over60, double male,
			double female) {
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

	public double getUnder20() {
		return under20;
	}

	public void setUnder20(double under20) {
		this.under20 = under20;
	}

	public double getIn30() {
		return in30;
	}

	public void setIn30(double in30) {
		this.in30 = in30;
	}

	public double getIn40() {
		return in40;
	}

	public void setIn40(double in40) {
		this.in40 = in40;
	}

	public double getIn50() {
		return in50;
	}

	public void setIn50(double in50) {
		this.in50 = in50;
	}

	public double getOver60() {
		return over60;
	}

	public void setOver60(double over60) {
		this.over60 = over60;
	}

	public double getMale() {
		return male;
	}

	public void setMale(double male) {
		this.male = male;
	}

	public double getFemale() {
		return female;
	}

	public void setFemale(double female) {
		this.female = female;
	}
	
	
	
}

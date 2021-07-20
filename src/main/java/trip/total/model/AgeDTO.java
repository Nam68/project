package trip.total.model;

public class AgeDTO {
	
	private int under20;
	private int in30;
	private int in40;
	private int in50;
	private int over60;
	private int sum;
	
	public AgeDTO() {
		
	}

	public AgeDTO(int under20, int in30, int in40, int in50, int over60, int sum) {
		super();
		this.under20 = under20;
		this.in30 = in30;
		this.in40 = in40;
		this.in50 = in50;
		this.over60 = over60;
		this.sum = sum;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}

package trip.total.model;

public class GenderDTO {
	
	private int male;
	private int female;
	private int sum;
	
	public GenderDTO() {
		
	}

	public GenderDTO(int male, int female, int sum) {
		super();
		this.male = male;
		this.female = female;
		this.sum = sum;
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

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	
}

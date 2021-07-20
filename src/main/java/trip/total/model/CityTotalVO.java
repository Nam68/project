package trip.total.model;

public class CityTotalVO {
	
	private String city;
	private int c_idx;
	private double value;
	
	public CityTotalVO() {
		
	}

	public CityTotalVO(String city, int c_idx, double value) {
		super();
		this.city = city;
		this.c_idx = c_idx;
		this.value = value;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
}

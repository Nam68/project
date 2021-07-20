package trip.total.model;

public class CityDTO {
	
	private int c_idx;
	private String city;
	
	public CityDTO() {
		
	}

	public CityDTO(int c_idx, String city) {
		super();
		this.c_idx = c_idx;
		this.city = city;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}	
	
	
}

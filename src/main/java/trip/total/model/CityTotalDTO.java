package trip.total.model;

public class CityTotalDTO {
	
	private int pl_idx;
	private int c_idx;
	private int count;
	
	public CityTotalDTO() {
		
	}

	public CityTotalDTO(int pl_idx, int c_idx, int count) {
		super();
		this.pl_idx = pl_idx;
		this.c_idx = c_idx;
		this.count = count;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}

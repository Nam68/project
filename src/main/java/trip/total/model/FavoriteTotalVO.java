package trip.total.model;

public class FavoriteTotalVO {
	
	private String v_name;
	private int v_idx;
	private double value;
	
	public FavoriteTotalVO() {
		
	}

	public FavoriteTotalVO(String v_name, int v_idx, double value) {
		super();
		this.v_name = v_name;
		this.v_idx = v_idx;
		this.value = value;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}

	public int getV_idx() {
		return v_idx;
	}

	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	
	
}

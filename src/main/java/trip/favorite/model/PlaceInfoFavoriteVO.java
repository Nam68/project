package trip.favorite.model;

public class PlaceInfoFavoriteVO {
	
	private int pl_idx;
	private int v_idx;
	private int count;
	private String v_name;
	
	public PlaceInfoFavoriteVO() {
		
	}

	public PlaceInfoFavoriteVO(int pl_idx, int v_idx, int count, String v_name) {
		super();
		this.pl_idx = pl_idx;
		this.v_idx = v_idx;
		this.count = count;
		this.v_name = v_name;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public int getV_idx() {
		return v_idx;
	}

	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	
}

package trip.favorite.model;

public class PlaceInfoFavoriteDTO {

	private int pl_idx;
	private int v_idx;
	private int count;
	
	public PlaceInfoFavoriteDTO() {
		
	}

	public PlaceInfoFavoriteDTO(int pl_idx, int v_idx, int count) {
		super();
		this.pl_idx = pl_idx;
		this.v_idx = v_idx;
		this.count = count;
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
	
}

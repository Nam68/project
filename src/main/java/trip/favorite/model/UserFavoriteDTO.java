package trip.favorite.model;

public class UserFavoriteDTO {
	
	private int idx;
	private int v_idx;
	private int count;
	
	public UserFavoriteDTO() {
		
	}

	public UserFavoriteDTO(int idx, int v_idx, int count) {
		super();
		this.idx = idx;
		this.v_idx = v_idx;
		this.count = count;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

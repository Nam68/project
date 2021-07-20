package trip.favorite.model;

public class FavoriteDTO {
	
	private int v_idx;
	private String v_name;
	
	public FavoriteDTO() {
		
	}

	public FavoriteDTO(int v_idx, String v_name) {
		super();
		this.v_idx = v_idx;
		this.v_name = v_name;
	}

	public int getV_idx() {
		return v_idx;
	}

	public void setV_idx(int v_idx) {
		this.v_idx = v_idx;
	}

	public String getV_name() {
		return v_name;
	}

	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	
}

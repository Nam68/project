package trip.map.model;

public class PlanDTO {
	
	private int p_idx;
	private String p_name;
	private String p_content;
	private int idx;
	
	public PlanDTO() {
		
	}

	public PlanDTO(int p_idx, String p_name, String p_content, int idx) {
		super();
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.p_content = p_content;
		this.idx = idx;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
	
	
}
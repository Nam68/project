package trip.question.model;

public class QuestionDTO {
	
	private int q_idx;
	private String q_content;
	
	public QuestionDTO() {
	
	}

	public QuestionDTO(int q_idx, String q_content) {
		super();
		this.q_idx = q_idx;
		this.q_content = q_content;
	}

	public int getQ_idx() {
		return q_idx;
	}

	public void setQ_idx(int q_idx) {
		this.q_idx = q_idx;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}
	
	
}

package trip.member.model;

public class MemberDTO {
	
	private int idx;
	private String id;
	private String pwd;
	private String name;
	private int question;
	private String answer;
	private int groupidx;
	
	public MemberDTO() {
	
	}

	public MemberDTO(int idx, String id, String pwd, String name, int question, String answer, int groupidx) {
		super();
		this.idx = idx;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.question = question;
		this.answer = answer;
		this.groupidx = groupidx;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuestion() {
		return question;
	}

	public void setQuestion(int question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getGroupidx() {
		return groupidx;
	}

	public void setGroupidx(int groupidx) {
		this.groupidx = groupidx;
	}
	
}

package trip.member.model;

public class BusinessDTO {
	
	private int idx;
	private String tel;
	private String account;
	private String addr;
	
	public BusinessDTO() {
	
	}

	public BusinessDTO(int idx, String tel, String account, String addr) {
		super();
		this.idx = idx;
		this.tel = tel;
		this.account = account;
		this.addr = addr;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

package trip.member.model;

public class AdminDTO {
	
	private int idx;
	private String account;
	private int ad_price;
	private int pro_price;
	
	public AdminDTO() {
	
	}

	public AdminDTO(int idx, String account, int ad_price, int pro_price) {
		super();
		this.idx = idx;
		this.account = account;
		this.ad_price = ad_price;
		this.pro_price = pro_price;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAd_price() {
		return ad_price;
	}

	public void setAd_price(int ad_price) {
		this.ad_price = ad_price;
	}

	public int getPro_price() {
		return pro_price;
	}

	public void setPro_price(int pro_price) {
		this.pro_price = pro_price;
	}
	
}

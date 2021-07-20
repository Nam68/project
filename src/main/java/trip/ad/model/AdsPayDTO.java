package trip.ad.model;

import java.sql.Date;

public class AdsPayDTO {
	
	private int bbs_idx,pay;
	private Date countdate;

	public AdsPayDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getBbs_idx() {
		return bbs_idx;
	}

	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}

	public int getPay() {
		return pay;
	}

	public void setPay(int pay) {
		this.pay = pay;
	}

	public Date getCountdate() {
		return countdate;
	}

	public void setCountdate(Date countdate) {
		this.countdate = countdate;
	}

	public AdsPayDTO(int bbs_idx, int pay, Date countdate) {
		super();
		this.bbs_idx = bbs_idx;
		this.pay = pay;
		this.countdate = countdate;
	}
	
	
	
}

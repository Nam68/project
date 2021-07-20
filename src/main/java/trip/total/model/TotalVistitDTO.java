package trip.total.model;

import java.sql.Date;

public class TotalVistitDTO {

	private int idx, type;
	private String ip;
	private Date connectdate;
	
	public TotalVistitDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getConnectdate() {
		return connectdate;
	}

	public void setConnectdate(Date connectdate) {
		this.connectdate = connectdate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public TotalVistitDTO(int idx, int type, String ip, Date connectdate) {
		super();
		this.idx = idx;
		this.type = type;
		this.ip = ip;
		this.connectdate = connectdate;
	}

	
	
	
}

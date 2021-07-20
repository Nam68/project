package trip.ad.model;

import java.sql.Date;

public class AdVO {
	
	private int bbs_idx;
	private int a_idx;
	private String a_title;
	private String a_content;
	private String a_writer;
	private int a_limit;
	private String a_href;
	private int a_count;
	private Date a_startdate;
	private Date a_enddate;
	private int cpc;
	private double rate;
	private String a_permit;
	private String bbs_img;
	private String leftdate;
	
	public AdVO() {
		
	}

	public AdVO(int bbs_idx, int a_idx, String a_title, String a_content, String a_writer, int a_limit, String a_href,
			int a_count, Date a_startdate, Date a_enddate, int cpc, double rate, String a_permit, String bbs_img, String leftdate) {
		super();
		this.bbs_idx = bbs_idx;
		this.a_idx = a_idx;
		this.a_title = a_title;
		this.a_content = a_content;
		this.a_writer = a_writer;
		this.a_limit = a_limit;
		this.a_href = a_href;
		this.a_count = a_count;
		this.a_startdate = a_startdate;
		this.a_enddate = a_enddate;
		this.cpc = cpc;
		this.rate = rate;
		this.a_permit = a_permit;
		this.bbs_img = bbs_img;
		this.leftdate = leftdate;
	}

	public int getBbs_idx() {
		return bbs_idx;
	}

	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}

	public int getA_idx() {
		return a_idx;
	}

	public void setA_idx(int a_idx) {
		this.a_idx = a_idx;
	}

	public String getA_title() {
		return a_title;
	}

	public void setA_title(String a_title) {
		this.a_title = a_title;
	}

	public String getA_content() {
		return a_content;
	}

	public void setA_content(String a_content) {
		this.a_content = a_content;
	}

	public String getA_writer() {
		return a_writer;
	}

	public void setA_writer(String a_writer) {
		this.a_writer = a_writer;
	}

	public int getA_limit() {
		return a_limit;
	}

	public void setA_limit(int a_limit) {
		this.a_limit = a_limit;
	}

	public String getA_href() {
		return a_href;
	}

	public void setA_href(String a_href) {
		this.a_href = a_href;
	}

	public int getA_count() {
		return a_count;
	}

	public void setA_count(int a_count) {
		this.a_count = a_count;
	}

	public Date getA_startdate() {
		return a_startdate;
	}

	public void setA_startdate(Date a_startdate) {
		this.a_startdate = a_startdate;
	}

	public Date getA_enddate() {
		return a_enddate;
	}

	public void setA_enddate(Date a_enddate) {
		this.a_enddate = a_enddate;
	}

	public int getCpc() {
		return cpc;
	}

	public void setCpc(int cpc) {
		this.cpc = cpc;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getA_permit() {
		return a_permit;
	}

	public void setA_permit(String a_permit) {
		this.a_permit = a_permit;
	}

	public String getBbs_img() {
		return bbs_img;
	}

	public void setBbs_img(String bbs_img) {
		this.bbs_img = bbs_img;
	}

	public String getLeftdate() {
		return leftdate;
	}

	public void setLeftdate(String leftdate) {
		this.leftdate = leftdate;
	}
	
}

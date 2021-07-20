package trip.sns.model;

import java.sql.Date;
import java.util.ArrayList;

public class SnsVO {
	
	private int bbs_idx;
	private String sns_title;
	private String sns_content;
	private String sns_writer;
	private Date sns_writedate;
	private ArrayList<String> bbs_img;

	public SnsVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SnsVO(int bbs_idx, String sns_title, String sns_content, String sns_writer, Date sns_writedate,
			ArrayList<String> bbs_img) {
		super();
		this.bbs_idx = bbs_idx;
		this.sns_title = sns_title;
		this.sns_content = sns_content;
		this.sns_writer = sns_writer;
		this.sns_writedate = sns_writedate;
		this.bbs_img = bbs_img;
	}
	
	
	public int getBbs_idx() {
		return bbs_idx;
	}
	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}
	public String getSns_title() {
		return sns_title;
	}
	public void setSns_title(String sns_title) {
		this.sns_title = sns_title;
	}
	public String getSns_content() {
		return sns_content;
	}
	public void setSns_content(String sns_content) {
		this.sns_content = sns_content;
	}
	public String getSns_writer() {
		return sns_writer;
	}
	public void setSns_writer(String sns_writer) {
		this.sns_writer = sns_writer;
	}
	public Date getSns_writedate() {
		return sns_writedate;
	}
	public void setSns_writedate(Date sns_writedate) {
		this.sns_writedate = sns_writedate;
	}
	public ArrayList<String> getBbs_img() {
		return bbs_img;
	}
	public void setBbs_img(ArrayList<String> bbs_img) {
		this.bbs_img = bbs_img;
	}
	
}

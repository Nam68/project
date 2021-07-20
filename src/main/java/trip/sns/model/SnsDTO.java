package trip.sns.model;

import java.sql.Date;

public class SnsDTO {
	private int bbs_idx;
	private String sns_title;
	private String sns_content;
	private String sns_writer;
	private Date sns_writedate;
	private String bbs_img;
	private long commentCount;
	
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
	public String getBbs_img() {
		return bbs_img;
	}
	public void setBbs_img(String bbs_img) {
		this.bbs_img = bbs_img;
	}
	public long getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(long commentCount) {
		this.commentCount = commentCount;
	}
	
	
	public SnsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SnsDTO(int bbs_idx, String sns_title, String sns_content, String sns_writer, Date sns_writedate,
			String bbs_img, long commentCount) {
		super();
		this.bbs_idx = bbs_idx;
		this.sns_title = sns_title;
		this.sns_content = sns_content;
		this.sns_writer = sns_writer;
		this.sns_writedate = sns_writedate;
		this.bbs_img = bbs_img;
		this.commentCount = commentCount;
	}

}


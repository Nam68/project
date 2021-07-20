package trip.notice.model;

import java.sql.Date;

public class NoticeDTO {

	private int n_idx;
	private String n_title;
	private String n_content;
	private String n_writer;
	private Date n_writedate;
	private int n_readnum;
	
	public NoticeDTO() {
		super();
	}

	public NoticeDTO(int n_idx, String n_title, String n_content, String n_writer, Date n_writedate, int n_readnum) {
		super();
		this.n_idx = n_idx;
		this.n_title = n_title;
		this.n_content = n_content;
		this.n_writer = n_writer;
		this.n_writedate = n_writedate;
		this.n_readnum = n_readnum;
	}

	public int getN_idx() {
		return n_idx;
	}

	public void setN_idx(int n_idx) {
		this.n_idx = n_idx;
	}

	public String getN_title() {
		return n_title;
	}

	public void setN_title(String n_title) {
		this.n_title = n_title;
	}

	public String getN_content() {
		return n_content;
	}

	public void setN_content(String n_content) {
		this.n_content = n_content;
	}

	public String getN_writer() {
		return n_writer;
	}

	public void setN_writer(String n_writer) {
		this.n_writer = n_writer;
	}

	public Date getN_writedate() {
		return n_writedate;
	}

	public void setN_writedate(Date n_writedate) {
		this.n_writedate = n_writedate;
	}

	public int getN_readnum() {
		return n_readnum;
	}

	public void setN_readnum(int n_readnum) {
		this.n_readnum = n_readnum;
	}

	
	
}

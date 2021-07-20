package trip.qna.model;

import java.sql.Date;

public class QnADTO {

	private int bbs_idx;
	private String q_title, q_content, q_writer;
	private Date q_writedate;
	
	public QnADTO() {
		super();
	}

	public QnADTO(int bbs_idx, String q_title, String q_content, String q_writer, Date q_writedate) {
		super();
		this.bbs_idx = bbs_idx;
		this.q_title = q_title;
		this.q_content = q_content;
		this.q_writer = q_writer;
		this.q_writedate = q_writedate;
	}

	public int getBbs_idx() {
		return bbs_idx;
	}

	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_content() {
		return q_content;
	}

	public void setQ_content(String q_content) {
		this.q_content = q_content;
	}

	public String getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
	}

	public Date getQ_writedate() {
		return q_writedate;
	}

	public void setQ_writedate(Date q_writedate) {
		this.q_writedate = q_writedate;
	}
	
	
}

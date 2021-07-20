package trip.comment.model;

import java.util.Date;

public class CommentVO {
	
	private int c_idx;
	private String c_writer;
	private String c_content;
	private Date c_writedate;
	private int bbs_idx;
	
	public int getC_idx() {
		return c_idx;
	}
	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}
	public String getC_writer() {
		return c_writer;
	}
	public void setC_writer(String c_writer) {
		this.c_writer = c_writer;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public Date getC_writedate() {
		return c_writedate;
	}
	public void setC_writedate(Date c_writedate) {
		this.c_writedate = c_writedate;
	}
	public int getBbs_idx() {
		return bbs_idx;
	}
	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}
	
	
	public CommentVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommentVO(int c_idx, String c_writer, String c_content, Date c_writedate, int bbs_idx) {
		super();
		this.c_idx = c_idx;
		this.c_writer = c_writer;
		this.c_content = c_content;
		this.c_writedate = c_writedate;
		this.bbs_idx = bbs_idx;
	}
	
	@Override
	public String toString() {
		return "CommentVO [c_idx=" + c_idx + ", c_writer=" + c_writer + ", c_content=" + c_content + ", c_writedate="
				+ c_writedate + ", bbs_idx=" + bbs_idx + "]";
	}

	
	
	
}

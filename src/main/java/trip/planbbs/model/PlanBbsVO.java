package trip.planbbs.model;

import java.sql.*;

import org.springframework.web.multipart.MultipartFile;

public class PlanBbsVO {
	
	int idx; //member idx
	String id;//member id
	int p_idx; //플랜 넘버
	String p_name; //플랜 제목
	String p_content;//플랜 내용
	int bbs_idx;
	String plan_title;
	String plan_content;
	String plan_writer;
	Date plan_writedate;
	int pl_idx;//플레이스 인덱스 (장소가져올때)
	int day;
	String img;
	String pl_name;
	
	public PlanBbsVO() {
		super();
	}

	public PlanBbsVO(int idx, String id, int p_idx, String p_name, String p_content, int bbs_idx, String plan_title,
			String plan_content, String plan_writer, Date plan_writedate, int pl_idx, int day, String img,
			String pl_name) {
		super();
		this.idx = idx;
		this.id = id;
		this.p_idx = p_idx;
		this.p_name = p_name;
		this.p_content = p_content;
		this.bbs_idx = bbs_idx;
		this.plan_title = plan_title;
		this.plan_content = plan_content;
		this.plan_writer = plan_writer;
		this.plan_writedate = plan_writedate;
		this.pl_idx = pl_idx;
		this.day = day;
		this.img = img;
		this.pl_name = pl_name;
	}

	
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getP_idx() {
		return p_idx;
	}

	public void setP_idx(int p_idx) {
		this.p_idx = p_idx;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getBbs_idx() {
		return bbs_idx;
	}

	public void setBbs_idx(int bbs_idx) {
		this.bbs_idx = bbs_idx;
	}

	public String getPlan_title() {
		return plan_title;
	}

	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}

	public String getPlan_content() {
		return plan_content;
	}

	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}

	public String getPlan_writer() {
		return plan_writer;
	}

	public void setPlan_writer(String plan_writer) {
		this.plan_writer = plan_writer;
	}

	public Date getPlan_writedate() {
		return plan_writedate;
	}

	public void setPlan_writedate(Date plan_writedate) {
		this.plan_writedate = plan_writedate;
	}

	public int getPl_idx() {
		return pl_idx;
	}

	public void setPl_idx(int pl_idx) {
		this.pl_idx = pl_idx;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getPl_name() {
		return pl_name;
	}

	public void setPl_name(String pl_name) {
		this.pl_name = pl_name;
	}
	
	


	
	
	
	
	
	
	

}

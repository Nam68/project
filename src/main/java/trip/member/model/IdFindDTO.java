package trip.member.model;

import java.sql.Date;

public class IdFindDTO {

	private String id;
	private Date joindate;
	
	public IdFindDTO() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public IdFindDTO(String id, Date joindate) {
		super();
		this.id = id;
		this.joindate = joindate;
	}
	
	
	
}

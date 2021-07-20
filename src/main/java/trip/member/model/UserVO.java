package trip.member.model;

import java.sql.Date;

public class UserVO {
	
	private int idx, gender,c_idx;
	private String tel;
	private Date age;
	
	public UserVO() {
		
	}
	



	public UserVO(int idx, int gender, int c_idx, String tel, Date age) {
		super();
		this.idx = idx;
		this.gender = gender;
		this.c_idx = c_idx;
		this.tel = tel;
		this.age = age;
	}




	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}



	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getC_idx() {
		return c_idx;
	}

	public void setC_idx(int c_idx) {
		this.c_idx = c_idx;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}
	
	
	
	
}
package trip.member.model;

import java.sql.Date;

public class UserDTO {
	
	private int idx,gender,c_idx,over_ten,over_twenty,over_thirty,over_forty,over_fifty,over_sixty;
	private String tel,a1,b1,c1,d1,e1,f1,gen;
	private Date age;
	
	public UserDTO() {
		super();
	}

	public UserDTO(int idx, int gender, int c_idx, int over_ten, int over_twenty, int over_thirty, int over_forty,
			int over_fifty, int over_sixty, String tel, String a1, String b1, String c1, String d1, String e1,
			String f1, String gen, Date age) {
		super();
		this.idx = idx;
		this.gender = gender;
		this.c_idx = c_idx;
		this.over_ten = over_ten;
		this.over_twenty = over_twenty;
		this.over_thirty = over_thirty;
		this.over_forty = over_forty;
		this.over_fifty = over_fifty;
		this.over_sixty = over_sixty;
		this.tel = tel;
		this.a1 = a1;
		this.b1 = b1;
		this.c1 = c1;
		this.d1 = d1;
		this.e1 = e1;
		this.f1 = f1;
		this.gen = gen;
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

	public int getOver_ten() {
		return over_ten;
	}

	public void setOver_ten(int over_ten) {
		this.over_ten = over_ten;
	}

	public int getOver_twenty() {
		return over_twenty;
	}

	public void setOver_twenty(int over_twenty) {
		this.over_twenty = over_twenty;
	}

	public int getOver_thirty() {
		return over_thirty;
	}

	public void setOver_thirty(int over_thirty) {
		this.over_thirty = over_thirty;
	}

	public int getOver_forty() {
		return over_forty;
	}

	public void setOver_forty(int over_forty) {
		this.over_forty = over_forty;
	}

	public int getOver_fifty() {
		return over_fifty;
	}

	public void setOver_fifty(int over_fifty) {
		this.over_fifty = over_fifty;
	}

	public int getOver_sixty() {
		return over_sixty;
	}

	public void setOver_sixty(int over_sixty) {
		this.over_sixty = over_sixty;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getA1() {
		return a1;
	}

	public void setA1(String a1) {
		this.a1 = a1;
	}

	public String getB1() {
		return b1;
	}

	public void setB1(String b1) {
		this.b1 = b1;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getD1() {
		return d1;
	}

	public void setD1(String d1) {
		this.d1 = d1;
	}

	public String getE1() {
		return e1;
	}

	public void setE1(String e1) {
		this.e1 = e1;
	}

	public String getF1() {
		return f1;
	}

	public void setF1(String f1) {
		this.f1 = f1;
	}

	public String getGen() {
		return gen;
	}

	public void setGen(String gen) {
		this.gen = gen;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}
	
}

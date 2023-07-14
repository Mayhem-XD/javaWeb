package ch00;

import java.time.LocalDate;

public class Member {
	private String mid;
	private String password;
	private String uname;
	private int age;
	private char sex;
	private String email;
	private LocalDate regDate;
	private int isDeleted;
	
	
	
	public Member() {
		super();
	}
	
	


	public Member(String mid, String password, String uname, int age, char sex, String email) {
		super();
		this.mid = mid;
		this.password = password;
		this.uname = uname;
		this.age = age;
		this.sex = sex;
		this.email = email;
	}




	public Member(String mid, String password, String uname, int age, char sex, String email, LocalDate regDate,
			int isDeleted) {
		super();
		this.mid = mid;
		this.password = password;
		this.uname = uname;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.regDate = regDate;
		this.isDeleted = isDeleted;
	}




	public String getMid() {
		return mid;
	}




	public void setMid(String mid) {
		this.mid = mid;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public char getSex() {
		return sex;
	}




	public void setSex(char sex) {
		this.sex = sex;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public LocalDate getRegDate() {
		return regDate;
	}




	public void setRegDate(LocalDate regDate) {
		this.regDate = regDate;
	}




	public int getIsDeleted() {
		return isDeleted;
	}




	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}




	@Override
	public String toString() {
		return "Member [mid=" + mid + ", password=" + password + ", uname=" + uname + ", age=" + age + ", sex=" + sex
				+ ", email=" + email + ", regDate=" + regDate + ", isDeleted=" + isDeleted + "]";
	}
	
	
	
	
}


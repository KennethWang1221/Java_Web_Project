package login.vo;

public class UserVo {
	/*
	 * 值对象一般和数据库的某张数据表字段一一对应
	 * */
	private int uid;
	private String usname;
	private String psword;
	private int grade;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsname() {
		return usname;
	}
	public void setUsname(String usname) {
		this.usname = usname;
	}
	public String getPsword() {
		return psword;
	}
	public void setPsword(String psword) {
		this.psword = psword;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	//构造方法默认无参
	
	

}

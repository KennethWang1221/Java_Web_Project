package user.vo;

public class UserVo {
	private int uid;
	private String usname;
	private String psword;
	private String address;
	//private boolean shuoshi;
	private String email;
	private char sex;
	private String birthday;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	//����Զ���һ���޲ι�����
	public UserVo(){}
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/* ��JavaBean�У������������boolean���ͣ���getter������Ҫ��ΪisXxx
	 * public boolean isShuoshi() {
		return shuoshi;
	}
	public void setShuoshi(boolean shuoshi) {
		this.shuoshi = shuoshi;
	}*/
	
	//...
	
	

}

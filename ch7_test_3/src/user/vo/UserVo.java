package user.vo;

public class UserVo {
	/**
	 * 数据库中，用户信息表的对应VO类，和数据表中表示“用户”信息的记录进行映射
	 * 
	 * */
	private int uid;
	private String username;
	private String password;
	private String address;
	private String email;
	private char sex;
	private String birthday;
	//private int age;
	//默认无参的构造器，最好自定义一个
	public UserVo(){  }
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
    
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
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
	
		
	
	
}

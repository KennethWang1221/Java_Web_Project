package user.vo;

public class UserVo {
	/**
	 * ���ݿ��У��û���Ϣ��Ķ�ӦVO�࣬�����ݱ��б�ʾ���û�����Ϣ�ļ�¼����ӳ��
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
	//Ĭ���޲εĹ�����������Զ���һ��
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

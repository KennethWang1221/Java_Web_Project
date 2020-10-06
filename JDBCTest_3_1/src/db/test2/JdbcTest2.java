package db.test2;

import java.sql.*;

public class JdbcTest2 {
	//jdbc������
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	//���ݿ����
	String dbdriver="com.mysql.jdbc.Driver";
	String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
	String usn="root";
	String psd="123456";
	
	//��ȡ����
	public Connection getConn(){
		try {
			Class.forName(dbdriver);
			conn=DriverManager.getConnection(dburl,usn,psd);
					
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	//ʹ��Ԥ�����������޸ļ�¼��һ�㶼�Ǿ�ȷ��λ�޸�
	/*
	 * sql��䳣�õ������֣�DDL��DML��CRUD������������sql���ʱ����ɾ�Ĳ����ַ����У����˲�ѯ����
	 * ��������������ֶ�����int
	 * */
	public int modifyById(UserVo user){
		int res=0;
		
		try {
			conn=this.getConn();
			String sql="update userinfo1 set usname=?,psword=?,address=?,email=?,sex=?,age=? where uid=?";
			pstmt=conn.prepareStatement(sql);
			//��ռλ�����θ�ֵ
			pstmt.setString(1, user.getUsname());
			pstmt.setString(2, user.getPsword());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getSex()+"");
			pstmt.setInt(6, user.getAge());
			pstmt.setInt(7, user.getUid());
			//Ԥ������������sql����dbmsִ��ʱ��û�в���
			res=pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.close();
		}
		
		return res;
	}
	
	//ɾ����¼��һ��Ҳ�Ǿ�ȷ��λ
	public int deleteById(int uid){
		int res=0;
		try {
			
			conn=this.getConn();
			stmt=conn.createStatement();
			String sql="delete from userinfo1 where uid="+uid;
			res=stmt.executeUpdate(sql);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			this.close();
		}
		
		return res;
	}
	
	//��ѯ���ݣ�������ʾ
	public void getAllUsers(){
		try {
			conn=this.getConn();
			stmt=conn.createStatement();
			String sql="select * from userinfo1";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()){
				System.out.print(rs.getInt("uid")+"   ");
				System.out.print(rs.getString("usname")+"   ");
				System.out.print(rs.getString("psword")+"   ");
				System.out.print(rs.getString("address")+"   ");
				System.out.println();
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally{
			this.close();
		}
	}
	
	//��װ�ر����ݿ���Դ�ķ���
	public void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		UserVo user=new UserVo();
		user.setUid(1);
		user.setUsname("����");
		user.setPsword("333");
		user.setAddress("���");
		user.setAge(32);
		user.setEmail("liao@sina.com");
		user.setSex('��');
		
		JdbcTest2 jt=new JdbcTest2();
		//int res=jt.modifyById(user);
		
		/*int res=jt.deleteById(3);
		if(res>0){
			System.out.println("ɾ���ɹ�");
		}
		else {
			System.out.println("ɾ��ʧ��");
		}*/
		
		jt.getAllUsers();
	}

}

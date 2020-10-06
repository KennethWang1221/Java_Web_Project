package user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import user.vo.UserVo;

public class UserDao {
	/*
	 * ��װ�����ݿ���ĳ�����ݱ��CRUD����
	 * 
	 * */
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	 //��ƻ�ȡ���ӵķ�������������Dao��Ҳ��Ҫʹ�ã����Ӧ�õ�����װһ����
	
	//���һ���û������ݿ⣬�����ӵķ�������Ʒ���ʱ������Խ��Խ��
	public int addUser(UserVo user){
		int res=0;
		try {
			//��ȡ���Ӷ���
			conn=new GetConn().getConn();
			String sql="insert into userinfo(username,password,address,email,sex,age) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//Ϊռλ����ֵ
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getSex()+"");
			pstmt.setString(6, user.getBirthday());
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
	
	//��ȡȫ���û���Ϣ
	public List getAllUsers(){
		List li=null;
		try {
			conn=new GetConn().getConn();
			stmt=conn.createStatement();
			String sql="select * from userinfo";
			rs=stmt.executeQuery(sql);
			//��rs��������б���
			//List�ǽӿڣ�����ʵ����Ϊʵ�������
			li=new ArrayList();
			while(rs.next()){
				//һ����¼����Ӧһ��VO����
				UserVo user=new UserVo();
				
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setBirthday(rs.getString("birthday"));
				//��ؽ�vo������ӵ�List���϶�����
				li.add(user);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.close();
		}
		return li;
	}
	
	//����id��ֵ������һ����¼��ת��vo����
	public UserVo findUserById(int uid){
		UserVo user=null;
		try {
			conn=new GetConn().getConn();
			String sql="select * from userinfo where uid="+uid;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//��Ϊ֮����һ����¼
			if(rs.next()){
				//ʵ����vo����
				user=new UserVo();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setBirthday(rs.getString("birthday"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.close();
		}
			
		return user;
	}
	
	//����һ��vo���󣬶�ԭ��¼�����޸�
	public int updateUser(UserVo u){
		int res=0;
		try {
			conn=new GetConn().getConn();
			String sql="update userinfo set username=?,password=?,address=?,email=?,sex=?,age=? where uid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getAddress());
			pstmt.setString(4, u.getEmail());
			pstmt.setString(5, u.getSex()+"");
			pstmt.setString(6, u.getBirthday());
			pstmt.setInt(7, u.getUid());
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
	
	//�ر���Դ
	public void close(){
		try {
			if(rs!=null){
				rs.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(conn!=null){
				conn.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

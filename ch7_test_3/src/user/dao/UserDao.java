package user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import user.vo.UserVo;

public class UserDao {
	/*
	 * 封装对数据库中某张数据表的CRUD访问
	 * 
	 * */
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	 //设计获取连接的方法，但是其他Dao类也需要使用，因此应该单独封装一个类
	
	//添加一个用户到数据库，设计添加的方法，设计方法时，参数越少越好
	public int addUser(UserVo user){
		int res=0;
		try {
			//获取连接对象
			conn=new GetConn().getConn();
			String sql="insert into userinfo(username,password,address,email,sex,age) values(?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			//为占位符赋值
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
	
	//获取全部用户信息
	public List getAllUsers(){
		List li=null;
		try {
			conn=new GetConn().getConn();
			stmt=conn.createStatement();
			String sql="select * from userinfo";
			rs=stmt.executeQuery(sql);
			//对rs结果集进行遍历
			//List是接口，必须实例化为实现类对象
			li=new ArrayList();
			while(rs.next()){
				//一条记录，对应一个VO对象
				UserVo user=new UserVo();
				
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setEmail(rs.getString("email"));
				user.setSex(rs.getString("sex").charAt(0));
				user.setBirthday(rs.getString("birthday"));
				//务必将vo对象，添加到List集合对象中
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
	
	//根据id的值，查找一条记录，转换vo对象
	public UserVo findUserById(int uid){
		UserVo user=null;
		try {
			conn=new GetConn().getConn();
			String sql="select * from userinfo where uid="+uid;
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			//因为之查找一条记录
			if(rs.next()){
				//实例化vo对象
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
	
	//根据一个vo对象，对原记录进行修改
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
	
	//关闭资源
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

package db.test2;

import java.sql.*;

public class JdbcTest2 {
	//jdbc三剑客
	Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	//数据库参数
	String dbdriver="com.mysql.jdbc.Driver";
	String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
	String usn="root";
	String psd="123456";
	
	//获取连接
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
	
	
	//使用预处理语句对象，修改记录，一般都是精确定位修改
	/*
	 * sql语句常用的有两种：DDL，DML（CRUD），语句对象发送sql语句时，增删改查四种访问中，除了查询返回
	 * 结果集，其他三种都返回int
	 * */
	public int modifyById(UserVo user){
		int res=0;
		
		try {
			conn=this.getConn();
			String sql="update userinfo1 set usname=?,psword=?,address=?,email=?,sex=?,age=? where uid=?";
			pstmt=conn.prepareStatement(sql);
			//对占位符依次赋值
			pstmt.setString(1, user.getUsname());
			pstmt.setString(2, user.getPsword());
			pstmt.setString(3, user.getAddress());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getSex()+"");
			pstmt.setInt(6, user.getAge());
			pstmt.setInt(7, user.getUid());
			//预处理语句对象发送sql语句给dbms执行时，没有参数
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
	
	//删除记录，一般也是精确定位
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
	
	//查询数据，遍历显示
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
	
	//封装关闭数据库资源的方法
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
		user.setUsname("张辽");
		user.setPsword("333");
		user.setAddress("许昌");
		user.setAge(32);
		user.setEmail("liao@sina.com");
		user.setSex('男');
		
		JdbcTest2 jt=new JdbcTest2();
		//int res=jt.modifyById(user);
		
		/*int res=jt.deleteById(3);
		if(res>0){
			System.out.println("删除成功");
		}
		else {
			System.out.println("删除失败");
		}*/
		
		jt.getAllUsers();
	}

}

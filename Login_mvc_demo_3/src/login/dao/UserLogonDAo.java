package login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import login.vo.UserVo;

public class UserLogonDAo {
	Connection conn=null;
	Statement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	//登录判断
	public UserVo checkUserLogin(String usn,String psd){
		UserVo u=null;
		try {
			conn=new GetConn().getConn();
			String sql="select * from userinfo3 where usname='"+usn+"'";
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				if(psd.equals(rs.getString("psword"))){
					u=new UserVo();
					u.setUid(rs.getInt("uid"));
					u.setUsname(rs.getString("usname"));
					u.setPsword(rs.getString("psword"));
					u.setAddress(rs.getString("address"));
					u.setEmail(rs.getString("email"));
					u.setSex(rs.getString("sex").charAt(0));
					u.setBirthday(rs.getString("birthday"));
				}
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			this.close();
		}
		return u;
	}
	
	//由于对数据库资源的释放，经常使用，所以封装方法
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

}

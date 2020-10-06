package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConn {
	//static Connection conn=null;
	
	public Connection getConn(){
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","root");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
				
		return conn;
	}

}

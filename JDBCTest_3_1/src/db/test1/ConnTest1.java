package db.test1;

import java.sql.*;

public class ConnTest1 {
	/*
	 * JDBC�������ݿ��Ϊ�����׶Σ�
	 * 1 ��ȡ���ݿ������
	 * 2 �����ݿ�dbms����sql���
	 * 3 ����dbmsִ��sql���Ľ��
	 * */
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	public void getConn(){
		/*
		 * ����MySql���ݿ⣬��ȡ���Ӷ���
		 * */
		//ʵ����һ���������ݿ����������
		//Java�д��������࣬��������ȫ�޶����������ȫ��
		try {
			new com.mysql.jdbc.Driver();
			//�����������ʵ�����ɹ��������ڴ��л����һ��Mysql���ݿ���������
			//DriverManager����������񣬾����ҵ�
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","123456");
			//���connʵ�����ɹ������ʾ�������ݿ�ɹ�
			if(conn!=null){
				System.out.println("mysql���ݿ����ӳɹ���");
			}
			else {
				System.out.println("mysql���ݿ�����ʧ��");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//ʹ��conn���󣬴���������
	public void getStmt() {
		if(conn!=null){
			try {
				stmt=conn.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	//��ȡĳ�����ݱ�ļ�¼��
	public void getCount(){
		if(stmt!=null){
			int res=0;
			String sql="select count(*) from t_table";
			try {
				rs=stmt.executeQuery(sql);
				
				if(rs.next()){
					res=rs.getInt(1);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(res);
			
			
			
			
		}
	}
	
	public static void main(String[] args) {
		ConnTest1 t1=new ConnTest1();
		t1.getConn();
		t1.getStmt();
		t1.getCount();
		
		
		
		
	}
	

}

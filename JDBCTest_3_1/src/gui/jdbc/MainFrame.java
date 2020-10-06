package gui.jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
/*
 * eclipse  RCP  版本
 * */

public class MainFrame extends JFrame {
	JButton btn_test=null;
	JButton btn_list=null;
	JButton btn_exit=null;
	JPanel pn1,pn2;
	JScrollPane jsp=null;
	JTable table=null;
	Vector colNames;
	//jdbc的对象
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	//构造方法
	public MainFrame(){
		btn_test=new JButton("测试连接");
		btn_test.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","123456");
					if(conn!=null){
						JOptionPane.showMessageDialog(MainFrame.this, "连接测试成功！");				
					}
					else {
						JOptionPane.showMessageDialog(MainFrame.this, "连接测试失败！");
					}
					
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				
			}
			
		});
		
		btn_list=new JButton("显示数据");
		btn_list.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if(conn==null){
						Class.forName("com.mysql.jdbc.Driver");
						conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","123456");
					}
					//如果还没有连上
					if(conn==null){
						JOptionPane.showMessageDialog(null, "数据库连接异常！");
						return;
					}
					
					stmt=conn.createStatement();
					String sql="select * from userinfo1";
					rs=stmt.executeQuery(sql);
					
					Vector userData=new Vector();				
					
					while(rs.next()){
						Vector row=new Vector();
						row.add(rs.getInt(1));
						row.add(rs.getString(2));
						row.add(rs.getString(3));
						row.add(rs.getString(4));
						row.add(rs.getString(5));
						row.add(rs.getString(6));
						row.add(rs.getInt(7));						
						
						userData.add(row);
						
					}
					
					table=new JTable(userData, colNames);
					jsp=new JScrollPane(table);
					
					MainFrame.this.add(jsp);
					MainFrame.this.setVisible(true);
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				finally {
					//close
				}
				
			}
			
		});
		
		btn_exit=new JButton("退出");
		btn_exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//关闭资源
				
				System.exit(0);
			}
			
		});
		
		pn1=new JPanel();
		pn1.add(btn_test);
		pn1.add(btn_list);
		pn1.add(btn_exit);
		
		this.add(pn1, BorderLayout.NORTH);
		
		//放置表格组件
		colNames=new Vector();
		colNames.add("编号");
		colNames.add("用户名");
		colNames.add("密码");
		colNames.add("地址");
		colNames.add("邮箱");
		colNames.add("性别");
		colNames.add("年龄");
		
		Vector userData=new Vector();
		Vector rowData=new Vector();
		rowData.add(1);
		rowData.add("老王");
		rowData.add("www");
		rowData.add("王家坟");
		rowData.add("ww@sin.com");
		rowData.add("男");
		rowData.add(32);
		userData.add(rowData);
		
		rowData=new Vector();
		rowData.add(2);
		rowData.add("老李");
		rowData.add("lll");
		rowData.add("李家坑");
		rowData.add("ll@sin.com");
		rowData.add("男");
		rowData.add(36);
		userData.add(rowData);
		
		table=new JTable(userData, colNames);
		jsp=new JScrollPane(table);
		
		this.add(jsp);
		
		this.setSize(600,400);
		this.setLocation(100, 50);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new MainFrame();
		
		
	}

}

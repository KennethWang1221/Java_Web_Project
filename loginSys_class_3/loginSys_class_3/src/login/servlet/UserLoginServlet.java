package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import login.vo.UserVo;

@WebServlet(urlPatterns="/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	/*
	 * JDBC链接数据库，分三步，分别由一名剑客处理。
	 * 
	 * */
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;	
	HttpSession session=null;
	PrintWriter out=null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		out=resp.getWriter();
		session=req.getSession();
		//读取表单数据
		String usname=req.getParameter("usname");
		String psword=req.getParameter("psword");
		String yzm=req.getParameter("randomCode");
		//是否Cookie登录
		String ck=req.getParameter("login");
		if(ck==null){
			ck="";
		}

		if("ck".equals(ck)){
			this.loginNoCokie(usname, psword);
			//System.out.println(usname+"  "+psword);
			return;
		}
		//System.out.println(yzm);
		
		if(usname==null || psword==null || yzm==null){
			out.println("<script>");
			out.println("alert(\"输入信息不能为空！\");");
			out.println("window.location.href=\"login.jsp\";");
			out.println("</script>");
			return;
		}
		if("".equals(yzm) || "".equals(usname)){
			out.println("<script>");
			out.println("alert(\"输入信息不能为空！\");");
			out.println("window.location.href=\"login.jsp\";");
			out.println("</script>");
			return;
		}
		
		//判断验证码，不正确直接pass
		
		String yzm2=(String)session.getAttribute("randomCode");
		
		if(!(yzm.equals(yzm2))){
			out.println("<script>");
			out.println("alert(\"验证码输入有误！\");");
			out.println("window.location.href=\"login.jsp\";");
			out.println("</script>");
			return;
		}
		
		//获取Cookie时效的参数
		String shixiao=req.getParameter("shixiao");
		//处理有效性
		if(shixiao==null){
			shixiao="now";
		}
		
		//根据不同的cookie时效，进行处理
		if("now".equals(shixiao)){
			this.loginNoCokie(usname, psword);
		}
		
		int age=0;
		if("week".equals(shixiao)){
			age=60*60*24*7;
			this.loginAddCokie(usname, psword, age, resp);
		}
		
		if("month".equals(shixiao)){
			age=60*60*24*30;
			this.loginAddCokie(usname, psword, age, resp);
		}

		
	}
	
	public void loginNoCokie(String usname,String psword){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","123456");
			//System.out.println(conn);
			
			//从连接产生语句对象
			stmt=conn.createStatement();			
			
			//语句可以将sql语句发送给数据库
			String sql="select * from t_table where usname='"+usname+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				String psd=rs.getString("psword");
				if(psd.equals(psword)){
					//登录成功
					UserVo user=new UserVo();
					user.setUid(rs.getInt(1));
					user.setUsname(rs.getString(2));
					user.setPsword(psd);
					user.setGrade(rs.getInt(4));					
					session.setAttribute("user", user);
					
					//给用户提示，跳转
					out.println("<script>");
					out.println("alert(\"登录成功！\");");
					out.println("window.location.href=\"manager.jsp\";");
					out.println("</script>");					
				}
				else{
					out.println("<script>");
					out.println("alert(\"输入信息有误，登录失败！\");");
					out.println("window.location.href=\"login.jsp?input=ok\";");
					out.println("</script>");					
				}
			}
			else {
				out.println("<script>");
				out.println("alert(\"输入信息有误，登录失败！\");");
				out.println("window.location.href=\"login.jsp?input=ok\";");
				out.println("</script>");				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			catch(Exception e){
				
			}			
		}
	}
	
	public void loginAddCokie(String usname,String psword, int age, HttpServletResponse resp){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/logintest","root","123456");
			//System.out.println(conn);
			
			//从连接产生语句对象
			stmt=conn.createStatement();			
			
			//语句可以将sql语句发送给数据库
			String sql="select * from t_table where usname='"+usname+"'";
			rs=stmt.executeQuery(sql);
			if(rs.next()){
				String psd=rs.getString("psword");
				if(psd.equals(psword)){
					//登录成功
					UserVo user=new UserVo();
					user.setUid(rs.getInt(1));
					user.setUsname(rs.getString(2));
					user.setPsword(psd);
					user.setGrade(rs.getInt(4));
					//将登陆成功的用户对象放入session
					session.setAttribute("user", user);
					
					//将用户名和密码添加到Cookie，保存在客户端
					Cookie ck1=new Cookie("usn",usname);
					Cookie ck2=new Cookie("psd",psword);
					ck1.setMaxAge(age);
					ck2.setMaxAge(age);
					resp.addCookie(ck1);
					resp.addCookie(ck2);
					
					//给用户提示，跳转
					out.println("<script>");
					out.println("alert(\"登录成功！\");");
					out.println("window.location.href=\"manager.jsp\";");
					out.println("</script>");					
				}
				else{
					out.println("<script>");
					out.println("alert(\"输入信息有误，登录失败！\");");
					out.println("window.location.href=\"login.jsp\";");
					out.println("</script>");					
				}
			}
			else {
				out.println("<script>");
				out.println("alert(\"输入信息有误，登录失败！\");");
				out.println("window.location.href=\"login.jsp\";");
				out.println("</script>");				
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}
			catch(Exception e){
				
			}			
		}
	}

}

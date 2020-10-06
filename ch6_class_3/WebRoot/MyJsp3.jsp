<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD张三 HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp3.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2>从数据库中读取所有的用户信息，并列表显示</h2>
    <%!
    //连接数据库的三剑客
    Connection conn=null;
    Statement stmt=null;
    ResultSet rs=null;
    String DBDriver="com.mysql.jdbc.Driver";
    String dburl="jdbc:mysql://127.0.0.1:3306/logintest";
    String usn="root";
    String psd="123";
    
     %>
    
    <%
    //获取数据库连接
    Class.forName(DBDriver);
    conn=DriverManager.getConnection(dburl,usn,psd);
    //out.println(conn);
    
    //通过连接对象，获取语句对象
    stmt=conn.createStatement();
    String sql="select * from users";
    //返回语句对象发送sql语句之后，dbms返回的结果
    rs=stmt.executeQuery(sql);
    //根据rs结果集的内容，遍历输出或者进一步的处理
    
    %>
    <table width="600" border="1" align="center">
    <tr>
    	<th>编号</th>
    	<th>用户名</th>
    	<th>密码</th>
    	<th>级别</th>
    </tr>
    <%
    while(rs.next()){
    	%>
    	<tr>
    	<td><%=rs.getInt(1) %></td>
    	<td><%=rs.getString(2) %></td>
    	<td><%=rs.getString(3) %></td>
    	<td><%out.print(rs.getString(4)); %></td>
    	</tr>
    	<%
    }
    
    
     %>
    </table>
  </body>
</html>

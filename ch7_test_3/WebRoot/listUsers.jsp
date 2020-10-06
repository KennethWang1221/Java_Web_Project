<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="user.dao.*,user.vo.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>显示所有用户信息</title>
    
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
  <br><br>
    <%
    //Jsp页面程序中，禁止导入java.sql包
    //调用dao对象的方法，获取封装记录映射的vo对象的集合
    List al=new UserDao().getAllUsers();
    //检测vo对象的集合有无数据
    if(al!=null && al.size()>0){
    	%>
    	<table width="800" border="1" align="center">
    	<tr>
    	<td>编号</td>
    	<td>用户名</td>
    	<td>密码</td>
    	<td>地址</td>
    	<td>邮箱</td>
    	<td>性别</td>
    	<td>年龄</td>
    	<td>编辑</td>
    	<td>删除</td>
    	</tr>
    	<%
    	for(int i=0;i<al.size();i++){
    		UserVo u=(UserVo)al.get(i);
    		%>
    		<tr>
	    	<td><%=u.getUid() %></td>
	    	<td><%=u.getUsername() %></td>
	    	<td><%=u.getPassword() %></td>
	    	<td><%=u.getAddress() %></td>
	    	<td><%=u.getEmail() %></td>
	    	<td><%=u.getSex() %></td>
	    	<td><%=u.getBirthday() %></td>
	    	<td><a href="editUserinfo.jsp?uid=<%=u.getUid() %>">编辑</a></td>
    		<td><a href="DelUserServlet?uid=<%=u.getUid() %>">删除</a></td>
	    	</tr>
    		<%    		
    	}
    	%>
    	
    	</table> 
    	<%  	
    	
    }
    else {
    	%>
    	<table width="800" border="1" align="center">
    	<tr><td>暂无用户数据！</td></tr>
    	</table> 
    	<%
    }
    
    
    %>  
      
    
      
  </body>
</html>

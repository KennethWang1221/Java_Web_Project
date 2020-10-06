<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加用户信息的表单</title>
    
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
  <%
  String username=request.getParameter("username");
  //处理空对象
   if(username==null){
     username="";
   }
   %>
  
    <center>
    <h2>请输入用户信息：</h2>
    </center>
    <form action="addUser.jsp" method="post">   
    <table width="300" align="center">
    <tr>
    <td>用户名：</td>
    <td><input type="text" name="username" value="<%=username %>"></td>
    </tr>
    <tr>
    <td>密码：</td>
    <td><input type="password" name="password"></td>
    </tr>
    <tr>
    <td>重复密码：</td>
    <td><input type="password" name="password2"></td>
    </tr>
    <tr>
    <td>地址：</td>
    <td><input type="text" name="address"></td>
    </tr>
    <tr>
    <td>邮箱：</td>
    <td><input type="text" name="email"></td>
    </tr>
    <tr>
    <td>性别：</td>
    <td>
		<select name="sex">
			<option value="-1">请选择性别</option>
			<option value="0">男</option>
			<option value="1">女</option>
		</select>
	</td>
    </tr>
    <tr>
    <td>生日：</td>
    <td><input type="text" name="Birthday"></td>
    </tr>
    <tr>    
    <td colspan="2"><input type="submit" value="添加"></td>
    </tr>
    </table>
	</form>	
  </body>
</html>

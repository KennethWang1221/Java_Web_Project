<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'loginForm.jsp' starting page</title>
    
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
    <center>
    <h2>请输入登录信息</h2>    
    </center>
    <form action="UserLoginServlet" method="post">
    <table width="300" align="center">
    <tr>
    <td>用户名：</td>
    <td><input type="text" name="usn"></td>
    </tr>
    <tr>
    <td>密码：</td>
    <td><input type="password" name="psd"></td>
    </tr>
    <tr>    
    <td colspan=2><input type="submit" value="登录"></td>
    </tr>
    </table>
    </form>
  </body>
</html>

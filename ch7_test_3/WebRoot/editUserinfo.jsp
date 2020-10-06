<%@ page language="java" import="java.util.*,user.dao.*,user.vo.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'editUserinfo.jsp' starting page</title>
    
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
    String uid=request.getParameter("uid");
    //处理空对象和空值
    if(uid==null || "".equals(uid)){
    	%>
    	<script type="text/javascript">
    	alert("条件不具备，请重试！");
    	window.location.href="listUsers.jsp";
    	</script>
    	<%
    	return;
    }
        
    int id=Integer.parseInt(uid);
    //调用dao对象的方法，查找一条记录，返回一个vo对象
    UserVo user=new UserDao().findUserById(id);
    
    
     %>
    
	<center>
    <h2>请输入用户信息：</h2>
    </center>
    <form action="ModifyUserServlet?uid=<%=user.getUid() %>" method="post">   
    <table width="300" align="center">
    <tr>
    <td>用户名：</td>
    <td><input type="text" name="username" value="<%=user.getUsername() %>"></td>
    </tr>
    <tr>
    <td>密码：</td>
    <td><input type="password" name="password" value="<%=user.getPassword() %>"></td>
    </tr>
    <tr>
    <td>重复密码：</td>
    <td><input type="password" name="password2" value="<%=user.getPassword() %>"></td>
    </tr>
    <tr>
    <td>地址：</td>
    <td><input type="text" name="address" value="<%=user.getAddress() %>"></td>
    </tr>
    <tr>
    <td>邮箱：</td>
    <td><input type="text" name="email" value="<%=user.getEmail() %>"></td>
    </tr>
    <tr>
    <td>性别：</td>
    <td>
    <%
    int sex2=('男'==user.getSex())?0:1;
     %>
		<select name="sex">
			<option value="-1">请选择性别</option>
			<option value="0" <%=(0==sex2)?"selected":"" %>>男</option>
			<option value="1" <%=(1==sex2)?"selected":"" %>>女</option>
		</select>
	</td>
    </tr>
    <tr>
    <td>生日：</td>
    <td><input type="text" name="birthday" value="<%=user.getBirthday() %>"></td>
    </tr>
    <tr>    
    <td colspan="2"><input type="submit" value="修改"></td>
    </tr>
    </table>
	</form>	

  </body>
</html>

 <%@ page language="java" import="java.util.*,user.vo.*,user.dao.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'addUser.jsp' starting page</title>
    
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
   //接收表单信息
   request.setCharacterEncoding("utf-8");
   String username=request.getParameter("username");
   String password=request.getParameter("password");
   String password2=request.getParameter("password2");
   String address=request.getParameter("address");
   String email=request.getParameter("email");
   String sex=request.getParameter("sex");
   String birthday=request.getParameter("birthday");
   
   
   //对用户信息进行校验
   //对数据空对象、空值进行校验
   if(!password.equals(password2)){
     %>
	   <script type="text/javascript">
	   alert("两次密码不一致！");
	   window.location.href="addUserForm.jsp";
	   </script>
	   <% 
	   return;  //终止程序的运行
   }
   
   if("-1".equals(sex)){
     %>
	   <script type="text/javascript">
	   alert("请选择正确的性别！");
	    window.location.href="addUserForm.jsp?username=<%=username %>";
	   </script>
	   <% 
	   return;
   }
   
   //调用Dao对象，完成添加到数据库操作
   UserVo user=new UserVo();
   user.setUsername(username);
   user.setPassword(password);
   user.setEmail(email);
   user.setAddress(address);
   char sex2=("0".equals(sex))?'男':'女';
   user.setSex(sex2);
   user.setBirthday(birthday);
   
   
   
   int res=new UserDao().addUser(user);
   if(res>0){
	   %>
	   <script type="text/javascript">
	   alert("添加用户成功！");
	   window.location.href="listUsers.jsp";
	   </script>
	   <% 
   }else {
	   %>
	   <script type="text/javascript">
	   alert("添加用户失败！");
	   window.location.href="addUserForm.jsp";
	   </script>
	   <% 
   }
   
   %>
  </body>
</html>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="login.vo.*" %>
<%
/*使用session，对登录用户进行检测
系统规定，登录成功的用户，将该用户的对象放入session保存
*/

UserVo user=(UserVo)session.getAttribute("user");
if(user==null){

%>
<<script type="text/javascript">
<!--
alert("你还没有登录系统！");
window.location.href="login.jsp";
//-->
</script>
<%
  return;
}
String usn=user.getUsname();

 %>


<!DOCTYPE html>
<head>
	<!-- templatemo 418 form pack -->
    <!-- 
    Form Pack
    http://www.templatemo.com/preview/templatemo_418_form_pack 
    -->
	<title>系统后台管理界面</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">-->
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	<h1>欢迎你，<%=usn %>，这里是管理界面</h1>
    <h2><span class="gray">by</span> template<span class="green">mo</span></h2>
	<div class="container center-block templatemo-form-list-container templatemo-container">
		<div class="col-md-12">		
		<table class="table table-striped table-hover">
	      <thead>
	        <tr>
	          <th>#</th>
	          <th>Form Name</th>
	          <th class="text-right">View</th>
	        </tr>
	      </thead>
	      <tbody>
	        <tr>
	          <td>1</td>
	          <td>Login Form 1</td>
	          <td class="text-right"><a href="login-1.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>2</td>
	          <td>Login Form 2</td>
	          <td class="text-right"><a href="login-2.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>3</td>
	          <td>Inline Login</td>
	          <td class="text-right"><a href="inline-login.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>4</td>
	          <td>Forgot Password</td>
	          <td class="text-right"><a href="forgot-password.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>5</td>
	          <td>Create Account</td>
	          <td class="text-right"><a href="create-account.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>6</td>
	          <td>Contact Form 1</td>
	          <td class="text-right"><a href="contact-form-1.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>7</td>
	          <td>Contact Form 2</td>
	          <td class="text-right"><a href="contact-form-2.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	        <tr>
	          <td>8</td>
	          <td>Payment Form</td>
	          <td class="text-right"><a href="payment-form.html" class="btn btn-info"><i class="fa fa-arrow-circle-right"></i></a></td>
	        </tr>
	      </tbody>
	    </table>
		</div>
	</div>
</body>
</html>
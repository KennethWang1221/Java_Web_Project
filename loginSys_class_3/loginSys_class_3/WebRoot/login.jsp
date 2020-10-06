<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE html>
<head>
	<!-- templatemo 418 form pack -->
    <!-- 
    Form Pack
    http://www.templatemo.com/preview/templatemo_418_form_pack 
    -->
	<title>用户登录</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!--<link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet" type="text/css">-->
	<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
	<link href="css/templatemo_style.css" rel="stylesheet" type="text/css">	
</head>
<body class="templatemo-bg-gray">
	
	<%
	/*
	 登陆程序先获取客户端的Cookie数据，查找用户名和密码，值如果存在，则直接访问
	 登陆的Servlet程序，连接数据库
	 如果登陆失败或者没有找到Cookie，则显示登录表单，用户自行输入。
	*/
	String input=request.getParameter("input");
	if(input==null){
		input="";
	}
	
	//System.out.println(cks);
	if(!"ok".equals(input)){
		Cookie[] cks=request.getCookies();
		if(cks!=null && cks.length>0){
			String usn=null;
			String psd=null;
			for(Cookie ck:cks){
				if("usn".equals(ck.getName())){
					usn=ck.getValue();
				}
				if("psd".equals(ck.getName())){
					psd=ck.getValue();
				}			
			}
			if(usn!=null && psd!=null){
					
				response.sendRedirect("UserLoginServlet?usname="+usn+"&psword="+psd+"&login=ck");
				//return;
				//System.out.println(usn+"    "+psd);		
				
			}
		}
	}
	
	
	
	 %>
	<div class="container">
		<div class="col-md-12">
			<h1 class="margin-bottom-15">请登录：</h1>
			<form class="form-horizontal templatemo-container templatemo-login-form-1 margin-bottom-30" role="form" action="UserLoginServlet" method="post">				
		        <div class="form-group">
		          <div class="col-xs-12">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" name="usname" id="username" placeholder="Username">
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		            	<label for="password" class="control-label fa-label"><i class="fa fa-lock fa-medium"></i></label>
		            	<input type="password" class="form-control" name="psword" id="password" placeholder="Password">
		            </div>
		          </div>
		        </div>
		        <div class="form-group">
		          <div class="col-xs-6">		            
		            <div class="control-wrapper">
		            	<label for="username" class="control-label fa-label"><i class="fa fa-user fa-medium"></i></label>
		            	<input type="text" class="form-control" name="randomCode" id="username" placeholder="验证码">
		            	<img src="RandomCodeServlet" />
		            </div>		            	            
		          </div>              
		        </div>
		        <div class="form-group">
		          <div class="col-md-12">
	             	<div class="checkbox control-wrapper">
	                	<label>
	                  		<input type="radio" name="shixiao" value="now" checked> 浏览器进程	                  		
                		</label>
                		<label>
	                  		<input type="radio" name="shixiao" value="week"> 一周不登录	                  		
                		</label>
                		<label>
	                  		<input type="radio" name="shixiao" value="month"> 一月不登录	                  		
                		</label>
	              	</div>
		          </div>
		        </div>
		        
		        <div class="form-group">
		          <div class="col-md-12">
		          	<div class="control-wrapper">
		          		<input type="submit" value="Log in" class="btn btn-info">
		          		<a href="forgot-password.html" class="text-right pull-right">Forgot password?</a>
		          	</div>
		          </div>
		        </div>
		        <hr>
		        <div class="form-group">
		        	<div class="col-md-12">
		        		<label>Login with: </label>
		        		<div class="inline-block">
		        			<a href="#"><i class="fa fa-facebook-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-twitter-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-google-plus-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-tumblr-square login-with"></i></a>
			        		<a href="#"><i class="fa fa-github-square login-with"></i></a>
		        		</div>		        		
		        	</div>
		        </div>
		      </form>
		      <div class="text-center">
		      	<a href="create-account.html" class="templatemo-create-new">Create new account <i class="fa fa-arrow-circle-o-right"></i></a>	
		      </div>
		</div>
	</div>
</body>
</html>
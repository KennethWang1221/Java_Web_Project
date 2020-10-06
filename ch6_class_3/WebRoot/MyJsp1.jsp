<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'MyJsp1.jsp' starting page</title>
    
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
    <h2>显示当前页面的刷新数</h2>
    <%!
    //声明区中，只能定义，不能有功能语句
    int num=0;
    int wwww=0;
    
    public int getMax(int a,int b){
    	if(a>b){
    		return a;
    	}
    	else {
    		return b;
    	}
    }
    
    class Person{
    	int age;
    	String name;
    }
    
     %>
     
     <%
     int oooo=99;
     
     out.println(this.getMax(5, 9));
     %>
     <%=this.getMax(10, 7) %>
     <%
     num++;
     //out.println("<h2>刷新数："+num+"</h2>");
      %>
      
     <h2 style="color:red;size:32px">刷新数：<%=num %></h2> 
     <a href="MyJsp2.jsp?sx=<%=num %>">MyJsp2.jsp</a>
  </body>
</html>

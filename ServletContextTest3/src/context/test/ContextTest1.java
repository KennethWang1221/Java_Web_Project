package context.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextTest1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置编码
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		
		//流对象
		PrintWriter out=resp.getWriter();
		
		//获取ServletContext对象
		ServletContext context=this.getServletContext();
		//使用ServletContext，获取web应用的全局配置信息
		Enumeration<String> names=context.getInitParameterNames();
		//根据初始化配置信息的所有名称，进行遍历
		while(names.hasMoreElements()){
			String paramName=names.nextElement();
			//根据名字，取值
			String value=context.getInitParameter(paramName);
			//输出到浏览器
			out.println("<h1>"+paramName+"-"+value+"</h1>");
			
		}
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//业务功能一样，回调方法
		this.doGet(req, resp);
	}

}

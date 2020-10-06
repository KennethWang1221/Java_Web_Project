package context.test2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/ContextTest6")
public class ContextTest6 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		PrintWriter out=resp.getWriter();
		/*
		 * 记录并显示当前web应用的访问次数（刷新数）
		 * 当第一个访问时，还没有保存过该数据，则要将1放入。
		 * 之后的访问，每次都是先取得当前数据，+1，再保存。
		 * 
		 * */
		//获取容器对象
		ServletContext context=this.getServletContext();
		//读取保存的刷新数
		Integer num=(Integer)context.getAttribute("shuaxin");
		
		int temp=0;
		//判断如果num没存过，则会获取null值，表示第一次
		if(num==null){
			context.setAttribute("shuaxin", 1);  //自动装箱
			temp=1;
		}
		else {
			//已经有过访问量
			temp=num+1;
			//再次将新数据存入
			context.setAttribute("shuaxin", temp);
		}
		
		
		//显示当前访问量（刷新数）
		out.println("<h1>当前访问量："+temp+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}

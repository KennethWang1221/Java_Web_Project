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
		 * ��¼����ʾ��ǰwebӦ�õķ��ʴ�����ˢ������
		 * ����һ������ʱ����û�б���������ݣ���Ҫ��1���롣
		 * ֮��ķ��ʣ�ÿ�ζ�����ȡ�õ�ǰ���ݣ�+1���ٱ��档
		 * 
		 * */
		//��ȡ��������
		ServletContext context=this.getServletContext();
		//��ȡ�����ˢ����
		Integer num=(Integer)context.getAttribute("shuaxin");
		
		int temp=0;
		//�ж����numû���������ȡnullֵ����ʾ��һ��
		if(num==null){
			context.setAttribute("shuaxin", 1);  //�Զ�װ��
			temp=1;
		}
		else {
			//�Ѿ��й�������
			temp=num+1;
			//�ٴν������ݴ���
			context.setAttribute("shuaxin", temp);
		}
		
		
		//��ʾ��ǰ��������ˢ������
		out.println("<h1>��ǰ��������"+temp+"</h1>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}

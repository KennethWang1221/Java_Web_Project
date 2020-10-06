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
		//���ñ���
		resp.setCharacterEncoding("gbk");
		resp.setContentType("text/html;charset=gbk");
		
		//������
		PrintWriter out=resp.getWriter();
		
		//��ȡServletContext����
		ServletContext context=this.getServletContext();
		//ʹ��ServletContext����ȡwebӦ�õ�ȫ��������Ϣ
		Enumeration<String> names=context.getInitParameterNames();
		//���ݳ�ʼ��������Ϣ���������ƣ����б���
		while(names.hasMoreElements()){
			String paramName=names.nextElement();
			//�������֣�ȡֵ
			String value=context.getInitParameter(paramName);
			//����������
			out.println("<h1>"+paramName+"-"+value+"</h1>");
			
		}
		
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ҵ����һ�����ص�����
		this.doGet(req, resp);
	}

}

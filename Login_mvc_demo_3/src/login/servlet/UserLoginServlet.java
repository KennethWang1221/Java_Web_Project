package login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.dao.UserLogonDAo;
import login.vo.UserVo;

@WebServlet(urlPatterns="/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		//���յ�¼��Ϣ
		String usn=req.getParameter("usn");
		String psd=req.getParameter("psd");
		
		//����У��
		if(usn==null || "".equals(usn.trim())){
			//����
			return;
		}
		if(psd==null || "".equals(psd)){
			//����
			return;
		}
		
		//����dao���������ݿ�ȶ�
		UserVo u=new UserLogonDAo().checkUserLogin(usn, psd);
		if(u!=null){
			//��u����session�У���ʾ�ɹ���ת�򡣡�
		}
		
		
	}

}

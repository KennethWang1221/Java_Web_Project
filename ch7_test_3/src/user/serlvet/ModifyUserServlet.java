package user.serlvet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.vo.UserVo;

@WebServlet(urlPatterns = "/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		// ��������
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		String uid=request.getParameter("uid");
		

		// ����У��
		if (!password.equals(password2)) {
			out.println("<script>");
			out.println("alert(\"�������벻һ��\");");
			out.println("window.location.href=\"editUserinfo.jsp\";");
			out.println("</script>");
			return;
		}

		// ��װvo����
		UserVo user = new UserVo();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);
		char sex2 = ("0".equals(sex)) ? '��' : 'Ů';
		user.setSex(sex2);
		user.setBirthday(birthday);
		user.setUid(Integer.parseInt(uid));
		
		int res=new UserDao().updateUser(user);
		if (res>0) {
			out.println("<script>");
			out.println("alert(\"�޸��û���Ϣ�ɹ���\");");
			out.println("window.location.href=\"listUsers.jsp\";");
			out.println("</script>");
			return;
		}
		else {
			out.println("<script>");
			out.println("alert(\"�޸��û���Ϣʧ�ܣ�\");");
			out.println("window.location.href=\"listUsers.jsp\";");
			out.println("</script>");
			return;
		}
		
		

	}

}

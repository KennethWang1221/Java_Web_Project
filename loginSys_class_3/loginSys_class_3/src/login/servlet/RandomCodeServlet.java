package login.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns="/RandomCodeServlet")
public class RandomCodeServlet extends HttpServlet {
	// ��֤��ͼƬ�Ŀ�ȡ�
	private int width = 70;
	// ��֤��ͼƬ�ĸ߶ȡ�
	private int height = 26;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		
		// ����һ��������������ࡣ
		Random random = new Random();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// �������壬����Ĵ�СӦ�ø���ͼƬ�ĸ߶�������
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		// �������塣
		g.setFont(font);

		// ���߿�
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		
		 //�������10�������ߣ�ʹͼ���е���֤�벻�ױ���������̽�⵽�� g.setColor(Color.GRAY); 
		 for (int i=0;i<10;i++) { int x = random.nextInt(width); int y =
		 random.nextInt(height); int xl = random.nextInt(10); int yl =
		 random.nextInt(10); g.drawLine(x,y,x+xl,y+yl); }
		 
		// randomCode���ڱ��������������֤�룬�Ա��û���¼�������֤��
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		java.util.Random rd=new java.util.Random();
		// �������4λ���ֵ���֤�롣
		int i=0;
		while(i<4) {
			// �õ������������֤�����֡�
			String strRand;
			/*if(i==1){
				strRand = String.valueOf((char)(random.nextInt(26)+65));
			}else{
				strRand = String.valueOf(random.nextInt(10));
			}*/			
			String ch=String.valueOf(random.nextInt(10));
			if(i==0){
				if("0".equals(ch)){
					continue;
				}
			}
			if(i>0){
				if(randomCode.indexOf(ch)!=-1){
					continue;
				}
			}
			strRand = ch;
			// �����������ɫ������������ɫֵ�����������ÿλ���ֵ���ɫֵ������ͬ��
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);

			// �������������ɫ����֤����Ƶ�ͼ���С�
			g.setColor(new Color(red, green, blue));
			int pos_y=rd.nextInt(8)+14;
			g.drawString(strRand, 13 * i + 6, pos_y);

			// ���������ĸ�����������һ��
			randomCode.append(strRand);
			i++;
		}
		// ����λ���ֵ���֤�뱣�浽Session�С�
		HttpSession session = req.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		// ��ֹͼ�񻺴档
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpeg");

		// ��ͼ�������Servlet������С�
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
}

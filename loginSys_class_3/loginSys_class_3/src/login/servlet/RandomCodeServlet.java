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
	// 验证码图片的宽度。
	private int width = 70;
	// 验证码图片的高度。
	private int height = 26;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, java.io.IOException {
		BufferedImage buffImg = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics2D g = buffImg.createGraphics();
		
		// 创建一个随机数生成器类。
		Random random = new Random();

		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);

		// 创建字体，字体的大小应该根据图片的高度来定。
		Font font = new Font("Times New Roman", Font.PLAIN, 18);
		// 设置字体。
		g.setFont(font);

		// 画边框。
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		
		 //随机产生10条干扰线，使图象中的认证码不易被其它程序探测到。 g.setColor(Color.GRAY); 
		 for (int i=0;i<10;i++) { int x = random.nextInt(width); int y =
		 random.nextInt(height); int xl = random.nextInt(10); int yl =
		 random.nextInt(10); g.drawLine(x,y,x+xl,y+yl); }
		 
		// randomCode用于保存随机产生的验证码，以便用户登录后进行验证。
		StringBuffer randomCode = new StringBuffer();
		int red = 0, green = 0, blue = 0;
		java.util.Random rd=new java.util.Random();
		// 随机产生4位数字的验证码。
		int i=0;
		while(i<4) {
			// 得到随机产生的验证码数字。
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
			// 产生随机的颜色分量来构造颜色值，这样输出的每位数字的颜色值都将不同。
			red = random.nextInt(110);
			green = random.nextInt(50);
			blue = random.nextInt(50);

			// 用随机产生的颜色将验证码绘制到图像中。
			g.setColor(new Color(red, green, blue));
			int pos_y=rd.nextInt(8)+14;
			g.drawString(strRand, 13 * i + 6, pos_y);

			// 将产生的四个随机数组合在一起。
			randomCode.append(strRand);
			i++;
		}
		// 将四位数字的验证码保存到Session中。
		HttpSession session = req.getSession();
		session.setAttribute("randomCode", randomCode.toString());
		// 禁止图像缓存。
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);

		resp.setContentType("image/jpeg");

		// 将图像输出到Servlet输出流中。
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
}

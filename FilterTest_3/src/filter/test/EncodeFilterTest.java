package filter.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodeFilterTest implements Filter {

	private String encode=null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		/*
		 * 为请求和响应对象，设置编码
		 * */
		String code="utf-8";
		if(this.encode!=null){
			code=this.encode;
		}
		req.setCharacterEncoding(code);
		resp.setCharacterEncoding(code);
		resp.setContentType("text/html;charset="+code);
		
		//让过滤任务继续
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// TODO Auto-generated method stub
		this.encode=cfg.getInitParameter("encode");
	}

}

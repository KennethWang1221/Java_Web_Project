package filter.test;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterTest1 implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("过滤器的 destroy 方法调用了。。");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器的 doFilter 方法调用了。。");
		//要注意继续执行过滤的下一个目的，这里是继续运行Servlet程序
		//调用chain的doFilter方法，让过滤任务继续进行。
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("过滤器的 init 方法调用了。。");
	}
	
	

}

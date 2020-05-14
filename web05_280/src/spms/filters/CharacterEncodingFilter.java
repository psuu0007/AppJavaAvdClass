package spms.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter{

	FilterConfig config = null;
	
	@Override
	public void init(FilterConfig filterConfig) 
			throws ServletException {
		// TODO Auto-generated method stub
		
		this.config = filterConfig;
	}
	
	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain fc)
			throws IOException, ServletException {
		
		String encoding = this.config.getInitParameter("encoding");
		
		request.setCharacterEncoding(encoding);
		
		fc.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}

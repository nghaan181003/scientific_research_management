package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/XFrameOptionsFilter")
public class XFrameOptionsFilter implements Filter {
	private String mode = "DENY";
	public void init(FilterConfig fConfig) throws ServletException {
		 String configMode = fConfig.getInitParameter("mode");
	        if ( configMode != null ) {
	            mode = configMode;
	        }

	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
	    res.addHeader("X-Frame-Options", mode);  
	    chain.doFilter(req, res);
		
	}

	public void destroy() {
		//close any resources here
	}

}
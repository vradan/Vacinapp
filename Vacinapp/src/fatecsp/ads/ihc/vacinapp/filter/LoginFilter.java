package fatecsp.ads.ihc.vacinapp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		String uri = ((HttpServletRequest)request).getRequestURI();
		Object user = null;
		
		if (session != null) {
			user = session.getAttribute("usuarioLogado");
		}
		
		if (user != null || uri.endsWith("cadastro.jsf")) {
			chain.doFilter(request, response);
		} else {
			String contextPath = ((HttpServletRequest) request).getContextPath(); 
			((HttpServletResponse) response).sendRedirect(contextPath + "/");
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
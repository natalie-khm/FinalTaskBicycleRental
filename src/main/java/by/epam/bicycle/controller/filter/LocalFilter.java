package by.epam.bicycle.controller.filter;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.epam.bicycle.config.ConfigurationManager;

@WebFilter(urlPatterns = { "/*" })
public class LocalFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpSession session = httpReq.getSession(true);
		
		//set default locale
		if (session.getAttribute("language") == null)  {
			String language = ConfigurationManager.getProperty("language.default");
			session.setAttribute("language", language);
		}
		
		//set locale from params		
		
		
		chain.doFilter(request, response);
		
	}
	

	@Override
	public void destroy() {
	}

}
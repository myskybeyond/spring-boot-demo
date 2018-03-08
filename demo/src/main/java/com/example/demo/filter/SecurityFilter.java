package com.example.demo.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityFilter implements Filter {

	private final static Logger logger = LoggerFactory.getLogger(SecurityFilter.class);

	private Set<String> ignoreUrlSet;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rsp = (HttpServletResponse) reponse;
		String uri = req.getRequestURI();
		if (uri.endsWith(".js") || uri.endsWith(".css") || uri.endsWith(".jpg") || uri.endsWith(".png") || uri.endsWith(".gif") || uri.endsWith(".ico")) {
			chain.doFilter(request, reponse);
			return;
		}
		if(ignoreUrlSet.contains(uri)){
			chain.doFilter(request, reponse);
			return;
		}
		//会话
		HttpSession session = req.getSession();
		if(session != null && session.getAttribute("user_key") != null){
			chain.doFilter(request, reponse);
			return;
		}else{
			rsp.sendRedirect("/toLogin");
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ignoreUrlSet = new HashSet<String>();
		String ignoreUrls = config.getInitParameter("ignoreUrls");
		String[] urls = ignoreUrls.split(",");
		for (String url : urls) {
			ignoreUrlSet.add(url.trim());
		}
		logger.info("SecurityFilter init");
	}

}

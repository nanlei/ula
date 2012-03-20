package ula.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)req;
//        if (request.getRequestURI().indexOf("/admin") == -1) {
//            request.getRequestDispatcher("/index.html").forward(req, res);
//        } else {
//        }
        chain.doFilter(req, res);
	}

	public void init(FilterConfig config) throws ServletException {

	}

}

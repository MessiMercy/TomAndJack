package com;

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

@WebFilter(filterName = "Login", urlPatterns = { "/*", "/" })
public class LoginFilter implements Filter {

	private FilterConfig config;

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		ServletContext context = this.config.getServletContext();
		System.out.println("开始过滤来自" + context.getContextPath() + "的请求………………");
		// if (context.getAttribute("preLogin") != null) {
		// arg2.doFilter(arg0, arg1);
		// System.out.println("放行！");
		// return;
		// }
		if (context.getAttributeNames().hasMoreElements() && context.getAttribute("isLogin") != null) {
			System.out.println(context.getContextPath() + "放行登录");
			arg2.doFilter(arg0, arg1);
		} else {
			System.out.println(context.getContextPath() + "登录失败");
			HttpServletRequest aa = (HttpServletRequest) arg0;
			System.out.println(aa.getRequestURI());
			if (aa.getRequestURI().equals("/TomAndJack/login") && context.getAttribute("preLogin") != null) {
				arg2.doFilter(arg0, arg1);
				System.out.println("放行loginServlet");
				return;
			}
			context.setAttribute("preLogin", "true");
			arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
	}

}

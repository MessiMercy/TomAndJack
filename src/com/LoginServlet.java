package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "LoginServlet", urlPatterns = "/TomAndJack/login", asyncSupported = true)
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("biaoji---------------");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String pw = req.getParameter("pw");
		System.out.println("账号： " + userName);
		System.out.println("密码： " + pw);
		System.out.println("--------------");
		if (userName.contains("liu") && pw.contains("920923")) {
			req.setAttribute("isLogin", "true");
			req.getServletContext().setAttribute("userName", userName);
			resp.sendRedirect("TomAndJack/index.jsp");
		} else {
			resp.sendRedirect("TomAndJack/login.jsp");
		}
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		doPost((HttpServletRequest) arg0, (HttpServletResponse) arg1);
	}

}

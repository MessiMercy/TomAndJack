package com;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "firstServlet", urlPatterns = { "/firstServlet" })
public class FirstServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintStream out = new PrintStream(response.getOutputStream());
		out.println("hello world!");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1744341586203904721L;

}

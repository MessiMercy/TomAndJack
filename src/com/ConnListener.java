package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConnListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

		ServletContext application = arg0.getServletContext();
		Connection conn = (Connection) application.getAttribute("conn");
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("application已关闭");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			ServletContext application = arg0.getServletContext();
			String url = application.getInitParameter("url");
			String driver = application.getInitParameter("driver");
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url);
			application.setAttribute("conn", conn);
			if (conn != null && conn.isValid(10)) {
				System.out.println("connection已建");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("检测到application启动！");
	}

}

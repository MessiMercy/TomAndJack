package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.DynamicAttributes;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class QueryTag extends SimpleTagSupport implements DynamicAttributes {

	private String url;
	private String driver;
	private DbDao dao;
	ResultSet set = null;

	public void setDynamicAttribute(String query, String arg1, Object arg2) throws JspException {
		dao = new DbDao(driver, url);
		set = dao.query(query);
	}

	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();
		out.println("<div>");
		try {
			while (set.next()) {
				String id = set.getString(1);
				out.println("<li>id: " + id + "</li>");
				String title = set.getString(2);
				out.println("<li>title: " + title + "</li>");
				String content = set.getString(3);
				out.println("<li>content: " + content + "</li>");
				String created = set.getString(4);
				out.println("<li>created: " + created + "</li>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</div>");
	}

}

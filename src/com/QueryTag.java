package com;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class QueryTag extends SimpleTagSupport {

	private String url;
	private String driver;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public DbDao getDao() {
		return dao;
	}

	public void setDao(DbDao dao) {
		this.dao = dao;
	}

	public ResultSet getSet() {
		return set;
	}

	public void setSet(ResultSet set) {
		this.set = set;
	}

	private DbDao dao;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	private String query;
	ResultSet set = null;

	public void doTag() throws JspException, IOException {
		dao = new DbDao(driver, url);
		set = dao.query(query);
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
		} finally {
			dao.closeConn();
		}
		out.println("</div>");
	}

}

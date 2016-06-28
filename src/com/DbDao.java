package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDao {

	private Connection conn;
	private String driver;
	private String url;

	public DbDao() {

	}

	public DbDao(String driver, String url) {
		this.driver = driver;
		this.url = url;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 得到数据库连接
	public Connection getConnection() {
		try {
			if (conn == null) {
				Class.forName(this.driver);
				conn = DriverManager.getConnection(url);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}

	// 插入记录
	public boolean insertOne(String sql, Object... args) throws SQLException {
		boolean flag = false;
		PreparedStatement st = getConnection().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			st.setObject(i + 1, args[i]);
		}
		if (st.executeUpdate() == 1) {
			flag = true;
		}
		return flag;
	}

	// 查询记录
	public ResultSet query(String sql, Object... object) {
		ResultSet set = null;
		try {
			PreparedStatement st = getConnection().prepareStatement(sql);
			for (int i = 0; i < object.length; i++) {
				st.setObject(i + 1, object[i]);
			}
			set = st.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConn();
		}
		return set;
	}

	// 关闭连接
	public void closeConn() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

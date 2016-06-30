<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<%@taglib uri="http://tomcat.apache.org/example-taglib" prefix="mytag" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MessiMercy</title>
</head>
<body>
<div><a href="http://www.baidu.com" target="_blank"></a></div>
<div><a href="http://www.baidu.com" target="_blank"></a></div>
<mytag:helloworld></mytag:helloworld>
<mytag:queryTag query="select * from post limit 2;" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/test"></mytag:queryTag>
<%out.println(new java.util.Date());%>
<%!
public int count =0;
public String inf()
{
	return "hello world!";
}
%>
<p>
<%out.println(count++); %>
<%=inf() %>
<%
String driver = application.getInitParameter("driver");
String url = application.getInitParameter("url");
Class.forName(driver);
Connection conn=DriverManager.getConnection(url);
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery("select * from post limit 2");
%>
</p>
<table bgcolor = "#123456" border="1" width="300">
	<%while(rs.next()){ %>
	<tr>
		<td>
			<%=rs.getString(1)%>
		</td>
		<td>
			<%=rs.getString(2)%>
		</td>
	</tr>
	<%} %>
</table>
<div>
	 <%@include file="login.jsp" %>
</div>
<div>
	<jsp:useBean id="p1" class="com.Person" scope="session"></jsp:useBean>
	<jsp:setProperty name="p1" property="name" value="mercylove"/>
	<jsp:setProperty name="p1" property="id" value="11"/>
	<h1>JavaBean</h1><jsp:getProperty name="p1" property="name"/>
	<%=pageContext.getRequest().getLocalAddr()%>
	<%=pageContext.getRequest().getLocalName()+pageContext.getRequest().getProtocol() %>
</div>
<div>
	<form id="postForm" method="get" action="request.jsp">
		账号： <input type="text" name="userId">
		密码： <input type="password" name="password">
		性别： <select name="sex"><option value="男">男</option><option value="女" selected="selected">女</option></select>
		爱好：妹子<input type="checkbox" name="favor" value="妹子">汉子<input type="checkbox" name="favor" value="汉子" checked="checked">
		<br><input type="submit" value="提交"><input type="reset" value="重置">
	</form>
</div>
</body>
</html>
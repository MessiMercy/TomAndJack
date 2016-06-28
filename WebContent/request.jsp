<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接受post请求</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	Enumeration<String> em = request.getHeaderNames();
	while(em.hasMoreElements()){
		String headName = em.nextElement();
		out.println(headName+": "+request.getHeader(headName));
	}
	Map<String,String[]> mm = request.getParameterMap();
	Iterator<Entry<String,String[]>> it = mm.entrySet().iterator();
	while(it.hasNext()){
		Entry<String,String[]> entry = it.next();
		out.println(entry.getKey()+": "+Arrays.asList(entry.getValue()).toString());
	}
	response.addHeader("u r sb", "sure");
	response.addCookie(new Cookie("hehe","0.0"));
%>
<%@include file="index.jsp" %>>
</body>
</html>
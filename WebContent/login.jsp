<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<html>
	<title>Messi</title>	
	<h1>这是一个登录页面</h1>
	<form  id = "login" method = "post" action="request.jsp">
		<div>
			<label>账号：</label>
			<input type="text" name = "userName" id="userName" />
		</div>	
		<div>
			<label>密码：</label>
			<input type = "password" name = "pw" id="pw" />
		</div>
		<div>
			<input type = "submit" value="提交" />
		</div>
	</form>
</html>

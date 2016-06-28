<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta>
  <title> 您要找的东西不在这里 </title>
  <!-- styles -->
  <style>
    body {
      background-color: #f8f8f8;
      font: 12px/18px "helvetica neue",helvetica,arial;
    }
    .container {
      width: 1200px;
      margin-left: auto;
      margin-right: auto;
      *zoom: 1;
    }
    .centerdiv {
      text-align: center;
      border-radius: 5px;
      position: relative;
      width: 750px;
      margin: auto;
      margin-top: 120px;
      padding: 30px;
      background-color: #fff;
      -webkit-box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
      -moz-box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
      box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.3);
    }
    .title {
      font-size: 45px;
      font-weight: bold;
      color: #333;
      line-height: 1;
      margin-bottom: 25px;
    }
    .subtitle {
      font-size: 22px;
      font-weight: bold;
      color: #999;
      line-height: 1;
      margin-bottom: 25px;
    }
    p {
      color: #666;
      line-height: 1.5;
      text-align: center;
    }
    a{
      color: #666;
      line-height: 1.5;
      text-align: center;
    }
  </style>
</head>

<body>
<div class="container">
  <div class="centerdiv">
    <div class="title">
      Error
    </div>
    <div class="subtitle">
      <p>哦豁，出现了异常</p>
      <p>异常名为：<%=exception.getClass() %></p>
      <p>异常信息：<%=exception.getMessage() %></p>
      <p>异常代码：
      <%
      	StackTraceElement[] elements= exception.getStackTrace(); 
      	for(StackTraceElement element:elements){
      		out.println(element);
      	}
      %></p>
	   <a href="/">点击这里回到首页</a>
    </div>
  </div>
</div>

</body>
</html>
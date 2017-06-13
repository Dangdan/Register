<%@page import="com.ddd.Service.Impl.UserManagerImpl"%>
<%@page import="com.ddd.entity.RUser"%>
<%@page import="com.ddd.Service.UserManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.sql.*,java.util.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>处理</title>
</head>
<body>
	<%
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String password2=request.getParameter("password2");
		
		request.setAttribute("username", username);
		UserManager um=new UserManagerImpl();
		RUser u=new RUser();
		u.setName(username);
		u.setPassword(password);
		
		if(um.exists(u)){
			response.sendRedirect("registerFail.jsp");
			return;
		}else{
			um.add(u);
			response.sendRedirect("registerSuccess.jsp");
		}
		
		
	
	%>
</body>
</html>
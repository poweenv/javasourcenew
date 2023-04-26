<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


	String userid=request.getParameter("userid");
	String password=request.getParameter("passord");

	
	// loginPro 에서 uesrid, password 값을 공유하고 싶음
	// setAtribute(), getAttribute(), removeAttribute()
	
	request.setAttribute("userid",userid);
	request.setAttribute("password",password);
	
	pageContext.forward("loginPro.jsp");
%>
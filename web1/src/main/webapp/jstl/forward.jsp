<%@page import="user.domain.LoginDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	List<LoginDTO> loginDTO = new ArrayList<>();

	loginDTO.add(new LoginDTO("hong123","72345"));
	loginDTO.add(new LoginDTO("hong223","62345"));
	loginDTO.add(new LoginDTO("hong323","52345"));
	loginDTO.add(new LoginDTO("hong423","42345"));
	loginDTO.add(new LoginDTO("hong523","32345"));
	loginDTO.add(new LoginDTO("hong623","22345"));
	loginDTO.add(new LoginDTO("hong723","12345"));
	
	request.setAttribute("loginDTO", loginDTO);
	pageContext.forward("jstlTest.jsp");
%>